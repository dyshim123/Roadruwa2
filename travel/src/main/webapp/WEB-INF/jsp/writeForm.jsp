<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="../../assets/css/summernote.css">
<link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css">
<link rel="stylesheet" href="../../assets/css/main.css" />
<link rel="stylesheet" href="../../assets/css/writeForm.css" />
<link rel="stylesheet" href="../../assets/css/circleimage.css" /> 
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.4.2/css/all.css">
<link rel="stylesheet" 
  href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
  <style>
#clr {
	background-color: #DDEAF3;
	margin-bottom: 0.8rem;
}

#le {
	padding-right: 20px;
}

#fon {
	/* style="font-size: 5rem; margin-left: 90px; color: #6c757d;" */
	font-size: 5rem;
	color: #6c757d;
}

#fon2 {
	text-align: center;
	padding-top: 10px;
}

#for {
	margin-left: 670px;
}

#a {
	padding: 8px;
}
</style>

</head>
<%@ include file="header.jsp"%>
<body>
	<!-- head -->
	<div class="jumbotron btm jumbotron-fluid" id="clr">
		<table style="margin: auto;">
			<tr>
				<td id="a"><img src="../../images/plane1.png"
					style="width: 80px; vertical-align: -1px;"></td>
				<td id="a"><h4 id="fon">나만의 여행코스</h4></td>
				<td id="a"><img src="../../images/plane1.png"
					style="width: 80px; vertical-align: -1px;"></td>
			</tr>
		</table>
		<br>
	</div>
	<!-- head -->
	<br><br>
<script>
    function sendFile(file, el) {
      var form_data = new FormData();
      form_data.append('file', file);
      $.ajax({
        data: form_data,
        type: "POST",
        url: '/Upload.do',
        cache: false,
        contentType: false,
        enctype: 'multipart/form-data',
        processData: false,
        success: function(url) {
           $(el).summernote('editor.insertImage', url);
          $('#imageBoard > ul').append('<li><img src="'+url+'" width="480" height="auto"/></li>'); 
       
        }
      });
    }
