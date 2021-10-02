# 숫자 야구 게임

## 진행 방법

* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정

* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

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

* [ ] 사용자 입력 받기
    * [ ] 잘못된 값 입력 시
        * [ ] 잘못된 값 처리
            * [ ] 숫자 이외
            * [ ] 3자리가 아닌 숫자
            * [ ] 0이 들어간 세자리 숫자
        * [ ] 에러 메시지 출력 ([ERROR] 에러메시지)
        * [ ] 다시 입력 받기 (게임 계속 진행)


* [ ] 상대방 역할 구현
    * [ ] 서로 다른 임의의 수(1~9) 3개 선택
    * [ ] 사용자가 입력한 숫자에 대한 결과 출력
        * [ ] 같은 수가 같은 자리에 있으면 스트라이크
        * [ ] 다른 자리에 있으면 볼
        * [ ] 같은 수가 전혀 없으면 포볼 또는 낫싱
    * [ ] 사용자가 정답을 맞힐 시
        * [ ] 게임 종료 후
            * [ ] '1' 입력 시 게임 다시 시작
            * [ ] '2' 입력 시 누르면 게임 완전 종료

* [ ] 

IntelliJ IDEA code style XML import failed with error message:
The file doesn't seem to be a valid Intellij IDEA XML scheme, it should contain 'code_scheme root' element, found '
module' instead.
