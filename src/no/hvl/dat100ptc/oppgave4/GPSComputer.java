package no.hvl.dat100ptc.oppgave4;

import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave3.GPSUtils;

import java.sql.Time;

import javax.lang.model.util.ElementScanner14;

import no.hvl.dat100ptc.TODO;

public class GPSComputer {
	
	private GPSPoint[] gpspoints;
	
	public GPSComputer(String filename) {

		GPSData gpsdata = GPSDataFileReader.readGPSFile(filename);
		gpspoints = gpsdata.getGPSPoints();

	}

	public GPSComputer(GPSPoint[] gpspoints) {
		this.gpspoints = gpspoints;
	}
	
	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	public double totalDistance() {

		double distance = 0;
		for( int i = 0; i < gpspoints.length - 1; i++){

			distance += GPSUtils.distance(gpspoints[i], gpspoints[i+1]); 
		}

			return distance;
			
			
		}

	

	public double totalElevation() {

		double elevation = 0;

		for( int i = 0; i < gpspoints.length - 1; i++){
			
			if (gpspoints[i].getElevation() < gpspoints[i+1].getElevation()){
				elevation += gpspoints[i+1].getElevation() - gpspoints[i].getElevation();
			}
		}

			return elevation;
		
	}

	public int totalTime() {

	int totalTid = gpspoints[gpspoints.length-1].getTime() - gpspoints[0].getTime(); 
			
	
		return totalTid;
		
	}
		

	public double[] speeds() {

		double[] speeds = new double[gpspoints.length-1];
		
		for( int i = 0; i < gpspoints.length - 1; i++){
			speeds[i] = GPSUtils.speed(gpspoints[i], gpspoints[i+1]);
		}

		return speeds; 
		
	}
	
	public double maxSpeed() {
		
		double maxspeed = 0;
		
		for( int i = 0; i < gpspoints.length - 1; i++){
			double cspeed = GPSUtils.speed(gpspoints[i], gpspoints[i+1]);
			if(maxspeed < cspeed ){
				maxspeed = cspeed; 
			}
		}

		return maxspeed; 
	
	}

	public double averageSpeed() {

		double average = 0;

		average = totalDistance()/totalTime();
		
		return average; 
	}


	// conversion factor m/s to miles per hour (mps)
	public static final double MS = 2.23;

	public double kcal(double weight, int secs, double speed) {

		double kcal;

		double met = 0;		
		double speedmph = speed * MS;


		if (speedmph < 10){
			met = 4.0; 
		}else if (speedmph >= 10 && speedmph < 12){
			met = 6.0; 
		}else if (speedmph >= 12 && speedmph < 14){
			met = 8.0; 
		}else if (speedmph >= 14 && speedmph < 16){
			met = 10.0; 
		}else if (speedmph >= 16 && speedmph < 20){
			met = 12.0; 
		}else if (speedmph > 20){
			met = 16.0; 
		}


		kcal = (met * weight * secs)/3600;
		return kcal; 
		
	}
	public double totalKcal(double weight) {
		double totalkcal = 0;
		
		for (int i = 1; i < gpspoints.length; i++) {

			int time = gpspoints[i].getTime() - gpspoints[i - 1].getTime(); 
        	double speed = speeds()[i-1];

			if (time > 0) { 
				totalkcal += kcal(weight, time, speed); 
			}
		}
			

			return totalkcal;
	}
	
	
	
	private static double WEIGHT = 80.0;
	
	public void displayStatistics() {

		System.out.println("=======================");
		System.out.println("Total Time     :" + GPSUtils.formatTime(totalTime()));
		System.out.println("Total distance :" + totalDistance());
		System.out.println("Total elevation:" + totalElevation());
		System.out.println("Max speed      :" + maxSpeed());
		System.out.println("Average speed  :" + averageSpeed());
		System.out.println("Energy         :" + totalKcal(WEIGHT));
		System.out.println("=======================");
		
	}

}
