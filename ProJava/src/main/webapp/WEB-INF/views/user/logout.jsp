<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <c:url var="root" value="/"/> --%>
<c:set var="root" value="${pageContext.request.contextPath }/"/>	<!-- contextPath 구하기. -->
<script>
	alert("로그아웃 되었습니다.")
	location.href = "${root}main"
</script>
