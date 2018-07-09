package projetFinale;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class InterfaceInstalation extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	JButton b1;
	JButton b2;
	JButton b3;
	JButton b4;
	JButton b5;
	JButton b6;
	
	
	
	JTextField f1;
	JTextField f2;
List L;
	
	JPanel p1;
	JPanel p2;
	JPanel p3;
	JPanel p4;
	
	
	JLabel j1;
	JLabel j2;
	JLabel j3;
	JLabel j4;

	
	public InterfaceInstalation() {
		super();
	
		setTitle("Génération du 'data.ser' du 'SiteMap.xml'");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800,400);
	
		 init();
		 
		 pack();
		 setLocationRelativeTo(null);
		 setVisible(true);
		
	}
	
	

	public void init() {

		BorderLayout border = new BorderLayout(30,150);
		Container contentPane = getContentPane();
		contentPane.setLayout(border);

		
	L=new List(5);
		
		b1=new JButton("Générer");
		b2=new JButton("Démarer");
		b3=new JButton("Quitter");
		b4=new JButton("Effacer");
		b5=new JButton("Précédent");
		b6=new JButton("OpenSiteMap");
		
		
		f1=new JTextField(35);
		f2=new JTextField(25);
	
		
	
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p4=new JPanel();
		
		
		j1=new JLabel("Chemin du dossier que vous voulez traiter");
		j2=new  JLabel("Votre 'Data.ser' et 'SiteMap.xml' seront enregistrer dans :");
		j3=new JLabel("Entrer les chemins suivant :");
		
		p1.add(j1);
		
		p2.add(j2);
		p2.add(f2);
		
		
		p1.add(f1);
		p1.add(L);
		
		f2.setBounds(5,52,2,2);
		
		p2.add(b6);
		
		
		p4.add(b5);
		p4.add(b2);
		p4.add(b3);
				
		
		
		contentPane.add(BorderLayout.NORTH, p1);
		 contentPane.add(BorderLayout.WEST, p2);
	
		 contentPane.add(BorderLayout.EAST, b1);
		 contentPane.add(BorderLayout.CENTER, p3);
		 
		 contentPane.add(BorderLayout.SOUTH, p4);
		
		
		
		 b1.addActionListener(new geAction());
		 b2.addActionListener(new suivAction());
		 
		 b3.addActionListener(new quiAction());
		 b4.addActionListener(new effAction());
		 b5.addActionListener(new preAction());
		 b6.addActionListener(new ouvAction());
		
		
		
	}
	
	
	
	
	
	
	public  class geAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			CreationDebutFin s1=new CreationDebutFin(f2.getText()+"\\sitemap.xml");
			
			ParcoursDossier diskFileExplorer = new ParcoursDossier(f1.getText(), true);
			
			
				int option = JOptionPane.showConfirmDialog(null, 
			
		        "Voulez-vous lancer la génération du SiteMap et l'indexation?", 
		        "Lancement de la génération", 
		        JOptionPane.YES_NO_OPTION, 
		        JOptionPane.QUESTION_MESSAGE);

		      if(option == JOptionPane.OK_OPTION){
		    	  JOptionPane.showMessageDialog(null,"Appyuez sur OK et patientez quelques instants s'il vous plait ...",
		    			  "Information", JOptionPane.INFORMATION_MESSAGE);
		       
		     
				try {
					
					
					s1.debutDuFichier(f2.getText()+"\\sitemap.xml");
				
				diskFileExplorer.listDirectory(f1.getText());
				
				 for (int i=0;i<diskFileExplorer.NbrF();i++) {
					  String v=diskFileExplorer.Ar1.get(i);
					  String k=diskFileExplorer.Ar.get(i);    
					 L.add(k);
					  new SiteMap(k,v,f2.getText()+"\\sitemap.xml");
			     	  new TraitementIndexation(k,f2.getText());
			     	
				 
				 }
				 s1.finDuFichier(f2.getText()+"\\sitemap.xml");
				 
				  new Chemin(f2.getText()+"\\"+"indexation.txt");
				  
				  
				JOptionPane.showMessageDialog(null,"l'installation de votre moteur est terminer avec succès, "
						+ "appuyez sur OK pour continuer", "Information", JOptionPane.INFORMATION_MESSAGE);
			
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				
			
			}
			}
		}	
	
				
		}
			
			
		
		
	
	
	
	private class effAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			f1.setText("");
			f2.setText("");
			
			
			
					
		}
	}
	

	private class ouvAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			
			int option = JOptionPane.showConfirmDialog(null, 
					
			        "Voulez-vous vraiment ouvrir le sitemap.xml?", 
			        "Comfirmation d'o"
			        + "uverture du sitemap.xml", 
			        JOptionPane.YES_NO_OPTION, 
			        JOptionPane.QUESTION_MESSAGE);

			      if(option == JOptionPane.OK_OPTION){
			    	  
			    	  Desktop desk = Desktop.getDesktop(); // parametre pour ouverture de fichier
			    	   
				    	
							try {
								desk.open(new File(f2.getText()+"\\sitemap.xml"));
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
			      }
			
					
		}
	}
	
	
	private class quiAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			int option1 = JOptionPane.showConfirmDialog(null, 
					
			        "Voulez-vous vraiment quitter ?", 
			        "Quitter le Promenade", 
			        JOptionPane.YES_NO_OPTION, 
			        JOptionPane.QUESTION_MESSAGE);

			      if(option1 == JOptionPane.OK_OPTION){
			    	  
			    	  dispose();
			
			      }
		}
	}
	
	private class suivAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			new IntefaceGraphique(f2.getText());
			dispose();
			
			
		}
	}
	
	private class preAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			new InterfaceDebut();
			dispose();
			
			
		}
	}
	
	public static void main(String [] args) {
		new InterfaceInstalation();
		
	}


}