package no.hvl.dat100ptc.oppgave2;

import javax.xml.catalog.Catalog;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSData {

	private GPSPoint[] gpspoints;
	protected int antall = 0;

	public GPSData(int antall) {
		this.antall = 0;
		this.gpspoints = new GPSPoint[antall];
	}

	public GPSPoint[] getGPSPoints() {

		return this.gpspoints;
	}
	
	protected boolean insertGPS(GPSPoint gpspoint) {

		boolean inserted = false;

		if (antall < gpspoints.length) {
			gpspoints[antall] = gpspoint; 
			antall++;
			inserted = true;
		}

		return inserted; 
		
		
		
		// TODO 
	
	}

	public boolean insert(String time, String latitude, String longitude, String elevation) {
			
		
		GPSPoint gpsPoint = GPSDataConverter.convert(time, latitude, longitude, elevation);
    
		
		return insertGPS(gpsPoint);
		
		
		
	}

	public void print() {
		System.out.println("===== GPS Data - Start =====");
		for (int i = 0; i < gpspoints.length; i++) {
			if (gpspoints[i] != null) { // Check for null to avoid NullPointerException
				System.out.println(gpspoints[i].toString()); // Call toString() on the instance
			}
		}
		System.out.println("===== GPS Data - End =====");
	}
}
