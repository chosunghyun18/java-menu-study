package menu.back.app.menu.adapter.out.persistence;

import menu.back.app.menu.application.port.out.LoadCategoryPort;
import menu.back.app.menu.domain.Category;

public class GetCategoryPersistenceAdapter implements LoadCategoryPort {
    @Override
    public Category getCategory() {
        return CategoryEntity.getCategory();
    }

}
