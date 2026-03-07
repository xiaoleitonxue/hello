package demo;

public class movie {


    private String name;
    private double price;
    private String actor;
    private String type;

    public movie(String name,double price,String actor,String type){
        this.name = name;
        this.price = price;
        this.actor = actor;
        this.type = type;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
