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

import java.util.*;

public class AdminServiceImpl extends UserServiceIml implements AdminService {
    private DaoFactory daoFactory = new DaoFactoryImpl();
    private final TicketRepository ticketRepository = daoFactory.createTicketRepository("tickets.db");
    private final MovieRepository movieRepository = daoFactory.createMovieRepository("movies.db");
    private final ProjectionRepository projectionRepository = daoFactory.createProjectionRepository("projection.db");
    private final ProgramRepository programRepository = daoFactory.createProgramRepository("program.db");
    private final HallRepository hallRepository = daoFactory.createHallRepository("hall.db");
    private final ReviewRepository reviewRepository = daoFactory.createReviewRepository("review.db");
    private final RegisteredUserRepository registeredUserRepository = daoFactory.createRegisteredUserRepository("users.db");
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
        movieValidator.validate(movie, false);
        admin.getMoviesModerated().add(movie);
        var addedMovie = movieRepository.create(movie);
        movieRepository.save();
        return addedMovie;
    }

    @Override
    public Movie updateMovie(Admin admin, Movie movie) throws NonExistingEntityException, ConstraintViolationException, InvalidEntityDataException {
        repository.load();
        movieRepository.load();
        reviewRepository.load();
        projectionRepository.load();
        programRepository.load();
        hallRepository.load();
        movieValidator.validate(movie, true);
        ticketRepository.load();
        //update watched movie in user
        List<RegisteredUser> userList = new ArrayList<>(registeredUserRepository.findUsersByWatchedMovie(movie));
        for(RegisteredUser registeredUser: userList ){
            registeredUser.getWatchedMovies().remove(movie);
            registeredUser.getWatchedMovies().add(movie);
            update(registeredUser);
        }
        //update favourite in user
       userList = new ArrayList<>(registeredUserRepository.findUsersByFavouriteMovie(movie));
        for(RegisteredUser registeredUser: userList ){
            registeredUser.getFavouriteMovies().remove(movie);
            registeredUser.getFavouriteMovies().add(movie);
            update(registeredUser);
        }
        //movie in reviews
        List<Review> reviewsList = new ArrayList<>(reviewRepository.findByMovie(movie));
        for(Review review: reviewsList){
            review.setMovie(movie);
            reviewRepository.update(review);

        }
        admin.getMoviesModerated().add(movie);
        //movie in tickets
        List<Ticket> ticketList = new ArrayList<>(ticketRepository.findTicketsByMovie(movie));
        for (Ticket ticket: ticketList){
            ticket.setMovie(movie);
            ticketRepository.update(ticket);
        }
        // movie in projection -> daily program -> hall
        List<Projection> projectionList = new ArrayList<>(projectionRepository.findByMovie(movie));
        for (Projection projection: projectionList){
            projection.setMovie(movie);

            for (DailyProgram dailyProgram: programRepository.findAll()){
                if(dailyProgram.getProjections().contains(projection)){
                   dailyProgram.getProjections().remove(projection);
                    dailyProgram.getProjections().add(projection);
                    for(Hall hall: hallRepository.findAll()){
                        List<DailyProgram> hallProgram = Arrays.asList(hall.getMovieProgram());
                        if(hallProgram.contains(dailyProgram)){
                            hallProgram.set(hallProgram.indexOf(dailyProgram), dailyProgram);
                            hall.setMovieProgram(hallProgram.toArray(DailyProgram[]::new));
                            hallRepository.update(hall);
                        }
                    }
                }
            }
        }
        projectionRepository.save();//yes
        programRepository.save();//yes
        hallRepository.save();//yes
        reviewRepository.save();//yes
         ticketRepository.save();//yes
         repository.save();//yes
        var updatedMovie = movieRepository.update(movie);
        movieRepository.save();//yes
        return updatedMovie;
    }

    @Override
    public Movie deleteMovie(Admin admin, Movie movie) throws InvalidEntityDataException, NonExistingEntityException {
        repository.load();
        movieRepository.load();
        reviewRepository.load();
        projectionRepository.load();
        programRepository.load();
        hallRepository.load();
        ticketRepository.load();
        //update watched movie in user
        List<RegisteredUser> userList = new ArrayList<>(registeredUserRepository.findUsersByWatchedMovie(movie));
        for(RegisteredUser registeredUser: userList ){
            registeredUser.getWatchedMovies().remove(movie);
            update(registeredUser);
        }
        //update favourite in user
        userList = new ArrayList<>(registeredUserRepository.findUsersByFavouriteMovie(movie));
        for(RegisteredUser registeredUser: userList ){
            registeredUser.getFavouriteMovies().remove(movie);
            update(registeredUser);
        }
        //movie in reviews
        List<Review> reviewsList = new ArrayList<>(reviewRepository.findByMovie(movie));
        for(Review review: reviewsList){
            reviewRepository.deleteById(review.getId());

        }
        admin.getMoviesModerated().add(movie);
        //movie in tickets
        List<Ticket> ticketList = new ArrayList<>(ticketRepository.findTicketsByMovie(movie));
        for (Ticket ticket: ticketList){
            ticketRepository.deleteById(ticket.getId());
        }
        // movie in projection -> daily program -> hall
        List<Projection> projectionList = new ArrayList<>(projectionRepository.findByMovie(movie));
        for (Projection projection: projectionList){
            projectionRepository.deleteById(projection.getId());

            for (DailyProgram dailyProgram: programRepository.findAll()){
                if(dailyProgram.getProjections().contains(projection)){
                    dailyProgram.getProjections().remove(projection);
                    for(Hall hall: hallRepository.findAll()){
                        List<DailyProgram> hallProgram = Arrays.asList(hall.getMovieProgram());
                        hallProgram.set(hallProgram.indexOf(dailyProgram), dailyProgram);
                        hall.setMovieProgram(hallProgram.toArray(DailyProgram[]::new));
                        hallRepository.update(hall);
                    }
                }
            }
        }
        projectionRepository.save();//yes
        programRepository.save();//yes
        hallRepository.save();//yes
        reviewRepository.save();//yes
        ticketRepository.save();//yes
        repository.save();//yes
        var deletedMovie = movieRepository.deleteById(movie.getId());
        movieRepository.save();//yes
        return deletedMovie;
    }

    @Override
    public DailyProgram addDailyProgram(Admin admin, DailyProgram dailyProgram) throws EntityAlreadyExistsException {
        programRepository.load();
        var addedProgram = programRepository.create(dailyProgram);
        programRepository.save();
        return addedProgram;

    }

    @Override
    public DailyProgram deleteDailyProgram(Admin admin, DailyProgram dailyProgram) throws NonExistingEntityException {
        programRepository.load();
        hallRepository.load();
        ticketRepository.load();
        for(Hall hall: hallRepository.findAll()){
            List<DailyProgram> hallProgram = Arrays.asList(hall.getMovieProgram());
            hallProgram.remove(dailyProgram);
            hall.setMovieProgram(hallProgram.toArray(DailyProgram[]::new));
            hallRepository.update(hall);
        }
        admin.getProgramsModerated().add(dailyProgram);
        var deletedProgram = programRepository.deleteById(dailyProgram.getId());
        programRepository.save();
        hallRepository.save();
        return deletedProgram;
    }

    @Override
    public DailyProgram updateDailyProgram(Admin admin, DailyProgram dailyProgram) throws NonExistingEntityException {
        programRepository.load();
        hallRepository.load();
        for(Hall hall: hallRepository.findAll()){
            List<DailyProgram> hallProgram = Arrays.asList(hall.getMovieProgram());
            hallProgram.set(hallProgram.indexOf(dailyProgram), dailyProgram);
            hall.setMovieProgram(hallProgram.toArray(DailyProgram[]::new));
            hallRepository.update(hall);
        }
        admin.getProgramsModerated().add(dailyProgram);
        var updatedProgram = programRepository.update(dailyProgram);
        programRepository.save();
        hallRepository.save();
        return updatedProgram;
    }



    @Override
    public Hall addHall(Admin admin, Hall hall) throws EntityAlreadyExistsException {
        hallRepository.load();
        var addedHall = hallRepository.create(hall);
        hallRepository.save();
        return addedHall;
    }

    @Override
    public Hall deleteHall(Admin admin, Hall hall) throws NonExistingEntityException {
        hallRepository.load();
        ticketRepository.load();
        var deletedHall = hallRepository.deleteById(hall.getId());
        List<Ticket> ticketList = new ArrayList<>(ticketRepository.findTicketsByHall(hall));
        for(Ticket ticket: ticketList){
            ticketRepository.deleteById(ticket.getId());
        }
        hallRepository.save();
        ticketRepository.save();
        return deletedHall;
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
