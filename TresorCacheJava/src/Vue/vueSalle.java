package Vue;

import Modele.Case;
import Modele.FantomeRouge;
import Modele.Salle;

import java.util.ArrayList;

public class vueSalle {

        public void affichage(Salle salle){
            System.out.println("+                               /---------\\                                       +");
            System.out.println("+------------------------------<  SALLE "+salle.getNom()+"  >--------------------------------------+");
            System.out.println("+                               \\---------/                                       +");
            System.out.println("+                                                                                 +");
            if (!salle.isTresor()){
                System.out.println("+                              PAS DE TRESOR                                          +");
                System.out.println("+                                   [❌]                                          +");
            }else if (salle.isTresor() && salle.getListeFantomes().size() == 0){
                System.out.println("+                            TRESOR DISPONIBLE                                    +");
                System.out.println("+                                    \uD83D\uDC8E                                           +");
                System.out.println("+                       (entrez 5 pour prendre la gème)                           +");
            }else {
                System.out.println("+                            TRESOR DISPONIBLE                                    +");
                System.out.println("+                                   [\uD83D\uDC8E]                                          +");
                System.out.println("+                (Battez les fantomes avant de prendre la geme)                   +");
            }

            System.out.println("+                                                                                 +");
            System.out.println("+                                                                                 +");
            if (salle.getListeFantomes().get(0) instanceof FantomeRouge) {
                System.out.println("+                               /---------\\                                       +");
                System.out.println("+                <     \uD83D\uDC80     >                   +");
                System.out.println("+                               \\---------/                                       +");
            }else if (salle.getListeFantomes().size() == 1){
                System.out.println("+                               /---------\\                                       +");
                System.out.println("+                              <   \uD83D\uDC7B       >                                       +");
                System.out.println("+                               \\---------/                                       +");
            }else if (salle.getListeFantomes().size() == 2){
                System.out.println("+                               /---------\\                                       +");
                System.out.println("+                              <   \uD83D\uDC7B \uD83D\uDC7B       >                                       +");
                System.out.println("+                               \\---------/                                       +");
            }else if (salle.getListeFantomes().size() == 3){
                System.out.println("+                               /---------\\                                       +");
                System.out.println("+                              <   \uD83D\uDC7B \uD83D\uDC7B \uD83D\uDC7B       >                                       +");
                System.out.println("+                               \\---------/                                       +");
            }else if (salle.getListeFantomes().size() == 0) {
                System.out.println("+                               /---------\\                                       +");
                System.out.println("+                <     Il n'y à pas de fantome dans cette salle     >                   +");
                System.out.println("+                               \\---------/                                       +");
            }
            System.out.println("+---------------------------------------------------------------------------------+");
        }
    }


