<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div id="content_wraps">
	<div id="user_div" style="text-align: center;">
		<form action="/bis/aprvmgmt/fileupaprv/log" method="post">
			全選： <input id="submitall" type="checkbox" value="1"> <input
				name="commit" type="submit" value="刪除"> <br> <br>
			<table class="data_table">
				<thead>
					<tr>
						<th>勾選</th>
						<th>ID</th>
						<th>員工編號</th>
						<th>姓名</th>
						<th>部門</th>
						<th>刪除</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${usersList}" var="users">
						<tr class="${users.id}">
							<td><input id="${users.id}" type="checkbox" value="1"></td>
							<td>${users.id}</td>
							<td><a href='/bis/sysmgmt/usrmgmt/users?code=${users.code}'>${users.code} </a></td>
							<td>${users.name}</td>
							<td>${users.departments.code}&ensp;${users.departments.name}</td>
							<td>刪除</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>

	</div>
</div>