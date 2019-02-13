package exercise.com;


public class Item {
    private String name;
    private Double unitPrice;

    public Item(String name, Double unitPrice) {
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    @Override
    public String toString() {
        return name;
    }
}
