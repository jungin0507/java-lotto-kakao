# java-lotto-kakao

## 프로그래밍 요구사항

* indent(인덴트, 들여쓰기) depth를 2단계에서 1단계로 줄여라.
* depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.
* else를 사용하지 마라.
* 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
* method가 한 가지 일만 하도록 최대한 작게 만들어라.
* 배열 대신 ArrayList를 사용한다.
* java enum을 적용해 프로그래밍을 구현한다.
* 규칙 3: 모든 원시값과 문자열을 포장한다.
* 규칙 5: 줄여쓰지 않는다(축약 금지)
* 규칙 8: 일급 콜렉션을 쓴다.

## 기능 요구사항

* 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
* 로또 1장의 가격은 1000원이다.

```
구입금액을 입력해 주세요.
14000
14개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[23, 25, 33, 36, 39, 41]
[1, 3, 5, 14, 22, 45]
[5, 9, 38, 41, 43, 44]
[2, 8, 9, 18, 19, 21]
[13, 14, 18, 21, 23, 35]
[17, 21, 29, 37, 42, 45]
[3, 8, 27, 30, 35, 44]

지난 주 당첨 번호를 입력해 주세요.
1, 2, 3, 4, 5, 6
보너스 볼을 입력해 주세요.
7

당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
5개 일치, 보너스 볼 일치(30000000원) - 0개
6개 일치 (2000000000원)- 0개
총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
```

## 기능 구현

### 입출력

* 구입금액을 입력 받는다.
* 당첨 번호 6개를 입력 받는다.
* 보너스 볼을 입력 받는다.
* 구매한 로또 매수를 출력한다.
* 생성된 로또 번호를 출력한다.
* 당첨 통계를 출력한다.
* 수익률을 출력한다.

### 핵심 기능

* 로또 번호 6개를 랜덤으로 생성한다.
    * 1~45 사이의 숫자를 생성한다.
    * 숫자 6개를 중복되지 않게 생성한다.
* 구입 금액에 맞는 개수 만큼의 로또를 구매한다.
    * 구입 금액에 맞는 로또 개수를 계산한다.
* 입력한 당첨 번호와 생성된 로또 번호를 비교해 당첨 통계를 계산한다.
    * 당첨 번호와 로또 번호가 3개만 일치하는지 확인한다. - 5등
    * 당첨 번호와 로또 번호가 4개만 일치하는지 확인한다. - 4등
    * 당첨 번호와 로또 번호가 5개만 일치하는지 확인한다. - 3등
    * 당첨 번호와 로또 번호가 5개만 일치하고, 보너스 볼과 일치하는지 확인한다. - 2등
    * 당첨 번호와 로또 번호가 6개만 일치하는지 확인한다. - 1등
* 당첨 통계로 부터 수익률을 계산한다.
    * 구입한 로또가 5등에 당첨되면 5000원이다.
    * 구입한 로또가 4등에 당첨되면 50000원이다.
    * 구입한 로또가 3등에 당첨되면 1500000원이다.
    * 구입한 로또가 2등에 당첨되면 30000000원이다.
    * 구입한 로또가 1등에 당첨되면 2000000000원이다.
    * 당첨 금액의 합을 구한다.
    * 금액의 합과 구입 금액으로 부터 수익률을 계산한다.

### 도메인 설계

* 로또 번호
    * 1부터 45 사이의 정수인지 검사
* 구매 금액
    * 1 이상의 정수인지 검사
* 로또 상점
    * 로또 1장의 금액 저장 - 상수
    * 구매 금액에 맞게 로또 리스트 반환
        * 로또를 한 장도 못사면 예외 발생
        * 로또는 최대한 많이 구매
        * 남은 금액은 무시
* 당첨 로또
    * 로또 번호가 중복되는지 검사
    * 당첨 번호 6개와 보너스 번호 1개를 주입받아서 생성
    * 로또를 받아서 몇 등인지 계산
* 로또
    * 로또 번호가 중복되는지 검사
    * 로또 번호 6개 생성
* 로또 등수 (enum)
    * 당첨 금액 저장
    * 로또 번호가 등수에 맞는지 판단
* 당첨 결과
    * 로또 등수에 따른 로또 개수를 갖고 있음
    * 구입 금액으로 수익률 계산
