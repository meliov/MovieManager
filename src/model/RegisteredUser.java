package model;

import java.util.List;

import static model.Role.REGISTERED_USER;

public class RegisteredUser extends User{
    private List<Movie> favouriteMovies;
    private List<Movie> watchedMovies;
    private List<Review> reviews;

    public RegisteredUser(String firstName, String lastName, String username, String password, String email) {
        super(firstName, lastName, username, password, email, REGISTERED_USER);
    }

    public List<Movie> getFavouriteMovies() {
        return favouriteMovies;
    }

    public void setFavouriteMovies(List<Movie> favouriteMovies) {
        this.favouriteMovies = favouriteMovies;
    }

    public List<Movie> getWatchedMovies() {
        return watchedMovies;
    }

    public void setWatchedMovies(List<Movie> watchedMovies) {
        this.watchedMovies = watchedMovies;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "RegisteredUser{" +
                super.toString() +
                ", favouriteMovies=" + favouriteMovies +
                ", watchedMovies=" + watchedMovies +
                ", reviews=" + reviews +
                "} " ;
    }
}
