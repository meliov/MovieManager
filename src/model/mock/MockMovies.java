package model.mock;

import model.entity.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static model.Genre.FANTASY;
import static model.Genre.THRILLER;

public class MockMovies {
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd:MM:yyyy");
    public static final List<Movie> MOCK_MOVIES = Arrays.asList(
            new Movie(240, 8, "Batman", FANTASY, "The dark knight returns",  LocalDate.parse("10:02:2022", dtf)),
            new Movie(240, 7, "Superman", FANTASY, "Superman and the killers",  LocalDate.parse("10:02:2015", dtf)),
            new Movie(240, 8, "Prisoners", THRILLER, "Kids in labyrinth",  LocalDate.parse("10:02:2009", dtf))
    );
}
