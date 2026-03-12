package demo6;

public class card {
    private String size;
    private String color;
    private int sizeValue;

    @Override
    public String toString() {
        return size + color;
    }

    public card(String size, String color, int sizeValue) {
        this.size = size;
        this.color = color;
        this.sizeValue = sizeValue;
    }

    public card() {
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSizeValue() {
        return sizeValue;
    }

    public void setSizeValue(int sizeValue) {
        this.sizeValue = sizeValue;
    }
}
