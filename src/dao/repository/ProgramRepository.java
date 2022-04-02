package dao.repository;

import dao.exception.NonExistingEntityException;
import model.DayOfWeek;
import model.entity.DailyProgram;
import model.entity.Projection;

import java.util.Collection;

public interface ProgramRepository extends PersistableRepository<Integer, DailyProgram>{
    DailyProgram findByDayOfWeek(DayOfWeek dayOfWeek) throws NonExistingEntityException;

}
