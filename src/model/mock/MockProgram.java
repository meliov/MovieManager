package model.mock;

import model.entity.DailyProgram;
import model.entity.Movie;
import model.entity.Projection;

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
import static model.mock.MockProjections.MOCK_PROJECTIONS;

public class MockProgram {

    public static final List<DailyProgram> MOCK_PROGRAM = Arrays.asList(
           new DailyProgram(MONDAY,Arrays.asList(
                      MOCK_PROJECTIONS.get(0), MOCK_PROJECTIONS.get(1), MOCK_PROJECTIONS.get(2)
                   )),
                   new DailyProgram(TUESDAY,Arrays.asList(
                           MOCK_PROJECTIONS.get(3), MOCK_PROJECTIONS.get(4), MOCK_PROJECTIONS.get(5)
                   ))


    );
}
