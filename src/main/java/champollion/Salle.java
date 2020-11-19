/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package champollion;

/**
 *
 * @author frede
 */
public class Salle {
    
    private String intitule;
    private int capacite;
    
    public Salle(String i,int c){
        this.intitule = i;
        this.capacite = c;
} 

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    @Override
    public String toString() {
        return "Salle{" + "intitule=" + intitule + ", capacite=" + capacite + '}';
    }
    
    
}
