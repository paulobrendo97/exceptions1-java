package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exception.DomainException;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

		try {
			System.out.print("Room Number: ");
			int number = sc.nextInt();
			System.out.print("Check-in Date (dd/MM/yyy)");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-Out Date (dd/MM/yyy)");
			Date checkOut = sdf.parse(sc.next());

			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in Date (dd/MM/yyy)");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-Out Date (dd/MM/yyy)");
			checkOut = sdf.parse(sc.next());

			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
		}
		catch (ParseException e) {
			System.out.println("Invalid date format");
		} 
		catch (DomainException e) {
			System.out.println("Error in reservation " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}

		sc.close();

	}
}
