package model.entity;

import model.Role;

import java.util.List;

import static model.Role.REGISTERED_USER;

public class RegisteredUser extends User{
    private List<Movie> favouriteMovies;
    private List<Movie> watchedMovies;
    private List<Ticket> orderedTickets;

    public List<Ticket> getOrderedTickets() {
        return orderedTickets;
    }

    public void setOrderedTickets(List<Ticket> orderedTickets) {
        this.orderedTickets = orderedTickets;
    }
//    private List<Review> reviews; //po dobre v survisa na userite da se vzeme repoto na ticket, za da ne se promenq na tolkova mnogo mesta

    public RegisteredUser(Integer id) {
        super(id);
    }

    public RegisteredUser(String firstName, String lastName, String username, String password, String email) {
        super(firstName, lastName, username, password, email, REGISTERED_USER);
    }

    public RegisteredUser(String firstName, String lastName, String username, String password, String email, List<Movie> watchedMovies) {
        super(firstName, lastName, username, password, email, REGISTERED_USER);
        this.watchedMovies = watchedMovies;
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
