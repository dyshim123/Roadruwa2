# Roadruwa <여행 경로 가이드북>
[![License](http://img.shields.io/:license-apache-brightgreen.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

#### 회원가입을 해야만 게시글을 볼 수 있기 때문에 이미 가입 시켜 놓은 ID로 접속 후 보실 수 있습니다 
#### (ID: cyshim / PW: cyshim) http://dadang.skycows.pe.kr/

프로젝트 소개
--------
이 프로젝트는 계획을 짤 시간이 없거나, 많고 다양한 여행정보에 어려움을 느끼는 사람들을 위한 여행 경로 공유 홈페이지입니다. Spring Framework를 접하게 되면서 순수 자바로만 코딩한 졸업작품 홈페이지의 문제점이 많이 보였습니다. 첫째로 같은 코드 반복으로 재사용성이 떨어졌고 둘째로 후에 수정할 때 전부 수정이 필요해 불편함이 있어 리펙토링의 필요성을 느꼈습니다. 이로 인해 기존에 다뤘던 주제로 기술적인 면을 업그레이드하고 싶어 동일한 주제를 선정하였습니다.

기술
--------
SpringFramework, Mariadb, mybatis, jquery, HTML5, CSS

프로젝트 설계 및 계획
----------
- 팀장 심다영 /  팀원 2명 (총 3명)
- 팀장: 데이터베이스 구축과 주요 기능 구현, 전체 구성원의 R&R을 정의, 과제 진척을 관리
- 다른 팀원: 각자 화면 구성 및 기능 개발을 담당
- 주요 기능 테스트 및 품질 검토: 팀장, 강사님

주요 기능 설명
------
기존 졸업작품의 기능에 좀 더 추가하였습니다!<br>

- 회원가입 (추가: 이메일 인증, 아이디 중복 체크)<br>

<img src="https://user-images.githubusercontent.com/59246146/73720658-d17b2900-4765-11ea-946e-ef3df9e1ccea.png" width="180px">&nbsp;&nbsp;
<img src="https://user-images.githubusercontent.com/59246146/73722618-3f295400-476a-11ea-98c0-2b123d33e7e2.png" width="300px" height="350px">&nbsp;
<img src="https://user-images.githubusercontent.com/59246146/73722899-f7ef9300-476a-11ea-8873-d4079387b85b.png" width="350px" height="50px">&nbsp;

> 계정이 없을 시 회원가입을 통해 계정을 만들 수 있습니다.<br>
> 아이디 중복확인을 해야만 회원가입 버튼이 활성화됩니다.<br>
> 이메일 인증을 한 후 회원가입이 완료됩니다.<br>
> 회원가입시 500포인트가 주어집니다.
 
 - 인기코스(추가: 디자인)<br>
 
 <img src="https://user-images.githubusercontent.com/59246146/73816268-92171000-482b-11ea-9723-1174877c3918.png" width="400px">&nbsp;
 <img src="https://user-images.githubusercontent.com/59246146/73816273-94796a00-482b-11ea-8a00-5749f55b0356.png" width="400px">
 
> (경로: 메인화면 -> 인기코스의 `더 보기` 클릭)<br>
> 별점 순으로 가장 인기 있는 게시글 TOP3를 볼 수 있습니다.<br>
> 하단에 별점 순으로 게시글 10개를 볼 수 있습니다.<br>
> 게시글을 나타내는 각 모달 상단 위에 지역을 나타내 수월하게 원하는 지역을 찾을 수 있습니다.
 
 
 - 검색<br>
 
 <img src="https://user-images.githubusercontent.com/59246146/73750348-5b47e800-47a0-11ea-9842-ebcc81898456.png" width="400px">&nbsp;
 <img src="https://user-images.githubusercontent.com/59246146/73751497-964b1b00-47a2-11ea-9693-1aa12ffcd789.png" width="400px">
 
> 검색창을 통해 원하는 키워드로 검색할 수 있습니다.<br>
> 관리자의 승인처리가 되지 않은 게시물은 볼 수 없습니다.
 
 
 <img src="https://user-images.githubusercontent.com/59246146/73751770-18d3da80-47a3-11ea-8c69-d50f87551e26.png" width="300px">
 
> 지역, 여행일수, 교통, 경비, 테마 별로 검색을 할 수 있습니다.<br>
> 사용자가 원하는 정보를 좀 더 자세하게 검색할 수 있습니다.<br>
> 관리자의 승인처리가 되지 않은 게시물은 볼 수 없습니다.
 
 
 - 게시글 작성<br>
 (경로: 로그인 후 -> 마이페이지 -> 글쓰기)<br>
 
 
 <img src="https://user-images.githubusercontent.com/59246146/73812677-06988180-4821-11ea-9ce1-2d9657f4327f.png" width="300px">
 
> 작성할 경로의 제목, 여행을 대표할 사진 3개를 입력해 여행지의 핵심을 알 수 있습니다.<br>
> Selectbox를 사용한 카테고리 선택, 지역, 교통을 입력할 수 있습니다.
 
 <img src="https://user-images.githubusercontent.com/59246146/73812918-cede0980-4821-11ea-8a80-6bb7a841a2d4.png" width="400px">&nbsp;
 <img src="https://user-images.githubusercontent.com/59246146/73812848-98a08a00-4821-11ea-96d4-cd289f7476a5.png" width="400px">
 
 > 작성할 여행 경로의 일수에 따라 게시글 양식이 동적으로 생성됩니다.<br>
 > 여행 일수별로 여행비, 식비, 교통비, 숙박비를 입력할 수 있습니다.<br>
 > 여행 일수별로 Summernote라는 에디터를 사용하여 유연성 있는 게시글을 작성할 수 있습니다.<br>
 > 여행 일수별로 가장 추천하는 여행지의 주소를 입력하여 주소의 지도로 볼 수 있습니다.
 
 
 - 게시글(추가: 결제페이지)<br>
 
 <구매 전><br>
 
 <img src="https://user-images.githubusercontent.com/59246146/73814881-a6f1a480-4827-11ea-86bc-0c09d9151933.png" width="400px">&nbsp;&nbsp;
 <img src="https://user-images.githubusercontent.com/59246146/73814892-ad801c00-4827-11ea-8d2e-36934540c955.png" width="300px">&nbsp;
 
> 게시글을 구매해야만 글을 볼 수 있습니다.<br>
> 게시글을 구매하지 않았을 경우 모달을 통해 경로의 간단한 정보를 확인 후 구매 여부를 결정할 수 있습니다.
 
 
 <img src="https://user-images.githubusercontent.com/59246146/73815126-54fd4e80-4828-11ea-977e-c875271d4c7c.png" width="500px">&nbsp;
 
> 게시글의 구매 버튼을 누르면 구매페이지를 넘어갑니다.<br>
> 게시글의 가격과 사용자의 현재 포인트, 결제 후 포인트를 알 수 있습니다.<br>
> 구매 후엔 게시글의 상세내용을 보실 수 있습니다.

 
 <구매 후><br>
 
 <img src="https://user-images.githubusercontent.com/59246146/73814016-27fb6c80-4825-11ea-9066-872f3a1baf3f.png" width="500px">&nbsp;
 
 > 여행을 대표할 사진 3개와 카테고리, 제목, 작성자, 별점, 총비용 등 여행에 대한 기본정보를 알 수 있습니다.<br>
 
 
 <img src="https://user-images.githubusercontent.com/59246146/73814029-30ec3e00-4825-11ea-867b-e08ba45663ab.png" width="400px">&nbsp;
 <img src="https://user-images.githubusercontent.com/59246146/73814176-9d673d00-4825-11ea-9112-3679a9c03599.png" width="400px">
 
> ex) 1박 2일의 여행 게시글<br>
> 등록된 여행 일수별로 작성된 글을 볼 수 있습니다.<br>
> 처음에 1일 차로 초기화되어있으며 1 일차의 추천 여행지 주소, 지도, 종류별 비용, 게시글을 볼 수 있습니다.<br>
> 2 일차를 클릭하면 2 일차의 추천 여행지 주소, 지도, 종류별 비용, 게시글을 볼 수 있습니다.
 
 
 <img src="https://user-images.githubusercontent.com/59246146/73815664-fb961f00-4829-11ea-8f80-5ea78c9e59c9.png" width="400px" height="350px">&nbsp;
 <img src="https://user-images.githubusercontent.com/59246146/73815962-cccc7880-482a-11ea-87cd-0067ad001fc6.png" width="400px" height="350px">&nbsp;
 
 > 일수별 게시글을 볼 수 있습니다.<br>
 > 일수별로 게시글을 나누어 보기가 간편하고 자세하게 볼 수 있습니다.
 
  - 쪽지<br>
  
  <게시글 작성자와 사용자>
  
<img src="https://user-images.githubusercontent.com/59246146/73817097-7f053f80-482d-11ea-8a33-a8ee93664250.png" width="200px" height="250px">&nbsp;
<img src="https://user-images.githubusercontent.com/59246146/73816735-b6bfb780-482c-11ea-88ac-0fa7fba8453d.png" width="200px" height="250px">&nbsp;
<img src="https://user-images.githubusercontent.com/59246146/73816941-2a61c480-482d-11ea-9c9c-39a6119cbe21.png" width="400px" height="250px">&nbsp;


> 게시글에 대한 질문을 쪽지로 통해 게시글 작성자와 소통을 할 수 있습니다.<br>
> 쪽지를 작성 후 마이페이지에서 보낸 쪽지함을 통해 확인할 수 있습니다.

 
  <관리자와 사용자><br>
  (경로: 로그인 후 -> 마이페이지 -> 쪽지 -> 관리자한테 쪽지버튼)<br>


  <img src="https://user-images.githubusercontent.com/59246146/73817350-06eb4980-482e-11ea-8d4d-7be09ad28c6f.png" width="400px" height="250px">&nbsp;
<img src="https://user-images.githubusercontent.com/59246146/73817361-0e125780-482e-11ea-908d-9baa70e404aa.png" width="250px" height="250px">&nbsp;


> 홈페이지에 대한 질문을 쪽지를 통해 관리자와 소통할 수 있습니다.<br>
> 관리자에게 보낸 후 마이페이지에서 보낸 쪽지함을 통해 확인할 수 있습니다.
 
 - 댓글<br>
 
 <img src="https://user-images.githubusercontent.com/59246146/74009212-1b624a00-49c6-11ea-89b3-5bae0aea64a3.png" width="400px" height="250px">&nbsp;
<img src="https://user-images.githubusercontent.com/59246146/74009110-dc33f900-49c5-11ea-99c3-3ffefe368757.png" width="400px" height="250px">&nbsp;

> 구매한 게시글의 후기와 질문을 댓글로 작성할 수 있습니다.<br>
> (자신의 글만 수정/삭제 할 수 있습니다.)<br>
> 댓글의 내용, 첨부 파일, 별점을 줄 수 있습니다.<br>
> 게시글의 작성자는 자신의 글에 댓글을 달 수 없습니다.<br>
> ( 자신의 글에 댓글을 달아 글 가격 올림 방지)

 - 별점<br>
 
 <img src="https://user-images.githubusercontent.com/59246146/74009612-ef939400-49c6-11ea-8fe3-8de4f2496fcc.png" width="400px" height="250px">&nbsp;
<img src="https://user-images.githubusercontent.com/59246146/74010223-51a0c900-49c8-11ea-81c0-c01c1027d441.png" width="400px" height="250px">&nbsp;

> 댓글 작성에서 별점을 줄 수 있습니다.<br>
> 별점은 1점부터 5점까지 줄 수 있습니다.


<img src="https://user-images.githubusercontent.com/59246146/74009660-0afe9f00-49c7-11ea-871e-27576573e7e8.png" width="200px" height="150px">&nbsp;&nbsp;&nbsp;
<img src="https://user-images.githubusercontent.com/59246146/74009560-ce32a800-49c6-11ea-8bc0-d0c081b660fb.png" width="400px" height="300px">&nbsp;

> 글의 가격은 별점으로 측정됩니다.<br>
> 글의 총 별점이 50개당 100원씩 증가합니다.<br>
> 예를 들어 글의 총 별점이 50개 미만 0원, 50개는 100원, 100개는 200원으로 측정됩니다.<br>
> 사용자들이 직접 읽고 별점으로 글의 가격을 매김으로써 글 가격이 합리적입니다.


- 포인트(추가: 카카오페이) <br>
(경로: 로그인 후 -> 마이페이지 -> 포인트 ->충전하기 버튼)<br>

<img src="https://user-images.githubusercontent.com/59246146/74011430-2c618a00-49cb-11ea-9a70-48d04a18c8d2.png" width="350px" height="250px">&nbsp;
<img src="https://user-images.githubusercontent.com/59246146/74011435-2d92b700-49cb-11ea-94af-bd0f5eb9b423.png" width="200px" height="250px">&nbsp;
<img src="https://user-images.githubusercontent.com/59246146/74011444-32576b00-49cb-11ea-8320-5ce0452ef3d5.png" width="270px" height="250px">&nbsp;

> 회원가입시 500포인트를 받을 수 있습니다.<br>
> TextBox를 통해 금액을 입력할 수 있습니다.<br>
> 카카오페이로 금액을 결제할 수 있습니다.

- 관리자(추가: 차트) <br>
(관리자ID : 관리자 / pw: 1234)<br>


<img src="https://user-images.githubusercontent.com/59246146/74011959-7434e100-49cc-11ea-96bf-5e867f913435.png" width="250px" height="300px">&nbsp;&nbsp;&nbsp;
<img src="https://user-images.githubusercontent.com/59246146/74012238-194fb980-49cd-11ea-946d-036d3b0fcfc2.png" width="250px" height="300px">&nbsp;&nbsp;&nbsp;
<img src="https://user-images.githubusercontent.com/59246146/74011965-76973b00-49cc-11ea-982d-630cdaa02f3d.png" width="250px" height="300px">&nbsp;

> 관리자는 카테고리별 글 등록 수를 차트로 볼 수 있습니다.<br>
> 관리자는 월별로 카테고리 글 등록 수를 차트로 볼 수 있습니다.<br>
> 관리자는 지역별 글 등록 수를 차트로 볼 수 있습니다.

<img src="https://user-images.githubusercontent.com/59246146/74012400-83685e80-49cd-11ea-8bff-5b01649c3898.png" width="600px" height="250px">&nbsp;

> 관리자는 사용자가 글 등록을 한 후 게시글을 검토하여 승인/미승인 처리를 할 수 있습니다.<br>
> 관리자가 미승인 시 게시글을 사용자들이 볼 수 없습니다.


마치며
------
처음엔 spring framework에 대해 아는 것이 없어 막막하고 어려움이 많았습니다. 하지만 프로젝트를 끝낸 이 시점엔 기본적인 spring framework에 대한 이해와 활용 역량이 향상되었습니다. 또한, 팀장으로서 팀원들의 R&R 관리와 일정/진척관리의 중요성을 이해하는 계기가 되었습니다. 기존 순수 자바로 진행한 졸업작품의 프로젝트에 비해 중복 코드가 많이 해소되었고 소스가 많이 정리되어 좀 더 수월하게 진행하였습니다. 또한, 쿼리 부분이 분리됨으로써 깔끔함을 느꼈고 화면, 로직 제어, 데이터 부분이 명확하게 분리되면서 전체 시스템의 흐름의 파악도 쉬어졌습니다. 아직도 많이 부족하지만, 팀원들과 함께 노력을 많이 한 만큼 보람 있는 프로젝트였습니다. 앞으로도 좀 더 나은 프로그램을 위해 노력하는 사람이 되겠습니다.
