import src.TicketBooking;

import java.io.File;

// todo - please do not forget creating git repository
//  for this exam and make it public, and also share the link
//  of the project in the group.
public class Main {
    public static void main(String[] args) {

        //Race Condition Problem
        TicketBooking obj=new TicketBooking();

        Thread thread1=new Thread("Passenger1 Thread");
        Thread thread2=new Thread("Passenger2 Thread");

        thread1.start();
        thread2.start();


        //Streams
        Streams fileCopyHandler = new Streams();
        File srcFile = new File("notes.txt");

        fileCopyHandler.copyFileWithDuplicateName(srcFile);

        File destFile = new File("destination.txt");
        fileCopyHandler.copyFile(srcFile, destFile);
    }
}





