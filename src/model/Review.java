package model;

import dao.Identifiable;

import java.time.LocalDate;
import java.util.Objects;

public class Review implements Identifiable<Long> {
    private Long id;
    private String content;
    private User postingUser;
    private Movie movie;
    private LocalDate postingTime;

    @Override
    public void setId(Long id) {
        this.id = id;
    }
    @Override
    public Long getId(){
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

    public void setPostingUser(User postingUser) {
        this.postingUser = postingUser;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDate getPostingTime() {
        return postingTime;
    }

    public void setPostingTime(LocalDate postingTime) {
        this.postingTime = postingTime;
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
                ", postingTime=" + postingTime +
                '}';
    }
}
