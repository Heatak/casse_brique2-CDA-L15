package com.hpage.cassebrique.models;

import com.hpage.cassebrique.CasseBrique;

import java.awt.*;

public class Barre extends Rectangle {

    public Barre(int posX, int posY, Color couleur, int largeur, int hauteur) {
        super(posX, posY, couleur, largeur, hauteur);
    }

    public void deplacementDroit() {
        if (posX <= CasseBrique.LARGEUR - largeur) {
            setPosX(posX+=10);
        }

    }

    public void deplacementGauche() {
        if (posX > 0) {
            setPosX(posX -= 10);
        }
    }
}
