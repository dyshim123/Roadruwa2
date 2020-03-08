<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../../assets/css/jquery.modal.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script>
<script>
function upFile(){
		frm = document.excelUploadForm;
		frm.action = "/excelUploadAjax.do";
		frm.submit();	
} 

</script>

<br><br><div align="center"><form name="excelUploadForm" id="excelUploadForm" enctype="multipart/form-data" method="post">
                                      첨부 파일<input type="file"  name="excelFile" id="excelFile" />
                     <input type="hidden" name="svcId" value="${param.svcId}" />
                     <!-- <button type="button" id="addExcelImpoartBtn" class="btn" onclick="check()" ><span>추가</span></button> -->
                  <input type="button" class="btn btn-primary" value="추가" onclick="upFile()" /> 
		
		</form></div>
<table class="table" style="display: inline-table; width:70%; margin-left:450px;">
		<thead>
			<tr>
				<th scope="col" style=" vertical-align: middle;">고객 아이디</th>
				<th scope="col" style=" vertical-align: middle;">고객 이름</th>
				<th scope="col" style=" vertical-align: middle;">고객 이메일</th>
				<th scope="col" style=" vertical-align: middle;">등록 날짜</th>
				<th scope="col" style=" vertical-align: middle;">수정 내역</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var ="list" items="${list}" >
			<tr style="background-color: #ffffff;">
				<td>${list.uId}</td>
				<td>${list.uName}</td>
				<td>${list.uEmail}</td>
				<td>${list.uReg}</td>
				<td><a href="/manager/userUpdate.do?uId=${list.uId}" rel="modal2:open">수정</a><a href="/manager/userdelete.do?uId=${list.uId}" style=" margin-left: 15px;">삭제</a></td>
			</tr>
			
			</c:forEach>
		</tbody>
	</table>
	
	<script src="../../../assets/js/jquery.modal.js"></script>
<%@ include file="footer.jsp" %>