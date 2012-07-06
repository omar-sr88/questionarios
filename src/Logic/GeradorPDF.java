/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.*;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author omar
 */
public class GeradorPDF {
    
    public GeradorPDF(){
        
    }
    
    public void gerar(DefaultListModel<Questao> lista) throws FileNotFoundException, DocumentException, IOException{
        
      Document doc = null;

        OutputStream os = null;
        try {

            //cria o documento tamanho A4, margens de 2,54cm

            doc = new Document(PageSize.A4, 72, 72, 72, 72);
            //cria a stream de saída
            os = new FileOutputStream("out.pdf");

            //associa a stream de saída ao

            PdfWriter.getInstance(doc, os);

       
            //abre o documento

            doc.open();
            int i = 1;
            
            for(int j = 0;j<lista.size();j++){
                
            Paragraph p = new Paragraph(i +" - " +lista.get(j).getTexto());
            doc.add(p);
            Paragraph p2 = new Paragraph("R:____________________________");
            doc.add(p2);
            i++;
            }
            
            
            
        } finally {

            if (doc != null) {

                //fechamento do documento

                doc.close();

            }

            if (os != null) {

               //fechamento da stream de saída

               os.close();

            }

        }

        
        if (Desktop.isDesktopSupported()) {
    try {
        File myFile = new File("out.pdf");
        Desktop.getDesktop().open(myFile);
    } catch (IOException ex) {
        // no application registered for PDFs
    }
}
        
        
    }

      
        
        }
    

