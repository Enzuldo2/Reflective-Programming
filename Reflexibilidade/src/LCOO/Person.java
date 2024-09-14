package LCOO;

public class Person {

    private int id;

    private String name;

    private String email;

    @Atribute({"id", "name", "email"})
    public Person(int i, String johnDoe, String mail) {
        this.id = i;
        this.name = johnDoe;
        this.email = mail;
    }

    @Atribute({"id"})
    public int getID() {
        return this.id;
    }

    @Atribute({"name"})
    public String getName() {
        return this.name;
    }

    @Atribute({"email"})
    public String getEmail() {
        return this.email;
    }

    @Atribute({"id"})
    public void setID(int id) {
        this.id = id;
    }

    @Atribute({"name"})
    public void setName(String name) {
        this.name = name;
    }

    @Atribute({"email"})
    public void setEmail(String email) {
        this.email = email;
    }

    @Atribute({"id", "name", "email"})
    public String toString() {
        return "ID: " + this.id + " Name: " + this.name + " Email: " + this.email;
    }

}
