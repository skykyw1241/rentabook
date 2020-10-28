# Team 3 - Book Rental (책 대여 서비스)
## 구현 Repository
1. 책 상품 관리: https://github.com/team34final/rentabook/tree/main/Book
2. 주문 관리: https://github.com/team34final/rentabook/tree/main/Rental
3. 배송 관리: https://github.com/team34final/rentabook/tree/main/Delivery
4. 고객 페이지: https://github.com/team34final/rentabook/tree/main/Viewer
5. 게이트웨이: https://github.com/team34final/rentabook/tree/main/gateway

## Table of Contents
* 서비스 시나리오
  * 시나리오 테스트 결과
* 분석/설계
* 구현
  * DDD의 적용
  * Gateway 적용
  * 폴리글랏 퍼시스턴스
  * 동기식 호출과 Fallback 처리
  * 비동기식 호출과 Eventual Consistency
* 운영
  * CI/CD 설정

## 서비스 시나리오
### 기능적 요구사항
1. 고객이 책 대여를 신청한다.
2. 주문이 접수된다.
3. 요청한 책의 배송이 시작된다.
4. 고객이 책 대여를 취소할 수 있다.
5. 대여가 취소되면 배송이 중지된다.
6. 고객이 자신의 주문 정보를 확인할 수 있다.

### 비기능적 요구사항
1.	트랜잭션\
  i.	결제가 되지 않은 주문 건은 접수가 불가하다.\
  ii.	재고가 0인 경우 접수가 불가하다.
2.	장애격리\
  i.	배송관리 기능이 수행되지 않더라도 대여 접수가 가능하다.\
  ii.	대여 시스템에 부하가 걸리면 대여 신청을 보류한다.\
  iii.	주문 취소 시 재고 관리가 되지 않더라도 취소되어야 한다.
3.	성능\
  i.	고객이 자신의 주문 이력을 확인할 수 있다.

## 분석/설계
AS-IS 조직 -> TO-BE 조직

### Event Storming
![이벤트스토밍 설계](https://user-images.githubusercontent.com/73535272/97375299-d12b4b00-18fd-11eb-9b0b-871b1e3588a2.JPG)
 



