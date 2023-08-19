import src.Reminder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReminderApp {
    public static void main(String[] args) throws ParseException {
        ReminderScheduler scheduler = new ReminderScheduler();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // Example usage
        Date reminderTime = dateFormat.parse("2023-08-19 15:00:00");
        Reminder reminder = new Reminder("Complete assignment", reminderTime);
        scheduler.scheduleReminder(reminder);

        // Simulate program running
        try {
            Thread.sleep(10000); // Sleep for 10 seconds to see the reminder firing
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        scheduler.markReminderAsCompleted(reminder);
    }

}
