package model;

import dao.Identifiable;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Movie implements Identifiable<Long> {
    private Long id;
    private int length;
    private double price;
    private String movieName;
    private Genre genre;
    private String description;
    private LocalDate releaseDate;
    private List<Review> reviews;

    @Override
    public void setId(Long id) {
        this.id = id;
    }
    @Override
    public Long getId() {
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

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
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
                ", length=" + length +
                ", price=" + price +
                ", movieName='" + movieName + '\'' +
                ", genre=" + genre +
                ", description='" + description + '\'' +
                ", releaseDate=" + releaseDate +
                ", reviews=" + reviews +
                '}';
    }
}
