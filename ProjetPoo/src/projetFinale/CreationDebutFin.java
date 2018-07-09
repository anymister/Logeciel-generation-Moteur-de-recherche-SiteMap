package projetFinale;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CreationDebutFin{
	 
			String s122;		
			/**
			 * 
			 * @param s122 le chemin où il va enregistrer le résultat.
			 */
			public CreationDebutFin(String s122) {
				this.s122=s122;
				
			}
			
			/**
			 * 
			 * @return retourne le chemin  où il enregistre le sitemap.xml
			 */
			public String getS122() {
				return s122;
			}

			/**
			 * 
			 * @param s122 entrer le chemin  où il enregistre le sitemap.xml
			 */
			public void setS122(String s122) {
				this.s122 = s122;
			}

			/**
			 * 
			 *  @throws IOException si le chemin n'existe pas
			 * @param s le chemin où il enregistre les premiers balises meme si il a deja etais initialiser
			 
			 
			 */
			public void debutDuFichier(String s) throws IOException {
			
			BufferedWriter wri = new BufferedWriter(new FileWriter(getS122(), true)); // ecrire les deux premiere balises du fichier

		wri.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
					"\r\n" + 
					"<urlset xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.5\">\r\n ");
			wri.close();
		
			
		}
	 //ecrire la balise </urlset> à la fin du fichier sitemap.xml
			
			/**
			 *  @throws IOException si le chemin n'existe pas
			 * 
			 * @param s chemin ou il va ecrire la balise meme si il a deja etais initialiser
			 */
	 public void finDuFichier(String s) throws IOException {
			BufferedWriter writ = new BufferedWriter(new FileWriter(getS122(), true));
			writ.write("</urlset > ");
			writ.close();
			
		}
}
