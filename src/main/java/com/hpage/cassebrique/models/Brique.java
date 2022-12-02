package com.hpage.cassebrique.models;

import com.hpage.cassebrique.CasseBrique;

import java.awt.*;

public class Brique extends Rectangle{

    boolean casse = false;

    public Brique(int posX, int posY, Color couleur, int largeur, int hauteur, boolean casse) {
        super(posX, posY, couleur, largeur, hauteur);
        this.casse = casse;
    }

    public void detruite() {
        CasseBrique.listeBrique.remove(this);

    }

    public boolean isCasse() {
        return casse;
    }

    public void setCasse(boolean casse) {
        this.casse = casse;
    }
}
