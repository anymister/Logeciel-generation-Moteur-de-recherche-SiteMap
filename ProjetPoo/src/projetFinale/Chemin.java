package projetFinale;

public class Chemin {

public String g;

/**
 * méthode pour le chemin de chaque fichier du dossier.
 * @param g le chemin qu'onva utiliser pour en va enregistrer le sitemap.xml et data.ser
 */

public Chemin(String g) {
	this.g=g;
	
	
}
/**
 * 
 * @return retourne le chemin g
 */
public String getG() {
	return g;
}
/**
 * 
 * @param g le chemin obtenue
 */
public void setG(String g) {
	this.g = g;
}


public String toString() {
	return "G [g=" + g + "]";
}


}
