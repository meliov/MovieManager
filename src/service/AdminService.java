package service;

import dao.exception.ConstraintViolationException;
import dao.exception.EntityAlreadyExistsException;
import dao.exception.InvalidEntityDataException;
import dao.exception.NonExistingEntityException;
import dao.repository.UserRepository;
import model.entity.*;

public interface AdminService extends Service<Integer, User> {
//    DailyProgram addToProgram()
    DailyProgram addDailyProgram(Admin admin,DailyProgram dailyProgram) throws EntityAlreadyExistsException;
    DailyProgram deleteDailyProgram(Admin admin,DailyProgram dailyProgram) throws NonExistingEntityException;
    DailyProgram updateDailyProgram(Admin admin,DailyProgram dailyProgram) throws NonExistingEntityException;
    User updateUser(Admin admin, RegisteredUser registeredUser) throws InvalidEntityDataException, NonExistingEntityException;
    User addUser(Admin admin, RegisteredUser registeredUser) throws InvalidEntityDataException, EntityAlreadyExistsException;
    User deleteUser(Admin admin, RegisteredUser registeredUser) throws NonExistingEntityException;
    Hall addHall(Admin admin,Hall hall) throws EntityAlreadyExistsException;
    Hall deleteHall(Admin admin,Hall hall) throws NonExistingEntityException;
    Hall updateHall(Admin admin,Hall hall);
    Ticket addTicket(Admin admin,Ticket ticket);
    Ticket updateTicket(Admin admin,Ticket ticket);
    Ticket deleteTicket(Admin admin,Ticket ticket);
    Projection addProjection(Admin admin,Projection projection);
    Projection deleteProjection(Admin admin,Projection projection);
    Projection updateProjection(Admin admin,Projection projection);
    Review updateReview(Admin admin,Review review);
    Review deleteReview(Admin admin,Review review);
    Review addReview(Admin admin,Review review);
    Movie addMovie(Admin admin,Movie movie) throws EntityAlreadyExistsException, ConstraintViolationException;
    Movie updateMovie(Admin admin,Movie movie) throws NonExistingEntityException, ConstraintViolationException, InvalidEntityDataException;
    Movie deleteMovie(Admin admin,Movie movie) throws InvalidEntityDataException, NonExistingEntityException;

}
