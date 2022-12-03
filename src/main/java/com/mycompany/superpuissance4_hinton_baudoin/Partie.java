/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.superpuissance4_hinton_baudoin;

import java.util.Random;
import java.util.Scanner;

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
    
    /**
     * Méthode permettant de affecter 30 jeton de la couleur d'un joueur à ce joueur
     * @param unjoueur le joueur à qui on souhaite affecter les jetons (type : joueur)
     */
    public void creerEtAffecterJeton(joueur unjoueur){
        for (int i=0 ; i<30 ; i++){
            unjoueur.ajouterJeton( new Jeton(unjoueur.lireCouleur()));
        }
    }
    
    /**
     * Méthode permettant de placer 5 trounoir et 5 desintegrateurs (3 trounoir partagent la meme cellule que 3 desintegrateurs)
     */
    public void placerTrousNoirsEtDesintegrateurs(){
        Random aleat1 = new Random() ;
        Random aleat2 = new Random() ;
        int x ;                                                                                                 //coordonée de la ligne
        int y ;                                                                                                 //coordonée de la colone
        int i = 0 ;                                                                                             //Variable incrémentée
        //Ajout de 3 Trounoir et 3 Desintégrateurs cahés derrière les trounoir
        while( i != 3) {
            x = aleat1.nextInt(0,6) ;
            y = aleat2.nextInt(0,7) ;
            if (plateau.presenceTrouNoir(x,y) == false){                                                        //Teste si la cellule ne contient pas de trounoir
                plateau.placerTrouNoir(x, y) ;
                plateau.placerTrouNoir(x, y) ;
                i += 1 ;
            }
        }
        //Ajout de 2 Trounoir seuls
        while (i != 5){
            x = aleat1.nextInt(0,6) ;
            y = aleat2.nextInt(0,7) ;
            if (plateau.presenceTrouNoir(x, y) == false){                                                        //Teste si la cellule ne contient pas de trounoir
                plateau.placerTrouNoir(x, y) ;
                i += 1 ;
            }
        }
        //Ajout de 2 Desintégrateurs seuls
        while (i != 7){
            x = aleat1.nextInt(0,6) ;
            y = aleat2.nextInt(0,7) ;
            if ((plateau.presenceTrouNoir(x,y) == false) && (plateau.presenceDesintegrateur(x, y) == false)){    //Teste si la cellule ne contient pas de desintégrateur et de trou noir
                plateau.placerDesintegrateur(x, y) ;
                i += 1 ;
            }
        }
    }
    
    /**
     * Méthode permettant d'initialiser une partie (remettre tout OK pour démarer une nouvelle partie)
     */
    public void initialiserPartie(){
        attribuerCouleurAuxJoueurs() ;
        creerEtAffecterJeton(listeJoueurs[0]) ;
        creerEtAffecterJeton(listeJoueurs[1]) ;
        placerTrousNoirsEtDesintegrateurs() ;
    } 

    /**
     * Méthode qui permet à un joueur de jouer un jeton sur la grille
     * @param unjoueur le joueur qui souhaite jouer
     */
    public void jouerJeton(joueur unjoueur) {
        System.out.println("C'est au joueur " + unjoueur.lireCouleur() + " de jouer" + "\n" + "Il te reste " + unjoueur.nombreDeJetons() + " jetons" + "\n" + "Où souhaite-tu jouer? (colonnes 1 à 7)");
        int colonne = -1 ;
        //Récupère la colonne souhaitée par le joueur (vérifie si elle est bien dans la grille ou si elle est jouable)
        while ((colonne < 1 || colonne >7) || plateau.colonneRemplie((colonne-1))){
            Scanner sc = new Scanner(System.in) ;                                            
            colonne = sc.nextInt();
            if(colonne > 0 && colonne < 8 && plateau.colonneRemplie((colonne-1)) == false){
                break ;
            }
            System.out.println("Erreur : colonne pleinne ou inexistante (veillez re-essayer)");
        }       
        plateau.ajouterJetonDansColonne(unjoueur.jouerJeton(),(colonne-1)) ;
    }
    
    /**
     * Méthode qui permet de jouer une partie
     */
    public void lancerPartie(){
        //Choix aléatoire du joueur qui demarre la partie:
        Random joueur = new Random() ;
        joueurCourant =  listeJoueurs[joueur.nextInt(0,2)] ;
        
        //Boucle de jeu :
        joueur gagnant = null;
        while (gagnant == null){
            if (joueurCourant == listeJoueurs[0]){                                               //Permet de changer de joueur à chaque tour de boucle
                joueurCourant = listeJoueurs[1] ;                               
            }
            else{
                joueurCourant = listeJoueurs[0] ;
            }
            plateau.afficherGrilleSurConsole() ;                                                 //Permet d'afficher la grille au joueurs
            jouerJeton(joueurCourant);                                                    //Permet au joueur de jouer un jeton
            if (plateau.etreGagnantePourCouleur(joueurCourant.lireCouleur()) == true){
                gagnant = joueurCourant ;
            }
        }
        //Annonce du gagnant :
        plateau.afficherGrilleSurConsole() ;                                                    //Permet d'afficher la grille au joueurs
        System.out.println("Le joueur " + gagnant.lireCouleur() + " à gagné !");
    }
}
