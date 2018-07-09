package projet;


	import java.io.BufferedWriter;
	import java.io.File;
	
	import java.io.FileWriter;
	import java.io.IOException;
	
	import java.sql.Date;
	import java.text.SimpleDateFormat;

	public class SiteMap {
	   public String s;
		 
		/**
		 * Constructeur
		 * @param path chemin du répertoire
		 * @param subFolder analyse des sous dossiers
		 */
		   
		    public SiteMap(String b,String v,String stt) {
		    	
		       this.s=stt;
		    	
		        File f=new File(b);
		        
		     	 String c=getFormatedDate(f);
		     
		     	 CreationDuFichier(c,v);
		       }
			
		   

	public String getS() {
			return s;
		}



		public void setS(String s) {
			this.s = s;
		}



	/**
	 * extraire la date de derniere modification du fichier
	 * @param f fichier quand veux lui soustraire la date de derniere modif
	 * @return
	 */
		    public String getFormatedDate(File f) {
				
			        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); // 
			        Date d = new Date(f.lastModified());
			       
			        return sdf.format(d);
			}
		   
		    /**
		     *   le texte à ecrire sur le fichier XML
		     * @param v la date derniere modif
		     * @param k le nom du dossier
		     * @param a le nom du fichier
		     */
		public void CreationDuFichier(String v,String a) {
				
					try {
						BufferedWriter writer = new BufferedWriter(new FileWriter(getS(), true));
					
				
						
						writer.write(	"   <url>\r\n" + 
								"\r\n" + 
								"<loc>");
						writer.write("http://www.promenade.com/");
						writer.write(a);
					
						writer.write("</loc>\r\n" + 
								"\r\n" + 
								" <lastmod>");
						
						
						writer.write(v);
						
						writer.write("</lastmod>\r\n" + 
								 
								"\r\n" + 
								"<frequence> Monthly </frequence>"+
								"      <priority> 0.5 </priority>\r\n" + 
								
								"\r\n" + 
								"   </url>\r\n");
						
						writer.close();
						
						}
						catch (IOException e)
						{
					
					e.printStackTrace();
						}
			}
			
		}         
	
	





