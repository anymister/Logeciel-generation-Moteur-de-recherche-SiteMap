package projetFinale;

import java.io.BufferedReader; 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader; 
import java.io.IOException;
import java.util.ArrayList;


public class Recherche {
	
	public ArrayList <String> aL ; 
	public ArrayList <String> aL5;
	public ArrayList<String> aL4;
	
	private BufferedReader rd,rdd;
	public int i ; 
	public int[] tab; 

	
	public Recherche() {
		tab= new int[10000];
		aL5= new ArrayList <String>();
		aL4= new ArrayList <String>();
		aL= new ArrayList <String>();
	}
	/**
	 * indexation.txt est fichier intermediare qui sera supprimer apres le remplissage de l'arraylist
	 * methode qui permet d'ajouter toute l'indexation dans l'arraylist aL5
	 * @param oo chemin du fichier intermediare indexation.txt
	 */
	public void ajou(String oo) { 
		
		String lin=null;
		File f=new File(oo+"\\indexation.txt"); // 

		try {
			rd = new BufferedReader(new FileReader(f));
			
			try {
				while((lin= rd.readLine()) !=null) {
					aL5.add(lin);
				}
			}
			
		catch (IOException e) {
			
			e.printStackTrace();
		}
			
		try {
			rd.close();
		}
			catch(IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		f.delete() ;
		
		}
		/**
		 * 
		 *  methode qui permet de lire le fichier intermediare qui 
		 *  chemin.txt est fichier intermediare qui contient les chemin des fichiers indexer et qui sera supprimer apres le remplissage de l'arraylist
		 *  chaine de caractère utilisé pour lire le fichier intermediaire qui contient tout les chemins des fichiers
		 * @param o  chemin du fichier intermediare chemin.txt
		 */
		
		public void chemAjou(String o) { 	
			
							//contient tout les chemins des fichiers indexer et qui sera supprimer apres le remplissage de l'arraylist aL4
			
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

				
			/**
			 *  methode qui permet la recherche du mot voulu et ajouter les resultats dans l'arraylist aL5 
			 * @param v le mot à rechercher
			 */

			public void lire(String v)  { //
				
		 i=0;
		 int k=0;

				
				for(int j=0;j<aL5.size();j++) { //parcourir l'arraylist aL5 qui contient l'indexation
					// si l arraylist aL5 contient le mot 'v' voulu en majuscule est miniscule
				if(aL5.get(j).contains(v)||aL5.get(j).contains(v.toLowerCase())||aL5.get(j).contains(v.toUpperCase ())) { 	
					i=1;
					tab[k]=j; //ajouter la position du resultat trouver dans un tableau
					k++;
					aL.add(aL5.get(j)); //ajouter le resultat dasn l arraylist aL
					
					System.out.println(aL5.get(j)+"__"+aL.size()); 
			}
				}
				if(i!=1) {
					System.out.println("Le mot ----"+v+"----n'est pas trouver"); 	
				}
				
				}
}
