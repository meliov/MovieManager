package model.entity;

import dao.Identifiable;
import model.Genre;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Movie implements Identifiable<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private int length;
    private double price;
    private String movieName;
    private Genre genre;
    private String description;
    private LocalDate releaseDate;
    private String directorName;
    private String studioName;

    public Movie(int length, double price, String movieName, Genre genre, String description, LocalDate releaseDate,
                 String directorName, String studioName) {
        this.length = length;
        this.price = price;
        this.movieName = movieName;
        this.genre = genre;
        this.description = description;
        this.releaseDate = releaseDate;
        this.directorName = directorName;
        this.studioName = studioName;
    }


    public Movie(Integer id) {
        this.id = id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
    @Override
    public Integer getId() {
        return this.id;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getStudioName() {
        return studioName;
    }

    public void setStudioName(String studioName) {
        this.studioName = studioName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
              //  ", length=" + length +
               // ", price=" + price +
                ", movieName='" + movieName + '\'' +
                ", genre=" + genre +
              //  ", description='" + description + '\'' +
              //  ", releaseDate=" + releaseDate +
               // ", reviews=" + reviews +
                '}';
    }
}
