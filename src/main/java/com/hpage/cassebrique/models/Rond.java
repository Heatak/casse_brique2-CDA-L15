package com.hpage.cassebrique.models;

import java.awt.*;

public class Rond extends Sprite {
    protected int diametre;

    public Rond(int posX, int posY, Color couleur, int diametre) {
        super(posX, posY, couleur);
        this.diametre = diametre;
    }

    @Override
    public void dessiner(Graphics2D dessin) {
        dessin.setColor(couleur);
        dessin.fillOval(posX, posY, diametre, diametre);
//        dessin.setColor(Color.GREEN);
//        dessin.fillOval(posX, posY, getDiametre() - 5, getDiametre() - 5);
    }

    public int getDiametre() {
        return diametre;
    }

    public void setDiametre(int diametre) {
        this.diametre = diametre;
    }
}
