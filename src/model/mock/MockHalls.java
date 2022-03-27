package model.mock;

import model.entity.DailyProgram;
import model.entity.Hall;

import java.util.Arrays;
import java.util.List;

import static model.mock.MockProgram.MOCK_PROGRAM;

public class MockHalls {
    public static final List<Hall> MOCK_HALLS = Arrays.asList(
      new Hall(10, 20, new DailyProgram[] {
            MOCK_PROGRAM.get(0), MOCK_PROGRAM.get(1),
              MOCK_PROGRAM.get(2),MOCK_PROGRAM.get(3),
              MOCK_PROGRAM.get(4),MOCK_PROGRAM.get(5),
              MOCK_PROGRAM.get(6)}) //coma here
            //new here
    );


}
