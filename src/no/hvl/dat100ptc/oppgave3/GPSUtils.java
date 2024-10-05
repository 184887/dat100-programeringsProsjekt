package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.TODO;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		double min = da[0];
		
		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}
		
		return min;

	
		
	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		double[] latitudes = new double[gpspoints.length];


		for(int i = 0; i<latitudes.length; i++){
			latitudes[i] = gpspoints[i].getLatitude();
		}

		return latitudes;
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		
		double[] longitudes = new double[gpspoints.length];


		for(int i = 0; i<longitudes.length; i++){
			longitudes[i] = gpspoints[i].getLongitude();
		}

		return longitudes; 

	}

	private static final int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;
		double latitude1, longitude1, latitude2, longitude2;

		latitude1 = gpspoint1.getLatitude();
		latitude2 = gpspoint2.getLatitude();

		longitude1 = gpspoint1.getLongitude();
		longitude2 = gpspoint2.getLongitude();


		double lat1Rad = toRadians(latitude1);
        double lat2Rad = toRadians(latitude2);
        double deltaphi = toRadians(latitude2 - latitude1);
        double deltadelta = toRadians(longitude2 - longitude1);

		double a = compute_a(lat1Rad, lat2Rad, deltaphi, deltadelta);
		double c = compute_c(a);
		d = R * c;

		return d; 
 	}
	
	private static double compute_a(double phi1, double phi2, double deltaphi, double deltadelta) {
	
		return Math.pow(sin(deltaphi/2), 2) +
		(cos(phi1) * cos(phi2) * Math.pow(sin(deltadelta/2), 2) );
		
	}

	private static double compute_c(double a) {

		
		double c =  2 * (atan2(sqrt(a), sqrt(1-a)));
		 return c; 
	}

	
	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {


		int sec1 = gpspoint1.getTime();
		int sec2 = gpspoint2.getTime(); 
		int secs = sec2 - sec1; 
		double speed;
		double d = distance(gpspoint1, gpspoint2);

		speed = d / secs;

		return speed; 
	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";
		


		int h = secs / 3600;
		int m = (secs % 3600)/60; 
		int s = secs % 60;

		timestr = String.format("  %02d%s%02d%s%02d",h, TIMESEP, m, TIMESEP, s);


		return timestr; 
		
	}
	
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str;

		str =  String.format("%10.2f", d).substring(0, TEXTWIDTH);


		return str.substring(0, Math.min(TEXTWIDTH, str.length()));
	}
}
