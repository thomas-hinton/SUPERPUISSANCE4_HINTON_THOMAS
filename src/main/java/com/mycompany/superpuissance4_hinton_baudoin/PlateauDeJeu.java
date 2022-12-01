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
    
    
    
    
    
    
    
    
    
    
    
}
