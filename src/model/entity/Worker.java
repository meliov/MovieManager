package model.entity;

import java.util.List;
import java.util.Objects;

import static model.Role.WORKER;

public class Worker extends User{
   private List<Movie> updatedMovies;
   private List<Snack> updatedSnacks;

    public List<Movie> getUpdatedMovies() {
        return updatedMovies;
    }

    public void setUpdatedMovies(List<Movie> updatedMovies) {
        this.updatedMovies = updatedMovies;
    }

    public List<Snack> getUpdatedSnacks() {
        return updatedSnacks;
    }

    public void setUpdatedSnacks(List<Snack> updatedSnacks) {
        this.updatedSnacks = updatedSnacks;
    }

    public Worker(String firstName, String lastName, String username, String password, String email) {
        super(firstName, lastName, username, password, email, WORKER);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Worker worker = (Worker) o;
        return Objects.equals(updatedMovies, worker.updatedMovies) && Objects.equals(updatedSnacks, worker.updatedSnacks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), updatedMovies, updatedSnacks);
    }

    @Override
    public String toString() {
        return "Worker{" +
                super.toString() +
                ", updatedMovies=" + updatedMovies +
                ", updatedSnacks=" + updatedSnacks +
                "} " ;
    }
}
