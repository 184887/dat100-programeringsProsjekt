package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {

	
	private static int TIME_STARTINDEX = 11; 

	public static int toSeconds(String timestr) {
	
		int hr = Integer.parseInt(timestr.substring(TIME_STARTINDEX, 13));
		int min = Integer.parseInt(timestr.substring(TIME_STARTINDEX + 3, 15));
		int sec = Integer.parseInt(timestr.substring(TIME_STARTINDEX + 6, 17));

		int secs;
		secs = hr * 3600 + min * 60 + sec;

		return secs;

		
	}

	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {

		GPSPoint gpspoint;

		// TODO 
		throw new UnsupportedOperationException(TODO.method());
		
	}
	
}
