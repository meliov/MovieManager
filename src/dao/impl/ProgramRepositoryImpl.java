package dao.impl;

import dao.IdGenerator;
import dao.exception.NonExistingEntityException;
import dao.repository.ProgramRepository;
import model.DayOfWeek;
import model.entity.DailyProgram;
import model.entity.Projection;

import java.util.Collection;
import java.util.stream.Collectors;

 class ProgramRepositoryImpl extends PersistableRepositoryFileImpl<Integer, DailyProgram> implements ProgramRepository {
    public ProgramRepositoryImpl(IdGenerator<Integer> idGenerator, String fileName) {
        super(idGenerator, "program", fileName);
    }

    @Override
    public DailyProgram findByDayOfWeek(DayOfWeek dayOfWeek) throws NonExistingEntityException {
        var movie = entityMap.values()
                .stream()
                .filter(e -> e.getDayOfWeek().equals(dayOfWeek))
                .findAny();
        if(movie.isEmpty()){
            throw new NonExistingEntityException("There is no program for  " +  dayOfWeek+ " .");
        }
        return movie.get();
    }

}