</script>

	<div class="container">
		<form method="post" action="contentForm.do" name="writeform" enctype="multipart/form-data">
			<br>
			<div class="form-group row">
				<label for="bTitle" class="col-sm-1 col-form-label"
					style="padding-top: 1.1rem;">제목</label>
				<div class="col-sm-8">
					<input type="text" style="width: 70%" name="bTitle" id="bTitle" required="required">
				</div>
			</div>
			<br>
			<br>
			<h3>*여행의 핵심의 사진 세장을 등록해주세요.*</h3>
			<br>
			<div class="form-group row">
				<div class="col-sm-3">
					<div id="profile-upload">
						<div class="hvr-profile-img">
							<input type="file" class="upload w180" name="bPic1" id="bPic1"
								title="Dimensions 180 X 180" 
								onchange="loadFile(event)">
						</div>
					</div>
				</div>
				<div class="col-sm-3">
					<div id="profile-upload2">
						<div class="hvr-profile-img">
							<input type="file" class="upload w180"  name="bPic2" id="bPic2"
								title="Dimensions 180 X 180"
								onchange="loadFile2(event)">
						</div>
					</div>
				</div>
				<div class="col-sm-3">
					<div id="profile-upload3">
						<div class="hvr-profile-img">
							<input type="file" class="upload w180"  name="bPic3" id="bPic3"
								title="Dimensions 180 X 180"
								onchange="loadFile3(event)">
						</div>
					</div>
				</div>
			<script>
					var loadFile = function(event) {
						var reader = new FileReader();
						reader.onload = function() {
							var output = document.getElementById('bPic1');
							output.src = reader.result;
							document.getElementById('profile-upload').style.backgroundImage = "url("
									+ reader.result + ")";
						};
						reader.readAsDataURL(event.target.files[0]);
					};

					var loadFile2 = function(event) {
						var reader = new FileReader();
						reader.onload = function() {
							var output = document.getElementById('bPic2');
							output.src = reader.result;
							document.getElementById('profile-upload2').style.backgroundImage = "url("
									+ reader.result + ")";
						};
						reader.readAsDataURL(event.target.files[0]);
					};

					var loadFile3 = function(event) {
						var reader = new FileReader();
						reader.onload = function() {
							var output = document.getElementById('bPic3');
							output.src = reader.result;
							document.getElementById('profile-upload3').style.backgroundImage = "url("
									+ reader.result + ")";
						};
						reader.readAsDataURL(event.target.files[0]);
					};
				</script>
			</div>
			<br>
			<br>
			<div class="form-group row">
				<label for="b_cate" class="col-sm-2 col-form-label"
					style="padding-top: 1.1rem;">카테고리</label>
				<div class="col-sm-2">
					<select name="bCate">
						<option value="먹방">먹방</option>
						<option value="관광지">관광지</option>
						<option value="문화재/역사">문화재/역사</option>
						<option value="호캉스">호캉스</option>
						<option value="액티비티">액티비티</option>
						<option value="기타">기타</option>
					</select>
				</div>
			</div>
			<br>

			<div class="form-group row">
				<label for="b_lo" class="col-sm-2 col-form-label">지역</label>
				<div class="w_col-sm-2">
					<div class="form-check">
						<label class="d_container" for="se"> <input
							type="checkbox" name="bLo" id="se" class="aa" value="서울">서울
							<span class="d_checkmark"></span>
						</label>
					</div>
					<div class="form-check">
						<label class="d_container" for="gg"> <input
							type="checkbox" name="bLo" id="gg" value="경기/인천">경기/인천 <span
							class="d_checkmark"></span>
						</label>
					</div>
					<div class="form-check">
						<label class="d_container" for="gw"> <input
							type="checkbox" name="bLo" id="gw" value="강원">강원 <span
							class="d_checkmark"></span>
						</label>
					</div>
					<div class="form-check">
						<label class="d_container" for="ch"> <input
							type="checkbox" name="bLo" id="ch" value="충청">충청 <span
							class="d_checkmark"></span>
						</label>
					</div>
					<div class="form-check">
						<label class="d_container" for="jr"> <input
							type="checkbox" name="bLo" id="jr" value="전라">전라 <span
							class="d_checkmark"></span>
						</label>
					</div>
					<div class="form-check">
						<label class="d_container" for="gs"> <input
							type="checkbox" name="bLo" id="gs" value="경상">경상 <span
							class="d_checkmark"></span>
						</label>
					</div>
					<div class="form-check">
						<label class="d_container" for="bs"> <input
							type="checkbox" name="bLo" id="bs" value="부산">부산 <span
							class="d_checkmark"></span>
						</label>
					</div>
					<div class="form-check">
						<label class="d_container" for="jj"> <input
							type="checkbox" name="bLo" id="jj" value="제주">제주 <span
							class="d_checkmark"></span>
						</label>
					</div>
				</div>
			</div>
			<br>
			<script>
				function toggle(box, d1, d2) {
					if (document.getElementById) {
						var d1 = document.getElementById(d1);
						var d2 = document.getElementById(d2);
						if (box.checked) {
							d1.value = "0";
							d2.value = "1";

						} else {
							d1.value = "";
							d2.value = "";
						}
					}
				}
			</script>
			<div class="form-group row">
				<label for="b_tr" class="col-sm-2 col-form-label"
					style="padding-top: 1.1rem;">교통</label>
				<div class="col-sm-2">
					<select name="bTr">
						<option value="자동차">자동차</option>
						<option value="대중교통">대중교통</option>
						<option value="기타">기타</option>
					</select>
				</div>
			</div>
			<br>
			<br>
			<h4>*확인버튼을 누르면 숫자대로 밑에 페이지가 생성됩니다*</h4>
			<br>
			<div class="form-group row">
				<label for="b_day" class="col-sm-2 col-form-label"
					style="padding-top: 1.1rem;">여행 일 수</label>
				<div class="col-sm-1">
					<input type="text" size="50" maxlength="50" name="bDay1"
						id="b_day1" required="required">
				</div>
				<div class="pp">박</div>
				<div class="col-sm-1">
					<input type="text" size="50" maxlength="50" name="bDay2"
						id="b_day2" required="required">
				</div>
				<div class="col-sm-1">
					<div class="pp">일</div>
				</div>
				<div class="col-sm-2" style="padding-top: 0.6rem;">
					<div class="form-check">
						<label class="d_container" for="one"> <input
							type="checkbox" name="bOne" id="one" value="당일"
							onclick="toggle(this,'b_day1','b_day2')">당일치기 <span
							class="d_checkmark"></span>
						</label>
					</div>
				</div>
				<div class="col-sm-1">
					<input type="button" value="확인" id="aa1" />
				</div>
			</div>
			<br> <br>

			<!-- 동적 -->
			<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
			<script>
				// 우편번호 찾기 찾기 화면을 넣을 element
				var element_wrap = document.getElementById('wrap');

				function foldDaumPostcode() {
					// iframe을 넣은 element를 안보이게 한다.
					element_wrap.style.display = 'none';
				}

				function sample3_execDaumPostcode(idx) {
					// 현재 scroll 위치를 저장해놓는다.
					element_wrap = document.getElementById('wrap_' + idx);
					var currentScroll = Math.max(document.body.scrollTop,
							document.documentElement.scrollTop);

					new daum.Postcode(
							{
								oncomplete : function(data) {
									// 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

									// 각 주소의 노출 규칙에 따라 주소를 조합한다.
									// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
									var fullAddr = data.address; // 최종 주소 변수
									var extraAddr = ''; // 조합형 주소 변수

									// 기본 주소가 도로명 타입일때 조합한다.
									if (data.addressType === 'R') {
										//법정동명이 있을 경우 추가한다.
										if (data.bname !== '') {
											extraAddr += data.bname;
										}
										// 건물명이 있을 경우 추가한다.
										if (data.buildingName !== '') {
											extraAddr += (extraAddr !== '' ? ', '
													+ data.buildingName
													: data.buildingName);
										}
										// 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
										fullAddr += (extraAddr !== '' ? ' ('
												+ extraAddr + ')' : '');
									}

									// 우편번호와 주소 정보를 해당 필드에 넣는다.
									document.getElementById('sample3_postcode_'
											+ idx).value = data.zonecode; //5자리 새우편번호 사용
									document.getElementById('sample3_address_'
											+ idx).value = fullAddr;

									// iframe을 넣은 element를 안보이게 한다.
									// (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
									element_wrap.style.display = 'none';

									// 우편번호 찾기 화면이 보이기 이전으로 scroll 위치를 되돌린다.
									document.body.scrollTop = currentScroll;
								},
								// 우편번호 찾기 화면 크기가 조정되었을때 실행할 코드를 작성하는 부분. iframe을 넣은 element의 높이값을 조정한다.
								onresize : function(size) {
									element_wrap.style.height = size.height
											+ 'px';
								},
								width : '100%',
								height : '100%'
							}).embed(element_wrap);

					// iframe을 넣은 element를 보이게 한다.
					element_wrap.style.display = 'block';
				}
			</script>
			<script type="text/javascript">
		var divId = 1;
		
         $(document).ready(function() {      
            $("#aa1").click(function() {
               var count = document.all.b_day2.value;
               if (!isNaN(count)){   //숫자입력시
                  document.getElementById("rr").innerHTML = "";      //개체 생성 시 누적X
                  for (i = 0; i < count; i++) {
                	 var appendDiv =  $("#tmplt1").html();  
                	 
                	 appendDiv = appendDiv.replace(/{{idx}}/gi, divId+"");
                     $("#rr").append(appendDiv);

             		 $('#cont_'+divId).summernote({
        				height : 300,
        				minHeight : null,
        				maxHeight : null,
        				focus : true,
        				callbacks : {
        					onImageUpload : function(files, editor, welEditable) {
        						for (var i = files.length - 1; i >= 0; i--) {
        							//alert('upload image!!' + i);
        							sendFile(files[i], this);
        						}
        					}
        				}
        			 });
             		 divId++;
                  }
               }
            });
         });   
         </script>

			<div id="rr"></div> 
			<br>
        <script>
 		$(document).ready(function() {
			$("#sub").click(function() {
				document.writeform.action="contentForm.do";
			});
		}); 
 		/* function callFunction() {
			document.writeform.action="myPage.do";
		}); */
		
 	 	$(document).ready(function() {
			$("#dell").click(function() {
				location.href = 'myPage.do';
			});
		}); 
		
		</script>
		<div class="form-group row" style="margin-left: 200px;">
		<div class="col-sm-3">
			<div class="but" style="text-align: center;">
				<button id="sub" class="btn btn-ff btn-block" style="width: 50%; float: right;    height: 47px;">등록</button></div>	</div>
		<div class="col-sm-3"><a id="dell" class="button alt">취소</a></div>
		
			</div>
		</form>
		<br>
		<div id="tmplt1" style="display: none">

			<h3>
				<span>[ {{idx}}박의 내용을 입력해주세요 ]</span>
			</h3>
			<br>
			<br>
			<div class="form-group row">
				<div class="col-sm-3" style="left: 5%;">
					<img src="images/trav.png" style="max-width: 30%;">
					<h3>
						<label for="bTrav" class="col-form-label">여행비</label>
					</h3>
				</div>
				<div class="col-sm-3" style="left: 5%;">
					<img src="images/food.png" style="max-width: 30%;">
					<h3>
						<label for="bFood" class="col-form-label">식비</label>
					</h3>
				</div>
				<div class="col-sm-3" style="left: 5%;">
					<img src="images/trans.png" style="max-width: 30%;">
					<h3>
						<label for="bTrans" class="col-form-label">교통비</label>
					</h3>
				</div>
				<div class="col-sm-3" style="left: 5%;">
					<img src="images/stay.png" style="max-width: 30%;">
					<h3>
						<label for="bStay" class="col-form-label">숙박비</label>
					</h3>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-3">
					<input type="text" size="10" maxlength="10" name="bTrav"
						 placeholder="여행비용을 입력하세요" style="width: 80%;">
				</div>
				<div class="col-sm-3">
					<input type="text" size="10" maxlength="10" name="bFood"
						 placeholder=" 식비를 입력하세요" style="width: 80%;">
				</div>
				<div class="col-sm-3">
					<input type="text" size="10" maxlength="10" name="bTrans"
						 placeholder=" 교통비를 입력하세요" style="width: 80%;">
				</div>
				<div class="col-sm-3">
					<input type="text" size="10" maxlength="10" name="bStay"
						placeholder=" 숙박비를 입력하세요" style="width: 80%;">
				</div>
			</div>
			<br>

			<div class='col-sm-12' style="margin-left: -15px;">
				<textarea rows='10' id='cont_{{idx}}' name="bCont"></textarea>
				<br>
				<br>
				<h3>*꼭 추천하는 여행지의 주소를 찍어주세요*</h3>
				<br> <input type='text' id='sample3_postcode_{{idx}}'
					placeholder='우편번호' style='width: 120px; display: inline;'>
				<input type='button' onclick='sample3_execDaumPostcode("{{idx}}")'
					value='우편번호 찾기' style='width: 150px; text-align: center;'><br>
				<div id='wrap_{{idx}}'
					style='display: none; border: 1px solid; width: 500px; height: 300px; margin: 5px 0; position: relative'>
					<img
						src='//t1.daumcdn.net/localimg/localimages/07/postcode/320/close.png'
						id='btnFoldWrap' alt='접기 버튼'
						style='cursor: pointer; position: absolute; right: 0px; top: -1px; z-index: 1'
						onclick='foldDaumPostcode()'>
				</div>
				<input type='text' name="bPost" id='sample3_address_{{idx}}'
					style="width: 50%;" class='d_form large' placeholder='주소'><br>
				<br>
			</div>
		</div>
	</div>
	<br>
	<br>
	<br>
	<br>

	<!-- Scripts -->
	<script src="../../assets/js/jquery.min.js"></script>
	<script src="../../assets/js/breakpoints.min.js"></script>
	<script src="../../assets/js/writeForm.js"></script>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
	<script
		src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
	<script src="//netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
	<script
		src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>
	<script src="../../assets/js/summernote.js"></script>

	<%@ include file="footer.jsp"%>