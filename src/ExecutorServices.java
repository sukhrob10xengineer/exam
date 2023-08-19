import src.Reminder;

import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//todo - Create a program that simulates a simple reminder application.
// The program should allow users to schedule reminders for specific tasks
// at designated times
// Requirements:
//    Create a Reminder class that represents a single reminder. It should have the following properties: task (String), time (Date), and completed (boolean).
//    Implement a ReminderScheduler class that manages the scheduling and execution of reminders using a ScheduledThreadPoolExecutor.
//    The ReminderScheduler class should have the following methods:
//        scheduleReminder(Reminder reminder): Schedules a reminder for execution at the specified time.
//        cancelReminder(Reminder reminder): Cancels a scheduled reminder.
//        markReminderAsCompleted(Reminder reminder): Marks a reminder as completed.
//    The program should provide a simple command-line interface (CLI) for users to interact with the ReminderScheduler. Users should be able to:
//        Schedule a new reminder by providing the task description and the time (in the format "yyyy-MM-dd HH:mm:ss").
//        Cancel a scheduled reminder by specifying the task description.
//        Mark a reminder as completed by specifying the task description.
public class ExecutorServices {

        private String task;
        private Date time;
        private boolean completed;

        public void Reminder(String task, Date time) {
            this.task = task;
            this.time = time;
            this.completed = false;
        }

        public String getTask() {
            return task;
        }

        public Date getTime() {
            return time;
        }

        public boolean isCompleted() {
            return completed;
        }

        public void markAsCompleted() {
            completed = true;
        }
    }

    class ReminderScheduler {
        private ScheduledThreadPoolExecutor executor;

        public ReminderScheduler() {
            executor = new ScheduledThreadPoolExecutor(1);
        }

        public void scheduleReminder(Reminder reminder) {
            long delay = reminder.getTime().getTime() - System.currentTimeMillis();
            if (delay > 0) {
                executor.schedule(() -> {
                    System.out.println("Reminder: " + reminder.getTask() + " is due now!");
                }, delay, TimeUnit.MILLISECONDS);
            }
        }

        public void cancelReminder(Reminder reminder) {
            // Implementation to cancel reminder
        }

        public void markReminderAsCompleted(Reminder reminder) {
            reminder.markAsCompleted();
            System.out.println("Reminder: " + reminder.getTask() + " marked as completed.");
        }
    }



