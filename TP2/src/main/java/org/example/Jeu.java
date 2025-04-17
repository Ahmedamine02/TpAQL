package org.example;

public interface Jeu {
    public void jouer(Joueur joueur, De de1, De de2) throws throwsJeuFermeException;
    public void fermer();
    public boolean estOuvert();
}
