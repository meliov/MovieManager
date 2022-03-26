package model.mock;

import model.entity.Movie;
import model.entity.RegisteredUser;
import model.entity.Review;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static model.Genre.FANTASY;
import static model.Genre.THRILLER;
import static model.mock.MockMovies.MOCK_MOVIES;
import static model.mock.MockUsers.MOCK_USERS;

public class MockReviews {
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd:MM:yyyy");

    public static final List<Review> MOCK_REVIEWS = Arrays.asList(
          new Review( "The movie is really good i love Batman", (RegisteredUser) MOCK_USERS.get(0),MOCK_MOVIES.get(0) , LocalDate.parse("10:02:2022", dtf)),
            new Review( "The movie is bad, i dont like superman", (RegisteredUser) MOCK_USERS.get(0),MOCK_MOVIES.get(1) ),
            new Review( "Batman is not good", (RegisteredUser) MOCK_USERS.get(3),MOCK_MOVIES.get(0) ),
            new Review( "Prisoners is top movie", (RegisteredUser) MOCK_USERS.get(3),MOCK_MOVIES.get(2) , LocalDate.parse("15:02:2022", dtf))

    );
}
