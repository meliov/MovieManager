package model.entity;

import dao.Identifiable;

import java.util.Objects;

public class Projection implements Identifiable<Integer> {
    private Integer id;
    private String hour;
    private Movie movie;

    public Projection(String date, Movie movie) {
        this.hour = date;
        this.movie = movie;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Projection that = (Projection) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Projection{" +
                "id=" + id +
                ", date='" + hour + '\'' +
                ", movie=" + movie.getMovieName() +
                '}';
    }
}
