package model.entity;

import dao.Identifiable;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Hall implements Identifiable<Integer> {
    private Integer id;
    private int rows;
    private int cols;
    private int capacity;
    private boolean[][] hall;
    private List<DailyProgram> movieProgram;



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

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
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



    public List<DailyProgram> getMovieProgram() {
        return movieProgram;
    }

    public void setMovieProgram(List<DailyProgram> movieProgram) {
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
                ", rows=" + rows +
                ", cols=" + cols +
                ", capacity=" + capacity +
                ", hall=" + Arrays.toString(hall) +
                ", movieProgram=" + movieProgram +
                '}';
    }
}
