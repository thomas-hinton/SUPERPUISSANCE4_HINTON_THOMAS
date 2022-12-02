/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.superpuissance4_hinton_baudoin;

import java.util.Random;
/**
 *
 * @author 33621
 */
//Définition de la classe "Partie" :
public class Partie {
    private joueur [] listeJoueurs = new joueur[2] ;
    private joueur joueurCourant ;
    private PlateauDeJeu plateau ;
    
    /**
     * Constructeur d'objets de type "Partie"
     * @param joueur1 le joueur 1 (type : joueur)
     * @param joueur2 le joueur 2 (type : joueur)
     */
    public Partie (joueur joueur1, joueur joueur2) {
        listeJoueurs[0] = joueur1 ;
        listeJoueurs[1] = joueur2 ;
        plateau = new PlateauDeJeu() ;
    }
    
    /**
     * Méthode permettant d'attribuer aléatoirement une couleur à chacun des deux joueurs
     */
    public void attribuerCouleurAuxJoueurs() {
        Random aleat = new Random() ;                            //Création d'un nouvel objet de type "Random"
        int nb = aleat.nextInt(0, 2) ;                //Application de la méthode "nextInt()" qui nous permet de récuperer un nb aléatoire ente [0,1]
        if (nb == 0) {
            listeJoueurs[0].affecterCouleur("rouge") ;
            listeJoueurs[1].affecterCouleur("jaune") ;
        } 
        else{
            listeJoueurs[1].affecterCouleur("rouge") ;
            listeJoueurs[0].affecterCouleur("jaune") ;
        }
    }
}
