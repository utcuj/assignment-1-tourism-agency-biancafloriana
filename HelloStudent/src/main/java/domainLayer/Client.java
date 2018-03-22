package domainLayer;

public class Client {

    private int idClient;
    private String firstName;
    private String lastName;
    private int age;
    private String adress;
    private String cnp;
    private String card;

    public Client(int idClient, String firstName, String lastName, int age, String adress, String cnp, String card) {
        this.idClient = idClient;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.adress = adress;
        this.cnp = cnp;
        this.card = card;
    }

    public Client(String firstName, String lastName, int age, String adress, String cnp, String card) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.adress = adress;
        this.cnp = cnp;
        this.card = card;
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String toString(){

        return idClient+" "+ firstName + " " + lastName;
    }
}
