package com.hpage.cassebrique;

import com.hpage.cassebrique.models.Balle;
import com.hpage.cassebrique.models.Barre;
import com.hpage.cassebrique.models.Bonus;
import com.hpage.cassebrique.models.Brique;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class CasseBrique extends Canvas implements KeyListener {

    public static Graphics2D dessin;

    public final static int LARGEUR = 500;
    public final static int HAUTEUR = 600;

    public static ArrayList<Balle> listeBalle = new ArrayList<>();

    public static Barre barre = new Barre(225, 540, Color.BLACK, 100, 10);

    public static ArrayList<Brique> listeBrique = new ArrayList<>();
//            new Brique(225, 100, Color.red, 50, 30);

    public static ArrayList<Bonus> listeBonus = new ArrayList<>();

    public static int score;

    public static JLabel label;

    public static Bonus bonus = new Bonus(220, 480, Color.darkGray, 20, 3, 1);

    public static JLabel pLabel;

    public static JLabel labelVictoire;

    public static JButton boutton;

    public static JFrame fenetre = new JFrame("Casse brique");

    public static JPanel panneau = (JPanel) fenetre.getContentPane();

    public static boolean lance = true;

    public CasseBrique() throws InterruptedException {

        //On récupère le panneau de la fenetre principale

        //On définie la hauteur / largeur de l'écran
        panneau.setPreferredSize(new Dimension(LARGEUR, HAUTEUR));
        setBounds(0, 0, LARGEUR, HAUTEUR);
        label = new JLabel("Score: 0");
        //label.setFont(label.getFont().deriveFont(64));
        label.setBounds(220, 10, 80, 10);
        panneau.add(label);
        pLabel = new JLabel("PERDU !");
        pLabel.setBounds(145, 305, 205, 100);
        pLabel.setFont(new Font("Serif", Font.BOLD, 50));
        pLabel.setVisible(false);
        labelVictoire = new JLabel("Partie Terminée.");
        labelVictoire.setBounds(145, 305, 500, 100);
        labelVictoire.setFont(new Font("Serif", Font.BOLD, 25));
        labelVictoire.setVisible(false);
        panneau.add(pLabel);
        panneau.add(labelVictoire);
        boutton = new JButton("Fermer");
        boutton.setBounds(175, 420, 125, 40);
        boutton.setVisible(false);
        panneau.add(boutton);
        //On ajoute cette classe (qui hérite de Canvas) comme composant du panneau principal

        panneau.add(this);

        fenetre.pack();
        fenetre.setResizable(false);
        fenetre.setLocationRelativeTo(null);
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fenetre.requestFocus();
        fenetre.addKeyListener(this);

        //On indique que le raffraichissement de l'ecran doit être fait manuellement.
        createBufferStrategy(2);
        setIgnoreRepaint(true);
        this.setFocusable(false);

        demarrer();
    }

    public void demarrer() throws InterruptedException {

        listeBalle.add(new Balle(220, 480, Color.darkGray, 20, 3, -3));
        for (int i = 1; i * 60 < LARGEUR; i++) {
            switch (i) {
//                case 0:
                case 8:
                case 9:
                    continue;
            }
            for (int j = 1; j * 60 < HAUTEUR - 250; j++) {
                int randomRole = ThreadLocalRandom.current().nextInt(0, 3);
                bonus.setRole(randomRole);
                System.out.println(randomRole);
                listeBrique.add(new Brique(i * 55, j * 55, new Color((float)Math.random(),(float)Math.random(),(float)Math.random()), 50, 30, false));
//                listeBonus.add(new Bonus( i * 55, j * 55, new Color(255, 255, 255), 15, 0, bonus.getRole()));
            }
        }



        while (true) {

            if (!lance) return;
            dessin = (Graphics2D) getBufferStrategy().getDrawGraphics();

//            label = new JLabel("Score: 0");
//            label.setBounds(220, 10, 30, 10);
//            panneau.add(label);

            dessin.setColor(Color.white);
            dessin.fillRect(0, 0, LARGEUR, HAUTEUR);

            new ArrayList<>(listeBonus).forEach(b -> b.dessiner(dessin));
            new ArrayList<>(listeBrique).forEach(b -> b.dessiner(dessin));

            for (Balle balle : new ArrayList<>(listeBalle)) {
                balle.mouvement();
                balle.collision();

                if(!listeBrique.isEmpty()) collision(balle);
                balle.dessiner(dessin);
            }

            for (Bonus bonus: new ArrayList<>(listeBonus)
                 ) {
                bonus.mouvementBonus();
                bonus.collisionBonus();

            }

            barre.dessiner(dessin);

//            if (!listeBrique.isEmpty()) {
//                brique.dessiner(dessin);
//            }


            //-----------------------------
            dessin.dispose();
            getBufferStrategy().show();
            Thread.sleep(1000 / 60);
        }
    }


//    public static String path;

    public static void main(String[] args) throws InterruptedException {
        CasseBrique cb = new CasseBrique();
//        path = cb.getClass().getProtectionDomain().getCodeSource().getLocation().getFile();
//        System.out.println(cb.getClass().getProtectionDomain().getCodeSource().getLocation().getFile());
//        System.out.println("Test");
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 37) {
            barre.deplacementGauche();
        }
        if (e.getKeyCode() == 39) {
            barre.deplacementDroit();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void collision(Balle balle) {

        //si la balle est arrivée à droite ou à gauche alors on inverse sa vitesse
//        if(balle.getPosX() >= CasseBrique.LARGEUR - balle.getDiametre() || balle.getPosX() <= 0){
//            balle.setVitesseBalleX(balle.getVitesseBalleX() * -1); //vitesseHorizontalBalle = vitesseHorizontalBalle * -1
//            couleur = new Color((float)Math.random(),(float)Math.random(),(float)Math.random());
//        }

//        if(balle.getPosX() >= CasseBrique.HAUTEUR - balle.getDiametre() || balle.getPosY() <= 0){
//            balle.setVitesseBalleY(balle.getVitesseBalleY() * -1);
//        }

//        if(balle.getPosY() == brique.getPosY()) System.out.println(balle.getPosY() == brique.getPosY());
//        if ((balle.getPosY() == brique.getPosY() - balle.getDiametre() ) && (balle.getPosX() <= brique.getPosX() + brique.getLargeur()) && (balle.getPosX() >= brique.getPosX())) {
//            balle.setVitesseBalleY(balle.getVitesseBalleY() * -1);
//        }
         for (Brique brique : new ArrayList<>(listeBrique)) {

        boolean briqueContacteX = brique.getPosX() + brique.getLargeur() > balle.getPosX();
        boolean briqueContacteY = brique.getPosY() + brique.getLargeur() > balle.getPosY();
        boolean balleContacteX = balle.getPosX() + balle.getDiametre() > brique.getPosX();
        boolean balleContacteY = balle.getPosY() + balle.getDiametre() > brique.getPosY();
        if(briqueContacteX && briqueContacteY && balleContacteY && balleContacteX) {
            brique.detruite();
            if (listeBrique.isEmpty()){
                System.out.println("Partie Terminée");
                balle.detruire();
                boutton.setVisible(true);
                boutton.addActionListener(e -> {
                    fenetre.dispose();
                });
                labelVictoire.setVisible(true);
            }
            score+=100;
            label.setText("Score: " + score);
            balle.setVitesseBalleY(balle.getVitesseBalleY() * -1);

            break;
        }
        }

    }



    /*public static void reset() throws InterruptedException {
        //On récupère le panneau de la fenetre principale

        //On définie la hauteur / largeur de l'écran
        lance = true;
        panneau.setPreferredSize(new Dimension(LARGEUR, HAUTEUR));
        //setBounds(0, 0, LARGEUR, HAUTEUR);
        label = new JLabel("Score: 0");
        //label.setFont(label.getFont().deriveFont(64));
        label.setBounds(220, 10, 80, 10);
        panneau.add(label);
        pLabel = new JLabel("PERDU !");
        pLabel.setBounds(155, 305, 205, 100);
        pLabel.setFont(new Font("Serif", Font.BOLD, 50));
        pLabel.setVisible(false);
        panneau.add(pLabel);
        boutton = new JButton("Rejouer");
        boutton.setBounds(155, 420, 125, 40);
        boutton.setVisible(false);
        panneau.add(boutton);
        //On ajoute cette classe (qui hérite de Canvas) comme composant du panneau principal

        panneau.add(this);

        fenetre.pack();
        fenetre.setResizable(false);
        fenetre.setLocationRelativeTo(null);
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fenetre.requestFocus();
        fenetre.addKeyListener(this);

        //On indique que le raffraichissement de l'ecran doit être fait manuellement.
        //createBufferStrategy(2);
        //setIgnoreRepaint(true);
        //this.setFocusable(false);

        demarrer();
    }*/

    // AJouter bool etat brique -> lacher le bonus si brique cassee

}