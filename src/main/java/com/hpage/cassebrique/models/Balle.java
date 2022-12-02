package com.hpage.cassebrique.models;

import com.hpage.cassebrique.CasseBrique;

import java.awt.*;

import static com.hpage.cassebrique.CasseBrique.HAUTEUR;
import static com.hpage.cassebrique.CasseBrique.barre;

public class Balle extends Rond {
    protected int vitesseBalleX = 4;
    public int vitesseBalleY = 4;


    public Balle(int posX, int posY, Color couleur, int diametre, int vitesseBalleX, int vitesseBalleY) {
        super(posX, posY, couleur, diametre);
        this.vitesseBalleX = vitesseBalleX;
        this.vitesseBalleY = vitesseBalleY;
    }

    public void mouvement() {
        posX += vitesseBalleX;
        posY += vitesseBalleY;
    }

    public void collision() {

        //si la balle est arrivée à droite ou à gauche alors on inverse sa vitesse
        if(posX >= CasseBrique.LARGEUR - diametre || posX <= 0){
            vitesseBalleX *= -1;
        }

        if(posY >= CasseBrique.HAUTEUR - diametre || posY <= 0){
            vitesseBalleY *= -1;
        }
        boolean barreContacteX = barre.getPosX() + barre.getLargeur() > getPosX();
        boolean barreContacteY = barre.getPosY() + barre.getLargeur() > getPosY();
        boolean balleContacteX = getPosX() + getDiametre() > barre.getPosX();
        boolean balleContacteY = getPosY() + getDiametre() > barre.getPosY();
        if(barreContacteX && barreContacteY && balleContacteY && balleContacteX) {
            this.vitesseBalleY *= -1;
        }
        boolean fondContacteY = HAUTEUR - 20 <= getPosY();
        if (fondContacteY) {
            detruire();
            if(!CasseBrique.listeBalle.isEmpty()) return;
            CasseBrique.pLabel.setVisible(true);
            CasseBrique.boutton.setVisible(true);
            CasseBrique.boutton.addActionListener(e -> {
                CasseBrique.dessin.dispose();
                CasseBrique.fenetre.dispose();
            });
        }
    }

    public int getVitesseBalleX() {
        return vitesseBalleX;
    }

    public void setVitesseBalleX(int vitesseBalleX) {
        this.vitesseBalleX = vitesseBalleX;
    }

    public int getVitesseBalleY() {
        return vitesseBalleY;
    }

    public void setVitesseBalleY(int vitesseBalleY) {
        this.vitesseBalleY = vitesseBalleY;
    }


    public void detruire() {
        CasseBrique.listeBalle.remove(this);
    }
}
