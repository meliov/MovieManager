package model.entity;

import dao.Identifiable;
import model.DayOfWeek;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DailyProgram implements Identifiable<Long> {
    private Long id;
    private DayOfWeek dayOfWeek;
    private List<Map<LocalTime, Movie>> projections;

    public DailyProgram(DayOfWeek dayOfWeek, List<Map<LocalTime, Movie>> projections) {
        this.dayOfWeek = dayOfWeek;
        this.projections = projections;
    }

    @Override
    public Long getId() {
        return id;
    }
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public List<Map<LocalTime, Movie>> getProjections() {
        return projections;
    }

    public void setProjections(List<Map<LocalTime, Movie>> projections) {
        this.projections = projections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DailyProgram program = (DailyProgram) o;
        return Objects.equals(id, program.id) && dayOfWeek == program.dayOfWeek;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dayOfWeek);
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
