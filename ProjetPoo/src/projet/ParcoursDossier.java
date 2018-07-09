package projet;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

 
/**
 * Lister le contenu d'un répertoire
 * http://www.fobec.com/java/964/lister-fichiers-dossiers-repertoire.html
 * @author fobec 2010
 */
public class ParcoursDossier {
 
    private String initialpath = "";
    private Boolean recursivePath = false;
  
 private String g1;
    public ArrayList <String> Ar; //enregistre les chemins des fichiers parcourus
    public ArrayList <String> Ar1;//enregistre les noms des dossiers parcourus
    
    
   
/**
 * Constructeur
 * @param path chemin du répertoire
 * @param subFolder analyse des sous dossiers
 */
    public ParcoursDossier(String path, Boolean subFolder) { // methodes principale qui appels les methodes au dessous
        super();
        this.initialpath = path; //initialiser le chemin du dossier a traiter
        this.recursivePath = subFolder;
        Ar1=new ArrayList <String> () ;
        Ar=new ArrayList <String> () ;
        
    }
    
    
    
    
    public int NbrF () { //la taille de l arraylist Ar
	    return Ar.size();
	    }
    
    
    
    
    public static String getFileExt(String fil) { // extraire l'extension du fichier dans le chemin est fil
        int pos = fil.lastIndexOf(".");
        if (pos > -1) {
            return fil.substring(pos);
        } else {
            return fil;
        }
       
    
        
    
    }
  
    
    public void list() throws IOException { //appel la methode lisDirectory avec le chemin du dossier à traiter
        this.listDirectory(this.initialpath);
    }
 
   public void listDirectory(String dir) throws IOException {
        File file = new File(dir); //initialiser un file avec le chemin du dossier
        File[] files = file.listFiles();
        if (files != null) { // si il est pas vide
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory() == true) { //parcourir le dossier
                    
                    g1=files[i].getName(); //ajouter le nom du dossier dans le String g1
                    
                  
                } else {
                	String g12=dir+"."+files[i].getName(); //creer un string g12 avec le chemin du dossier à triater et le nom du fichier
                	String s=".html"; //creer un string qui contient .html
                	
                	if (getFileExt(files[i].getName()).equals(s) ) { //si l'extension du fichier correspont à .html
                		if(g12!=files[i].getAbsolutePath()) { //si le chemin du fichier ne correspont pas au chemin des fichier racines du dossier à traiter
                			
                			Ar1.add(g1+"/"+files[i].getName());  //ajouter le nom du dossier dansune arralist ar1
                			Ar.add(files[i].getAbsolutePath());  //ajouter le chemin du fichier dans une arraylist ar
                		
                    System.out.println("  Fichier: " + files[i].getName());
                   
       		     
                		}
                   
                    
                }}
                if (files[i].isDirectory() == true && this.recursivePath == true) { //appel recursif de la methode listDirectory
                    this.listDirectory(files[i].getAbsolutePath());
                }
            }
        }
    }    

}