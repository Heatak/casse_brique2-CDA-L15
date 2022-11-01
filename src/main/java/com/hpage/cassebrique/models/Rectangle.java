package com.hpage.cassebrique.models;

import com.hpage.cassebrique.CasseBrique;

import java.awt.*;

public class Rectangle extends Carre {
    protected int hauteur;

    public Rectangle(int posX, int posY, Color couleur, int largeur, int hauteur) {
        super(posX, posY, couleur, largeur);
        this.hauteur = hauteur;
    }

    @Override
    public void dessiner(Graphics2D dessin) {
        dessin.setColor(couleur);
        dessin.fillRect(posX, posY, largeur, hauteur);
//        dessin.setColor(Color.GREEN);
//        dessin.fillRect(posX, posY, getLargeur() - 5, getHauteur() - 5);
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }


}
