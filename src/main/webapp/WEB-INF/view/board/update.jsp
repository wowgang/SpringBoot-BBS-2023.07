<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/head.jspf" %>
	<style>
	 	td,th { text-align: center; }
	</style>
</head>
<body>
	<%@ include file="../common/top.jspf" %>

   	<div class="container" style="margin-top: 80px;">
       	<div class="row">
       		<%@ include file="../common/aside.jspf" %>
       		
       		<!-- ==================== main ==================== -->
       		<div class="col-sm-9">
       			<h3><strong>게시글 수정</strong></h3>
       			<hr>
       			<div class="row">
       				<div class="col-1"></div>
       				<div class="col-10">
       					<form action="/sbbs/board/update" method="post" enctype="multipart/form-data">
       						<input type="hidden" name="bid" value="${board.bid}">
       						<table class="table table-borderless">
       							<tr>
			                        <td><label class="col-form-label">제목</label></td>
			                        <td colspan="2">
			                        	<input type="text" name="title" class="form-control" value="${board.title}">
			                        </td>
			                    </tr>
			                    <tr>
			                        <td><label class="col-form-label">내용</label></td>
			                        <td colspan="2">
			                        	<textarea class="form-control" rows="10" name="content" >${board.content}</textarea>
		                        	</td>
			                    </tr>
			                    <tr>
			                        <td rowspan="2" style="width:10%">
			                        	<label class="col-form-label">첨부 파일</label>
		                        	</td>
			                        <td style="width:8%"><label class="col-form-label">삭제</label></td>
			                        <td style="width:82%; text-align: left;">
			                       	<c:forEach var="file" items="${fileList}">
			                       		<input class="ms-2 mt-2" type="checkbox" name="delFile" value="${file}"> ${file}
			                       	</c:forEach>
			                       	</td>
			                    </tr>
			                    <tr>
			                    	<td><label class="col-form-label">추가</label></td>
			                        <td><input type="file" name="files" class="form-control" multiple ></td>
			                    </tr>
			                    <tr>
			                        <td colspan="3" style="text-align: center;">
			                            <input class="btn btn-primary" type="submit" value="제출">
			                            <input class="btn btn-secondary ms-1" type="reset" value="초기화">
			                            <input class="btn btn-secondary ms-1" type="button" onclick="history.back()" value="취소" />
			                        </td>
			                    </tr>
       						</table>
       					</form>
       				</div>
       				<div class="col-1"></div>
       			</div>
      		</div>
      		<!-- ==================== main ==================== -->
      	</div>
      </div>
      
      <%@ include file="../common/bottom.jspf" %>
</body>
</html>