package dao.repository;

import dao.exception.NonExistingEntityException;
import model.DayOfWeek;
import model.entity.Hall;
import model.entity.Projection;

import java.util.Collection;

public interface HallRepository extends Repository<Integer, Hall>{
    Collection<Hall> findHallByCapacity(int capacity) throws NonExistingEntityException;
    Projection findProjectionByDayAndHour(DayOfWeek day, String hour) throws NonExistingEntityException;
}
