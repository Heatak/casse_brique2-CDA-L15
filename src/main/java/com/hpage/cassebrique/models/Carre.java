package com.hpage.cassebrique.models;

import java.awt.*;

public class Carre extends Sprite {

    protected int largeur;

    public Carre(int posX, int posY, Color couleur, int largeur) {
        super(posX, posY, couleur);
        this.largeur = largeur;
    }
    @Override
    public void dessiner(Graphics2D dessin) {
        dessin.setColor(couleur);
        dessin.fillRect(posX, posY, largeur, largeur);
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }
}
