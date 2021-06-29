package it.progetto;

import java.util.HashSet;
import java.util.Set;

public class LineSet {
	//CAMPI
	private Set<Line> lines;
	
	//COSTRUTTORI
	public LineSet() {
		lines = new HashSet<Line>();
	}
	
	public LineSet(Line l) {
		this();
		lines.add(l);
	}
	
	//METODI
	public Set<Line> getLines(){
		return this.lines;
	}
	
	public boolean addLine(Line l) {
		if(!contains(l)) {
			lines.add(l);
			return true;
		}
		return false;
	}
	
	public boolean contains (Line l) {
		for(Line f : lines) {
			if(f.equals(l)) {
				return true;
			}
		}
		return false;
	}
	
	public String toString () {
		String s="";
		for(Line l : lines) {
			s+=l.toString()+"\n";
		}
		return s;
	}
}
