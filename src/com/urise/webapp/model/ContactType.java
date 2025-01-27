package urise.webapp.model;

public enum ContactType {
    TEL("Телефон"),
    SKYPE("Skype"),
    EMAIL("Почта"),
    LINKEDLN("Профиль LinkedIn"),
    GITHUB("Профиль GitHub"),
    STACKOVERFLOW("Профиль Stackoverflow"),
    HOMEPAGE("Домашняя страница");

    private String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
