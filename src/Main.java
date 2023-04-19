import models.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Scanner sc = new Scanner(System.in);
        System.out.println("Room number");
        int number = sc.nextInt();

        System.out.println("Check-in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());

        System.out.println("Check-out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        if(!checkOut.after(checkIn)){
            System.out.println("Error in reservation: Check-out date must be after checkin");
        }else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation" + reservation);

            System.out.println("Room number");
            number = sc.nextInt();
            System.out.println("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.println("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());


           String error = reservation.updateDays(checkIn, checkOut);

           String mensagem = error != null
                   ? "Error in reservation" + error
                   : "Reservation: " + reservation;

            System.out.println(mensagem);
        }

        sc.close();
    }
}