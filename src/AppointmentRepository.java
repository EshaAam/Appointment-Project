
public class AppointmentRepository {
    private static final int MAX_APPOINTMENTS = 20;
    private Appointment[] appointments = new Appointment[MAX_APPOINTMENTS];
    private int lastApptIndex = 0;

    public void addDefaultAppointments() {
        appointments[0] = new Appointment("mar", 4, 17, 30, "Meeting with client");
        appointments[1] = new Appointment("apr", 1, 17, 30, "Academic Appointments");
        appointments[2] = new Appointment("may", 6, 17, 30, "Doctor's Appointment");
        appointments[3] = new Appointment("jun", 3, 17, 30, "Family gatherings");
        lastApptIndex = 3;
    }

    public String listAppointments() {
        // Your existing logic for listing appointments
        String appts = "\n";

        for (int i = 0; i < appointments.length; i++) {
            if (appointments[i] != null) {
                appts += (i + 1) + ". ";
                appts += appointments[i].toString();
                appts += "\n";
            }
            else {
                break;
            }
        }
        return appts;
    }

    public void deleteAppointment(int appt) {
        // Your existing logic for deleting appointments
        if (appt > 0 && appt - 1 <= lastApptIndex) {
            appointments[appt - 1] = null;

            for (int i = appt; i < appointments.length; i++) {
                if (appointments[i] != null) {
                    appointments[i - 1] = appointments[i];
                }
                else {
                    appointments[i - 1] = null;
                    break;
                }
            }

            lastApptIndex -= 1;
        }
    }

    public void insertAppointment(Appointment newAppointment) {
        // Your existing logic for inserting appointments
        int insertionIndex = 0;

        // Find insertion point
        for (int i = 0; i <= lastApptIndex; i++) {
            if (compareAppointment(newAppointment, appointments[i])) {
                insertionIndex = i;
                break;
            }
        }

        // Shift appointments to the right
        for (int i = lastApptIndex + 1; i > insertionIndex; i--) {
            appointments[i] = appointments[i - 1];
        }

        // Add the new appointment
        appointments[insertionIndex] = newAppointment;
        lastApptIndex++;
    }

    private boolean compareAppointment(Appointment newAppointment, Appointment existingAppointment) {
        int monthComparison = newAppointment.monthToNum(newAppointment.getMonth()) - newAppointment.monthToNum(existingAppointment.getMonth());

        if (monthComparison < 0) {
            return true;
        } else if (monthComparison == 0) {
            int dayComparison = newAppointment.getDay() - existingAppointment.getDay();
            if (dayComparison < 0) {
                return true;
            } else if (dayComparison == 0) {
                int hourComparison = newAppointment.getHour() - existingAppointment.getHour();
                if (hourComparison < 0) {
                    return true;
                } else if (hourComparison == 0) {
                    return newAppointment.getMinute() < existingAppointment.getMinute();
                }
            }
        }

        return false;
    }


    public int getLastAppointmentIndex() {
        return lastApptIndex;
    }

    public boolean canAddAppointment() {
        return lastApptIndex != MAX_APPOINTMENTS - 1;
    }
}
