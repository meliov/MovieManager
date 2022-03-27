package model.mock;

import model.entity.DailyProgram;
import model.entity.Movie;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static model.DayOfWeek.MONDAY;
import static model.DayOfWeek.TUESDAY;
import static model.Genre.FANTASY;
import static model.Genre.THRILLER;
import static model.ProjectionsTime.*;
import static model.mock.MockMovies.MOCK_MOVIES;

public class MockProgram {
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static final List<DailyProgram> MOCK_PROGRAM = Arrays.asList(
           new DailyProgram(MONDAY,Arrays.asList(
                   Map.of(THREE, MOCK_MOVIES.get(0)),
                    Map.of(FIVE, MOCK_MOVIES.get(1)),
                   Map.of(EIGHT, MOCK_MOVIES.get(2))
                   )),
                   new DailyProgram(TUESDAY,Arrays.asList(
                           Map.of(THREE, MOCK_MOVIES.get(2)),
                           Map.of(FIVE, MOCK_MOVIES.get(1)),
                           Map.of(EIGHT, MOCK_MOVIES.get(0))
                   ))
    );
}
