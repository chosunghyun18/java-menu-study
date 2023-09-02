package menu.back.app.menu.adapter.out.persistence;

import menu.back.app.menu.application.port.out.SaveMenuPort;
import menu.back.app.menu.domain.Menu;

// jpa 이용시  jpa 구현부
public class SaveMenuPersistenceAdapter implements SaveMenuPort {

    public SaveMenuPersistenceAdapter() {

    }

    @Override
    public void add(Menu menu) {
        MenuEntity menuEntity = MenuEntity.getInstance(menu);
    }
}
