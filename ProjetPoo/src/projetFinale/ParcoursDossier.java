package projetFinale;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

 
/**
 * Lister le contenu d'un répertoire
 
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
    
    
    /**
     * 
     * @return la taille de l arraylisy Ar
     */
    
    public int NbrF () { //la taille de l arraylist Ar
	    return Ar.size();
	    }
    
    
    /**
     *  extraire l'extension du fichier dans le chemin est fil
     * @param fil le nom du fichier 
     * @return l'extention du fichier 
     */
    
    public static String getFileExt(String fil) { 
        int pos = fil.lastIndexOf(".");
        if (pos > -1) {
            return fil.substring(pos);
        } else {
            return fil;
        }
       
    
        
    
    }
  
    /**
     * 
     * @throws IOException le chemin n'existe pas
     * //appel la methode lisDirectory avec le chemin du dossier à traiter
     
     
     */
    public void list() throws IOException { 
        this.listDirectory(this.initialpath);
    }
 /**
  * 
  * @param dir le chemin du dossier à traiter et qui sera modifier recursivement pour traiter tout le dossier et sous dossiers
  * @throws IOException si le chemin n'existe pas
  *  
  */
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
