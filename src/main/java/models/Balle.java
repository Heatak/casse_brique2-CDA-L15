package models;

import java.awt.*;

public class Balle {

    protected int posX;
    protected int posY;
    protected int taille;
    protected int vitesseBalleX = 5, vitesseBalleY = 5;
    protected Color couleur;

    public Balle(int posX, int posY, int taille, Color couleur) {
        this.posX = posX;
        this.posY = posY;
        this.taille = taille;
        this.couleur = couleur;
    }

    public void mouvement() {
        posX += vitesseBalleX;
        posY += vitesseBalleY;
    }

    public void collision(int largeurEcran, int hauteurEcran/*, Graphics2D dessinEcran*/) {
        if (posX >= (largeurEcran - taille) || (posX <= 0)) {
            vitesseBalleX *= -1;
            couleur = new Color((int)(Math.random() * 0x1000000));
//            dessinEcran.setColor(couleur);
//            dessinEcran.fillOval(posX, posY, 50, 50);
        }
        if (posY >= (hauteurEcran - taille) || (posY <= 0)) {
            vitesseBalleY *= -1;
            couleur = new Color((int)(Math.random() * 0x1000000));
//            dessinEcran.setColor(couleur);
//            dessinEcran.fillOval(posX, posY, 50, 50);
        }
    }

    public void dessiner(Graphics2D dessinEcran) {
        dessinEcran.setColor(couleur);
        dessinEcran.fillOval(posX, posY, taille, taille);
    }

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

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }


}
