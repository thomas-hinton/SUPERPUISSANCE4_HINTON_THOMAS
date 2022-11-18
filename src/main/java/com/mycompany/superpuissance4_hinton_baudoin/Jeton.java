/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.superpuissance4_hinton_baudoin;

/**
 *
 * @Créated by Mr Baudoin et Mr Hinton 
 */
//Création de la classe Jeton :
public class Jeton {
    private String couleur;
    
    /**
     * Constructeur d'objet de class "Jeton"
     * @param couleur peut prendre la valeur Jaune et Rouge
     */
    public Jeton(String unecouleur) {
        couleur = unecouleur;
    } 
    /**
     * Méthode permettant de lire et renvoyer la couleur du jeton
     * @return couleur string
     */
    String lireCouleur(){
        return couleur;
    }
    /**
     * Méthode "toString()" qui permet de renvoyer la couleur du jeton "R" ou "J"
     * @return 
     */
    @Override
    public String toString() {      
        String chaine_a_retourner ;
        if (couleur == "rouge"){            //Teste si la couleur est rouge ou jaune
            chaine_a_retourner = "R" ;
        }
        else{
            chaine_a_retourner = "J" ;
        }
        return chaine_a_retourner ;
    }
}
