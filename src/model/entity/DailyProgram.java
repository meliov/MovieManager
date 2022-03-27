package model.entity;

import dao.Identifiable;
import model.DayOfWeek;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DailyProgram implements Identifiable<Integer> {//implements Identifiable<Long> {
   private Integer id;
    private DayOfWeek dayOfWeek;
    private List<Projection> projections;

    public DailyProgram(DayOfWeek dayOfWeek, List<Projection> projections) {
        this.dayOfWeek = dayOfWeek;
        this.projections = projections;
    }

    @Override
    public Integer getId() {
        return id;
    }
    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public List<Projection> getProjections() {
        return projections;
    }

    public void setProjections(List<Projection> projections) {
        this.projections = projections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DailyProgram program = (DailyProgram) o;
        return
                Objects.equals(id, program.id) &&
                dayOfWeek == program.dayOfWeek;
    }

    @Override
    public int hashCode() {
        //return Objects.hash(id, dayOfWeek);
        return Objects.hash( dayOfWeek);
    }

    @Override
    public String
    toString() {
        return "Program{" +
              //  "id=" + id +
                ", dayOfWeek=" + dayOfWeek +
                ", projections=" + projections +
                '}';
    }
}
