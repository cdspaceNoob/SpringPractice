<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--     <c:url var="root" value="/"/>	<!-- ContextPath를 포함하는 절대 경로 구하기. --> --%>
<c:set var="root" value="${pageContext.request.contextPath }/"/>	<!-- contextPath 구하기. -->
<!DOCTYPE html>
<html>
	<script>
		function checkUserIdExist(){
			let user_id = $("#user_id").val();
			console.log("로그나와라");
			if(user_id.length == 0){
				alert("아이디를 입력해주세요");
			}
			
			$.ajax({
				url: "${root}user/checkUserIdExist/" + user_id,
				type: "get",
				dataType: "text",
				success: function(result){
					if(result.trim() == "true"){
						alert("사용할 수 있는 아이디입니다.");
						$("#userIdExist").val("true");
						console.log("사용 가능.");
					}else{
						alert("이미 존재하는 아이디입니다.");
						$("#userIdExist").val("false");
					}
				}
			})
		}
		
		function resetUserIdExist(){
			console.log("수정되고 있음.");
			$("#userIdExist").val("false");
		}
	</script>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>미니 프로젝트</title>
		<!-- Bootstrap CDN -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
	</head>
	
	<body>
	<!-- import nav -->
	<c:import url="/WEB-INF/views/include/nav.jsp"/>
		<div class="container" style="margin-top:100px">
			<div class="row">
				<div class="col-sm-3"></div>
				<div class="col-sm-6">
					<div class="card shadow">
						<div class="card-body">
						<form:form action="${root }user/join_pro" method="post" modelAttribute="joinUserBean">
							<form:hidden path="userIdExist"/> 
								<div class="form-group">
									<form:label path="user_name">이름</form:label>
									<form:input path="user_name" class="form-control"/>
									<form:errors path="user_name" style="color:red"/>
								</div>
								<div class="form-group">
									<form:label path="user_id">아이디</form:label>
									<div class="input-group">
										<form:input path="user_id" class="form-control" onkeypress="resetUserIdExist()"/>
										<div class="input-group-append">
											<button type="button" class="btn btn-primary" onclick="checkUserIdExist()">중복확인</button>
										</div>
									</div>
									<form:errors path="user_id" style="color:red"/>
								</div>
								<div class="form-group">
									<form:label path="user_pw">비밀번호</form:label>
									<form:password path="user_pw" class="form-control"/>
									<form:errors path="user_pw" style="color:red"/>
								</div>
								<div class="form-group">
									<form:label path="user_pw2">비밀번호 확인</form:label>
									<form:password path="user_pw2" class="form-control"/>
									<form:errors path="user_pw2" style="color:red"/>
								</div>
								<div class="form-group">
									<div class="text-right">
										<form:button class="btn btn-primary">작성 완료</form:button>
									</div>
								</div>
							</form:form>
						</div>
					</div>
				</div>
				<div class="col-sm-3"></div>
			</div>
		</div>
		<!-- import footer -->
		<c:import url="/WEB-INF/views/include/footer.jsp"/>
	</body>
	
</html>








