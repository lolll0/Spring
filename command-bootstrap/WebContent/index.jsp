<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- tomcat default url
	tomcat에서는 기본적으로 url을 설정하지 않아도 연결이 되는 페이지를 가지고 있다.
	1. index.html 2. index.htm 3. index.jsp
	여기서 우리는 index.jsp를 이용하여 location.href를 통해
	index.do로 연결하여 사용하고 있다.
 -->
<script>
	location.href="index.do";
</script>