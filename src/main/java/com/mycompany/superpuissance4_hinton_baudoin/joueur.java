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
    
    /**
     * Méthode permettant d'attribuer une couleur à un joueur
     * @param uneCouleur couleur souhaitée ("jaune" ou "rouge") (type : String) 
     */
    public void affecterCouleur(String uneCouleur){
        couleur = uneCouleur ;
    }
    
    /**
     * Méthode permettant de indiquer le nombre de jetons restants au joueur
     * @return le nombre de jetons restants (type : int)
     */
    public int nombreDeJetons(){
        return reserveJetons.size() ;
    }
    
    /**
     * Méthode permettant d'ajouter un jeton à la reserve de jetons
     * @param unJeton le jeton que l'on souhaite ajouter à la reserve (type : Jeton)
     */
    public void ajouterJeton(Jeton unJeton){
        reserveJetons.add(unJeton) ;
    }
    
    /**
     * Méthode permettant de simuler le jeux d'un jeton. (retir 1 de la reserve et renvoie la référence vers ce jeton)
     * @return référence du jeton (type : Jeton)
     */
    public Jeton jouerJeton(){
        Jeton reference = reserveJetons.remove(0);
        return reference ;
    }
    
    /**
     * Méthode permettant  d'incrémenter le nombre de désintégrateurs du joueur
     */
    public void obtenirDesintegrateur(){
        nombreDesintegrateurs += 1 ;
    }
    
    /**
     * Méthode permettant de décrémenter le nombre de désintégrateurs du joueur
     */
    public void utiliserDesintegrateur(){
        nombreDesintegrateurs -= 1 ;
    }
    
}
