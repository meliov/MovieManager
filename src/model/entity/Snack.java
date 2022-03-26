package model.entity;

import dao.Identifiable;
import model.SnackSize;

import java.util.Objects;

/**
 * @deprecated
 */
public class Snack implements Identifiable<Long> {
    private Long id;
    private String name;
    private SnackSize size;
    private double price;

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getId(){
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SnackSize getSize() {
        return size;
    }

    public void setSize(SnackSize size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Snack snack = (Snack) o;
        return Objects.equals(id, snack.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Snack{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", price=" + price +
                '}';
    }
}
