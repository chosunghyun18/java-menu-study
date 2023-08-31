## 🏛️클래스 구조
<img width="943" alt="image" src="https://github.com/chosunghyun18/java-menu-study/assets/113884028/1a85a101-10cf-4c41-a2fc-0d044688450f">

- Controller의 생성자를 호출하면서 InputView, OutputView, CoachInfo, GenerateCategory의 생성자를 호출한다. 그리고 process() 함수를 호출하여 순서에 알맞게 입,출력을 진행한다.<br>
- GenerateCategory의 생성자가 호출되면 월~금까지의 category 생성하여 list로 변환하고 속성 값으로 저장한다. <br>
- CoachInfo는 사용자가 입력한 코치의 이름, 코치들이 먹지 않는 음식들을 param으로 받아서 validation check를 하고, 알맞은 list 형태로 변환하여 속성 값으로 저장한다. <br>
- 옳지 않은 입력의 경우 error message를 출력 후, 문제가 발생한 곳에서 다시 입력을 받는다. 입력의 validation check는 view에서 진행하지 않고, controller 혹은 model에서 진행했다. <br>
예외 발생은 model에서 했고, try-catch는 controller에서 진행했다. 
  - view에서 validation check를 하지 않은 이유는 단순 입력 문제를 차리하는 것이 아닌 비즈니스 모델적 문제를 처리한다고 판단했기 때문이다.
  - try-catch를 controller에서 한 이유는 model에서 로직 반복 처리를 하지 않기 위해서이다. 흐름은 controller에만 맡기는 걸로~
- GenerateMenu은 생성된 category와 CoachInfo의 속성값들을 바탕으로 개개인에 알맞는 menus를 제작한다.
이중 for문을 도는데 외부는 요일별 category를 기준으로, 내부는 coach 개개인을 기준으로 loop를 돌면서 전체 점메추Menus list를 완성한다.
  - 처음에는 외부와 내부 loop를 바꿔서 구현했는데, ApplicationTest를 돌려보니 위의 5개의 결과 값은 첫번째 coach의 menus, 다음 5개는 두번째 coach의 menus가 되는 이상한 결과 값이 나왔다. 
  category도 알맞게 제작했고, 제공된 Foodlist.menus에서 해당 category에 맞는 list도 잘 찾았는데 오로지 결과만 이상하게 나왔다...(기묘하군)
  2시간 조금 넘게 이 문제로 삽질 했다... 답답하고 배고팠다...
- controller가 너무 무겁다면 viewController를 하나 더 만들어서 조금 가볍게 해주는 것도 방법인 것깉다.
- stream이 아주 유용하고 매력적이다. 학기 중에 stream과 java 자료구조들을 더 공부해봐야 겠다.



## 🏛️기능 요구 사항

### CoachInfo
- 코치들의 이름 list, 코치들이 먹지 않는 음식들 이중 list를 속성으로 가진다. 
- 이름의 validation check, 먹지 않는 음식의 validation check를 구현했다.
- [x] 속성1 : 코치들의 이름 list
  - [x] 코치 인원 2~5명
    - [x] ','로 구분
  - [x] 코치 이름 2~4글자
- [x] 속성2 : 각 코치가 못 먹는 메뉴 list
  - [x] 못 먹는 메뉴 각자 0~2개
    - [x] ','로 구분
  - [x] 실제 메뉴에 존재하는 음식인지 확인

### GenerateCategory
- 월~금의 category를 담은 list를 속성으로 가진다. 
- 같은 category가 2개 이상 되지 않도록 validation check를 구현했다.
- [x] 속성 : 월~금의 category
- [x] 기능 : category 를 생성한다.
  - [x] 같은 category 최대 2개

### FoodList
- 기본으로 제공되는 categories, menus, weekday의 정보를 가진 list들을 속성으로 가진다.
- 구현해야하는 기능들은 없다. 
- [X] categories, menus 의 정보가 list 로 담겨져 있음

### GenerateMenu
- 전체 코치들의 선정된 메뉴들 list를 속성으로 가진다.
- 이중 for문으로 구성되어 있는데, 먼저 요일(category)을 기준으로 loop를 돌고, 그 내부에는 코치 개개인을 기준으로 loop를 돈다.
  - list의 값을 copy하지 않고 그대로 가져오서 수정(.add()와 같은..)하면 기존 list도 수정된다는 점을 명심해야한다. (여기서 문제 발생했음..!)
- [x] 속성 : 전제 점메추 추전 리스트
- [x] 기능 : 해당 날짜의 음식 카테고리와 안먹는 음식을 고려해서 개개인의 메뉴를 생성한다.
  - [x] 한 사람의 점메추 중 메뉴는 중복되면 안된다.
  - [x] 못먹는 음식을 제외시킨다.

### InputView
- [x] 예외 처리는 controller 에서 한다. 
- [x] 예외가 발생한 부분에서 다시 입력 받음