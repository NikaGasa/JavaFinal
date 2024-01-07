import javafx.beans.value.ObservableValue;

import java.time.LocalDate;

public class Products {
    private int id;
    private String name;
    private Double price;
    private LocalDate date;

    public Products(int id, String name, Double price, LocalDate date){
        this.id = id;
        this.name = name;
        this.price = price;
        this.date = date;

    }

    public Double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }


}
