package model.entity;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import static model.Role.ADMIN;

public class Admin extends User{
    private Set<Movie> moviesModerated;
    private Set<User> usersModerated;
    private Set<DailyProgram> programsModerated;
    private Set<Hall> hallsModerated;
    private Set<Review> reviewsModerated;
    private Set<Projection> projectionsModerated;
    private Set<Ticket> ticketsModerated;

    public Set<Movie> getMoviesModerated() {
        return moviesModerated;
    }

    public void setMoviesModerated(Set<Movie> moviesModerated) {
        this.moviesModerated = moviesModerated;
    }

    public Set<DailyProgram> getProgramsModerated() {
        return programsModerated;
    }

    public void setProgramsModerated(Set<DailyProgram> programsModerated) {
        this.programsModerated = programsModerated;
    }

    public Set<Hall> getHallsModerated() {
        return hallsModerated;
    }

    public void setHallsModerated(Set<Hall> hallsModerated) {
        this.hallsModerated = hallsModerated;
    }

    public Set<Review> getReviewsModerated() {
        return reviewsModerated;
    }

    public void setReviewsModerated(Set<Review> reviewsModerated) {
        this.reviewsModerated = reviewsModerated;
    }

    public Set<Projection> getProjectionsModerated() {
        return projectionsModerated;
    }

    public void setProjectionsModerated(Set<Projection> projectionsModerated) {
        this.projectionsModerated = projectionsModerated;
    }

    public Set<Ticket> getTicketsModerated() {
        return ticketsModerated;
    }

    public void setTicketsModerated(Set<Ticket> ticketsModerated) {
        this.ticketsModerated = ticketsModerated;
    }

    public Set<Snack> getSnacksModerated() {
        return snacksModerated;
    }

    public void setSnacksModerated(Set<Snack> snacksModerated) {
        this.snacksModerated = snacksModerated;
    }

    private Set<Snack> snacksModerated;

    public Admin(String firstName, String lastName, String username, String password, String email) {
        super(firstName, lastName, username, password, email, ADMIN);
    }


    public Set<User> getUsersModerated() {
        return usersModerated;
    }

    public void setUsersModerated(Set<User> usersModerated) {
        this.usersModerated = usersModerated;
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
