# Roadruwa <여행 경로 가이드북>
[![License](http://img.shields.io/:license-apache-brightgreen.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

#### 회원가입을 해야만 게시글을 볼 수 있기 때문에 이미 가입 시켜 놓은 ID로 접속 후 보실 수 있습니다 
#### (ID: cyshim / PW: cyshim) http://dadang.skycows.pe.kr/

프로젝트 소개
--------
이 프로젝트는 여행 계획 수립시간이 부족하거나 많은 여행정보의 선택에 어려움이 있는 사람을 위한 여행 경로 공유 홈페이지입니다. Spring Framework를 접하게 되면서 순수 자바로만 코딩한 졸업작품 홈페이지의 문제점이 많이 보였습니다. 같은 코드 반복으로 재사용성이 떨어졌고 후에 수정할 때 전부 수정이 필요해 불편함이 있어 리펙토링의 필요성을 느꼈습니다. 이로 인해 기존에 다뤘던 주제로 기술적인 면을 업그레이드하고 싶어 동일한 주제를 선정하였습니다.

기술
--------
SpringFramework, MariaDB, MyBatis, jQuery, HTML5, CSS

프로젝트 설계 및 계획
----------
- 팀장 심다영 /  팀원 2명 (총 3명)
- 팀장: 데이터베이스 구축과 주요 기능 구현, 전체 구성원의 R&R을 정의, 과제 진척을 관리
- 다른 팀원: 각자 화면 구성 및 기능 개발을 담당
- 주요 기능 테스트 및 품질 검토: 팀장, 강사님

주요 기능 설명
------
기존 졸업작품의 기능에 좀 더 추가하였습니다!<br>

- 회원가입<br>

<img src="https://user-images.githubusercontent.com/59246146/73720658-d17b2900-4765-11ea-946e-ef3df9e1ccea.png" width="180px">&nbsp;&nbsp;
<img src="https://user-images.githubusercontent.com/59246146/73722618-3f295400-476a-11ea-98c0-2b123d33e7e2.png" width="300px" height="350px">&nbsp;
<img src="https://user-images.githubusercontent.com/59246146/73722899-f7ef9300-476a-11ea-8873-d4079387b85b.png" width="350px" height="50px">&nbsp;

> 아이디 중복확인을 해야만 회원가입 버튼이 활성화 / 이메일 인증후 회원가입 완료<br>
> 회원가입시 500포인트 적립

 - 검색<br>
 
 <img src="https://user-images.githubusercontent.com/59246146/73750348-5b47e800-47a0-11ea-9842-ebcc81898456.png" width="400px">&nbsp;
 <img src="https://user-images.githubusercontent.com/59246146/73751497-964b1b00-47a2-11ea-9693-1aa12ffcd789.png" width="400px">
 
> 관리자의 승인처리가 되지 않은 게시물은 검색불가

 
 <img src="https://user-images.githubusercontent.com/59246146/73751770-18d3da80-47a3-11ea-8c69-d50f87551e26.png" width="300px">
 
> 지역, 여행일수, 교통, 경비, 테마 별로 검색 / 관리자의 승인처리 되지 않은 게시물 검색불가<br>
 
 
 - 게시글 작성<br>
 
 <img src="https://user-images.githubusercontent.com/59246146/73812677-06988180-4821-11ea-9ce1-2d9657f4327f.png" width="300px">
 
> 작성할 경로의 제목, 여행지 사진 3개를 입력 가능<br>
> Selectbox를 사용한 카테고리 선택, 지역, 교통을 입력가능
 
 <img src="https://user-images.githubusercontent.com/59246146/73812918-cede0980-4821-11ea-8a80-6bb7a841a2d4.png" width="400px">&nbsp;
 <img src="https://user-images.githubusercontent.com/59246146/73812848-98a08a00-4821-11ea-96d4-cd289f7476a5.png" width="400px">
 
 > 작성할 여행 경로의 일수에 따라 게시글 양식이 동적으로 생성<br>
 > 여행 일수별로 여행비, 식비, 교통비, 숙박비를 입력<br>
 > 여행 일수별로 Summernote라는 에디터를 사용하여 유연성 있는 게시글을 작성<br>
 > 여행 일수별로 가장 추천하는 여행지의 주소를 입력가능
 
 
 - 게시글<br>
 
 <구매 전><br>
 
 <img src="https://user-images.githubusercontent.com/59246146/73814881-a6f1a480-4827-11ea-86bc-0c09d9151933.png" width="400px">&nbsp;&nbsp;
 <img src="https://user-images.githubusercontent.com/59246146/73814892-ad801c00-4827-11ea-8d2e-36934540c955.png" width="300px">&nbsp;
 
> 게시글을 구매시 게시글 사용가능<br>
> 게시글을 구매하지 않았을 경우 모달을 통해 경로의 간단한 정보를 확인 후 구매 여부를 결정
 
 
 <img src="https://user-images.githubusercontent.com/59246146/73815126-54fd4e80-4828-11ea-977e-c875271d4c7c.png" width="500px">&nbsp;

> 구매 후 구매한 게시글 사용가능

 
 <구매 후><br>
 
 <img src="https://user-images.githubusercontent.com/59246146/73814029-30ec3e00-4825-11ea-867b-e08ba45663ab.png" width="400px">&nbsp;
 <img src="https://user-images.githubusercontent.com/59246146/73814176-9d673d00-4825-11ea-9112-3679a9c03599.png" width="400px">
 
> ex) 1박 2일의 여행 게시글<br>
> 등록된 여행 일수별로 작성됨<br>
> 처음에 1일 차로 초기화되어있으며 1 일차의 추천 여행지 주소, 지도, 종류별 비용, 게시글을 볼 수 있음<br>
> 2 일차를 클릭시 2 일차의 추천 여행지 주소, 지도, 종류별 비용, 게시글을 볼 수 있음
 
 
 <img src="https://user-images.githubusercontent.com/59246146/73815664-fb961f00-4829-11ea-8f80-5ea78c9e59c9.png" width="400px" height="350px">&nbsp;
 <img src="https://user-images.githubusercontent.com/59246146/73815962-cccc7880-482a-11ea-87cd-0067ad001fc6.png" width="400px" height="350px">&nbsp;
 
 > 일수별 게시글을 볼 수 있음<br>
 
 - 댓글<br>
 
 <img src="https://user-images.githubusercontent.com/59246146/74009212-1b624a00-49c6-11ea-89b3-5bae0aea64a3.png" width="400px" height="250px">&nbsp;
<img src="https://user-images.githubusercontent.com/59246146/74009110-dc33f900-49c5-11ea-99c3-3ffefe368757.png" width="400px" height="250px">&nbsp;

> 구매한 게시글의 후기와 질문을 댓글로 작성가능<br>
> (자신의 글만 수정/삭제 할 수 있습니다.)<br>
> 댓글의 내용, 첨부 파일, 별점을 줄 수 있음<br>
> 게시글의 작성자는 자신의 글에 댓글을 달 수 없음<br>
> ( 자신의 글에 댓글을 달아 글 가격 올림 방지)

 - 별점<br>
 
<img src="https://user-images.githubusercontent.com/59246146/74009660-0afe9f00-49c7-11ea-871e-27576573e7e8.png" width="200px" height="150px">&nbsp;&nbsp;&nbsp;
<img src="https://user-images.githubusercontent.com/59246146/74009560-ce32a800-49c6-11ea-8bc0-d0c081b660fb.png" width="400px" height="300px">&nbsp;

> 글의 가격은 별점으로 측정<br>
> 글의 총 별점이 50개당 100원씩 증가<br>
> 예를 들어 글의 총 별점이 50개 미만 0원, 50개는 100원, 100개는 200원으로 측정<br>


- 포인트(추가: 카카오페이) <br>
(경로: 로그인 후 -> 마이페이지 -> 포인트 ->충전하기 버튼)<br>

<img src="https://user-images.githubusercontent.com/59246146/74011430-2c618a00-49cb-11ea-9a70-48d04a18c8d2.png" width="350px" height="250px">&nbsp;
<img src="https://user-images.githubusercontent.com/59246146/74011435-2d92b700-49cb-11ea-94af-bd0f5eb9b423.png" width="200px" height="250px">&nbsp;
<img src="https://user-images.githubusercontent.com/59246146/74011444-32576b00-49cb-11ea-8320-5ce0452ef3d5.png" width="270px" height="250px">&nbsp;

> TextBox를 통해 금액을 입력 후 카카오페이로 금액 결제가능<br>

- 관리자(추가: 차트) <br>
(관리자ID : 관리자 / pw: 1234)<br>

<img src="https://user-images.githubusercontent.com/59246146/74011959-7434e100-49cc-11ea-96bf-5e867f913435.png" width="250px" height="300px">&nbsp;&nbsp;&nbsp;
<img src="https://user-images.githubusercontent.com/59246146/74012238-194fb980-49cd-11ea-946d-036d3b0fcfc2.png" width="250px" height="300px">&nbsp;&nbsp;&nbsp;
<img src="https://user-images.githubusercontent.com/59246146/74011965-76973b00-49cc-11ea-982d-630cdaa02f3d.png" width="250px" height="300px">&nbsp;

> 카테고리별 글 등록 수를 차트로 볼 수 있음<br>
> 관리자는 월별로 카테고리 글 등록 수를 차트로 볼 수 있음<br>
> 관리자는 지역별 글 등록 수를 차트로 볼 수 있음

<img src="https://user-images.githubusercontent.com/59246146/74012400-83685e80-49cd-11ea-8bff-5b01649c3898.png" width="600px" height="250px">&nbsp;

> 관리자는 사용자가 글 등록을 한 후 게시글을 검토하여 승인/미승인 처리가능<br>
> 관리자가 미승인 시 게시글을 사용자들이 볼 수 없음


마치며
------
처음엔 Spring Framework에 대해 아는 것이 없어 막막하고 어려움이 많았습니다. 하지만 프로젝트를 끝낸 이 시점엔 기본적인 spring framework에 대한 이해와 활용 역량이 향상되었습니다. 또한, 팀장으로서 팀원들의 R&R 관리와 일정/진척관리의 중요성을 이해하는 계기가 되었습니다. 기존 순수 자바로 진행한 졸업작품의 프로젝트에 비해 중복 코드가 많이 해소되었고 소스가 많이 정리되어 좀 더 수월하게 진행하였습니다. 또한, 쿼리 부분이 분리됨으로써 깔끔함을 느꼈고 화면, 로직 제어, 데이터 부분이 명확하게 분리되면서 전체 시스템의 흐름의 파악도 쉬어졌습니다. 아직도 많이 부족하지만, 팀원들과 함께 노력을 많이 한 만큼 보람 있는 프로젝트였습니다. 앞으로도 좀 더 나은 프로그램을 위해 노력하는 사람이 되겠습니다.
