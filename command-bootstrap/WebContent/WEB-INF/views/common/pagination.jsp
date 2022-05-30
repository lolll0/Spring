<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<nav aria-label="Navigation">
	<ul class="pagination justify-content-center m-0">
		<li class="page-item"><a class="page-link"
			href="javascript:list_go(1);"> <i
				class="fas fa-angle-double-left"></i>
		</a>
		<li class="page-item"><a class="page-link" href=""> <i
				class="fas fa-angle-left"></i>
		</a></li>

		<c:forEach var="pageNum" begin="${pageMaker.startPage }"
			end="${pageMaker.endPage }">
			<li class="page-item ${cri.page == pageNum?'active':''}"><a
				class="page-link" href="javascript:list_go('${pageNum}');">${pageNum }</a>
			</li>

		</c:forEach>


		<li class="page-item"><a class="page-link" href=""> <i
				class="fas fa-angle-right"></i>
		</a></li>
		<li class="page-item"><a class="page-link" href=""> <i
				class="fas fa-angle-double-right"></i>
		</a></li>
	</ul>
</nav>



  
<form id="jobForm">	
	<input type='hidden' name="page" value="" />
	<input type='hidden' name="perPageNum" value=""/>
	<input type='hidden' name="searchType" value="" />
	<input type='hidden' name="keyword" value="" />
</form>