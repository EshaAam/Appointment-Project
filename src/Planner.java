
public class Planner {

    private AppointmentRepository appointmentRepository;
    private UserInput userInput;

    public Planner() {
        this.appointmentRepository = new AppointmentRepository();
        this.userInput = new UserInput();
        initializeDefaultAppointments();
    }

    public void run() {
        char selection;

        do {
            printMenu();
            selection = userInput.getChar();

            switch (Character.toLowerCase(selection)) {
                case 'a':
                    addAppointment();
                    break;
                case 'd':
                    deleteAppointment();
                    break;
                case 'l':
                    System.out.print(listAppointments());
                    break;
                default:
                    System.out.print("\n****You must enter one of the valid values from the menu.**** \n");
                    break;
            }
        } while(selection != 'e');
    }

    private void initializeDefaultAppointments() {
        appointmentRepository.addDefaultAppointments();
    }

    private String listAppointments() {
        return appointmentRepository.listAppointments();
    }

    private void deleteAppointment() {
        System.out.print("Please enter the number of the appointment that you would like to delete: ");
        int apptNum = userInput.getInt(1, appointmentRepository.getLastAppointmentIndex() + 1);
        appointmentRepository.deleteAppointment(apptNum);
    }

    private void addAppointment() {
        if (appointmentRepository.canAddAppointment()) {
            //Appointment newAppointment = new Appointment();
            Appointment newAppointment = new Appointment("mar", 4, 17, 30, "Quiz 1");
            newAppointment.inputAppointment(userInput);
            appointmentRepository.insertAppointment(newAppointment);
        }
    }

    private void printMenu() {
        String output = "\nA) Add Appointment \n";
        output += "D) Delete Appointment \n";
        output += "L) List Appointments \n";
        output += "E) Exit \n\n";
        output += "Please enter the letter of the action you would like to perform: ";

        System.out.print(output);
    }

    public static void main(String[] args) {
        Planner planner = new Planner();
        planner.run();
    }
}
