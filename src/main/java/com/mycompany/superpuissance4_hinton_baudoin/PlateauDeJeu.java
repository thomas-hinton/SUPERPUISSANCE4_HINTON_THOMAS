/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.superpuissance4_hinton_baudoin;

/**
 *
 * @author 33621
 */
//Définition de la classe "PlateauDeJeu" :
public class PlateauDeJeu {
    CelluleDeGrille[][] grille = new CelluleDeGrille[6][7];
    
    /**
     * Constructeur d'objetc de type "PlateauDeJeu"
     */
    public PlateauDeJeu() {
        for (int i=0; i < 6; i++) {                      //Parcours toute les lignes
            for (int j=0; j < 7; j++) {                  //Parcours toute les colonnes
                grille[i][j] = new CelluleDeGrille() ;   //Crée un nouvel objet de type "cellule" dans chaque cases du tableau
            }
        }  
    }
    /**
     * Méthode permettant de ajouter un jeton dans une colonne souhaitée (parcours les lignes de bas en haut : 5-> 0)
     * @param unJeton   le jeton à ajouter dans la colone (type : Jeton)
     * @param unecolonne  la colone dans laquelle onsouhaite ajouter le jeton
     * @return ligne sur laquelle à été rajouté le jeton (type : int) (si =-1 c'est que la colonne est pleine
     */
    public int ajouterJetonDansColonne(Jeton unJeton,int unecolonne) {
        for (int i=0; i<6; i++) {                                            //parcours des 6 lignes
            if (grille[5-i][unecolonne].presenceJeton() == false) {          //Teste la présence d'un jeton en partant du bas de la grille (grille[5][y])
                grille[5-i][unecolonne].affecterJeton(unJeton) ;      //Ajoute un jeton à la cellule (utilisiation d'une méthode de type "CelluleDeGrille"
                return (5-i) ;
            } 
        }
        return -1 ;                                                         //Return -1 si la colone est déja pleine
    }
    
    /**
     * Méthode permettant de savoir si la grille est pleine ou pas 
     * @return "true" (si "oui") or "false" (si "non") (type : boolean)
     */
    public boolean grilleRemplie() {
        for (int j=0; j < 7; j++) {                                         //Parcours la 1er ligne(en haut) de la grille)
            if (grille[0][j].presenceJeton() == false ){                    //verifie si un jeton est présent dans la cellule
                return false ;
            }
        }
        return true ;
    }
    
    /**
     * Méthode permettant d'afficher la grille dans la console
     */
    public void afficherGrilleSurConsole(){
        String grilleaffichage ="";                                           //Variable locale permettant de faciliter l'affichage de chaque lignes(incrémentée)
        for (int i=0; i < 6; i++) {               
            for (int j=0; j < 7; j++) {
                grilleaffichage = grilleaffichage + "|" + grille[i][j] ;      //ecriture de la première ligne  
            }
            grilleaffichage += "|" +"\n" ;                                    //Permet de fermer la grille de manière esthétique et de retourner à la ligne                          
        }
        System.out.println(grilleaffichage) ;
    }
    /**
     * Méthode permettant de savoir si une cellule de coordonées (x,y) est occupée
     * @param x ligne de la celulle (type : int)
     * @param y colonne de la cellule (type : int)
     * @return "true" (si oui) or "false" (si non) (type : boolean)
     */
    public boolean presenceJeton(int x, int y){
        return grille[x][y].presenceJeton() ;                               
    }
    
    /**
     * Méthode permettant de savoir si un trounoir est present sur une cellule de coordonées (x,y)
     * @param x ligne de la cellule (type : int)
     * @param y colonne de la cellule (type: int)
     * @return "true" (si oui) or "false" (si non) (type : boolean)
     */
    public boolean presenceTrouNoir(int x, int y){
        return grille[x][y].presenceTrouNoir() ;
    }
    
    /**
     * Méthode permettant de savoir si un desintegrateur est present sur une cellule de coordonées (x,y)
     * @param x ligne de la cellule (type : int)
     * @param y colonne de la cellule (type : int)
     * @return  "true" (si oui) or "false" (si non) (type : boolean)
     */
    public boolean presenceDesintegrateur(int x, int y){
        return grille[x][y].presenceDesintegrateur() ;
    }
    
    /**
     * Méthode permettant de connaitre la couleur du jeton qui occupe la cellule de coordonées (x,y)
     * @param x ligne de la celulle (type : int)
     * @param y colonne de la cellule (type : int)
     * @return couleur du jeton (type : String)
     */
    public String lireCouleurDuJeton(int x, int y){
        return grille[x][y].lireCouleurDuJeton() ;                            
    }
    
