package urise.webapp.model;

import java.util.Arrays;
import java.util.List;

public class ListSection extends AbstractSection {
    private List<String> info;

    public ListSection(String... info) {
        this(Arrays.asList(info));
    }

    public ListSection(List info) {
        this.info = info;
    }

    public List getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return info.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListSection that = (ListSection) o;

        return info.equals(that.info);
    }
}
