/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.ArrayList;

/**
 *
 * @author omar
 */
public class Questoes {
    
    ArrayList<String> questoes;
    
    public Questoes(){
        questoes = new ArrayList<String>();
    }
    
    public void adicionarQuestao(String texto){
        questoes.add(texto);
    }
    
    public String last(){
        return questoes.isEmpty() ? "Vazio" : questoes.get(questoes.size()-1);
    }
}
