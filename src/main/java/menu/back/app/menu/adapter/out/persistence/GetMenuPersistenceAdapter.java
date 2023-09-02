package menu.back.app.menu.adapter.out.persistence;

import menu.back.app.menu.application.port.out.LoadMenuPort;

import menu.back.app.menu.domain.Menu;

public class GetMenuPersistenceAdapter implements LoadMenuPort {
    public GetMenuPersistenceAdapter() {

    }
    @Override
    public Menu getMenu() {
        return MenuEntity.getMenu();
    }
}
