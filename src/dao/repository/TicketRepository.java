package dao.repository;

import dao.exception.NonExistingEntityException;
import model.entity.*;

import java.util.Collection;
import java.util.stream.Collectors;

public interface TicketRepository extends Repository<Integer, Ticket>{
    Collection<Ticket> findTicketsByUser(User user) throws NonExistingEntityException;
    Collection<Ticket> findTicketsByMovie(Movie movie) throws NonExistingEntityException;
    Collection<Ticket> findTicketsByHall(Hall hall) throws NonExistingEntityException;
    Collection<Ticket> findTicketByDayAndHour(String dayAndHour) throws NonExistingEntityException;
//    Collection<Ticket> updateTicketsByUser(User user);
}
