package com.hpage.cassebrique;

import com.hpage.cassebrique.models.Balle;

import javax.swing.*;
import java.awt.*;

public class CasseBrique extends Canvas {

    public final static int LARGEUR = 500;
    public final static int HAUTEUR = 600;

    public CasseBrique() throws InterruptedException {
        JFrame fenetre = new JFrame("Casse brique");
        //On récupère le panneau de la fenetre principale
        JPanel panneau = (JPanel) fenetre.getContentPane();
        //On définie la hauteur / largeur de l'écran
        panneau.setPreferredSize(new Dimension(LARGEUR, HAUTEUR));
        setBounds(0, 0, LARGEUR, HAUTEUR);
        //On ajoute cette classe (qui hérite de Canvas) comme composant du panneau principal
        panneau.add(this);

        fenetre.pack();
        fenetre.setResizable(false);
        fenetre.setLocationRelativeTo(null);
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fenetre.requestFocus();

        //On indique que le raffraichissement de l'ecran doit être fait manuellement.
        createBufferStrategy(2);
        setIgnoreRepaint(true);
        this.setFocusable(false);

        demarrer();
    }

    public void demarrer() throws InterruptedException {

        Balle[] tabBalle = new Balle[100];

        for (int i = 0; i < 100; i++) {

            int randTaille = (int) (Math.random() * 40 + 10);
            int randX = (int) (Math.random() * (LARGEUR - randTaille));
            int randY = (int) (Math.random() * (HAUTEUR - randTaille));

            tabBalle[i] = new Balle(randX, randY, randTaille, Color.lightGray);
        }

        while (true) {

            Graphics2D dessin = (Graphics2D) getBufferStrategy().getDrawGraphics();

            dessin.setColor(Color.white);
            dessin.fillRect(0, 0, LARGEUR, HAUTEUR);

            for (Balle balle : tabBalle) {
                balle.mouvement();
                balle.collision();
                balle.dessiner(dessin);
            }

//            dessin.setColor(couleur);
//            dessin.fillOval(posX, posY, 50, 50);

            //-----------------------------
            dessin.dispose();
            getBufferStrategy().show();
            Thread.sleep(1000 / 60);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new CasseBrique();
    }
}