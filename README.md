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
  * Request-Response 아키텍쳐 구현
  * 이벤트 드라이븐 아키텍처 구현
  * Gateway 적용
  *
  * 폴리글랏 퍼시스턴스
  *
  * 동기식 호출
  * 비동기식 호출과 Eventual Consistency
* 운영
  * CI/CD 설정
  * Autoscale
  * HPA 적용
  
  


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
AS-IS 조직(Horizontally-Aligned) -> TO-BE 조직(Vertically-Aligned)



### Event Storming
![이벤트스토밍 설계](https://user-images.githubusercontent.com/73535272/97375299-d12b4b00-18fd-11eb-9b0b-871b1e3588a2.JPG)
 
### 헥사고날 아키텍처


## 구현
### DDD의 적용
분석/설계 단계에서 도출된 MSA는 총 4개로 다음과 같음
* 고객페이지(view)는 CQRS를 위한 서비스
1. 책 상품 관리
2. 주문 관리
3. 배송 관리
4. 고객 페이지


### Request-Response 아키텍쳐 구현
소스..

### 이벤트 드리븐 아키텍처 구현
소스 ...

### 롤리그랏 프로그래밍
CQRS 를 위한 stock 서비스는 pom.xml 인메모리 DB인 hsqldb 사용 적용 함<br>
![polyglot](https://user-images.githubusercontent.com/73535272/97377031-57e22700-1902-11eb-8f73-845f700627c6.png)


### API 게이트웨이
1. Gateway 설정<br>
![Gateway_ 설정_yaml](https://user-images.githubusercontent.com/73535272/97379145-74349280-1907-11eb-9e07-78aeb5aa399d.JPG)
<br>

2. Gateway rental  설정<br>
![Gateway_rental생성](https://user-images.githubusercontent.com/73535272/97379165-7f87be00-1907-11eb-9f6f-9f4ab3f7cb7e.JPG)
<br>

3. Gateway 정보조회<br>
![Gateway_정보조회](https://user-images.githubusercontent.com/73535272/97379181-8adae980-1907-11eb-80b2-1595781751d0.JPG)
<br>

4. Gateway 직접정보조회<br>
![Gateway_직접정보조회](https://user-images.githubusercontent.com/73535272/97379198-975f4200-1907-11eb-96f2-94b3a6e50938.JPG)
<br>


## 운영
### CI/CD설정
...소스

### Autoscale

### HPA 적용
1. HPA 속성 지정<br>
![HPA_kubectl get all_replica 속성 지정](https://user-images.githubusercontent.com/73535272/97378949-f53f5a00-1906-11eb-9be7-d64f83c6e082.JPG)
<br>

2. HPA 실행<br>
![HPA_replica 실행됨](https://user-images.githubusercontent.com/73535272/97378959-fd979500-1906-11eb-9c2f-9bf10dd88a9b.JPG)
