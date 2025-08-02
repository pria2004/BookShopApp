package model;

public class Book {
    private int id;
    private String name;
    private String edition;
    private double price;

    // Constructors
    public Book() {}

    public Book(int id, String name, String edition, double price) {
        this.id = id;
        this.name = name;
        this.edition = edition;
        this.price = price;
    }

    public Book(String name, String edition, double price) {
        this.name = name;
        this.edition = edition;
        this.price = price;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
