package it.progetto;

public class Space {

	private static Plane INSTANCE = new Plane();
	
	private Space() {
	}
	
	public static Plane getInstance() {
		return INSTANCE;
	}
}
