package model;

import dao.Identifiable;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Hall implements Identifiable<Long> {
    private Long id;
    private HallName hallName;
    private int rows;
    private int cols;
    private int capacity;
    private boolean[][] hall;
    private LocalDateTime projectionTime;
    private Map<DayOfWeek, Map< LocalDateTime,Movie>> movieProgram;//ako tr da se vijda v koq zala e prosto vijdame dali filma sushtestvuva tukai printiram


    @Override
    public void setId(Long id) {
        this.id = id;
    }
    @Override
    public Long getId() {
        return this.id;
    }

    public HallName getHallName() {
        return hallName;
    }

    public void setHallName(HallName hallName) {
        this.hallName = hallName;
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

    public LocalDateTime getProjectionTime() {
        return projectionTime;
    }

    public void setProjectionTime(LocalDateTime projectionTime) {
        this.projectionTime = projectionTime;
    }

    public Map<DayOfWeek, Map<LocalDateTime, Movie>> getMovieProgram() {
        return movieProgram;
    }

    public void setMovieProgram(Map<DayOfWeek, Map<LocalDateTime, Movie>> movieProgram) {
        this.movieProgram = movieProgram;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hall hall = (Hall) o;
        return hallName == hall.hallName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hallName);
    }

    @Override
    public String toString() {
        return "Hall{" +
                "id=" + id +
                ", hallName=" + hallName +
                ", rows=" + rows +
                ", cols=" + cols +
                ", capacity=" + capacity +
                ", hall=" + Arrays.toString(hall) +
                ", projectionTime=" + projectionTime +
                ", movieProgram=" + movieProgram +
                '}';
    }
}
