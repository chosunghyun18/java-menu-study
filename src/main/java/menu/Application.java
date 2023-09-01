package menu;

import menu.front.app.controller.ViewController;

public class Application {
    public static void main(String[] args) {
        ViewController viewController = new ViewController();
        viewController.showIntroMessage();
        viewController.readCoachesInfo();
        //viewController.showResult();
    }
}
