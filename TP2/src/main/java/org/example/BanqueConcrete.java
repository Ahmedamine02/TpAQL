package org.example;

public class BanqueConcrete implements Banque {
    private int fond;
    private int fondMin;

    public BanqueConcrete(int fond, int fondMin) {
        this.fond = fond;
        this.fondMin = fondMin;
    }

    @Override
    public void crediter(int somme) {
        fond += somme;
    }

    @Override
    public boolean est_solvable() {
        return fond >= fondMin;
    }

    @Override
    public void debiter(int somme) {
        fond -= somme;
    }
}
