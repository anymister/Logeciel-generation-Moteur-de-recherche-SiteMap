package projet;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Indexation {
	Pattern p ;
	Matcher match;
	String path;
	/**
	 * 	traiter le fichier dans le chemin est 'car'
	 * @param car est une chaine de caractère permet d'acceder au contenue du fichier à traiter.
	 */

	public Indexation (String car){
		p = Pattern.compile(car);
	}

	/**
	 *  enregistre le chemin du fichier à traiter
	 * @param chemin est le chemin vers le fichier à indexer
	 */
	
	
	public void Path (String chemin){
		path = chemin;
	}
	
	
	/**
	 * //creer un matcher 
	 * @return retourne le motif que l'on chercher dans le FileContent c'est à dire dans le contenue du dossier qui est traiter.
	 * @throws IOException le chemin n'est pas absolue.
	 */
	public Matcher Search() throws IOException{
		File file = new File(path);
		String FileContent = readFileASString(file.getAbsolutePath()); // lire le File comme un chaines de caracteres
		match = p.matcher(FileContent);
		return match; //retourner le match
	}
	/**
	 * 
	 * @param filePath le chemin du fichier.
	 * @return le chemin d'accès 
	 * @throws java.io.IOException type d'erreur qui se trouve à l'interieur de try 
	 */
	private static String readFileASString(String filePath) throws java.io.IOException{
	byte[] buffer = new byte[(int) new File(filePath).length()];
	BufferedInputStream f = null;
	try{
		f = new BufferedInputStream(new FileInputStream(filePath)); // creer le lecteur du fichier dans le chemin est filePath
		f.read(buffer); // lire le fichier
	} 
	finally {
		if (f != null) try { f.close();} catch (IOException ignored){} //fermer la lecture

	}
		
		return new String(buffer);
	}
	
	
}


