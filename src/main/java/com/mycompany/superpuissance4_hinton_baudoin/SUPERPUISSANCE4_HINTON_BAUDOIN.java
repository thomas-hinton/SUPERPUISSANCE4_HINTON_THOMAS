/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.superpuissance4_hinton_baudoin;

/**
 *
 * @Créated by Mr Baudoin et Mr Hinton
 */
public class SUPERPUISSANCE4_HINTON_BAUDOIN {

    public static void main(String[] args) {
        joueur joueur1 = new joueur("thomas") ;              //création d'un joueur
        joueur joueur2 = new joueur("arthur") ;              //Création d'un deuxième joueur
        Partie unepartie = new Partie(joueur1, joueur2) ;            //Création d'une partie
        unepartie.initialiserPartie() ;                   
        unepartie.lancerPartie() ;
    }
}