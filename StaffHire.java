// StaffHire.java

public class StaffHire {
    private final int vacancyNumber;
    private final String designation;
    private final String jobType;
    private String staffName;
    private String joiningDate;
    private String qualification;
    private String appointedBy;
    private boolean joined;
//Constructs a StaffHire object with all required staff details. Initializes all atributes.

    public StaffHire(int vacancyNumber, String designation, String jobType, String staffName, String joiningDate, String qualification, String appointedBy, boolean joined) {
        this.vacancyNumber = vacancyNumber;
        this.designation = designation;
        this.jobType = jobType;
        this.staffName = staffName;
        this.joiningDate = joiningDate;
        this.qualification = qualification;
        this.appointedBy = appointedBy;
        this.joined = joined;
    }

    public int getVacancyNumber() { return vacancyNumber; }
    public String getDesignation() { return designation; }
    public String getJobType() { return jobType; }
    public String getStaffName() { return staffName; }
    public String getJoiningDate() { return joiningDate; }
    public String getQualification() { return qualification; }
    public String getAppointedBy() { return appointedBy; }
    public boolean getJoined() { return joined; }
//getters and setters: Provide read and write access to private attributes 

    public void setStaffName(String staffName) { this.staffName = staffName; }
    public void setJoiningDate(String joiningDate) { this.joiningDate = joiningDate; }
    public void setQualification(String qualification) { this.qualification = qualification; }
    public void setAppointedBy(String appointedBy) { this.appointedBy = appointedBy; }
    public void setJoined(boolean joined) { this.joined = joined; }
    public void display() {
        System.out.println("Vacancy Number: " + vacancyNumber);
        System.out.println("Designation: " + designation);
        System.out.println("Job Type: " + jobType);
        System.out.println("Staff Name: " + staffName);
        System.out.println("Joining Date: " + joiningDate);
        System.out.println("Qualification: " + qualification);
        System.out.println("Appointed By: " + appointedBy);
        System.out.println("Joined: " + joined);
    }  
    //display(): Outputs all details of the StaffHire object.
    //for testing lolz
    public static void main(String[] args) {
        StaffHire staff = new StaffHire(1, "Engineer", "Full-Time", "John Doe", "2025-05-01", "B.Tech", "HR", true);
        staff.display();
    }
    } 
        