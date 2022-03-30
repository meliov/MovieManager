package model.entity;

import java.util.List;
import java.util.Objects;

import static model.Role.ADMIN;

public class Admin extends User{
    private List<Movie> moviesModerated;
    private List<User> usersModerated;
    private List<DailyProgram> programsModerated;
    private List<Hall> hallsModerated;
    private List<Review> reviewsModerated;
    private List<Projection> projectionsModerated;
    private List<Ticket> ticketsModerated;

    public List<DailyProgram> getProgramsModerated() {
        return programsModerated;
    }

    public void setProgramsModerated(List<DailyProgram> programsModerated) {
        this.programsModerated = programsModerated;
    }

    private List<Snack> snacksModerated;

    public Admin(String firstName, String lastName, String username, String password, String email) {
        super(firstName, lastName, username, password, email, ADMIN);
    }

    public List<Movie> getMoviesModerated() {
        return moviesModerated;
    }

    public void setMoviesModerated(List<Movie> moviesModerated) {
        this.moviesModerated = moviesModerated;
    }

    public List<User> getUsersModerated() {
        return usersModerated;
    }

    public void setUsersModerated(List<User> usersModerated) {
        this.usersModerated = usersModerated;
    }

    public List<Snack> getSnacksModerated() {
        return snacksModerated;
    }

    public List<Hall> getHallsModerated() {
        return hallsModerated;
    }

    public void setHallsModerated(List<Hall> hallsModerated) {
        this.hallsModerated = hallsModerated;
    }

    public List<Review> getReviewsModerated() {
        return reviewsModerated;
    }

    public void setReviewsModerated(List<Review> reviewsModerated) {
        this.reviewsModerated = reviewsModerated;
    }

    public List<Projection> getProjectionsModerated() {
        return projectionsModerated;
    }

    public void setProjectionsModerated(List<Projection> projectionsModerated) {
        this.projectionsModerated = projectionsModerated;
    }

    public List<Ticket> getTicketsModerated() {
        return ticketsModerated;
    }

    public void setTicketsModerated(List<Ticket> ticketsModerated) {
        this.ticketsModerated = ticketsModerated;
    }

    public void setSnacksModerated(List<Snack> snacksModerated) {
        this.snacksModerated = snacksModerated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Admin admin = (Admin) o;
        return Objects.equals(moviesModerated, admin.moviesModerated) && Objects.equals(usersModerated, admin.usersModerated) && Objects.equals(snacksModerated, admin.snacksModerated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), moviesModerated, usersModerated, snacksModerated);
    }

    @Override
    public String toString() {
        return "Admin{" +
                 super.toString() +
                ", moviesModerated=" + moviesModerated +
                ", usersModerated=" + usersModerated +
                ", snacksModerated=" + snacksModerated +
                "} ";
    }
}
