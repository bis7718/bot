<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="content_wraps">
	<table class="data_table">
		<thead>
			<tr>
				<th>分行代碼</th>
				<th>分行名稱</th>
				<th>國內/海外</th>
				<th>刪除</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${deptList}" var="dept">
				<tr class="${dept.code}">
					<td>${dept.code}</td>
					<td><a href='/bis/deptmgmt/edit?id=${dept.id}'>${dept.name} </a></td>
					<td><c:if test='${dept.overseas_flag == "N"}'> 國內</c:if> <c:if
							test='${dept.overseas_flag == "Y"}'>國外</c:if></td>
					<td><a href='/bis/deptmgmt/delete?id=${dept.id}'
						onclick='return confirm("確定申請刪除分行${dept.name}");'> 刪除 </a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>