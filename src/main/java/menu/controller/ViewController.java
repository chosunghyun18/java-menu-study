package menu.controller;

import menu.view.InputView;
import menu.view.OutputView;

public class ViewController {
    private final InputView inputView;
    private final OutputView outputView;
    public ViewController(){
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }
}
