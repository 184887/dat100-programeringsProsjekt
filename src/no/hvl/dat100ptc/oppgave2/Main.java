package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class Main {

	
	public static void main(String[] args) {

	
		GPSPoint x = new GPSPoint(3200, 32, 31,10);
		GPSPoint y = new GPSPoint(4200, 30, 30,3);


		GPSData a = new GPSData(2);

		
		a.insertGPS(x);
		a.insertGPS(y);

		a.print();
		
	}
}
