/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.superpuissance4_hinton_baudoin;

/**
 *
 * @author 33621
 */
//Définition de la classe "CelluleDeGrille" :
public class CelluleDeGrille {
    private Jeton jetonCourant ;
    private boolean avoirTrouNoir ;
    private boolean avoirDesintegrateur ;
    
    /**
     *Constructeur d'objet de type "CelluleDeGrille"
     */
    public CelluleDeGrille() {
        jetonCourant = null ;
        avoirTrouNoir = false ;
        avoirDesintegrateur = false ;
    }
    /**
     * Méthode qui permet de tester la présence d'un jeton sur la cellule de la grille
     * @return boolean true = oui /false = non
     */
    public boolean presenceJeton(){
        if(jetonCourant != null){
            return true ;
        }
        else{
            return false ; 
        }
    }
    
    
    
}
