package projet;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CreationDebutFin {
	 
			
			String s122;
			
			public CreationDebutFin(String s122) {
				this.s122=s122;
				
			}
			
			public String getS122() {
				return s122;
			}

			public void setS122(String s122) {
				this.s122 = s122;
			}

			public void debutDuFichier(String s) throws IOException {
			
			BufferedWriter wri = new BufferedWriter(new FileWriter(getS122(), true)); //ecrire les deux premieres balises du fichier
			

		wri.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 					// sitemap.xml
					"\r\n" + 
					"<urlset xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.5\">\r\n ");
			wri.close();  // terminer l'ecriture et fermer la methode write
		
			
		}
	 // ecrire la balise </urlset> à la fin du fichier sitemap.xml
			public void finDuFichier(String s) throws IOException {
			BufferedWriter writ = new BufferedWriter(new FileWriter(getS122(), true)); // creer le bufferedWrite pour pouvoir ecrire et 
																						//appel le chemin et true permet de sauter à la ligne
																						// à chaque appel
			writ.write("</urlset > "); //
			writ.close();// fermer la methode write
			
		}
}

