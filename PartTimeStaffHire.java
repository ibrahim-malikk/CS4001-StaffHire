// Subclass of StaffHire for managing part time staff members
public class PartTimeStaffHire extends StaffHire {
    // Instance variables specific to part time staff
    private final int weeklyHours;
    private final double wagesPerHour;
    private String shifts;
    private boolean terminated;

    // Constructor initializing all attribues of part time staff
    public PartTimeStaffHire(int vacancyNumber, String designation, String jobType,
                             String staffName, String joiningDate, String qualification,
                             String appointedBy, boolean joined,
                             int weeklyHours, double wagesPerHour, String shifts) {
        super(vacancyNumber, designation, jobType, staffName, joiningDate, qualification, appointedBy, joined);
        this.weeklyHours = weeklyHours;
        this.wagesPerHour = wagesPerHour;
        this.shifts = shifts;
        this.terminated = false; // Staff is not terminated by default
    }

    // Getter for weekly working hours
    public int getWeeklyHours() {
        return weeklyHours;
    }

    // Getter for wages per hour
    public double getWagesPerHour() {
        return wagesPerHour;
    }

    // Getter for shift details
    public String getShifts() {
        return shifts;
    }

    // Getter to check if staff has been terminated
    public boolean isTerminated() {
        return terminated;
    }

    // Setter for shift details  only allowed if the staff has been appointed
    public void setShifts(String shifts) {
        if (getJoined()) {
            this.shifts = shifts;
        } else {
            System.out.println("Cannot set shifts because staff is not appointed.");
        }
    }

    // Method to terminate the staff member
    public void terminateStaff() {
        if (terminated) {
            System.out.println("Staff already terminated.");
        } else {
            // Clear staff related details
            setStaffName("");
            setJoiningDate("");
            setQualification("");
            setAppointedBy("");
            setJoined(false);
            terminated = true;
            System.out.println("Staff successfully terminated.");
        }
    }

    // Display all details about the part time staff
    @Override
    public void display() {
        super.display(); // Call display from parent class
        System.out.println("Weekly Hours: " + weeklyHours);
        System.out.println("Wages Per Hour: " + wagesPerHour);
        System.out.println("Shifts: " + shifts);
        System.out.println("Terminated: " + terminated);
        System.out.println("Income Per Week: " + (weeklyHours * wagesPerHour));
    }
}
