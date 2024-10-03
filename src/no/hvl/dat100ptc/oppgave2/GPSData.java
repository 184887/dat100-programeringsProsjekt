package no.hvl.dat100ptc.oppgave2;

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
		
		int inttime = Integer.parseInt(time);  
		double intLatitude= Double.parseDouble(latitude);
		double intLongitude = Double.parseDouble(longitude);		
		double inteLevation= Double.parseDouble(elevation);

		GPSPoint gpspoint = new GPSPoint(inttime, intLatitude, intLongitude, inteLevation) ;

		 
		return(insertGPS(gpspoint));
		
		
		
	}

	public void print() {

		throw new UnsupportedOperationException(TODO.method());

		// TODO 
	}
}
