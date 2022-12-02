package com.hpage.cassebrique.models;

import com.hpage.cassebrique.CasseBrique;

import java.awt.*;
import static com.hpage.cassebrique.CasseBrique.barre;

public class Bonus extends Rond {

    protected int vitesseBonusY = 1;

    protected int role = 0;

    public Bonus(int posX, int posY, Color couleur, int diametre, int vitesseBonusY, int role) {
        super(posX, posY, couleur, diametre);
        // Role : 0 - Inexistant ; 1 - Agrandissement ; 2 - Retrecissement
        // Couleur : Base - Noir ; Agrandissement - Bleu ; Retrecissement - Orange
        // Position aleatoire dans les briques ( present ou non dans les briques )

        this.vitesseBonusY = vitesseBonusY;
        this.role = role;
    }

    public void mouvementBonus() {
        posY += vitesseBonusY;
    }

    public void collisionBonus() {
        boolean barreContacteX = barre.getPosX() + barre.getLargeur() > getPosX();
        boolean barreContacteY = barre.getPosY() + barre.getLargeur() > getPosY();
        boolean bonusContacteX = getPosX() + getDiametre() > barre.getPosX();
        boolean bonusContacteY = getPosY() + getDiametre() > barre.getPosY();
        switch (role) {
            case 0:
                this.detruireBonus();
            case 1:
                this.setCouleur(Color.blue);
                barre.largeur += 10;
                this.mouvementBonus();
            case 2:
                this.setCouleur(Color.orange);
                barre.largeur -= 10;
                this.mouvementBonus();
            default:
                this.detruireBonus();
        }
        if(barreContacteX && barreContacteY && bonusContacteY && bonusContacteX) {
            this.detruireBonus();
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
}
