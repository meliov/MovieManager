package service.impl;

import dao.DaoFactory;
import dao.exception.ConstraintViolationException;
import dao.exception.EntityAlreadyExistsException;
import dao.exception.InvalidEntityDataException;
import dao.exception.NonExistingEntityException;
import dao.repository.AdminRepository;
import dao.repository.UserRepository;
import model.entity.*;
import service.AdminService;
import util.UserValidator;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class AdminServiceImpl extends UserServiceIml implements AdminService {
    private DaoFactory daoFactory;
    public AdminServiceImpl(AdminRepository repository, UserValidator validator, DaoFactory daoFactory) {
        super(repository, validator);
        this.daoFactory = daoFactory;
    }
    @Override
    public User updateUser(Admin admin, User user) {
       return null;
    }

    @Override
    public User addUser(Admin admin, User user) throws InvalidEntityDataException, EntityAlreadyExistsException {//it will be diff with other entities because we will have to validate them here
       var addedUser =  create(user);
       admin.getUsersModerated().add(user);
       return addedUser;
    }

    @Override
    public User deleteUser(Admin admin, User registeredUser) {
        return null;
    }
    @Override
    public Movie addMovie(Admin admin, Movie movie) {

        admin.getMoviesModerated().add(movie);
        return null;
    }

    @Override
    public Movie updateMovie(Admin admin, Movie movie) {
        return null;
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
