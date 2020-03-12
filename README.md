# Roadruwa <여행 경로 가이드북>
[![License](http://img.shields.io/:license-apache-brightgreen.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

#### 회원가입을 해야만 게시글을 볼 수 있기 때문에 이미 가입 시켜 놓은 ID로 접속 후 보실 수 있습니다 
#### (ID: cyshim / PW: cyshim) http://dadang.skycows.pe.kr/

프로젝트 소개
--------
이 프로젝트는 여행 계획 수립시간이 부족하거나 많은 여행정보의 선택에 어려움이 있는 사람을 위한 여행 경로 공유 홈페이지입니다. Spring Framework를 접하게 되면서 순수 자바로만 코딩한 졸업작품 홈페이지의 문제점이 많이 보였습니다. 같은 코드 반복으로 재사용성이 떨어졌고 후에 수정할 때 전부 수정이 필요해 불편함이 있어 리펙토링의 필요성을 느꼈습니다. 이로 인해 기존에 다뤘던 주제로 기술적인 면을 업그레이드하고 싶어 동일한 주제를 선정하였습니다.

구현 기술
--------
- 사용(개발) 언어 : JAVA
- 프레임워크 : Spring Framework
- 사용(개발)  툴 : ECLIPSE
- DB : MariaDB
- 기술: MyBatis, JavaScript, jQuery, HTML, CSS
- 데이터베이스 관리 도구: DBeaver

수행 조직
----------
- 팀장 심다영 /  팀원 2명 (총 3명)
- 팀장: 데이터베이스 구축과 주요 기능 구현, 전체 구성원의 R&R을 정의, 과제 진척을 관리
- 다른 팀원: 각자 화면 구성 및 기능 개발을 담당
- 주요 기능 테스트 및 품질 검토: 팀장, 강사님

주요 기능
------
- 회원가입 (이메일 인증)
- 검색 (검색별 / 카테고리별)
- 게시글 (카카오API 지도 / 우편 / 에디터(Summernote))
- 댓글 (별점부여)
- 포인트 (카카오페이)

상세설명
------

<h3> 1. 회원가입(이메일인증)

<img src="https://user-images.githubusercontent.com/59246146/73720658-d17b2900-4765-11ea-946e-ef3df9e1ccea.png" width="180px">&nbsp;&nbsp;
<img src="https://user-images.githubusercontent.com/59246146/73722618-3f295400-476a-11ea-98c0-2b123d33e7e2.png" width="300px" height="350px">&nbsp;
<img src="https://user-images.githubusercontent.com/59246146/73722899-f7ef9300-476a-11ea-8873-d4079387b85b.png" width="350px" height="50px">&nbsp;

<h4>ㄱ. 설명 </h4>

> 아이디 중복확인시 회원가입 버튼이 활성화 / 이메일 인증후 회원가입 완료<br>
> 회원가입시 500포인트 적립

<h4>ㄴ. 기능구현 설명 </h4>
<img src="https://user-images.githubusercontent.com/59246146/76487347-7c69bb80-6465-11ea-82e3-61a7939c45d8.png" width="450px">

> Spring설정하는 xml파일에 gmail인증 Baen을 추가<br>
> Mail전송시 필요한 기본정보 입력

<img src="https://user-images.githubusercontent.com/59246146/76487354-81c70600-6465-11ea-9e85-f253ffa40f3c.png" width="450px">&nbsp;
<img src="https://user-images.githubusercontent.com/59246146/76488639-62ca7300-6469-11ea-8d34-8fca35651f06.png" width="350px">

> Controller에서 MailUtils class선언 후 객체의 데이터 저장<br>
> Mail전송시 Authstatus의 값 0 -> 링크 클릭시 Authstatus의 값 1 update<br>
> 로그인시 Authstatus의 값 1인 사람만 가능

<h3> 2. 검색<br>
 
<img src="https://user-images.githubusercontent.com/59246146/73750348-5b47e800-47a0-11ea-9842-ebcc81898456.png" width="400px">&nbsp; <img src="https://user-images.githubusercontent.com/59246146/73751770-18d3da80-47a3-11ea-8c69-d50f87551e26.png" width="300px">
  
<h4>ㄱ. 설명 </h4>
 
> 관리자의 승인처리가 되지 않은 게시물은 검색불가<br>
> 지역, 여행일수, 교통, 경비, 테마 별로 검색
 
<h4>ㄴ. 기능구현 설명 </h4>
<img src="https://user-images.githubusercontent.com/59246146/76489775-b4c0c800-646c-11ea-8c59-7924239dc021.png" width="450px">

> 검색시 search함수에 카테고리의 SelectBox의 값들과 검색창의 Text값을 변수로 받아 Controller로 전달

<img src="https://user-images.githubusercontent.com/59246146/76489953-28fb6b80-646d-11ea-82b2-e41c9850835c.png" width="830px">
 
> RequestParam으로 카테고리와 검색의 데이터를 받아 getBoardList메소드의 변수로 대입

<img src="https://user-images.githubusercontent.com/59246146/76489963-2ac52f00-646d-11ea-8bdb-a235660a48c2.png" width="450px">

> XML에 if문으로 만약 각각의 데이터가 null이 아닐경우 board테이블 List에 해당되는 값들을 저장

<h3> 3. 게시글(작성)<br>
 
 <img src="https://user-images.githubusercontent.com/59246146/73812918-cede0980-4821-11ea-8a80-6bb7a841a2d4.png" width="400px">&nbsp;
 <img src="https://user-images.githubusercontent.com/59246146/73812848-98a08a00-4821-11ea-96d4-cd289f7476a5.png" width="450px">
 
 <h4>ㄱ. 설명 </h4>
 
 > 작성할 여행 경로의 일수에 따라 게시글 양식이 동적으로 생성<br>
 > 여행 일수별로 여행비, 식비, 교통비, 숙박비를 입력<br>
 > 여행 일수별로 Summernote라는 에디터를 사용하여 유연성 있는 게시글을 작성<br>
 > 여행 일수별로 가장 추천하는 여행지의 주소를 입력가능
 
 <h4>ㄴ. 기능구현 설명 </h4>
<img src="https://user-images.githubusercontent.com/59246146/76490814-6bbe4300-646f-11ea-93e9-aecbdf3352a8.png" width="400px">

> jQuery를 사용해 id가 tmplt1인 form을 일수에 따라 id가 rr인 곳에 적용<br>
> summernote라는 에디터기는 비동기식 함수인 callback함수을 사용해 file를 첨부할때마다 sendFile함수를 작동<br>

<img src="https://user-images.githubusercontent.com/59246146/76490811-69f47f80-646f-11ea-9156-a4fc488be735.png" width="400px">

> sendFile함수는 file를 Ajax를 사용해 비동기식으로 데이터전달 
 
<img src="https://user-images.githubusercontent.com/59246146/76491413-f3f11800-6470-11ea-9a11-500f565a01ab.png" width="830px">

> RequestParam으로 받은 file을 FileUploader클래스의 uploadFile메소드를 사용해 file정보 저장<br>
> DB에 Data 저장시 파일이 문자로 변환되어져 저장되기 때문에 용량이 비효율적인것을 막기 위해 성공시 file의 경로와 savednm으로 저장

<img src="https://user-images.githubusercontent.com/59246146/76491519-42061b80-6471-11ea-8fe1-771cb3142e93.png" width="400px">

> 동적으로 받은 Data를 getParameterValues를 이용해 배열로 저장 후 for문을 사용해 BoardDay테이블에 저장 

<h3> 3. 게시글(view)<br>

 <img src="https://user-images.githubusercontent.com/59246146/73814029-30ec3e00-4825-11ea-867b-e08ba45663ab.png" width="400px">&nbsp;
 <img src="https://user-images.githubusercontent.com/59246146/73814176-9d673d00-4825-11ea-9112-3679a9c03599.png" width="400px">
 
 <h4>ㄱ. 설명 </h4>
 
> ex) 1박 2일의 여행 게시글<br>
> 등록된 여행 일수별로 작성됨<br>
> 처음에 1일 차로 초기화되어있으며 1 일차의 추천 여행지 주소, 지도, 종류별 비용, 게시글을 볼 수 있음<br>
> 2 일차를 클릭시 2 일차의 추천 여행지 주소, 지도, 종류별 비용, 게시글을 볼 수 있음
 
 <img src="https://user-images.githubusercontent.com/59246146/73815664-fb961f00-4829-11ea-8f80-5ea78c9e59c9.png" width="400px" height="350px">&nbsp;
 <img src="https://user-images.githubusercontent.com/59246146/73815962-cccc7880-482a-11ea-87cd-0067ad001fc6.png" width="400px" height="350px">
 
 > 일수별 게시글을 볼 수 있음<br>
 
 <h4>ㄴ. 기능구현 설명 </h4>
<img src="https://user-images.githubusercontent.com/59246146/76493837-f191bc80-6476-11ea-9fd9-0eed11bd19b2.png" width="400px" height="400px">&nbsp;
<img src="https://user-images.githubusercontent.com/59246146/76493844-f5254380-6476-11ea-99a9-ee436b4af5e7.png" width="400px">
 
 > 카카오API를 사용해 게시글 작성할때 입력했던 우편번호를 addr, 몇일차인지의 nday를 사용해 지도에 적용<br>
 > 일수에 따라 해당사항이 없는 일수의 Data는 none처리

<h3> 4. 댓글(별점)<br>
 
<img src="https://user-images.githubusercontent.com/59246146/74009212-1b624a00-49c6-11ea-89b3-5bae0aea64a3.png" width="400px" height="250px">&nbsp;
<img src="https://user-images.githubusercontent.com/59246146/74009110-dc33f900-49c5-11ea-99c3-3ffefe368757.png" width="400px" height="250px">&nbsp;

<h4>ㄱ. 설명 </h4>

> 구매한 게시글의 후기와 질문을 댓글로 작성가능 (자신의 글만 수정/삭제)<br>
> 게시글의 작성자는 자신의 글에 댓글을 달 수 없음 (자신의 글에 댓글을 달아 글 가격 올림 방지)<br>

<img src="https://user-images.githubusercontent.com/59246146/74009660-0afe9f00-49c7-11ea-871e-27576573e7e8.png" width="200px" height="150px">&nbsp;&nbsp;&nbsp;
<img src="https://user-images.githubusercontent.com/59246146/74009560-ce32a800-49c6-11ea-8bc0-d0c081b660fb.png" width="400px" height="300px">&nbsp;

<h4>ㄱ. 설명 </h4>

> 글의 가격은 별점으로 측정<br>
> 글의 총 별점이 50개당 100원씩 증가<br>

<h3> 6. 포인트(카카오페이)<br>

<img src="https://user-images.githubusercontent.com/59246146/74011430-2c618a00-49cb-11ea-9a70-48d04a18c8d2.png" width="350px" height="250px">&nbsp;
<img src="https://user-images.githubusercontent.com/59246146/74011435-2d92b700-49cb-11ea-94af-bd0f5eb9b423.png" width="200px" height="250px">&nbsp;
<img src="https://user-images.githubusercontent.com/59246146/74011444-32576b00-49cb-11ea-8320-5ce0452ef3d5.png" width="270px" height="250px">&nbsp;

<h4>ㄱ. 설명 </h4>

> TextBox를 통해 금액을 입력 후 카카오페이로 금액 결제가능<br>

<h4>ㄴ. 기능구현 설명 </h4>
<img src="https://user-images.githubusercontent.com/59246146/76516888-99bb7b80-649f-11ea-8244-19d1f0ff4aca.png" width="600px">

> 무료 결제연동 서비스를 제공하는 아임포트에서 부여받은 가맹점 식별코드를 입력<br>
> Text박스의 id인 pay의 값을 result로 받은 후 IMP.request_pay()함수를 호출<br>
> 성공시 AJAX를 사용해 필요한 Data를 컨트롤러로 넘김

마치며
------
처음엔 Spring Framework에 대해 아는 것이 없어 막막하고 어려움이 많았습니다. 하지만 프로젝트를 끝낸 이 시점엔 기본적인 spring framework에 대한 이해와 활용 역량이 향상되었습니다. 또한, 팀장으로서 팀원들의 R&R 관리와 일정/진척관리의 중요성을 이해하는 계기가 되었습니다. 기존 순수 자바로 진행한 졸업작품의 프로젝트에 비해 중복 코드가 많이 해소되었고 소스가 많이 정리되어 좀 더 수월하게 진행하였습니다. 또한, 쿼리 부분이 분리됨으로써 깔끔함을 느꼈고 화면, 로직 제어, 데이터 부분이 명확하게 분리되면서 전체 시스템의 흐름의 파악도 쉬어졌습니다. 아직도 많이 부족하지만, 팀원들과 함께 노력을 많이 한 만큼 보람 있는 프로젝트였습니다. 앞으로도 좀 더 나은 프로그램을 위해 노력하는 사람이 되겠습니다.
