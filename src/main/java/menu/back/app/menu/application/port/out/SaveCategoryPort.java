package menu.back.app.menu.application.port.out;

import menu.back.app.menu.domain.Category;

public interface SaveCategoryPort {
    void add(Category category);
}
