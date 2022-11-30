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
    /**
     * Accesseur en écriture qui permet de mettre à jour la valeur de notre attribut "jetonCourant"
     * @param unjeton le Jeton à attribuer à la cellule 
     */
    public void affecterJeton(Jeton unjeton){
        jetonCourant = unjeton;
    }
    /**
     * Méthode qui permet de renvoyer la couleur du jeton sur la case
     * @return "rouge" ou "jaune" ou "vide" 
     */
    public String lireCouleurDuJeton() {
        if(jetonCourant != null){
            return jetonCourant.lireCouleur();
        }
        else{
            return "vide" ;
        } 
    }
    /**
     * Accesseur en écriture qui permet de affecter la valeur "true" à notre attribut "avoirTrouNoir" (ajouter un troue noir sur la cellue)
     */
    public void placerTrouNoir() {
        avoirTrouNoir = true ;
    }
    /**
     * Accesseur en écriture qui permet de affecter la valeur "false" à notre attribut "avoirTrouNoir" (supprimer un toue noir sur la cellule)
     */
    public void supprimerTrouNoir(){
        avoirTrouNoir = false ;
    }
    /**
     * Methode qui renvoie si un troue noir est présent ou pas
     * @return "true" or "false" (type : boolean)
     */
    public boolean presenceTrouNoir(){
        return avoirTrouNoir ;
    }
    
    
}
