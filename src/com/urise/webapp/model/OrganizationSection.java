package urise.webapp.model;

import java.util.List;

public class OrganizationSection extends AbstractSection {
    private List<Experience> info;

    public OrganizationSection(List<Experience> info) {
        this.info = info;
    }

    public List<Experience> getInfo() {
        return info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrganizationSection that = (OrganizationSection) o;

        return info.equals(that.info);
    }

    @Override
    public int hashCode() {
        return info.hashCode();
    }

    @Override
    public String toString() {
        return info.toString();
    }
}
