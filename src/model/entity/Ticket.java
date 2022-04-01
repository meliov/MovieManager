package model.entity;

import dao.Identifiable;

import java.util.Objects;

public class Ticket implements Identifiable<Integer> {
    private Integer id;
    private Movie movie;
    private User user;
    private Hall hall;
    private String dayAndHour;//tva shte se vzima kato se vzeme purvo
    private int row;
    private int seat;

    public Ticket(Movie movie, User user, Hall hall, String dayAndHour, int row, int seat ) {
        this.movie = movie;
        this.user = user;
        this.hall = hall;
        this.dayAndHour = dayAndHour;
        this.row = row;
        this.seat = seat;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
    @Override
    public Integer getId() {
        return id;
    }

    public String getDayAndHour() {
        return dayAndHour;
    }

    public void setDayAndHour(String dayAndHour) {
        this.dayAndHour = dayAndHour;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
       return String.format("Movie: %s, User: %s, Hall: %s, Seat: %s, Column: %s%n on %s",
                movie.getMovieName(), user.getUsername(), hall.getId(), row, seat, dayAndHour);
    }
}
