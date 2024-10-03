package no.hvl.dat100ptc.oppgave1;

import no.hvl.dat100ptc.TODO;

public class GPSPoint {

	private int time; 
	private double latitude;
	private double longitude;
	private double elevation; 
	
	public GPSPoint(int time, double latitude, double longitude, double elevation) {

		this.time = time;
		this.latitude = latitude;
		this.longitude = longitude;
		this.elevation = elevation;
		
	}

	// TODO - get/set metoder
	public int getTime() {
		
		return time;
		
	}

	public void setTime(int time) {
				
		time = Nytime;
		
	}

	public double getLatitude() {
		
		return latitude;
		
		
	}

	public void setLatitude(double nyLatitude) {
		
		latitude = nyLatitude;
		
	}

	public double getLongitude() {
		
		return longitude;
		
	}

	public void setLongitude(double nyLongitude) {
		
		longitude = nyLongitude;
		
	}

	public double getElevation() {
		
		return elevation;
		
	}

	public void setElevation(double nyElevation) {
		
		elevation = nyElevation;
		
	}
	
	public String toString() {
		
		String str;

		String strNyTime = Integer.toString(getTime());
		String strNyLatitude = Double.toString(getLatitude());
		String strNyLongitude = Double.toString(getLongitude());
		String strNyElevation = Double.toString(getElevation());
	
		str = strNyTime + " (" + strNyLatitude + ","+ strNyLongitude + ") "+strNyElevation + "\n";

		return str;
		
	}
}
