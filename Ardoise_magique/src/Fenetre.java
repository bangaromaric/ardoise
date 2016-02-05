
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class Fenetre extends JFrame {

	// creation de l'objet planch

	private Planche planch = new Planche();

	// contenaire principale
	private JPanel content = new JPanel();
	private JLabel label = new JLabel("roro"); // label test

	// creation du menudd wi jekk

	private JMenuBar menuBar = new JMenuBar();

	private JMenu fichier = new JMenu("Fichier");
	private JMenu edition = new JMenu("Edition");
	private JMenu trait = new JMenu("Trait");
	private JMenu forme = new JMenu("Forme");
	private JMenu couleur = new JMenu("Couleur");
	private JMenu propos = new JMenu("À propos de");
	// tableu des elements du Jmenu
	String[] tab_item = { "Quitter", "Effacer", "save", "Fin", "Moyen", "Gras", "Rond", "Carré", "?", "noir", "bleu",
			"rouge", "vert" };
	// creation un tab pour taille celle du tab_iten
	private JMenuItem[] item = new JMenuItem[tab_item.length];
	// barre d'outil
	private JToolBar toolBar = new JToolBar();
	private Color fondTool = Color.white; // utiliser dans la barre d'outil
	// les bouton de la barre d'outil avec leurs images
	private JButton pen = new JButton(new ImageIcon("img/pen2.png")),
			gomme = new JButton(new ImageIcon("img/gomme.png")), carre = new JButton(new ImageIcon("img/carré.png")),
			rond = new JButton(new ImageIcon("img/rond.png")), noir = new JButton(new ImageIcon("img/noir.png")),
			bleu = new JButton(new ImageIcon("img/bleu.png")), vert = new JButton(new ImageIcon("img/vert.png")),
			rouge = new JButton(new ImageIcon("img/rouge.png")), fin = new JButton(new ImageIcon("img/petit.png")),
			moyen = new JButton(new ImageIcon("img/moyen.png")), gras = new JButton(new ImageIcon("img/grand.png"));

	public Fenetre() {

		this.setTitle("ardoise");
		this.setSize(800, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		content.setBackground(Color.white);// changement de la couleur
											// principale
		content.setLayout(new BorderLayout());// definition du layout

		content.add(planch, BorderLayout.CENTER);// ajout de la planche
		this.setContentPane(content); // choisir le content comme principale
		initMenu();
		initToolbar();
		this.setVisible(true);
	}

	// permet de charger le menu
	public void initMenu() {

		for (int i = 0; i < tab_item.length; i++) {
			// ajoute des nom dans chaque menu
			item[i] = new JMenuItem(tab_item[i]);
		}
		// ajout de chaque element du menu dans leur menu respectif
		// avec leur action
		for (int i = 0; i < tab_item.length; i++) {

			if (i == 0) {

				this.fichier.add(item[i]); // quitter
				this.fichier.add(item[i + 1]);// effacer

				item[0].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						System.exit(0);

					}
				});

				item[1].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						planch.effacer();
					}
				});

			}

			if (i == 2) {
				// save
				this.fichier.add(item[i]);
				item[2].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						ScreenShotFactory.screenShot(new Rectangle(0, 0, 1980, 1080), new Dimension(1980, 1080),
								"test.png", ScreenShotFactory.IMAGE_TYPE_PNG);
					}
				});

			}
			if (i == 3) {

				this.trait.add(item[i]);
				this.trait.add(item[i + 1]);
				this.trait.add(item[i + 2]);
				this.edition.add(trait);
				// Ajout d'un séparateur
				this.edition.addSeparator();

				item[3].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						planch.setPoints(20);
					}
				});

				item[4].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						planch.setPoints(40);
					}
				});

				item[5].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						planch.setPoints(60);
					}
				});

			}
			if (i == 6) {

				this.forme.add(item[i]);
				this.forme.add(item[i + 1]);
				this.edition.add(forme);
				this.edition.addSeparator();

				item[6].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						planch.setForme("CERCLE");
					}
				});

				item[7].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						planch.setForme("CARRE");
					}
				});

			}
			if (i == 8) {
				this.propos.add(item[i]);

				item[8].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						JOptionPane jop = new JOptionPane();
						ImageIcon img = new ImageIcon("img/me.jpg");

						String mess = "Merci ! \n J'espère que vous vous amusez bien !\n";
						mess += " je travaille toujours deçu pour plus d'option  \n";
						mess += "\n Allez, si vous avez des bugs ! informer moi sur mon adress \t leromantiqueroma@gmail.com";
						jop.showMessageDialog(null, mess, "À propos de", JOptionPane.INFORMATION_MESSAGE, img);
					}
				});

			}

			if (i == 9) {

				this.couleur.add(item[i]);
				this.couleur.add(item[i + 1]);
				this.couleur.add(item[i + 2]);
				this.couleur.add(item[i + 3]);
				item[9].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						planch.setCouleur(Color.black);
					}
				});
				item[10].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						planch.setCouleur(Color.blue);
					}
				});
				item[11].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						planch.setCouleur(Color.red);

					}
				});
				item[12].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						planch.setCouleur(Color.green);
					}
				});

				this.edition.add(couleur);
			}

		} // fin du for

		this.menuBar.setPreferredSize(new Dimension(10, 50));

		this.menuBar.add(fichier);
		this.menuBar.add(edition);
		this.menuBar.add(propos);
		this.setJMenuBar(menuBar);
	}// fin initmenu

	// chargement de la barre d'outil
	public void initToolbar() {

		this.toolBar.add(pen);
		this.pen.setBackground(fondTool);
		this.pen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				planch.setCouleur(Color.black);
				;
			}
		});
		this.toolBar.add(gomme);
		this.gomme.setBackground(fondTool);
		this.gomme.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				planch.setCouleur(planch.getFond());
			}
		});
		this.toolBar.addSeparator();

		this.toolBar.add(carre);
		this.carre.setBackground(fondTool);
		this.carre.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				planch.setForme("CARRE");
			}
		});

		this.toolBar.add(rond);
		this.rond.setBackground(fondTool);
		this.rond.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				planch.setForme("CERCLE");

			}
		});
		this.toolBar.addSeparator();

		this.toolBar.add(noir);
		this.noir.setBackground(fondTool);
		this.noir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				planch.setCouleur(Color.black);

			}
		});
		this.toolBar.add(bleu);
		this.bleu.setBackground(fondTool);
		this.bleu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				planch.setCouleur(Color.blue);
			}
		});
		this.toolBar.add(vert);
		this.vert.setBackground(fondTool);
		this.vert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				planch.setCouleur(Color.green);
			}
		});
		this.toolBar.add(rouge);
		this.rouge.setBackground(fondTool);
		this.rouge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argo) {

				planch.setCouleur(Color.red);
			}

		});
		this.toolBar.addSeparator();

		this.toolBar.add(fin);
		this.fin.setBackground(fondTool);
		this.fin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				planch.setPoints(20);
			}
		});
		this.toolBar.add(moyen);
		this.moyen.setBackground(fondTool);
		this.moyen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				planch.setPoints(40);
			}
		});
		this.toolBar.add(gras);
		this.gras.setBackground(fondTool);
		this.gras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				planch.setPoints(60);
			}
		});
		this.add(toolBar, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		Fenetre f = new Fenetre();
		Point p = new Point(1, 1, 20, Color.black, "CERCLE");

	}

}
