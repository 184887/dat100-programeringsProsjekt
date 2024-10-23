package no.hvl.dat100ptc.oppgave1;

import java.sql.Time;

import no.hvl.dat100ptc.oppgave2.GPSData;

public class Main {

	public static void main(String[] args) {

		GPSPoint x = new GPSPoint(1, 2, 3, 5);

		x.getTime();
		x.setTime(2);
		String p = x.toString();

		System.out.println(p);

	}

}
