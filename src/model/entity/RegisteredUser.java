package model.entity;

import model.Role;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static model.Role.REGISTERED_USER;

public class RegisteredUser extends User{
    private Set<Movie> favouriteMovies;
    private Set<Movie> watchedMovies;
    private Set<Ticket> orderedTickets;
    private Set<Review> reviews;

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

    public Set<Ticket> getOrderedTickets() {
        return orderedTickets;
    }

    public void setOrderedTickets(Set<Ticket> orderedTickets) {
        this.orderedTickets = orderedTickets;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
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
