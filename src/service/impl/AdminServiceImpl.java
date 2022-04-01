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
import util.UserValidator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class AdminServiceImpl extends UserServiceIml implements AdminService {
    private DaoFactory daoFactory;
    private final TicketRepository ticketRepository = daoFactory.createTicketRepository();
    private final MovieRepository movieRepository = daoFactory.createMovieRepository();
    private final ProjectionRepository projectionRepository = daoFactory.createProjectionRepository();
    private final ProgramRepository programRepository = daoFactory.createProgramRepository();
    private final HallRepository hallRepository = daoFactory.createHallRepository();
    private final ReviewRepository reviewRepository = daoFactory.createReviewRepository();
    private final RegisteredUserRepository registeredUserRepository = daoFactory.createRegisteredUserRepository();
    public AdminServiceImpl(AdminRepository repository, UserValidator validator, DaoFactory daoFactory) {
        super(repository, validator);
        this.daoFactory = daoFactory;
    }

    //updates user and tickets which contain the user, reviews of user

    @Override
    public User updateUser(Admin admin, User user) throws InvalidEntityDataException, NonExistingEntityException {
        var updatedUser =  update(user);
        //tickets
        List<Ticket> tickets = new ArrayList<>(ticketRepository.findTicketsByUser(user));
        for(Ticket ticket: tickets){
            ticket.setUser(user);
            ticketRepository.update(ticket);
        }
        admin.getUsersModerated().add(user);
        //reviews
        List<Review> reviews = new ArrayList<>(reviewRepository.findByUser(user));
        for(Review review: reviews){
            review.setPostingUser((RegisteredUser) user);
            reviewRepository.update(review);
        }
        admin.getUsersModerated().add(user);

        return updatedUser;
    }

    @Override
    public User addUser(Admin admin, User user) throws InvalidEntityDataException, EntityAlreadyExistsException {//it will be diff with other entities because we will have to validate them here
       var addedUser =  create(user);
       admin.getUsersModerated().add(user);
       return addedUser;
    }

    @Override
    public User deleteUser(Admin admin, User user) throws NonExistingEntityException {
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
        return deletedUser;
    }
    @Override
    public Movie addMovie(Admin admin, Movie movie) throws EntityAlreadyExistsException {

        admin.getMoviesModerated().add(movie);
        return movieRepository.create(movie);
    }

    @Override
    public Movie updateMovie(Admin admin, Movie movie) throws NonExistingEntityException {
        admin.getMoviesModerated().add(movie);
        //update watched
        List<RegisteredUser> userList = new ArrayList<>(registeredUserRepository.findUsersByWatchedMovie(movie));
        for(RegisteredUser registeredUser: userList ){
            registeredUser.getWatchedMovies().add(movie);//getWatchedMovies is a hashSet
        }
        //update favourite
       userList = new ArrayList<>(registeredUserRepository.findUsersByFavouriteMovie(movie));
        for(RegisteredUser registeredUser: userList ){
            registeredUser.getFavouriteMovies().add(movie);//getWatchedMovies is a hashSet
        }


        return movieRepository.update(movie);
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
