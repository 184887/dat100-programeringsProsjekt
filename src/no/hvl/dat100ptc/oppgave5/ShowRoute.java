package no.hvl.dat100ptc.oppgave5;

import javax.swing.JOptionPane;

import easygraphics.EasyGraphics;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave3.GPSUtils;
import no.hvl.dat100ptc.oppgave4.GPSComputer;

import no.hvl.dat100ptc.TODO;

public class ShowRoute extends EasyGraphics {

	private static int MARGIN = 50;
	private static int MAPXSIZE = 800;
	private static int MAPYSIZE = 800;

	private GPSPoint[] gpspoints;
	private GPSComputer gpscomputer;
	private double[] speeds; 
	
	
	private double minlon, minlat, maxlon, maxlat;

	private double xstep, ystep;
	
	public ShowRoute() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");
		gpscomputer = new GPSComputer(filename);

		gpspoints = gpscomputer.getGPSPoints();
		speeds = gpscomputer.speeds();

	}

	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		makeWindow("Route", MAPXSIZE + 2 * MARGIN, MAPYSIZE + 2 * MARGIN);

		minlon = GPSUtils.findMin(GPSUtils.getLongitudes(gpspoints));
		minlat = GPSUtils.findMin(GPSUtils.getLatitudes(gpspoints));

		maxlon = GPSUtils.findMax(GPSUtils.getLongitudes(gpspoints));
		maxlat = GPSUtils.findMax(GPSUtils.getLatitudes(gpspoints));
		
		xstep = scale(MAPXSIZE, minlon, maxlon);
		ystep = scale(MAPYSIZE, minlat, maxlat);
		
		showRouteMap(MARGIN + MAPYSIZE);

		replayRoute(MARGIN + MAPYSIZE);
		
		showStatistics();
	}

	public double scale(int maxsize, double minval, double maxval) {

		double step = maxsize / (Math.abs(maxval - minval));

		return step;
	}

	public void showRouteMap(int ybase) {
		for (int i = 0; i < gpspoints.length -1 ;i++){
			
			int x = (int)((gpspoints[i].getLongitude() - minlon) * xstep) + MARGIN;
			int y = (int)((maxlat - gpspoints[i].getLatitude()) * ystep) + MARGIN;

			int x1 = (int)((gpspoints[i+1].getLongitude() - minlon) * xstep) + MARGIN;
			int y1 = (int)((maxlat - gpspoints[i+1].getLatitude()) * ystep) + MARGIN;

			if(i == 0){
				setColor(0, 120,0 );
			}
			else if(speeds[i] >= speeds[i-1]){
				setColor(0, 120,0 );
			} else if (speeds[i] < speeds[i-1]){
				setColor(120, 0, 0);
			}
			
			
			drawLine(x, y, x1, y1);

			
		}
		
		
	}

	public void showStatistics() {
		String stats = gpscomputer.displayStatistics();

		String[] lines = stats.split("\n");
		int TEXTDISTANCE = 20;
		

		setColor(0,0,0);
		setFont("Courier",12);
		int x = 100;
		int y = 40; 
		
		for (String line : lines){
			drawString(line, x, y);
			y += TEXTDISTANCE;
	}
		
	}

	public void replayRoute(int ybase) {
	setColor(0, 0, 120);
	
	int x = (int)((gpspoints[0].getLongitude() - minlon) * xstep) + MARGIN;
	int y = (int)((maxlat - gpspoints[0].getLatitude()) * ystep) + MARGIN;
	int idikator = fillCircle(x, y, 5); 

	for (int i = 1; i < gpspoints.length;i++){
		 x = (int)((gpspoints[i].getLongitude() - minlon) * xstep) + MARGIN;
		 y = (int)((maxlat - gpspoints[i].getLatitude()) * ystep) + MARGIN;
	
		pause(50);
	
		moveCircle(idikator, x, y);

	
	}

}

	
}
