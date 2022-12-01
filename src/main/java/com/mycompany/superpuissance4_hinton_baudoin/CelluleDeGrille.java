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
    /** 
     * Méthode qui permet de retourner une référence vers le jeton de la cellule et supprimer ce dernier de la cellule
     * @return référence vers la cellule (type : Jeton)
     */
    public Jeton recupererJeton(){
        Jeton temporaire = jetonCourant ;
        jetonCourant = null ;
        return temporaire ;
    }
    /**
     * Méthode qui permet de supprimer un jeton de la cellule
     */
    public void supprimerJeton(){
        jetonCourant = null ;
    }
    /**
     * Méthode qui permet de renvoyer la présence ou non d'un désintégrateur sur la cellule
     * @return "true" or "false" (type : boolean) 
     */
    public boolean presenceDesintegrateur(){
        return avoirDesintegrateur ;
    }
    /**
     * Accesseur en écriture qui permet de affecter la valeur "true" à notre attribut "avoirDesintegrateur" (placer un désintegrateur sur la cellule)
     */
    public void placerDesintegrateur(){
        avoirDesintegrateur = true ;
    }
    /**
     * Accesseur en écriture qui permet de affecter la valeur "false" à notre attribut "avoirDesintégrateur" (supprimer un désintégrateur)
     */
    public void supprimerDesintegrateur(){
        avoirDesintegrateur = false ;
    }
    /**
     * Méthode qui permet de activer le trou noir (supression du Jeton et du Trou Noir)
     */
    public void activerTrouNoir(){
        supprimerJeton() ;
        supprimerTrouNoir() ;
    }

    
     /**
     * Méthode "toString()" qui permet de renvoyer ce qui se trouve dans la cellule
     * @return "rouge" or "jaune" or "@" or "D" or "." (type : String)
     */
    @Override
    public String toString() {      
        if (lireCouleurDuJeton() == "rouge"){            //Teste si la couleur est rouge 
            return "R" ;
        }
        if (lireCouleurDuJeton() == "jaune"){            //Teste si la couleur est jaune
            return "J" ;
        }
        if (presenceTrouNoir() == true) {                //Teste si un trou noir est présent sur la cellule
            return"@" ;
        }
        if (presenceDesintegrateur() == true){           //Teste si un desintégrateur est présent sur la cellule
            return"D" ;
        }
        else{                                            //Si la cellule est vide renvoie "."
            return "." ;
        }
    }
    
    
}