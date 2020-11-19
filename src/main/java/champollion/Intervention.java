/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package champollion;

import java.util.Date;

/**
 *
 * @author frede
 */
public class Intervention {
    
    private Date debut;
    private int duree;
    private boolean annulee = false;
    private Salle s;
    private UE u;
    private Enseignant e;
    
    
    public Intervention(Salle s, UE u, Enseignant e, Date d, int duree){
        this.debut = d;
        this.duree = duree;
        this.s = s;
        this.u = u;
        this.e = e;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public boolean isAnnulee() {
        return annulee;
    }

    public void setAnnulee(boolean annulee) {
        this.annulee = annulee;
    }

    public Salle getS() {
        return s;
    }

    public void setS(Salle s) {
        this.s = s;
    }

    public UE getU() {
        return u;
    }

    public void setU(UE u) {
        this.u = u;
    }

    public Enseignant getE() {
        return e;
    }

    public void setE(Enseignant e) {
        this.e = e;
    }
    
    
    
    public void annulerIntervention(Intervention i,Enseignant e){
        i.setAnnulee(true);
        i.setDebut(null);
        i.setDuree(0);
        e.annulerIntervention(i);
    }
}
