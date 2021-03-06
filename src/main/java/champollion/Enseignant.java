package champollion;

import java.util.ArrayList;

public class Enseignant extends Personne {

    // TODO : rajouter les autres méthodes présentes dans le diagramme UML
    private ArrayList<UE> enseignements = new ArrayList<>();
    private ArrayList<ServicePrevu> SP = new ArrayList<>();
    private ArrayList<Intervention> interventions = new ArrayList<>();

    
    public Enseignant(String nom, String email) {
        super(nom, email);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures équivalent TD" Pour le calcul : 1 heure
     * de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut 0,75h
     * "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {
        // TODO: Implémenter cette méthode
        double h = 0;
        int h2 = 0;
        for(int i=0; i< enseignements.size();i++){
                h = h + SP.get(i).getVolumeCM()*1.5+SP.get(i).getVolumeTD()+SP.get(i).getVolumeTP()*0.75;
            }        
        h2 = (int) h;
        return h2;
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée en "heures équivalent TD" Pour
     * le calcul : 1 heure de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure
     * de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue) {
        // TODO: Implémenter cette méthode
        double h = 0;
        int h2 = 0;
        for(int i=0; i< enseignements.size();i++){
            if (ue.getIntitule().equals(enseignements.get(i).getIntitule())){
                h = h + SP.get(i).getVolumeCM()*1.5+SP.get(i).getVolumeTD()+SP.get(i).getVolumeTP()*0.75;
            }
            }
        h2 = (int) h;
        return h2;
    }

    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
        enseignements.add(ue);
        ServicePrevu s = new ServicePrevu(volumeCM,volumeTD,volumeTP);
        SP.add(s);
    }
    public void retirerEnseignement(UE ue){
        enseignements.remove(ue); 
    }
    
    public boolean enSousService(){
        if(this.heuresPrevues()<=192){
            return true; 
        }else;
            return false;
    }
    
    public void ajouterIntervention(Intervention i){
        interventions.add(i);
    }
    
    public void annulerIntervention(Intervention i){
        interventions.remove(i);
    }
    
    public int heurePlanifiees(){
        int h=0;
        for (int i = 0; i< interventions.size();i++){
            h = interventions.get(i).getDuree() +h;
        }
        return h;
    }
    public boolean comparerHeures(){
        int h=0;
        int h2=0;
        boolean b = true;
        for(int i = 0; i< interventions.size();i++){
            for(int j = 0; j< SP.size();j++){
                h = interventions.get(i).getDuree()+h;
                h2 = SP.get(i).somme();
                if(h == h2){
                    b = true;
                    System.out.println("Toutes les heures plannifiées ont été réalisées.");
                }else;
                    b=false;
                    System.out.println("Toutes les heures plannifiées n'ont pas été réalisées.");
            }
        }
        return b;
    }
}
