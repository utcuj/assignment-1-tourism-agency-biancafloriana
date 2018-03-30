package domainLayer.Model;

public class Person {

    private int idPerson;
    private String firstName;
    private String lastName;
    private int age;
    private String cnp;

    public Person(String firstName, String lastName, int age, String cnp) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.cnp = cnp;
    }

    public Person(int idPerson, String firstName, String lastName, int age, String cnp) {

        this.idPerson = idPerson;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.cnp = cnp;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

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
}
