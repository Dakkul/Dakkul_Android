# Dakkul_Android
#### 29th 솝커톤_안드로이드_4조_🌰🔨다꿀 (다함께 꿀밤)  - 우리의 작은 복수

***

### :desktop_computer: 서비스 이름과 간단한 서비스 소개

:yellow_heart: **서비스 명**

- **다꿀(다함께 꿀밤) - 우리의 작은 복수**

:yellow_heart: **서비스 한 줄 소개**

- 어제도 당하지 않았는가? 하찮은 종이, 작은 레고, 낮은 문지방에! 이제는 우리가 복수할 때! 모두 다함께 꿀밤, 다꿀로 모여!



### :family: 각자 개발 담당 부분

:star: **조재훈**

- `Home View`

:star: **김혜인**

- `End View`, `Dialog`

:star: **안나영**

- `splash`, `Funch View`



### :page_with_curl: 코드 컨벤션

| what                    | convention           | example                                                    |
| ----------------------- | -------------------- | ---------------------------------------------------------- |
| 함수, 변수              | Lower Carmel Case    | dakkulFunction                                             |
| 클래스, 인터페이스      | Upper Carmel Case    | DakkulClass                                                |
| 상수                    | Screaming Snake Case | DAKKUL_VALUE                                               |
| xml id                  | Snake case           | activity_dakkul.xml<br />item_home(where)_dakkul(what).xml |
| drawble                 | Snake case           | border_ (color)_(radius).xml                               |
| colors.xml              | Snake Case           | (color)_(colorcode)                                        |
| strings.xml, styles,xml | Snake Case           | (where)_(what)                                             |



### :deciduous_tree: ​브랜치 전략

- **develop에서 각자 이름으로 브랜치 생성**
  - 브랜치 명 : feat/이름
    - ex) feat/hyein
- **in 각자 브랜치**
  - 각자 기능 구현 후 commit
  - 중요한 변경 사항 있으면 !!꼭 말해주고!! push (develop으로)
    - main에서 바로 하면 충돌 위험이 있기에 develop 사용!
  - 다른 팀원들은 commit 후 pull (누군가 merge하면 바로 pull)
  - 자신이 맡은 부분 기능 구현 후 풀리퀘
  - 본인 브랜치는 삭제 하지 않고 사용
