package menu.constants.enums;

import java.util.Arrays;

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
        this.category = validateCategory(category);
    }

    private Category validateCategory(Category category) throws IllegalStateException {
        long count = Arrays.stream(Day.values())
            .filter(day -> day.getCategory() == category)
            .count();
        if (count >= 2) {
            throw new IllegalStateException();
        }
        return category;
    }
}
