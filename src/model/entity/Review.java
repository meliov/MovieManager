package model.entity;

import dao.Identifiable;

import java.time.LocalDate;
import java.util.Objects;

public class Review implements Identifiable<Integer> {
    private Integer id;
    private String content;
    private RegisteredUser postingUser;
    private Movie movie;
    private LocalDate postingDate;

    public Review(String content, RegisteredUser postingUser, Movie movie) {
        this.content = content;
        this.postingUser = postingUser;
        this.movie = movie;
        postingDate = LocalDate.now();
    }

    public Review(String content, RegisteredUser postingUser, Movie movie, LocalDate postingTime) {
        this.content = content;
        this.postingUser = postingUser;
        this.movie = movie;
        this.postingDate = postingTime;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
    @Override
    public Integer getId(){
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getPostingUser() {
        return postingUser;
    }

    public void setPostingUser(RegisteredUser postingUser) {
        this.postingUser = postingUser;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDate getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(LocalDate postingDate) {
        this.postingDate = postingDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(id, review.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", postingUser=" + postingUser +
                ", movie=" + movie +
                ", postingTime=" + postingDate +
                '}';
    }
}
