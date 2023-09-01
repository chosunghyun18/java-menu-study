package menu.front.app.controller;

import java.util.List;

import menu.back.app.menu.domain.Category;
import menu.back.app.coach.domain.Coach;

public class ViewController {

    private final InputViewController inputViewController;
    private final OutputViewController outputViewController;


    public ViewController() {
        this.inputViewController= new InputViewController();
        this.outputViewController = new OutputViewController();
    }
    public void showIntroMessage() {
        outputViewController.showIntroMessage();
    }

    public void showEndMessage(Category categories, Coach coach) {
        outputViewController.showEndMessage(categories,coach);
    }
    public List<String> readCoachesDislike(String name) {
        return inputViewController.readCoachesDislike(name);
    }
    public List<String> readCoachesName() {
        return inputViewController.readCoachesName();
    }

}
