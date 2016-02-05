
/*
		Afin de détecter les mouvements de la souris, 
		vous allez devoir utiliser l'interface MouseMotionListener ; 
		celle-ci contient
		deux méthodes :
		mouseMoved(MouseEvent e), qui détecte le mouvement de la 
		souris sur le composant ;
		mouseDragged(MouseEvent e), qui fonctionne comme mouseMoved,
		 sauf que vous devrez avoir cliqué sur le
		composant et maintenir ce clic enfoncé pendant le mouvement 
		(exactement ce dont vous avez besoin).
		*/

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Planche extends JPanel {

	private Color couleur = Color.black; // couleur du point
	private Color fond = Color.white;// couleur du fond
	private String forme = "CERCLE";

	private boolean effacer;
	private int points = 20;
	// ma collection de point
	// test git
	// test deux
	private ArrayList<Point> point = new ArrayList<Point>();

	public Planche() {
		// interface de dection des mouvements de la souris
		this.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				int ecranX = getWidth(), ecranY = getHeight();
				// pour dessiné lorsqu'on clique sans mouvement
				// charger des points dans une collection
				if (e.getX() < ecranX && e.getY() < ecranY) {
					point.add(new Point(e.getX() - (points / 2), e.getY() - (points / 2), points, couleur, forme));
					repaint();
				}
			}
		});

		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				// pour dessiné lorsqu'on clique sans mouvement
				// charger des points dans une collection
				point.add(new Point(e.getX() - (points / 2), e.getY() - (points / 2), points, couleur, forme));
				repaint();
			}
		});

	}

	public void paintComponent(Graphics g) {
		g.setColor(fond);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		// On parcourt notre collection de points
		// pour recupérer le dessin lorsqu'on change de dimension a la fenetre
		for (Point p : this.point) {
			// On récupère la couleur
			g.setColor(p.getColor());
			// Selon le type de point
			if (p.getForme().equals("CARRE")) {
				g.fillRect(p.getX(), p.getY(), p.getTaille(), p.getTaille());
			} else {
				g.fillOval(p.getX(), p.getY(), p.getTaille(), p.getTaille());
			}
		}
		// le deuxieme test
		/*
		 * Font font = new Font("Courier", Font.BOLD, 20); g.setFont(font);
		 * g.setColor(Color.red); g.drawString(
		 * "Tiens ! Tiens ! Tiens ! Tiens ! ", 10, 20); g.setColor(Color.blue);
		 * g.fillOval(x1, y1, this.getWidth()/2 , this.getHeight()/2);
		 */
	}

	public void effacer() {
		this.point = new ArrayList<Point>();
		repaint();
	}

	public Color getCouleur() {
		return couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	public String getForme() {
		return forme;
	}

	public void setForme(String forme) {
		this.forme = forme;
	}

	public Color getFond() {
		return fond;
	}

	public void setFond(Color fond) {
		this.fond = fond;
	}

	public boolean isEffacer() {
		return effacer;
	}

	public void setEffacer(boolean effacer) {
		this.effacer = effacer;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

}
