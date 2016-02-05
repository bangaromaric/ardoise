import java.awt.Color;

//classe qui va permettre de recuperer les point sur la planche
public class Point {

	private Color color = Color.black;
	private int taille = 20;
	private int x = -10;
	private int y = -10;
	private String forme = "CERCLE";

	// contructeur
	public Point() {
	}

	public Point(int x, int y, int taille, Color color, String forme) {
		this.color = color;
		this.taille = taille;
		this.x = x;
		this.y = y;
		this.forme = forme;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getForme() {
		return forme;
	}

	public void setForme(String forme) {
		this.forme = forme;
	}

}
