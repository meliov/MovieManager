package model.mock;

import model.entity.DailyProgram;
import model.entity.Projection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static model.DayOfWeek.TUESDAY;
import static model.ProjectionsTime.*;
import static model.mock.MockMovies.MOCK_MOVIES;

public class MockProjections {
    public static final List<Projection> MOCK_PROJECTIONS = Arrays.asList(
            new Projection(THREE, MOCK_MOVIES.get(0)),
            new Projection(FIVE, MOCK_MOVIES.get(1)),
            new Projection( EIGHT, MOCK_MOVIES.get(2)),
            new Projection(THREE, MOCK_MOVIES.get(1)),
            new Projection(FIVE, MOCK_MOVIES.get(2)),
            new Projection( EIGHT, MOCK_MOVIES.get(0))
    );
}
