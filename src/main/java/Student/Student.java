package Student;

public class Student {
    int nid;
    String firstName;
    String middleName;
    String grandfatherName;
    String lastName;
    String email;
    String password;
    String major;
    double gba;
    byte [] CV;

    public Student() {
    }


    public int getNid() {
        return nid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getGrandfatherName() {
        return grandfatherName;
    }

    public void setGrandfatherName(String grandfatherName) {
        this.grandfatherName = grandfatherName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getGba() {
        return gba;
    }

    public void setGba(double gba) {
        this.gba = gba;
    }

    public byte[] getCV() {
        return CV;
    }

    public void setCV(byte[] CV) {
        this.CV = CV;
    }

}
