package model;

import java.util.List;
import java.util.Objects;

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
                "updatedMovies=" + updatedMovies +
                ", updatedSnacks=" + updatedSnacks +
                '}';
    }
}