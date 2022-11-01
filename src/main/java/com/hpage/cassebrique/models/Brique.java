package com.hpage.cassebrique.models;

import com.hpage.cassebrique.CasseBrique;

import java.awt.*;

public class Brique extends Rectangle{

    public Brique(int posX, int posY, Color couleur, int largeur, int hauteur) {
        super(posX, posY, couleur, largeur, hauteur);
    }

    public void detruite() {
        CasseBrique.listeBrique.remove(this);
    }

}
