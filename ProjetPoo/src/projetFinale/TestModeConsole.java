package projetFinale;




import java.io.IOException;
import java.util.Scanner;

public class TestModeConsole {
	
//C:\Users\USER\Desktop\2eme ann�e ucp\programmation orienter objet\projet\promenade_fr.d

	private static Scanner c1;
	private static Scanner c2;
	private static Scanner c3;

	public static void main(String[] args) {
		 String s1;
		 String s2;
		 String s3;
		 
		 	
		
		
		System.out.println("Entrer le chemin du dossier � traiter \r\n");
		
		c1 = new Scanner(System.in);
		s1= c1.nextLine();
		System.out.println("Entrer le chemin ou voulez enregistrer votre 'SiteMap.xml'  et  'data.ser' \r\n");
		c2 = new Scanner(System.in);
		s2= c2.nextLine();
		
		
		
				System.out.println("Entrer le mot que vous voulez rechercher\n");
				c3 = new Scanner(System.in);
				 s3= c3.nextLine();
				 
		ParcoursDossier diskFileExplorer = new ParcoursDossier(s1, true);
		CreationDebutFin si=new CreationDebutFin(s2+"\\sitemap.xml");
		

		
	try {
		  
		diskFileExplorer.listDirectory(s1);
	
	  } catch (IOException e1) {
		e1.printStackTrace();
	}
	  
		try {
			si.debutDuFichier(s2+"\\sitemap.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
/*
 * 
 */
		
	for (int i=0;i<diskFileExplorer.NbrF();i++) {
		  String v=diskFileExplorer.Ar1.get(i);
		  String k=diskFileExplorer.Ar.get(i);      
	  
	//
		  new Chemin(s2);// chemin
		  
		new SiteMap(k,v,s2+"\\sitemap.xml");
      new TraitementIndexation(k,s2);
      
      
 
     	
     	System.out.println("Chemin : "+diskFileExplorer.Ar.get(i));
}	
	Recherche a=new Recherche();
	a.ajou(s2);
	a.chemAjou(s2);
	a.lire(s3);

		
 try {
		si.finDuFichier(s2+"\\sitemap.xml");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


}}

