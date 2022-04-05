package model.entity;

import model.Role;

import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static model.Role.REGISTERED_USER;

public class RegisteredUser extends User implements Serializable {
    private static final long serialVersionUID = 1L;
    private Set<Movie> favouriteMovies = new LinkedHashSet<>();
    private Set<Movie> watchedMovies = new LinkedHashSet<>();

    public RegisteredUser(Integer id) {
        super(id);
    }

    public RegisteredUser() {
    }

    public RegisteredUser(String firstName, String lastName, String username, String password, String email) {
        super(firstName, lastName, username, password, email, REGISTERED_USER);
    }

    public RegisteredUser(String firstName, String lastName, String username, String password, String email, Set<Movie> watchedMovies) {
        super(firstName, lastName, username, password, email, REGISTERED_USER);
        this.watchedMovies = watchedMovies;
    }


    public Set<Movie> getFavouriteMovies() {
        return favouriteMovies;
    }

    public void setFavouriteMovies(Set<Movie> favouriteMovies) {
        this.favouriteMovies = favouriteMovies;
    }

    public Set<Movie> getWatchedMovies() {
        return watchedMovies;
    }

    public void setWatchedMovies(Set<Movie> watchedMovies) {
        this.watchedMovies = watchedMovies;
    }


//    public List<Review> getReviews() {
//        return reviews;
//    }
//
//    public void setReviews(List<Review> reviews) {
//        this.reviews = reviews;
//    }

    @Override
    public String toString() {
        return "RegisteredUser{" +
                super.toString() +
                ", favouriteMovies=" + favouriteMovies +
                ", watchedMovies=" + watchedMovies +
               // ", reviews=" + reviews +
                "} " ;
    }
}
