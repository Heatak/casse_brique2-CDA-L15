package com.hpage.cassebrique.models;

import java.awt.*;

public abstract class Sprite {
    protected int posX;
    protected int posY;
    public Sprite(int posX, int posY, Color couleur) {
        this.posX = posX;
        this.posY = posY;
        this.couleur = couleur;
    }
    protected Color couleur;

    public abstract void dessiner(Graphics2D dessin);

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }
}
