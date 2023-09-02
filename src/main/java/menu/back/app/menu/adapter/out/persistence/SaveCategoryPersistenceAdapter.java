package menu.back.app.menu.adapter.out.persistence;

import menu.back.app.menu.application.port.out.SaveCategoryPort;

import menu.back.app.menu.domain.Category;

public class SaveCategoryPersistenceAdapter implements SaveCategoryPort {
    public SaveCategoryPersistenceAdapter() {

    }
    @Override
    public void add(Category category) {
        CategoryEntity categoryEntity = CategoryEntity.getInstance(category);
    }

}
