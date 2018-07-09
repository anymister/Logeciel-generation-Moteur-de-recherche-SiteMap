package projetFinale;


	//on importe les classes dont on a besoin
			import java.awt.*;
			import java.awt.event.*;

	import javax.swing.ImageIcon;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JPanel;




			/**
			 * Definition de la classe ImageCanvas. Cette classe permet l'affichage
			 * d'une image dont le contenu se treouve dans un fichier
			 */

			public class InterfaceDebut extends JFrame{
				
				private static final long serialVersionUID = 1L;
				private JButton b;
				private JButton b1;
				private JPanel p1;
				private JPanel p2;
				
				public InterfaceDebut(){
								
					
					
					setTitle("Bienvenu dans Pomenade"); // titre de l'interface
					setDefaultCloseOperation(EXIT_ON_CLOSE); // pouvoir fermer
					
					
					
					 init(); //appel la methode init()
					 setSize(10,10); //taillede l'interface
					pack(); //pouvoir regler la taille de l'interface apres l'execution
					setLocationRelativeTo(null);
					 setVisible(true); //toutes les methodes appeler seront visible
					
				
						
				
				}
					
					
					
					public void init() {
						JLabel j=new JLabel(""); //creer et initialiser un jlabel
						BorderLayout border = new BorderLayout(0,0);
						Container contentPane = getContentPane();
						contentPane.setLayout(border);
						
						
						b= new JButton("Suivant"); // creer le bouton suivante
						b1= new JButton("Quitter");//creer le bouton quitter
						 
						
						Image img = new ImageIcon(this.getClass().getResource("/system13.jpg")).getImage();// importer l'image system13
						
						j.setIcon(new ImageIcon(img)); //mettre l'image dansle jlabel creer
					//	j.setBounds(5,2,2,2);
						
						 p1=new JPanel(); // creer et initialiser un jpanel
						 p2=new JPanel();// creer et initialiser un jpanel
						
						p1.add(j); // ajouter le jlabel 'j ' dans p1
						
						p2.add(b);// ajouter le bouton 'suivant' dans p2
						p2.add(b1); // ajouter le bouton 'quitter' dans p2
						
						contentPane.add(BorderLayout.WEST, p1); //mettre je JPanel p1 à droite de l'interface
						 contentPane.add(BorderLayout.SOUTH, p2);//mettre je JPanel p2 au sud de l'interface
						 contentPane.add(BorderLayout.EAST, p2);//mettre je JPanel p2 à gauche de l'interface
						 contentPane.add(BorderLayout.NORTH, p2);//mettre je JPanel p2 à north de l'interface
						 
						
						
						
						
						
						b.addActionListener(new gAction());
						
						b1.addActionListener(new eAction());
					}
					
					private class eAction implements ActionListener{
						public void actionPerformed(ActionEvent e) {
							
							int option = JOptionPane.showConfirmDialog(null, // boite de dialogue pour confirmer de quitter
							 "Voulez-vous vraiment quitter Promenade?", 
						        "Lancement de la génération", 
						        JOptionPane.YES_NO_OPTION, 
						        JOptionPane.QUESTION_MESSAGE);

						      if(option == JOptionPane.OK_OPTION){ // si onclic sur oui
						    	  
						    	  dispose();//quitter le programme
							}
						}
					}
					
					
					private class gAction implements ActionListener{
						public void actionPerformed(ActionEvent e) {
							
							
							new InterfaceInstalation();
							dispose();
							JOptionPane.showMessageDialog(null,"Veuillez bien "// boite de dialogue informer de bien entrer
									+ "entrer les chemins demander," //les chemins demander
									+ " appuyez sur OK pour continuer", // 
									"Information", JOptionPane.INFORMATION_MESSAGE);// message d'information
							
							
						}
					}
			 
				

			 

			
	public static void main(String[] args) {
			new InterfaceDebut(); // executer la methode principale de la classe InterfaceDebut
		}
		
		
	}



