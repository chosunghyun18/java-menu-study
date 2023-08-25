package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public InputView( ) {

    }
    public String  getName() {
        return Console.readLine();
    }
    public String getMenu() {
        return Console.readLine();
    }
}
