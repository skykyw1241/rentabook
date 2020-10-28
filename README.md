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
  * 동기식 호출
  * 비동기식 호출과 Eventual Consistency
* 운영
  * CI/CD 설정
  * Liveness
  * Readiness
  * HPA 적용(Autoscale)
  
  


## 서비스 시나리오
### 기능적 요구사항
1. 고객이 책 대여를 신청한다.
2. 주문이 접수된다.
3. 요청한 책의 배송이 시작된다.
4. 고객이 책 대여를 취소할 수 있다.
5. 대여가 취소되면 배송이 중지된다.
6. 고객이 자신의 주문 정보를 확인할 수 있다.

### 비기능적 요구사항
1.	트랜잭션<br>
  i.	결제가 되지 않은 주문 건은 접수가 불가하다.<br>
  ii.	재고가 0인 경우 접수가 불가하다.
2.	장애격리<br>
  i.	배송관리 기능이 수행되지 않더라도 대여 접수가 가능하다.<br>
  ii.	대여 시스템에 부하가 걸리면 대여 신청을 보류한다.<br>
  iii.	주문 취소 시 재고 관리가 되지 않더라도 취소되어야 한다.
3.	성능<br>
  i.	고객이 자신의 주문 이력을 확인할 수 있다.


## 분석/설계
AS-IS 조직(Horizontally-Aligned) -> TO-BE 조직(Vertically-Aligned)



### Event Storming
![이벤트스토밍 설계](https://user-images.githubusercontent.com/73535272/97375299-d12b4b00-18fd-11eb-9b0b-871b1e3588a2.JPG)
 
### MSA 구조
![msa구조](https://user-images.githubusercontent.com/73535272/97383342-b7dfca00-1910-11eb-8ec4-f4e19bf5440c.JPG)


## 구현
### DDD의 적용
분석/설계 단계에서 도출된 MSA는 총 4개로 다음과 같음
* 고객페이지(view)는 CQRS를 위한 서비스
1. 책 상품 관리<br>
![view_books](https://user-images.githubusercontent.com/73535272/97380457-6af8f500-190a-11eb-88df-3fbe4ef56860.jpg)
![view_books_1](https://user-images.githubusercontent.com/73535272/97380459-6c2a2200-190a-11eb-9473-5330f69cceae.JPG)
![view_books_2](https://user-images.githubusercontent.com/73535272/97380460-6cc2b880-190a-11eb-8f56-7c2f32a7b947.JPG)
![view_books_3](https://user-images.githubusercontent.com/73535272/97380463-6d5b4f00-190a-11eb-9bdf-a36fc2b26106.JPG)
2. 주문 관리<br>
![view_rentals](https://user-images.githubusercontent.com/73535272/97380482-7b10d480-190a-11eb-8dea-dec980fe395b.jpg)
3. 배송 관리<br>
![view_deliveries](https://user-images.githubusercontent.com/73535272/97380496-849a3c80-190a-11eb-8dcc-459be87a874f.jpg)
4. 고객 페이지<br>
![view](https://user-images.githubusercontent.com/73535272/97380515-8e23a480-190a-11eb-8e9f-b694a42f4f94.jpg)

### Request-Response 아키텍쳐 구현
1. Req-Res 호출<br>
![req-res_1_호출 소스](https://user-images.githubusercontent.com/73535272/97381900-64b84800-190d-11eb-991e-c18770bd9f04.JPG)

2. Req-Res 처리<br>
![req-res_2_처리 controller](https://user-images.githubusercontent.com/73535272/97381905-6a159280-190d-11eb-88b8-c2212245e8c4.JPG)

### 이벤트 드리븐 아키텍처 구현
1. 이벤트 드리븐 - 비동기 호출<br>
![이벤트 드리븐 -1_비동기호출](https://user-images.githubusercontent.com/73535272/97381919-713ca080-190d-11eb-93f5-e34197932af5.JPG)

2. 이벤트 드리븐 - class 선언<br>
![이벤트 드리븐 -2_ 이벤트 class 선언](https://user-images.githubusercontent.com/73535272/97381924-76015480-190d-11eb-81b7-ccd32ab00015.JPG)

3. 이벤트 드리븐 - publish<br>
![이벤트 드리븐 -3_ publish](https://user-images.githubusercontent.com/73535272/97381928-7994db80-190d-11eb-8bf1-78622f1f4a1a.JPG)

4. 이벤트 드리븐 - 수신<br>
![이벤트 드리븐 -4_ 수신](https://user-images.githubusercontent.com/73535272/97381934-7ef22600-190d-11eb-849d-14da20a4516f.JPG)

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
1. git 복사<br>
![CI_1_git 복사](https://user-images.githubusercontent.com/73535272/97382363-9251c100-190e-11eb-8ba7-94c13f603093.JPG)

2. maven package <br>
![CI_2_maven 패키지](https://user-images.githubusercontent.com/73535272/97382371-97af0b80-190e-11eb-90e3-29cd10060a38.JPG)

3. image 생성<br>
![CI_3_이미지 생성](https://user-images.githubusercontent.com/73535272/97382383-a1387380-190e-11eb-8b7b-67af74e02574.JPG)

4. pod deploy 생성<br>
![CI_4_pod_deploy 생성](https://user-images.githubusercontent.com/73535272/97382403-abf30880-190e-11eb-9e01-169dfa630300.JPG)

### Liveness
1. yaml 설정<br>
![liveness_0_설정 yaml](https://user-images.githubusercontent.com/73535272/97382860-ab0ea680-190f-11eb-8852-64c2b77d034c.JPG)

2. deploy 생성<br>
![liveness_1_yaml로 deploy 생성](https://user-images.githubusercontent.com/73535272/97382888-b792ff00-190f-11eb-91de-94049b2672b3.JPG)

3. pod 내 오류로 인한 셧다운 처리<br>
![liveness_2_pod내 로그_ 오류로 shutdown 처리](https://user-images.githubusercontent.com/73535272/97382933-c7124800-190f-11eb-9b4d-d091ecb87a37.JPG)

### Readiness
1. readiness seige 과정

2. readiness seige 결과

### HPA 적용(Autoscale)
1. HPA 속성 지정<br>
![HPA_kubectl get all_replica 속성 지정](https://user-images.githubusercontent.com/73535272/97378949-f53f5a00-1906-11eb-9be7-d64f83c6e082.JPG)
<br>

2. HPA 실행<br>
![HPA_replica 실행됨](https://user-images.githubusercontent.com/73535272/97378959-fd979500-1906-11eb-9c2f-9bf10dd88a9b.JPG)
