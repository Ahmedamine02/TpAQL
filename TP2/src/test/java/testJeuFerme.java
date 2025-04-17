import org.example.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Assertions;



public class testJeuFerme<Jeux> {
    @Test
    void testJeuFerme() {
        Banque banque = mock(Banque.class);
        jeux jeu = new jeux(banque);
        jeu.fermer();

        Joueur joueur = mock(Joueur.class);
        De de1 = mock(De.class);
        De de2 = mock(De.class);

        assertThrows(throwsJeuFermeException.class, () -> jeu.jouer(joueur, de1, de2));
    }



   @Test
   void testJoueurInsolvable() throws DebitImpossibleException, throwsJeuFermeException {
       Banque banque = mock(Banque.class);
       Joueur joueur = mock(Joueur.class);
       De de1 = mock(De.class);
       De de2 = mock(De.class);

       when(joueur.mise()).thenReturn(100);
       doThrow(new DebitImpossibleException()).when(joueur).debiter(100);

       Jeu jeu = new jeux(banque);
       jeu.jouer(joueur, de1, de2);

       // Vérifie que les dés n'ont jamais été lancés
       verify(de1, never()).lancer();
       verify(de2, never()).lancer();
       verify(banque, never()).crediter(anyInt());
   }

    @Test
    void testPerdMise() throws Exception {
        Banque banque = mock(Banque.class);
        Joueur joueur = mock(Joueur.class);
        De de1 = mock(De.class);
        De de2 = mock(De.class);

        when(joueur.mise()).thenReturn(100);
        when(de1.lancer()).thenReturn(2);
        when(de2.lancer()).thenReturn(3); // somme = 5

        Jeu jeu = new jeux(banque);
        jeu.jouer(joueur, de1, de2);

        verify(joueur).debiter(100);
        verify(banque).crediter(100);
        verify(banque, never()).debiter(anyInt());
        verify(joueur, never()).crediter(anyInt());
    }

    @Test
    void testGagneMise_BanqueSolvable() throws Exception {
        Banque banque = mock(Banque.class);
        Joueur joueur = mock(Joueur.class);
        De de1 = mock(De.class);
        De de2 = mock(De.class);

        when(joueur.mise()).thenReturn(100);
        when(de1.lancer()).thenReturn(3);
        when(de2.lancer()).thenReturn(4); // somme = 7
        when(banque.est_solvable()).thenReturn(true);

        Jeu jeu = new jeux(banque);
        jeu.jouer(joueur, de1, de2);

        verify(banque).debiter(200);
        verify(joueur).crediter(200);
        assertTrue(jeu.estOuvert());
    }








}
