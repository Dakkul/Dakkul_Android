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

***

1. 구현 영상



2. 각자 맡은 부분 설명

- 뷰 구성 : Homefragment -> storyDialogFragment -> PunchFragment -> PunchReviewFragment->ResultFragment



- 각자 맡은 뷰 및 역할
  - 조재훈 : HomeFragment
    - xml, border, chip, 리싸이클러뷰, 서버통신, 기능 구현
  - 김혜인 : storyDialogFragment, ResultFragment
    - xml, border, esset 불러오기, 서버통신, 기능 구현
  - 안나영 : PuchFragment, PunchReviewFragment
    - xml, border, color 지정, 서버통신, 기능 구현



- 뷰 설명

  - HomeFragment : chip으로 구성된 태그 들을 최대 3개 중복 선택할 수 있으며 선택된 대로 오른쪽에 recyclerview로 해당 tag를 가진 오늘의 복수하고싶은 불운 item들이 불러와진다. 이 때 전체 tag는 default 선택되어있고 이 경우 모든 item이 불러와진다.
  - storyDialogFragment : HomeFragment의 item을 선택하면 해당 item에 대한 story, 이미지 등의 정보를 담은 dialog 창이 나타난다. 이 때 버튼을 선택하게 되면 해당 불운을 깨부술 수 있는 fragment를 호출한다.
  - PuchFragment : 사진에게 꿀밤(클릭)을 하면 파괴된 내 불운이 나타난다. 때린 후 기분이 시원해지면 마지막 한 마디를 남길 수 있는 버튼을 클릭하면 된다.
  - PuchReviewFragment : 나의 불운에게 최후의 한마디를 남길 수 있다. 이 때 더 때리고 싶다면 왼쪽의 버튼을 통해 돌아갈 수 있고, 리뷰를 남기게 되면 이제 됐다는 버튼이 활성화 되며 마지막 fragment로 이동할 수 있게 된다.

  - ResultFragment : ResultFragment에선 공동체를 느낄 수 있다. 나와 똑같은 불운을 겪은 사람들의 리뷰를 랜덤으로 7가지, 그리고 나의 리뷰를 하단에 띄워준다. 이를 통해 공감대를 형성하며 위로를 받을 수 있다. 복수 끝내기 버튼을 통해 다시 HomeFragment로 돌아간다.

