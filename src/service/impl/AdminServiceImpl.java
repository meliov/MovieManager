package service.impl;

import dao.DaoFactory;
import dao.exception.ConstraintViolationException;
import dao.exception.EntityAlreadyExistsException;
import dao.exception.InvalidEntityDataException;
import dao.exception.NonExistingEntityException;
import dao.impl.DaoFactoryImpl;
import dao.repository.*;
import model.entity.*;
import service.AdminService;
import util.MovieValidator;
import util.UserValidator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class AdminServiceImpl extends UserServiceIml implements AdminService {
    private DaoFactory daoFactory = new DaoFactoryImpl();
    private final TicketRepository ticketRepository = daoFactory.createTicketRepository("tickets.db");
    private final MovieRepository movieRepository = daoFactory.createMovieRepository("movies.db");
    private final ProjectionRepository projectionRepository = daoFactory.createProjectionRepository("projection.db");
    private final ProgramRepository programRepository = daoFactory.createProgramRepository("program.db");
    private final HallRepository hallRepository = daoFactory.createHallRepository("hall.db");
    private final ReviewRepository reviewRepository = daoFactory.createReviewRepository("review.db");
    private final RegisteredUserRepository registeredUserRepository = daoFactory.createRegisteredUserRepository("users.txt");
    private final MovieValidator movieValidator = new MovieValidator();
    public AdminServiceImpl(AdminRepository repository, UserValidator validator, DaoFactory daoFactory) {
        super(repository, validator);
        this.daoFactory = daoFactory;
    }
    //updates user and tickets which contain the user, reviews of user

    @Override
    public User updateUser(Admin admin,RegisteredUser user) throws InvalidEntityDataException, NonExistingEntityException {
        var updatedUser =  update(user);
        ticketRepository.load();
        reviewRepository.load();
        //tickets
        List<Ticket> tickets = new ArrayList<>(ticketRepository.findTicketsByUser(user));
        for(Ticket ticket: tickets){
            ticket.setUser(user);
            ticketRepository.update(ticket);
        }
        //reviews
        List<Review> reviews = new ArrayList<>(reviewRepository.findByUser(user));
        for(Review review: reviews){
            review.setPostingUser( user);
            reviewRepository.update(review);
        }
        ticketRepository.save();
        reviewRepository.save();
        admin.getUsersModerated().add(user);
        return updatedUser;
    }

    @Override
    public User addUser(Admin admin, RegisteredUser user) throws InvalidEntityDataException, EntityAlreadyExistsException {//it will be diff with other entities because we will have to validate them here
       var addedUser =  create(user);
       admin.getUsersModerated().add(user);
       return addedUser;
    }

    @Override
    public User deleteUser(Admin admin, RegisteredUser user) throws NonExistingEntityException {
        ticketRepository.load();
        reviewRepository.load();
        var deletedUser =  deleteById(user.getId());
        List<Ticket> tickets = new ArrayList<>(ticketRepository.findTicketsByUser(user));
        for(Ticket ticket: tickets){
            ticketRepository.deleteById(ticket.getId());
        }
        List<Review> reviews = new ArrayList<>(reviewRepository.findByUser(user));
        for(Review review: reviews){
            reviewRepository.deleteById(review.getId());
        }
        admin.getUsersModerated().add(user);
        ticketRepository.save();
        reviewRepository.save();
        return deletedUser;
    }


    @Override
    public Movie addMovie(Admin admin, Movie movie) throws EntityAlreadyExistsException, ConstraintViolationException {
        movieRepository.load();
        movieValidator.validate(movie);
        admin.getMoviesModerated().add(movie);
        var addedMovie = movieRepository.create(movie);
        movieRepository.save();
        return addedMovie;
    }

    @Override
    public Movie updateMovie(Admin admin, Movie movie) throws NonExistingEntityException, ConstraintViolationException, InvalidEntityDataException {
        movieRepository.load();
        reviewRepository.load();
        movieValidator.validate(movie);
        //update watched movie in user
        List<RegisteredUser> userList = new ArrayList<>(registeredUserRepository.findUsersByWatchedMovie(movie));
        for(RegisteredUser registeredUser: userList ){
            registeredUser.getWatchedMovies().add(movie);//getWatchedMovies is a hashSet
            update(registeredUser);
        }
        //update favourite in user
       userList = new ArrayList<>(registeredUserRepository.findUsersByFavouriteMovie(movie));
        for(RegisteredUser registeredUser: userList ){
            registeredUser.getFavouriteMovies().add(movie);//getWatchedMovies is a hashSet
            update(registeredUser);
        }
        //movie in reviews
        List<Review> reviewsList = new ArrayList<>(reviewRepository.findByMovie(movie));
        for(Review review: reviewsList){
            review.setMovie(movie);
            reviewRepository.update(review);
            reviewRepository.save();
        }
        admin.getMoviesModerated().add(movie);
        // movie in projection -> daily program -> hall


        var updatedMovie = movieRepository.update(movie);
        movieRepository.save();
        return updatedMovie;
    }

    @Override
    public Movie deleteMovie(Admin admin, Movie movie) {
        return null;
    }

    @Override
    public DailyProgram addDailyProgram(Admin admin, DailyProgram dailyProgram) {
        return null;
    }

    @Override
    public DailyProgram deleteDailyProgram(Admin admin, DailyProgram dailyProgram) {
        return null;
    }

    @Override
    public DailyProgram updateDailyProgram(Admin admin, DailyProgram dailyProgram) {
        return null;
    }



    @Override
    public Hall addHall(Admin admin, Hall hall) {
        return null;
    }

    @Override
    public Hall deleteHall(Admin admin, Hall hall) {
        return null;
    }

    @Override
    public Hall updateHall(Admin admin, Hall hall) {
        return null;
    }

    @Override
    public Ticket addTicket(Admin admin, Ticket ticket) {
        return null;
    }

    @Override
    public Ticket updateTicket(Admin admin, Ticket ticket) {
        return null;
    }

    @Override
    public Ticket deleteTicket(Admin admin, Ticket ticket) {
        return null;
    }

    @Override
    public Projection addProjection(Admin admin, Projection projection) {
        return null;
    }

    @Override
    public Projection deleteProjection(Admin admin, Projection projection) {
        return null;
    }

    @Override
    public Projection updateProjection(Admin admin, Projection projection) {
        return null;
    }

    @Override
    public Review updateReview(Admin admin, Review review) {
        return null;
    }

    @Override
    public Review deleteReview(Admin admin, Review review) {
        return null;
    }

    @Override
    public Review addReview(Admin admin, Review review) {
        return null;
    }


}
