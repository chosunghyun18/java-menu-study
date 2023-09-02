package menu.back.app.menu.adapter.out.persistence;

import menu.back.app.menu.domain.Menu;

public class MenuEntity {

    private static MenuEntity instance = null ;
    private static Menu menu;

    private MenuEntity(Menu menu) {
        this.menu = menu;
    }

    public static MenuEntity getInstance(Menu menu) {
        if(instance == null) {
            instance =new MenuEntity(menu);
        }
        return instance;
    }

    public static Menu getMenu() {
        return menu;
    }
}
