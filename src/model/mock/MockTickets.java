package model.mock;

import model.entity.Ticket;

import java.util.Arrays;
import java.util.List;

import static model.DayOfWeek.MONDAY;
import static model.DayOfWeek.SUNDAY;
import static model.mock.MockHalls.MOCK_HALLS;
import static model.mock.MockMovies.MOCK_MOVIES;
import static model.mock.MockUsers.MOCK_USERS;

public class MockTickets {
    public static final List<Ticket> MOCK_TICKETS = Arrays.asList(
            new Ticket(MOCK_MOVIES.get(0), MOCK_USERS.get(0), MOCK_HALLS.get(0),MONDAY + " 20:00", 5, 10),
            new Ticket(MOCK_MOVIES.get(2), MOCK_USERS.get(0), MOCK_HALLS.get(0),SUNDAY + " 14:00", 5, 10)
    );
}
