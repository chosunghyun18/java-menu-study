## 기능 요구 사항

### CoachInfo 
- [x] 속성1 : 코치들의 이름 list
  - [x] 코치 인원 2~5명
    - [x] ','로 구분
  - [x] 코치 이름 2~4글자
- [x] 속성2 : 각 코치가 못 먹는 메뉴 list
  - [x] 못 먹는 메뉴 각자 0~2개
    - [x] ','로 구분
  - [x] 실제 메뉴에 존재하는 음식인지 확인

### GenerateCoach
- [ ] 속성 : 월~금의 category
- [ ] category 를 생성한다. 
  - [ ] 같은 category 최대 2개

    
### FoodList
- [X] category, menu 의 정보가 list 로 담겨져 있음

### (애매) Coach
- [ ] 속성 : 이름, 못먹는 메뉴 list
- [ ] 기능 : 메뉴는 알맞게 생성한다.

### InputView
- [ ] 예외 처리는 controller 에서 한다. 