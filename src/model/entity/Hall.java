package model.entity;

import dao.Identifiable;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Hall implements Identifiable<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private int rows;
    private int seats;
    private int capacity;
    private boolean[][] hall;
    private DailyProgram[] movieProgram;


    public Hall(int rows, int seats, DailyProgram[] movieProgram) {
        this.rows = rows;
        this.seats = seats;
        this.capacity = rows*seats;
        this.movieProgram = movieProgram;
        hall = new boolean[rows][seats];
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
    @Override
    public Integer getId() {
        return this.id;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean[][] getHall() {
        return hall;
    }

    public void setHall(boolean[][] hall) {
        this.hall = hall;
    }


    public DailyProgram[] getMovieProgram() {
        return movieProgram;
    }

    public void setMovieProgram(DailyProgram[] movieProgram) {
        this.movieProgram = movieProgram;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hall hall = (Hall) o;
        return Objects.equals(id, hall.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Hall{" +
                "id=" + id +
               // ", rows=" + rows +
               // ", cols=" + seats +
                ", capacity=" + capacity +
               // ", hall=" + Arrays.toString(hall) +
                ", movieProgram=" + Arrays.toString(movieProgram) +
                '}';
    }
}
