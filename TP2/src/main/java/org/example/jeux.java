package org.example;

public class jeux implements Jeu{
    private Banque banque;
    private boolean ouvert = true;

    public jeux(Banque labanque) {
        this.banque = labanque;
    }

    public void jouer(Joueur joueur, De de1, De de2) throws throwsJeuFermeException {
        if (!ouvert) throw new throwsJeuFermeException();

        int mise = joueur.mise();

        try {
            joueur.debiter(mise);
        } catch (DebitImpossibleException e) {
            return;
        }

        banque.crediter(mise);
        int somme = de1.lancer() + de2.lancer();

        if (somme == 7) {
            int gain = 2 * mise;
            banque.debiter(gain);
            joueur.crediter(gain);

            if (!banque.est_solvable()) {
                this.fermer();
            }
        }
    }

    public void fermer() {
        this.ouvert = false;
    }

    public boolean estOuvert() {
        return ouvert;
    }
}
