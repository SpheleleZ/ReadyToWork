package api.secondapi;

public class POJOClass {

    private String firstName;
    private String lastName;
    private int age;
    private String job;
    private String[] soccer_teams;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String[] getSoccer_teams() {
        return soccer_teams;
    }

    public void setSoccer_teams(String[] soccer_teams) {
        this.soccer_teams = soccer_teams;
    }
}
