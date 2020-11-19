package champollion;

import java.util.Date;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ChampollionJUnitTest {
	Enseignant untel;
	UE uml, java;
        Salle s;
        Date date;
		
	@BeforeEach
	public void setUp() {
		untel = new Enseignant("untel", "untel@gmail.com");
		uml = new UE("UML");
		java = new UE("Programmation en java");
                s = new Salle("A01",30);
                date = new Date(2020,11,19);
	}
	

	@Test
	public void testNouvelEnseignantSansService() {
		assertEquals(0, untel.heuresPrevues(),
                        "Un nouvel enseignant doit avoir 0 heures prévues");
	}
	
	@Test
	public void testAjouteHeures() {
                // 10h TD pour UML
		untel.ajouteEnseignement(uml, 0, 10, 0);

		assertEquals(10, untel.heuresPrevuesPourUE(uml),
                        "L'enseignant doit maintenant avoir 10 heures prévues pour l'UE 'uml'");

                // 20h TD pour UML
                untel.ajouteEnseignement(uml, 0, 20, 0);
                
		assertEquals(10 + 20, untel.heuresPrevuesPourUE(uml),
                         "L'enseignant doit maintenant avoir 30 heures prévues pour l'UE 'uml'");		
		
                // 10h de CM = 15h de TD uml
                untel.ajouteEnseignement(uml, 10, 0, 0);
                
		assertEquals(30+15, untel.heuresPrevuesPourUE(uml),
                         "L'enseignant doit maintenant avoir 45 heures prévues pour l'UE 'uml'");		
                
                // 20h de TP = 15h de TD uml
                untel.ajouteEnseignement(uml, 0, 0, 20);
                
		assertEquals(45+15, untel.heuresPrevuesPourUE(uml),
                         "L'enseignant doit maintenant avoir 60 heures prévues pour l'UE 'uml'");		
                
                // 20 h de TD pour java
                untel.ajouteEnseignement(java, 0, 20, 0);
                assertEquals(60+20, untel.heuresPrevues(),"L'enseignant devrait avoir 80h de cours.");
        }
        
        
        @Test
        public void testSousService(){
            untel.ajouteEnseignement(uml, 10, 10, 10);
            assertTrue(untel.enSousService(),"L'enseignant devrait être en sous-service.");
        }
	@Test
        public void testHeurePlannifiée(){
            Intervention i = new Intervention(s, uml,untel,date,3);
            untel.ajouterIntervention(i);
            assertEquals(3,untel.heurePlanifiees(),"Le cours aurait dû durer 3h.");

        }
        
        @Test 
        public void annultationCours(){
            Intervention i = new Intervention(s, uml,untel,date,3);
            untel.ajouterIntervention(i);
            i.annulerIntervention(i,untel);
            assertEquals(0, untel.heurePlanifiees(),"Le cours aurait dû s'annuler");            
        }
}
