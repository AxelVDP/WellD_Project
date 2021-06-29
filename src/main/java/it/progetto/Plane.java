package it.progetto;

import java.util.HashSet;
import java.util.Set;
public class Plane {
	//CAMPI
	private Set<Point> plane;
	
	
	//COSTRUTTORI
	public Plane() {
		plane = new HashSet<Point>();
	}
	public Plane(Point p) {
		plane = new HashSet<Point>();
		plane.add(p);
	}
	
	//costruttori non necessari ma che potrebbero essere comodi
	public Plane(Set<Point> set) {
		plane = new HashSet<Point>();
		for(Point p : set)
		addPoint(p);
	}
	
	public Plane(Point... set) {
		plane = new HashSet<Point>();
		for(Point p : set) {
			addPoint(p);
		}
	}

	//METODI
	public Set<Point> getPlane() {return plane;}
	
	public boolean addPoint(Point p) {
		if(!contains(p)) {
			plane.add(p);
			return true;
		}
		return false;
	}

	public void addMultiplePoints(Point... set) {
		for(Point p : set) {
			addPoint(p);
		}
	}
	
	public boolean contains (Point p) {
		for(Point f : plane) {
			if(f.equals(p)) {
				return true;
			}
		}
		return false;
	}
	
	public int size() {return plane.size();}
	
	public void deleteAll () {plane.clear();}

	/*trova tutte le rette che attraversano almeno n punti nel piano*/
	public LineSet linesOfLength(int n) {
		int counter;
		Line l;
		//converto in array per semplificarmi la scrittura del codice
		Point[] pianoArray = new Point[plane.size()];
		plane.toArray(pianoArray);	
		LineSet linee = new LineSet();

		//se n=1 significa che ci sono infinite rette, se n>numero dei punti significa che non ne possono esistere
		if(n==1||n>plane.size()) {
			return linee;
		}
		for(int i=0; i<=pianoArray.length-n; i++) {
			for(int j=i+1;j<=pianoArray.length-n+1;j++) {
				l=new Line(pianoArray[i], pianoArray[j]);
				counter=2;
				//counter a 2 perche' creando una retta da 2 punti automaticamente sono inclusi
				for(int k=j+1; k<pianoArray.length;k++) {
					if(l.containsPoint(pianoArray[k])) {
						counter++;
						if(counter==n||counter==n+1) linee.addLine(l);
					}
				}
			}
		}
		return linee;
	}
	
	//ritorna tutti i punti del piano che stanno sulla retta indicata
	public Plane pointsInLine(Line l) {
		Plane result = new Plane();
		for(Point p : plane) {
			if(l.containsPoint(p)) result.addPoint(p);
		}
		return result;
	}
	
	//ritorna un set di insiemi di punti (segmenti) che stanno sul set di rette indicate
	public Set<Plane> segmentsOfLine(LineSet l_set) {
		Set<Plane> result = new HashSet<Plane>();
		Set<Line> set = l_set.getLines();
		for(Line l : set) {
			result.add(pointsInLine(l));
		}
		return result;
	}
	public Set<Plane> segmentsOfLine(int n){
		return segmentsOfLine(linesOfLength(n));
	}
	
	public String toString() {
		String s = "";
		for(Point p : plane) {
			s+= ""+p.toString()+"\n";
		}
		return s.equals("")? "Non ci sono punti nel piano." : s;
	}
}
