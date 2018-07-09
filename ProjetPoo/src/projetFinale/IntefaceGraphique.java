package projetFinale;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class IntefaceGraphique extends JFrame {
	
	
	private static final long serialVersionUID = 1L;

	JOptionPane	jop2 = new JOptionPane();
		
		private JTextField a1;
		private JTextField a2;
		private JTextField a3;
		
		private JPanel p1;
		private JPanel p2;
		private JPanel p3;
		private JPanel p5;
		
		private JLabel l;
		private JLabel l1;
		private JLabel j5;
		private JButton b5;
		private JButton b1;
		private JButton b2;
		private JButton b3;
		private JPanel p4;
		
		private List li;
		
		 
	
		private Recherche n=new Recherche();
		
		/**
		 * 
		 * @param chemin 
		 */
		public IntefaceGraphique(String chemin) {
			super();
			n.ajou(chemin);
			n.chemAjou(chemin);
			
			
			
			setTitle("promenade");
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setSize(600,400);
			
			
			 init();
			pack();
			setLocationRelativeTo(null);
			 setVisible(true);
			
		
		}
		
		

		public void init() {
			
			
			jop2 = new JOptionPane();
			BorderLayout border = new BorderLayout(30,50);
			Container contentPane = getContentPane();
			contentPane.setLayout(border);

			
		
		n.aL=new ArrayList<String>();
	
				 
		p1=new JPanel();
		p2=new JPanel();
		p4=new JPanel();
		p3=new JPanel();
		p5=new JPanel();
		
		l=new JLabel("Votre Mot :");
		l1=new JLabel("Dernière modification :");
		j5=new JLabel("Résultats :");
		
		 b1= new JButton("Rechercher");
		 b2= new JButton("Quitter");
		 b3=new JButton("Effacer");
		 b5=new JButton("Précédent");
		 
		 a1=new JTextField(20);
		 a2=new JTextField(15);
		 a3=new JTextField(15);
		 li= new List(17);
		 p1.add(l);
		 p1.add(a2);
		 p1.add(b1);
		
		 p2.add(l1);
		 p2.add(a1);
		 p2.add(j5);
		
		li.setBounds(20, 100, 140, 20); 

		 p5.add(li);
		 p4.add(li);
		 
		 p3.add(b2);
		 p3.add(b3);
		 p3.add(b5);
		 contentPane.add(BorderLayout.NORTH, p1);
		 contentPane.add(BorderLayout.WEST, p2);
		 contentPane.add(BorderLayout.EAST, p4);
		 contentPane.add(BorderLayout.CENTER, p5);
		 
		 contentPane.add(BorderLayout.SOUTH, p3);
		
		
		 b1.addActionListener(new gAction());
		 b2.addActionListener(new eAction());
		 li.addActionListener(new lAction());
		 b3.addActionListener(new efAction());
		 b5.addActionListener(new precAction());
		}
		
		
		
		public  class gAction implements ActionListener{ // le bouton recherche
		
			
			public void actionPerformed(ActionEvent e) {
				
				
			
if (a2.getText()==null) // si y'a rien ecris dans le jtextfiel
	JOptionPane.showMessageDialog(null,"Veillez saisir le mot à chercher",  //le message a afficher dans la boite de dialogue
			"Information", // titre de la boite de dialogue
			JOptionPane.INFORMATION_MESSAGE); // message d'information avec juste le bouton ok
else {
				
	
	
	n.lire(a2.getText()); // prendre le texte du jtextfield a2 et appeler la methode lire qui dans la classe recherche
	
			
				
				
			
				if((n.i)!=0) { // si y a au moins 1 resultat
				for(int i=0;i<n.aL.size();i++) { // remplire l ArrayList aL avec les resultat obtenu avec la methode recherche
				
				li.add(n.aL.get(i)); // mettre les resultats enregistrer dans l Arraylist dans la List graphique
				
				
				}
				
				}
					else {
					
					
					JOptionPane.showMessageDialog(null,"Le mot que vous recherchez n'existe pas",  //boite de dialogue et le message a afficher si le mot rechercher n'existe pas
							"Information",//titre de la boite 
							JOptionPane.INFORMATION_MESSAGE);// message d'information
						a1.setText("le mot__ '"+a2.getText()+"'__ N'existe pas ! ");
						
					}
					
				}	
					
			}
				
				
	}
			
		
		
		
		private class efAction implements ActionListener{ // le bouton effacer
			public void actionPerformed(ActionEvent e) {
				
				a1.setText(""); // effacer le JTextFiled a1
				a2.setText("");// effacer le JTextFiled a2
				a3.setText("");// effacer le JTextFiled a3
				li.removeAll();// efface la list
				n.aL.clear(); // effacer la ArrayList des resultat obtenu lors de la recherche
				
				
				
			}
		}
		
		
		private class eAction implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {
				

				int option = JOptionPane.showConfirmDialog(null, // boite de dialoguer pour confirmer de pouvoir quitter
				 "Voulez-vous vraiment quitter Promenade?", // le message a afficher
			        "Lancement de la génération", 
			        JOptionPane.YES_NO_OPTION,  
			        JOptionPane.QUESTION_MESSAGE);

			      if(option == JOptionPane.OK_OPTION){ // si la reponse est oui
			    	  
			    	  dispose(); // quitter le programe
				}
			
			}
		}
		
		/**
		 * 
		 * @author USER
		 *
		 */
		private class lAction implements ActionListener{ // la liste
			public void actionPerformed(ActionEvent e) {
				
			
			File  resultat=new File(n.aL4.get(n.tab[li.getSelectedIndex()]));
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");// creer un fichier dans le chemin est le resultat sur le quel on a cliquer
				 Date d = new Date(resultat.lastModified());
				a1.setText(sdf.format(d)); // ecrire la date derniere modif dans
																		// le JTextfield a1
		       
				 Desktop desk = Desktop.getDesktop();
				int option2 = JOptionPane.showConfirmDialog(null,  // boite de dialogue pour confirmer					
				        "Voulez-vous vraiment ouvirir le fichier ?", // quastiona affichier
				        "Lancement de la génération", //titre de la boite
				        JOptionPane.YES_NO_OPTION, // bouton oui ou non
				        JOptionPane.QUESTION_MESSAGE);

				      if(option2 == JOptionPane.OK_OPTION){ //si il clique sur oui
					
				    	  // parametre pour ouverture de fichier
				    	   
				    	try {
							//desk.open(new File(n.aL4.get(n.tab[li.getVisibleIndex()]))); // ouvrir le fichier selectioné
							desk.open(new File(n.aL4.get(n.tab[li.getSelectedIndex()])));
						} catch (IOException e1) { // exeption si le fichier n'existe pas
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				
				      }
					
				}
										
		}
			
		private class precAction implements ActionListener{ // bouton precedent
			public void actionPerformed(ActionEvent e) {
				new InterfaceInstalation(); // ouvrir l'interface d instalation
				dispose(); //quitter l'interface graphique
				
				
			}
		}
		
	 
}