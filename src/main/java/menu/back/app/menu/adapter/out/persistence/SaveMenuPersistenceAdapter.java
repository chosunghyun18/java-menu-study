package menu.back.app.menu.adapter.out.persistence;

import menu.back.app.menu.application.port.out.SaveMenuPort;

public class SaveMenuPersistenceAdapter implements SaveMenuPort {
    private final MenuPersistenceRepository menuPersistenceRepository;

    public SaveMenuPersistenceAdapter(MenuPersistenceRepository menuPersistenceRepository){
        this.menuPersistenceRepository = menuPersistenceRepository;
    }

}
