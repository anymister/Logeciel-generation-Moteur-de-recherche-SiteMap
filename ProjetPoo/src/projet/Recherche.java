package projet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class Recherche {

	
	public ArrayList <String> aL;
	public ArrayList <String> aL5;
	public ArrayList <String> aL4;
	
	
	private BufferedReader	rd,rdd ;
	
	public int i;
	public int [] tab;
	
	public Recherche() {
		tab=new int[10000];
		aL5= new ArrayList <String>();	// toute les phrases enregistrer dans le data.ser
		aL4= new ArrayList <String>(); //  chemins de chaque fichier indexer 
		aL= new ArrayList <String>(); // resultat de la recherche
		
	}

public void ajou(String oo) { // methode qui permet d'ajouter toute l'indexation dans l'arraylist aL5
	
	String lin=null;
	File f=new File(oo+"\\indexation.txt"); // fichier intermediare qui sera supprimer apres le remplissage de l'arraylist
	try {
		rd = new BufferedReader(new FileReader(f));
	
		 try {
			
		while ((lin = rd.readLine()) != null) { 
				 aL5.add(lin); // remplir l'arraylist avec toute les phrases enregistrer dans le fichier intermediare
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		try {
			rd.close(); // fermerla lecture
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); //si le fichier n'existe pas
		}
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		
		f.delete(); //supprimer le fichier intermediare indexation.txt
		
	 }



public void chemAjou(String o) { // methode qui permet de lire le fichier intermediare qui 
	//contient tout les chmins des fichiers indexer et qui sera supprimer apres le remplissage de l'arraylist aL4
	
	String lin=null;
	File fi=new File(o+"\\chemin.txt"); // fichier intermediare chemin.txt
	try {
		rdd = new BufferedReader(new FileReader(fi)); // creer un lecteur du fichier intermediare chemin.txt
	
		 try {
			
			while ((lin = rdd.readLine()) != null) { //parcourir le fichier chemin.txt ligne par ligne
				 aL4.add(lin);//ajouter les chemins dans l'arraylist al4
			
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		try {
			
			
			
			rdd.close();//fermer la lecture du fichier chemin.txt
		
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		
		fi.delete(); //supprimer le fichier intermediare chemin.txt
		
	 }

		
	

	public void lire(String v)  { // methode qui permet la recherche du mot voulu et ajouter les resultats dans l'arraylist aL5 
		
 i=0;
 int k=0;

		
		for(int j=0;j<aL5.size();j++) { //parcourir l'arraylist aL5 qui contient l'indexation
			// si l arraylist aL5 contient le mot 'v' voulu en majuscule est miniscule
		if(aL5.get(j).contains(v)||aL5.get(j).contains(v.toLowerCase())||aL5.get(j).contains(v.toUpperCase ())) { 	
			i=1;
			tab[k]=j; //ajouter la position du resultat trouver dans un tableau
			k++;
			aL.add(aL5.get(j)); //ajouter le resultat dasn l arraylist aL
				
			System.out.println("Résultat : "+aL5.get(j)+"____Nombre de resultats obtenu : "+aL.size()); 
		}
				}
	if(i!=1) {
		System.out.println("Le mot ----"+v+"----n'est pas trouver"); 	
	}
	
	}
	
	
	

	
}
