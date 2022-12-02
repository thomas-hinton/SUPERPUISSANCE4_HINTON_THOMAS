/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.superpuissance4_hinton_baudoin;

import java.util.ArrayList;

/**
 *
 * @author 33621
 */
//Définition de la classe "joueur" :
public class joueur {
    private String nom ;
    private String couleur ;
    private ArrayList<Jeton> reserveJetons = new ArrayList();
    private int nombreDesintegrateurs ;
    
    /**
     * Constructeur d'objet de type "joueur"
     * @param nomjoueur le nom du joueur (type : String)
     */
    public joueur(String nomjoueur){
        nom = nomjoueur ;
        nombreDesintegrateurs = 0 ;
    }
    
}
