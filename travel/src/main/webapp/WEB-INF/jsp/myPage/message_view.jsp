<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="sendMsg" value="${sendMsg}" />
<div class="form-group row">
	<label class="col-sm-6" style="text-align: left; font-size: 1.5em;">
		보낸이: ${sendMsg.uId}</label> <label class="col-sm-6"
		style="text-align: right; font-size: 1.5em;">${sendMsg.mDate}</label>
</div>
<table>
	<tr>
		<td style="font-size: 1.5em;"><b style="color: #007bff;">제목</b>
			&nbsp; ${sendMsg.mSid}</td>
	</tr>
	<tr>
		<td style="font-size: 1.5em; color: #007bff;"><b>내용</b></td>
	</tr>
	<tr>
		<td style="padding-top: 10px; font-size: 1.2em;">
			${sendMsg.mContent}</td>
	</tr>
</table>
<br>
<br>
<br>
<form name="replyMsgForm" method="post" action="message_reply.do">
	<table style="width: 100%;">
		<tr>
			<td style="padding-top: 10px; font-size: 1.5em; color: #007bff;">
				<b>답장</b>
			</td>
		</tr>
		<tr>
			<td><input type="text" name="mSid" id="mSid" required="required"
				class="s_form s_form-input" placeholder="제목을 입력하세요"
				style="width: 50%; margin-top: 10px;" /> <input type="hidden"
				name="mNum" value="${sendMsg.mNum}"> <input type="hidden"
				name="bNum" value="${sendMsg.bNum}"></td>
		</tr>
		<tr>
			<td><textarea name="mContent" id="mContent" cols="20" rows="5"
					placeholder="내용을 입력하세요"
					style="margin-top: 20px; width: 90%; height: 200px;"></textarea> <input
				type="hidden" name="uId" id="uId" class="s_form s_form-input"
				value="${sendMsg.sId}" readonly /> <input type="hidden" name="sId"
				id="sId" class="s_form s_form-input" value="${sendMsg.uId}" readonly />
			</td>
		</tr>
	</table>
	<br> <br>
	<button type="submit" style="margin: auto; width: 13%;">답장</button>
</form>
