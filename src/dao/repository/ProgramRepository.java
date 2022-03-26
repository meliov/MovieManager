package dao.repository;

import dao.exception.NonExistingEntityException;
import model.DayOfWeek;
import model.entity.DailyProgram;

import java.util.Collection;

public interface ProgramRepository extends Repository<Long, DailyProgram>{
    DailyProgram findByDayOfWeek(DayOfWeek dayOfWeek) throws NonExistingEntityException;
}
