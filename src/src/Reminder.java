package src;

import java.util.Date;

public class Reminder {
    private Date reminder;

    public Reminder(String completeAssignment, Date reminder) {
        this.reminder = reminder;
    }

    public Date getReminder() {
        return reminder;
    }

    public void setReminder(Date reminder) {
        this.reminder = reminder;
    }

    public Date getTime() {
        return null;
    }

    public String getTask() {
        return null;
    }

    public void markAsCompleted() {
    }
}
