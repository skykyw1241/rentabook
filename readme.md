# 3조 - 책 주문/배송


## 구현 Repository
1. 책 상품 관리 : https://github.com/skykyw1241/bookDelivery1.git
2. 주문 관리    : https://github.com/skykyw1241/bookDelivery1.git
3. 배송 관리    : https://github.com/skykyw1241/bookDelivery1.git
4. 고객페이지   : https://github.com/skykyw1241/bookDelivery1.git
5. 게이트웨이   : https://github.com/skykyw1241/bookDelivery1.git

## Table of Contents
* 서비스 Scenario
  - 시나리오 테스트 
* 분석 - 설계
* 구현
  - DDD의 적용
  - Gateway 적용 
  - Ployglot persistence
  - 동기식 호출과 Fallback 처리
  - 비동기식 호출과 Eventual Consistency

* 운영
  - CI/CD 설정
  - 서킷 브레이킹/ 장애격리
  - Auto Scale-out
  - 무정지 재배포


## 서비스 시나리오
기능적 요구사항
1.	고객이 책 대여를 신청한다.
2.	주문이 접수된다.
3.	요청한 책 배송 시작
4.	고객이 책 대여를 취소할 수 있다.
5.	대여가 취소되면 배송이 중지된다.
6.	고객이 자신의 주문 정보를 확인할 수 있다.
7.	주문 접수 시 책 재고량의 증감

비기능적 요구사항
1.	트랜잭션

    i.	결제가 되지 않은 주문 건은 접수가 불가하다.

    ii.	재고가 0인 경우 접수가 불가하다.


2.	장애격리

     i.	배송관리 기능이 수행되지 않더라도 대여 접수가 가능하다.
 
     ii.	대여 시스템에 부하가 걸리면 대여 신청을 보류한다.
 
     iii.	주문 취소 시 재고 관리가 되지 않더라도 취소되어야 한다.
 
 
3.	성능

     i.	고객이 자신의 주문 이력을 확인할 수 있다.



### 분석 설계

  - Event Storming
  
    ![event_storming](https://user-images.githubusercontent.com/27837607/97300455-d6ef4500-1899-11eb-8065-ef5de48e860b.jpg)
    

  - 헥사고날 아키텍처
    (이미지 경로)
    
### 구현
  - DDD의 적용
  
  - Gateway 적용
  
  - Polyglot persistence
  
  - 동기식 호출과 Fallback 처리
  
  - 비동기식 호출과 Eventual Consistency
    
    
    
### 운영
  - CI / CD 설정
  
  - 서킷 브레이킹 / 장애처리
  
  - Auto Scale-out
  
  - 무정지 재배포
  
