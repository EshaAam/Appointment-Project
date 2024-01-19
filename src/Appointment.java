
public class Appointment {

    private static UserInput userInput;
    private  Month month;
    private int day;
    private int hour;
    private int minute;
    private String message;
    private int attempts = 0;
    private Validation monthValidation;


    public Appointment(String newMonth, int newDay, int newHour, int newMinute, String newMessage) {
        this.monthValidation = new MonthValidation();
        setMonth(newMonth);
        setDay(newDay);
        setHour(newHour);
        setMinute(newMinute);
        setMessage(newMessage);

    }

    /*
    final public boolean setMonth(String newMonth) {
        if (isValidMonth(newMonth)) {
            month = newMonth.toLowerCase();
            return true;
        } else {
            return false;
        }
    }
    */
    public boolean setMonth(String newMonth) {
        if (monthValidation.validate(newMonth)) {
            month = Month.fromString(newMonth);
            return true;
        } else {
            return false;
        }
    }
    public String getMonth() {
        return month.name().toLowerCase();
    }


    final public boolean setDay(int newDay) {
        if (newDay > 0 && newDay <= numDays()) {
            day = newDay;
            return true;
        } else {
            return false;
        }
    }

    public int getDay() {
        return day;
    }

    final public boolean setHour(int newHour) {
        if (newHour > -1 && newHour < 24) {
            hour = newHour;
            return true;
        } else {
            return false;
        }
    }

    public int getHour() {
        return hour;
    }

    final public boolean setMinute(int newMinute) {
        if (newMinute > -1 && newMinute < 60) {
            minute = newMinute;
            return true;
        } else {
            return false;
        }
    }

    public int getMinute() {
        return minute;
    }

    final public boolean setMessage(String newMessage) {
        if (!newMessage.isEmpty() && newMessage.length() < 41) {
            message = newMessage;
            return true;
        } else {
            return false;
        }
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        String data = "";
        data += day +  " "+ month.name()   + " -- ";
        data += message + " -- ";
        data += String.format("%02d", hour) + ":" + String.format("%02d", minute);
        return data;
    }

    public void inputAppointment(UserInput userInput) {

        // Get month
        do {
            if (attempts < 2) {
                System.out.print("Please enter the three letter abbreviation for the month of your appointment: ");
                attempts++;
            } else {
                System.out.print("Please enter one of the following three letter abbreviation for the month of your appointment: \n");
                System.out.print("JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC: ");
            }
        } while (!setMonth(UserInput.getString(1, 3)));
        attempts = 0;

        do {
            System.out.print("Please enter the day of the month your appointment is on: ");
        } while (!setDay(UserInput.getInt(1, numDays())));

        System.out.print("Please enter the hour of your appointment: ");
        setHour(UserInput.getInt(0, 23));

        System.out.print("Please enter the minute of your appointment: ");
        setMinute(UserInput.getInt(0, 59));

        System.out.print("Please enter a note for this appointment (40 character maximum): ");
        setMessage(UserInput.getString(1, 40));
    }

//    private boolean isValidMonth(String testValue) {
//
//        String[] validMonths = {"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"};
//
//        for (int i = 0; i < validMonths.length; i++) {
//            if (testValue.equalsIgnoreCase(validMonths[i])) {
//                return true;
//            }
//        }
//        return false;
//    }

    private int numDays() {
        return DaysInMonth.valueOf(month.name()).getDays();
    }
    public static int monthToNum(String month) {
        return Month.fromString(month).getMonthNumber();
    }

}
