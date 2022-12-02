package com.hpage.cassebrique.models;

import com.hpage.cassebrique.CasseBrique;

import java.awt.*;

import static com.hpage.cassebrique.CasseBrique.*;

public class Bonus extends Rond {

    protected int vitesseBonusY = 1;

    protected int role = 0;

    public Bonus(int posX, int posY, Color couleur, int diametre, int role) {
        super(posX, posY, couleur, diametre);
        // Role : 0 - Inexistant ; 1 - Agrandissement ; 2 - Retrecissement
        // Couleur : Base - Noir ; Agrandissement - Bleu ; Retrecissement - Orange
        // Position aleatoire dans les briques ( present ou non dans les briques )

        this.role = role;
        switch (role) {
            case 1 -> this.couleur = Color.blue;
            case 2 -> this.couleur = Color.red;
        }
    }

    public void mouvementBonus() {
        posY += vitesseBonusY;
    }

    public void collisionBonus() {
        boolean barreContacteX = barre.getPosX() + barre.getLargeur() > getPosX();
        boolean barreContacteY = barre.getPosY() + barre.getLargeur() > getPosY();
        boolean bonusContacteX = getPosX() + getDiametre() > barre.getPosX();
        boolean bonusContacteY = getPosY() + getDiametre() > barre.getPosY();
        if(barreContacteX && barreContacteY && bonusContacteY && bonusContacteX) {
            this.detruireBonus();
            this.declencherBonus();
        }
    }

    public void declencherBonus() {
        switch (role) {
            case 1 -> barre.largeur += 10;
            case 2 -> barre.largeur -= 10;
        }
    }


    public void detruireBonus() {
        CasseBrique.listeBonus.remove(this);
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getVitesseBonusY() {
        return vitesseBonusY;
    }

    public void setVitesseBonusY(int vitesseBonusY) {
        this.vitesseBonusY = vitesseBonusY;
    }
}