    /**
     * Méthode permettant de savoir si une couleur est gagante
     * @param couleur couleur du potentiel gagant à tester
     * @return "true" (si gagné) "false" (si pas gagné) (type : boolean)
     */
    public boolean etreGagnantePourCouleur(String couleur){
        //Teste sur les lignes
        for (int i=0; i < 6 ; i++){                 
            for (int j=0; j < 4 ; j++){
                if((lireCouleurDuJeton(i,j) == couleur) && (lireCouleurDuJeton(i,j+1) == couleur) && (lireCouleurDuJeton(i,j+2) == couleur) && (lireCouleurDuJeton(i,j+3) == couleur)){
                   return true ; 
                }
            }
        }
        //Teste sur les colonnes
        for (int i=0; i < 3 ; i++){
            for (int j=0; j < 6 ; j++){
                if((lireCouleurDuJeton(i,j) == couleur) && (lireCouleurDuJeton(i+1,j) == couleur) && (lireCouleurDuJeton(i+2,j) == couleur) && (lireCouleurDuJeton(i+3,j) == couleur)){
                   return true ; 
                }
            }
        }
        //Teste sur les diagonales descendantes
        for (int i=0; i < 3 ; i++){
            for (int j=0; j < 4 ; j++){
                if((lireCouleurDuJeton(i,j) == couleur) && (lireCouleurDuJeton(i+1,j+1) == couleur) && (lireCouleurDuJeton(i+2,j+2) == couleur) && (lireCouleurDuJeton(i+3,j+3) == couleur)){
                   return true ; 
                }
            }
        }
        //Teste sur les diagonales montantes
        for (int i=0; i < 3 ; i++){
            for (int j=0; j < 4 ; j++){
                if((lireCouleurDuJeton(5-i,j) == couleur) && (lireCouleurDuJeton(4-i,j+1) == couleur) && (lireCouleurDuJeton(3-i,j+2) == couleur) && (lireCouleurDuJeton(2-i,j+3) == couleur)){
                   return true ; 
                }
            }
        }
        return false ;
    }
    
    /**
     * Méthode permettant de tasser une colonne lorsque un jeton est détruit/suprimé
     * @param j colonne que l'on souhaite tasser (type : int)
     */
    public void tasserColonne(int j){
        for (int i=0; i < 5 ; i++){                     //On ne s'occupe pas de la premiere ligne (en effet il n'y a pas de lignes au dessus)
            if(presenceJeton(6-i,j) == false){
                grille[5-i][j] = grille[4-i][j] ;
                grille[4-i][j].supprimerJeton();
            }
        }
    }
    
    /**
     * Méthode permettant de savoir si une colonne est remplie ou non
     * @param j la colonne 
     * @return "true" (si oui) "false" (si non) (type : boolean)
     */
    public boolean colonneRemplie(int j){
        return presenceJeton(0,j) ;
    }
    
    /**
     * Méthode permettant de placer un trounoir sur la grille au coordonées souhaitées
     * @param x ligne souhaitée (type : int)
     * @param y colonne souhaitée (type : int)
     */
    public void placerTrouNoir(int x, int y){
        grille[x][y].placerTrouNoir();
    }
    
    /**
     * Méthode permettant de supprimer un trounoir sur la grille au coordonées souhaitées
     * @param x ligne souhaitée (type : int)
     * @param y colonne souhaitée (type : int)
     */
    public void supprimerTrouNoir(int x, int y){
        grille[x][y].supprimerTrouNoir();
    }
    
    /**
     * Méthode permettant de placer un Desintegrateur sur la grille au coordonées souhaitées
     * @param x ligne souhaitée (type : int)
     * @param y colonne souhaitée (type : int)
     */
    public void placerDesintegrateur(int x,int y){
        grille[x][y].placerDesintegrateur();
    }
    
    /**
     * Méthode permettant de supprimer un jeton sur la grille au coordonées souhaitées
     * @param x ligne souhaitée (type : int)
     * @param y colonne souhaitée (tpe : int)
     */
    public void supprimerJeton(int x, int y){
        grille[x][y].supprimerJeton();
    }
    
    /**
     * Méthode permettant de récupérer un jeton sur la grille au coordonées souhaitées
     * @param x ligne souhaitée (type : int)
     * @param y colonne souhaitée (type int)
     */
    public void recupererJeton(int x, int y){
        grille[x][y].recupererJeton();
    }
    
}
