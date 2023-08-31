package menu.constants.enums;

public enum Day {
    월요일,
    화요일,
    수요일,
    목요일,
    금요일;

    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
