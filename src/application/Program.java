package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("check-in date (dd/MM/yyyy):");
		Date checkIn = sdf.parse(sc.next());
		
		System.out.print("check-out date (dd/MM/yyyy):");
		Date checkOut = sdf.parse(sc.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println(" Errorin reservation: Check-out date must beaftercheck-in date");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation"  + reservation);
			System.out.println("");
			System.out.println("Enter data to update the reservation:");
			System.out.print("Room number: ");
			System.out.print("check-in date (dd/MM/yyyy):");
			 checkIn = sdf.parse(sc.next());
			
			System.out.print("check-out date (dd/MM/yyyy):");
			 checkOut = sdf.parse(sc.next());
			 
			 Date now = new Date();
			 if(checkIn.before(now) || checkOut.before(now)) {
				 System.out.println(" Errorin reservation: Reservation dates for updatemust be future dates");
			 }
			 else if (!checkOut.after(checkIn)) {
			System.out.println(" Errorin reservation: Check-out date must beaftercheck-in date");	 
			 }
			 else {
			 reservation.updateDates(checkIn, checkOut);
			 System.out.println("Reservation"  + reservation);
		 }
		}
    sc.close();
	}

}
