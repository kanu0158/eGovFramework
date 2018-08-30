<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<div id="content">
		<div id="user-login-layout">
		<h1>계정탈퇴</h1>
		<form id="removeForm">
		비밀번호 재입력: <input TYPE="password" name="password" id="password" /><br>
		<input id="removeFormBtn" type="button" value="전 송"/> 
		</form>
	</div>
	</div> <!-- content end -->
<script>
$('#removeFormBtn').click(function(){
	alert('user아디 : '+app.uI());
	$('#removeForm').append(
		$("<input type='text' value="+sessionStorage.getItem('userId')+" name='userId'>")
	);
	$('#removeForm').attr({
		action:app.x()+"/member/remove",
		method:"POST"
	})
	.submit();
});
</script>