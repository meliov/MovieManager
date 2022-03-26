package dao.impl;

import dao.repository.TicketRepository;
import model.entity.Ticket;

public class TicketRepositoryImpl extends AbstractRepository<Long, Ticket> implements TicketRepository {
    public TicketRepositoryImpl(IdGenerator idGenerator) {
        super(idGenerator);
    }
}