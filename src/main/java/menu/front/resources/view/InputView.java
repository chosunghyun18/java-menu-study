package menu.front.resources.view;

import camp.nextstep.edu.missionutils.Console;
import menu.front.resources.constant.ErrorCode;

public class InputView {

    public InputView() {

    }

    public String readCoachesName() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)\n");
        return getReadLine();
    }

    public String readDisLike(String name) {
        System.out.println(name + "(이)가 못 먹는 메뉴를 입력해 주세요.");
        return getReadLine();
    }

    private String getReadLine() {
        return Console.readLine();
    }

    public void showInputErrorMessage(String errorData) {
        System.out.println(ErrorCode.ERROR_MESSAGE_HEADER + errorData);
    }
}
