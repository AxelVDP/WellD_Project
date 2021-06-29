package it.progetto;

public class Point {
	//CAMPI
	private double x, y;
	
	//COSTRUTTORI
	public Point() {
		this(0, 0);
	}
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	//METODI
	public double getX() {return x;}
	public double getY() {return y;}
	
	public void setX(int x) {this.x = x;}
	public void setY(int y) {this.y = y;}

	public boolean equals(Object p) {
		if(this == p) return true;
		if(p instanceof Point) {
			return (this.x==((Point) p).getX())&&(this.y == ((Point) p).getY());
		}
		return false;
	}

	public String toString() {
		return "(x: "+x+", y: "+y+");";
	}
}
