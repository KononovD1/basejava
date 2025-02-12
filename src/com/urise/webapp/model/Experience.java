package urise.webapp.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Experience implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    String website;
    List<Period> periods = new ArrayList<>();

    public Experience(String name, String website, LocalDate start, LocalDate end, String title, String description) {
        this.name = name;
        this.website = website;
        periods.add(new Period(start, end, title, description));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Experience that = (Experience) o;

        if (!name.equals(that.name)) return false;
        if (!website.equals(that.website)) return false;
        return periods != null ? periods.equals(that.periods) : that.periods == null;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + website.hashCode();
        result = 31 * result + (periods != null ? periods.hashCode() : 0);
        return result;
    }

    public String getName() {
        return name;
    }

    public String getWebsite() {
        return website;
    }

    public String getPeriods() {
        return periods.toString();
    }
}
