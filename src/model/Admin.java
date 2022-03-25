package model;

import java.util.List;
import java.util.Objects;

public class Admin extends User{
    private List<Movie> moviesModerated;
    private List<User> usersModerated;
    private List<Snack> snacksModerated;

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
                "moviesModerated=" + moviesModerated +
                ", usersModerated=" + usersModerated +
                ", snacksModerated=" + snacksModerated +
                '}';
    }
}
