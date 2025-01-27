package urise.webapp.model;

import java.time.LocalDate;

public class Period {
    LocalDate start;
    LocalDate end;
    String title;
    String description;

    public Period(LocalDate start, LocalDate end, String title, String description) {
        this.start = start;
        this.end = end;
        this.title = title;
        this.description = description;
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + start.hashCode();
        result = 31 * result + end.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return start + " - " + end + '\n' +
                title + ' ' +
                description;
    }
}
