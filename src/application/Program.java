package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

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
    sc.close();
	}

}
