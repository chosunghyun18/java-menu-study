package menu.back.app.menu.adapter.out.persistence;

import menu.back.app.menu.domain.Category;

public class CategoryEntity {
    private static CategoryEntity instance = null;

    private static Category category;

    private CategoryEntity(Category category) {
        this.category = category;
    }

    public static CategoryEntity getInstance(Category category) {
        if(instance == null){
            instance = new CategoryEntity(category);
        }
        return instance;
    }
    public static Category getCategory() {
        return category;
    }
}
