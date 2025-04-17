package org.example;

public class throwsJeuFermeException extends Exception {
    public throwsJeuFermeException() {
        super("Le jeu est fermé !");
    }
}
