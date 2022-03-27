package model.mock;

import model.entity.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static model.Genre.*;

public class MockMovies {
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd:MM:yyyy");
    public static final List<Movie> MOCK_MOVIES = Arrays.asList(
            new Movie(120, 8, "Batman", FANTASY, "The dark knight returns",  LocalDate.parse("10:02:2022", dtf)),
            new Movie(120, 7, "Superman", FANTASY, "Superman and the killers",  LocalDate.parse("10:02:2015", dtf)),
            new Movie(120, 8, "Prisoners", THRILLER, "Kids in labyrinth",  LocalDate.parse("10:02:2009", dtf)),
            new Movie(90, 8, "King-Kong", FANTASY, "Big monkey, dead people",  LocalDate.parse("10:02:2018", dtf)),
            new Movie(120, 8, "Rambo", ACTION, "Alone man vs a lot men",  LocalDate.parse("10:02:1996", dtf))
    );
}
