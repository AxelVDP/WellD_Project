package it.progetto;


public class Line {
	//CAMPI
	private double x_coeff, offset, y_coeff;
	
	//COSTRUTTORI
	public Line() {
		x_coeff=y_coeff=offset=0;
	}
	public Line (double m, double q, double n) {
		x_coeff = m;
		offset = q;
		y_coeff = n;
	}
	public Line (double m, double q) {
		this(m, q, 1);
	}
	
	/*Dato che per 2 punti passa solo una retta un costruttore che ha come argomenti 2 punti puo' essere utile*/
	public Line (Point p1, Point p2) {
		this();
		if (p1.getX()==p2.getX())
			this.setLine(1, p1.getX(), 0);		
		else if (p1.getY()==p2.getY())
			this.setLine(0, p1.getY(), 1);	
		else {
			double m=(p1.getY()-p2.getY()) / (p1.getX()-p2.getX());
			double q=p1.getY()-m*p1.getX();
			this.setLine(m, q, 1);
			}
	}
	/*i 3 tipi di rette (x = c), (y = c), (y = mx + c) vengono gestiti*/
	
	//METODI
	public double getX_coeff() {return this.x_coeff;}
	public double getY_coeff() {return this.y_coeff;}
	public double getOffset() {return this.offset;}
	
	private void setLine (double m, double q, double n) {
		x_coeff=m;
		offset=q;
		y_coeff=n;
	}
	
	/*metodo che controlla se un punto appartiene alla retta*/
	public boolean containsPoint(Point p) {
		if (x_coeff == 0)
			return p.getY() == offset;
		if (y_coeff == 0)
			return p.getX() == offset;
		return (offset+x_coeff*p.getX())==p.getY();
	}
	
	public boolean equals(Object l) {
		if(this==l) return true;
		if (l instanceof Line) { 
			return this.x_coeff==((Line)l).getX_coeff()&&this.y_coeff==((Line)l).getY_coeff()&&this.offset==((Line)l).getOffset();
		}
		return false;
	}
	
	public String toString() {
		String sign = "+";
		double t_offset = offset;
		if (x_coeff == 0)
			return "y = "+t_offset+"";
		if (y_coeff == 0)
			return "x = "+t_offset+"";
		if (offset<0) {
			sign = "-";
			t_offset*=-1;
		}
		if (offset == 0) 
			return "y = "+x_coeff+"x";
		return "y = "+x_coeff+"x "+sign+" "+t_offset;
	}
}