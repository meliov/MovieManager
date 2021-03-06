package model.entity;

import dao.Identifiable;
import model.DayOfWeek;

import java.io.Serializable;
import java.util.*;

public class DailyProgram implements Identifiable<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
   private Integer id;
    private DayOfWeek dayOfWeek;
    private Set<Projection> projections = new LinkedHashSet<>();

    public DailyProgram(DayOfWeek dayOfWeek, Set<Projection> projections) {
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

    public Set<Projection> getProjections() {
        return projections;
    }

    public void setProjections(Set<Projection> projections) {
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
                "id=" + id +
                ", dayOfWeek=" + dayOfWeek +
                ", projections=" + projections +
                '}';
    }
}
