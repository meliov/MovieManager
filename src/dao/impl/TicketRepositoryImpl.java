package dao.impl;

import dao.IdGenerator;
import dao.exception.NonExistingEntityException;
import dao.repository.TicketRepository;
import model.entity.*;

import java.util.Collection;
import java.util.stream.Collectors;

 class TicketRepositoryImpl extends PersistableRepositoryFileImpl<Integer, Ticket> implements TicketRepository {
    public TicketRepositoryImpl(IdGenerator idGenerator, String fileName) {
        super(idGenerator, "ticket", fileName);
    }

    @Override
    public Collection<Ticket> findTicketsByUser(User user) throws NonExistingEntityException {
        var tickets = entityMap.values()
                .stream()
                .filter(f -> f.getUser().equals(user))
                .collect(Collectors.toList());
        if(tickets.isEmpty()){
            throw new NonExistingEntityException("There are no tickets with user: " + user.getUsername());
        }
        return tickets;
    }

    @Override
    public Collection<Ticket> findTicketsByMovie(Movie movie) throws NonExistingEntityException {
        var tickets = entityMap.values()
                .stream()
                .filter(f -> f.getMovie().equals(movie))
                .collect(Collectors.toList());
        if(tickets.isEmpty()){
            throw new NonExistingEntityException("There are no tickets for movie: " + movie.getMovieName());
        }
        return tickets;
    }

    @Override
    public Collection<Ticket> findTicketsByHall(Hall hall) throws NonExistingEntityException {
        var tickets = entityMap.values()
                .stream()
                .filter(f -> f.getHall().equals(hall))
                .collect(Collectors.toList());
        if(tickets.isEmpty()){
            throw new NonExistingEntityException("There are no tickets for hall with id: " + hall.getId());
        }
        return tickets;
    }

    @Override
    public Collection<Ticket> findTicketByDayAndHour(String dayAndHour) throws NonExistingEntityException {
        var tickets = entityMap.values()
                .stream()
                .filter(f -> f.getDayAndHour().equals(dayAndHour))
                .collect(Collectors.toList());
        if(tickets.isEmpty()){
            throw new NonExistingEntityException("There are no tickets for: " + dayAndHour);
        }
        return tickets;
    }

 }
