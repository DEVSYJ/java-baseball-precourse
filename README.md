# 숫자 야구 게임

## 진행 방법

* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정

* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

---

## 요구사항

### 기능 상세

* 1부터 9까지 서로 다른수로 이루어진 3자리의 수를 맞추는 게임
    * 같은수가 같은 자리에 있으면 스트라이크
    * 다른자리에 있으면 볼
    * 같은수가 전혀 없으면 포볼 또는 낫싱
* 스트라이크, 볼, 낫싱의 힌트를 이용해서 상대방(컴퓨터)의 수를 맞추면 승리
    * [예] 상대방(컴퓨터)의 수가 425일 때,
        * 123 제시 - 1스트라이크
        * 456 제시 - 1스트라이크 1볼
        * 789 제시 - 낫싱
* 위 숫자 야구게임에서 상대방의 역할을 컴퓨터가 한다.
    1. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다.
    1. 게임플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고,
    1. 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
    1. 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
    1. 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
* 사용자가 잘못된 값을 입력할 경우 [ERROR]로 시작하는 에러메시지를 출력하고 게임을 계속 진행할 수 있어야 한다.

#### 실행 결과

```
숫자를 입력해주세요 : 123
1스트라이크 1볼
숫자를 입력해주세요 : 145
1볼
숫자를 입력해주세요 : 671
2볼
숫자를 입력해주세요 : 216
1스트라이크
숫자를 입력해주세요 : 713
3스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 끝
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
1
숫자를 입력해주세요 : 123
1볼
…
```

### 제약 사항 및 단위테스트

<details>
<summary>제약 사항</summary>

* 자바 코드 컨벤션을 지키면서 프로그래밍 한다.
    * https://naver.github.io/hackday-conventions-java/
* indent(인덴트,들여쓰기) depth를 2가 넘지 않도록 구현한다. 1까지만 허용한다.
    * 예를들어 while문안에 if문이 있으면 들여쓰기는 2이다.
    * 힌트 : indent(인덴트,들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
* 자바 8에 추가된 stream api를 사용하지 않고 구현해야 한다. 단, 람다는 사용가능하다.
* else 예약어를 쓰지 않는다.
    * 힌트 : if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    * else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
* 함수(또는 메소드)의 길이가 10라인을 넘어가지 않도록 구현한다.
    * 함수(또는 메소드)가 한가지 일만 잘하도록 구현한다.

</details>

<details>
<summary>단위 테스트</summary>

* 도메인 로직에 단위테스트를 구현해야 한다. 단, UI(System.out,System.in,Scanner) 로직은 제외
    * 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
    * 힌트 : MVC 패턴 기반으로 구현한 후 View, Controller를 제외한 Model에 대한 단위 테스트를 추가하는 것에 집중한다.

</details>

## TODO

### 환경 설정

* [x] 코드 컨벤션 체크 셋팅
    * https://naver.github.io/hackday-conventions-java/#_intellij
* [x] 커밋 로그 셋팅
    * [제시된 Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)
      ```
      <type>(<scope>): <subject>  // 명령형, 현재시제 사용, 첫 글자 대문자/온점 미사용
      <BLANK LINE>
      <body>  // 왜 변경됐는지, 이전과의 비교내역
      <BLANK LINE>
      <footer>
      ```
    * [IntelliJ Plugin](https://plugins.jetbrains.com/plugin/9861-git-commit-template)

### 기능 구현

#### 게임판

* [x] 게임 시작
* [x] 서로 다른 임의의 수(1~9) 3개 선택
* [x] 게임 재시작
* [x] 게임 종료

#### 투수

* [x] 사용자 입력 받기
* [x] 잘못된 값 입력 시
    * [x] 잘못된 값 처리
        * [x] 숫자 이외
        * [x] 3자리가 아닌 숫자
        * [x] 0이 들어간 세자리 숫자
        * [x] 중복되는 숫자가 있는 경우
    * [x] 에러 메시지 출력 ([ERROR] 에러메시지)
    * [x] 다시 입력 받기 (게임 계속 진행)

#### 심판

* [x] 사용자가 입력한 숫자에 대한 결과 출력
    * [x] 같은 수가 같은 자리에 있으면 스트라이크
    * [x] 다른 자리에 있으면 볼
    * [x] 같은 수가 전혀 없으면 포볼 또는 낫싱
* [x] 사용자가 정답을 맞힐 시
    * [x] 게임 종료
