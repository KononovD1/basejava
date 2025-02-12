package urise.webapp.model;

public class TextSection extends AbstractSection {
    private static final long serialVersionUID = 1L;

    public String info;

    public TextSection(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextSection that = (TextSection) o;

        return info.equals(that.info);
    }

    @Override
    public int hashCode() {
        return info.hashCode();
    }
}
