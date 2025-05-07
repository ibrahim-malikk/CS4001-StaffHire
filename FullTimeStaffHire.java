// FullTimeStaffHire.java

// This class is the full time staffhire
public class FullTimeStaffHire extends StaffHire {
    private double salary;
    private int weeklyHours;

    // Constructor for initializing a fulltime staff hire
    public FullTimeStaffHire(
        int vacancyNumber, 
        String designation, 
        String jobType, 
        String staffName, 
        String joiningDate, 
        String qualification, 
        String appointedBy, 
        boolean joined, 
        double salary, 
        int weeklyHours
    ) {
        // Call to the parent class constructor
        super(vacancyNumber, designation, jobType, staffName, joiningDate, qualification, appointedBy, joined);
        this.salary = salary;
        this.weeklyHours = weeklyHours;
    }

    // Getter for salary
    public double getSalary() {
        return salary;
    }

    // Getter for weekly working hours
    public int getWeeklyHours() {
        return weeklyHours;
    }

    // Sets the salary only if the staff has not been appointed yet.
    public void setSalary(double salary) {
        if (!getJoined()) { // Changed logic: only allow update if not yet joined
            this.salary = salary;
        } else {
            System.out.println("Cannot change salary after staff is appointed.");
        }
    }

    //Sets the weekly working hours.
    public void setWeeklyHours(int weeklyHours) {
        this.weeklyHours = weeklyHours;
    }

    //Displays fulltime staff information.
    @Override
    public void display() {
        super.display(); // Call the display method from StaffHire
        System.out.println("Salary: " + salary);
        System.out.println("Weekly Working Hours: " + weeklyHours);
    }
}