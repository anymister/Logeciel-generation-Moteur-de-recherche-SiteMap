package projet;


	
import java.io.BufferedWriter;

import java.io.Serializable; 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;	
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


import java.util.regex.Matcher;
import java.util.regex.Pattern;


	public class TraitementIndexation implements Serializable{
		
		private static final long serialVersionUID = 1L;
		
		
		private  Matcher match1;
		private  Matcher match2;
		private  Matcher match3;
		private  Matcher match4;
		ObjectInputStream oiss = null;
        ObjectOutputStream ooss = null;
		FileInputStream fi;
		
	
		
		
		private  String st;
		private  String g;
		Pattern p;
	public TraitementIndexation(String g,String st)   {
	setG(g);
		this.st=st;
			
		
				try {
					maini(g);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
	}
	 public void setSt(String st) {
		this.st = st;
	}
	public  String getSt() {
		return st;
	}
	
	public String getG() {
		return g;
	}
	public void setG(String g) {
		this.g = g;
	}
	public	void ecrire(Matcher s) throws IOException {
		
	           
	         
	          try {
	            ooss = new ObjectOutputStream( new FileOutputStream  ( new File(getSt()+"\\data.ser"),true));
	            ooss.writeObject(s.group(1)+"\r\n");
	            ooss.close();
	        } catch (FileNotFoundException e1) {
	            // TODO Auto-generated catch block
	            e1.printStackTrace();
	        } catch (IOException e1) {
	            // TODO Auto-generated catch block
	            e1.printStackTrace();
	        }
	          
	    
	         
	          
	          
	     	BufferedWriter writ = new BufferedWriter(new FileWriter(new File(getSt()+"\\"+"indexation.txt"),true));

			writ.write(s.group(1)+"\r\n");
			writ.close();
			
		}
		public void chem(String fii) {
		
		  	BufferedWriter chem;
			try {
				
				
				chem = new BufferedWriter(new FileWriter(new File(getSt()+"\\"+"chemin.txt"),true));
				chem.write(fii+"\r\n");
				chem.close();
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

					
					
			
		}
		
		public  void maini(String f) throws IOException {
			// TODO Auto-generated method stub
			
			Indexation h1 = new Indexation(".*<h1>(.*)\\</h1\\>");
			Indexation title = new Indexation(".*<title>(.*)\\</title\\\\>");
			Indexation Title = new Indexation(".*<TITLE>(.*)\\</TITLE\\>");
			Indexation H1 = new Indexation(".*<H1>(.*)\\</H1\\>");
			
			Title.Path(f);
			title.Path(f);
			h1.Path(f);
			H1.Path(f);
			
			match1 = title.Search();
			match2 = h1.Search();
			match3 = H1.Search();
			match4 = Title.Search();
		
			while (match1.find()){
				String Text= Remplace(match1.group(1));
				ecrire(match1);
				chem(getG());
				
				
				System.out.println(getG()+" \n" +Text+"\n");
				}
			while (match3.find()){
				String Text= Remplace(match3.group(1));
				ecrire(match3);
				chem(getG());
				
				
				System.out.println(getG()+" \n" +Text+"\n");
				
				
				}
			while (match4.find()){
				String Text= Remplace(match4.group(1));
				ecrire(match4);
				chem(getG());
				System.out.println(getG()+" \n" +Text+"\n");
				
				}
			while (match2.find()){
				
				String Text= Remplace(match2.group(1));
				ecrire(match2);
				chem(getG());
				
				
				System.out.println(getG()+" \n" +Text+"\n");
		
				
			}
			}
		
		private static String Remplace(String remplace) {
            remplace = Pattern.compile("&agrave;").matcher(remplace).replaceAll("à");
            remplace = Pattern.compile("&Agrave;").matcher(remplace).replaceAll("À");
            remplace = Pattern.compile("&Acirc;").matcher(remplace).replaceAll("Â");
            remplace = Pattern.compile("&acirc;").matcher(remplace).replaceAll("â");
            remplace = Pattern.compile("&ccedil;").matcher(remplace).replaceAll("ç");
            remplace = Pattern.compile("&Ccedil;").matcher(remplace).replaceAll("Ç");
            remplace = Pattern.compile("&eacute;").matcher(remplace).replaceAll("é");
            remplace = Pattern.compile("&Eacute;").matcher(remplace).replaceAll("É");
            remplace = Pattern.compile("&egrave;").matcher(remplace).replaceAll("è");
            remplace = Pattern.compile("&Egrave;").matcher(remplace).replaceAll("È");
            remplace = Pattern.compile("&ecirc;").matcher(remplace).replaceAll("ê");
            remplace = Pattern.compile("&Ecirc;").matcher(remplace).replaceAll("Ê");
            remplace = Pattern.compile("&euml;").matcher(remplace).replaceAll("ë");
            remplace = Pattern.compile("&Euml;").matcher(remplace).replaceAll("Ë");
            remplace = Pattern.compile("&icirc;").matcher(remplace).replaceAll("î");
            remplace = Pattern.compile("&Icirc;").matcher(remplace).replaceAll("Î");
            remplace = Pattern.compile("&iuml;").matcher(remplace).replaceAll("ï");
            remplace = Pattern.compile("&Iuml;").matcher(remplace).replaceAll("Ï");
            remplace = Pattern.compile("&ocirc").matcher(remplace).replaceAll("ô");
            remplace = Pattern.compile("&Ocirc").matcher(remplace).replaceAll("Ô");
            remplace = Pattern.compile("&oelig;").matcher(remplace).replaceAll("œ");
            remplace = Pattern.compile("&OElig;").matcher(remplace).replaceAll("Œ");
            remplace = Pattern.compile("&ucirc;").matcher(remplace).replaceAll("û");
            remplace = Pattern.compile("&Ucirc;").matcher(remplace).replaceAll("Û");
            remplace = Pattern.compile("&nbsp;").matcher(remplace).replaceAll(" ");
            remplace = Pattern.compile("Ã©").matcher(remplace).replaceAll("é");
           
            remplace = Pattern.compile("Ã").matcher(remplace).replaceAll("è");
          //  remplace = Pattern.compile("").matcher(remplace).replaceAll(" ");
          //  remplace = Pattern.compile("").matcher(remplace).replaceAll(" ");
          //  remplace = Pattern.compile("").matcher(remplace).replaceAll(" ");
          //  remplace = Pattern.compile(",").matcher(remplace).replaceAll(" ");
          //  remplace = Pattern.compile(",").matcher(remplace).replaceAll(" ");
            remplace = Pattern.compile("¨").matcher(remplace).replaceAll("");
            remplace = Pattern.compile("\\)").matcher(remplace).replaceAll(" ");
            remplace = Pattern.compile("\\(").matcher(remplace).replaceAll(" ");
             remplace = Pattern.compile("¯").matcher(remplace).replaceAll(" ");
            remplace = Pattern.compile("-").matcher(remplace).replaceAll(" ");
            remplace = Pattern.compile(",").matcher(remplace).replaceAll(" ");
            remplace = Pattern.compile(";").matcher(remplace).replaceAll(" ");
            remplace = remplace.replaceAll("<[^>]*>", "");
            return remplace;
			
			
			
		}
		
	}

