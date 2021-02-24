<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="content_wraps">
	<div id="user_div" style="text-align: center;">
		<h2>使用者資訊</h2>
		<table class="data_table">
			<thead>
				<tr>
					<th>指令</th>
					<th>員工編號</th>
					<th>姓名</th>
					<th>部門</th>
					<th>帳號啟用</th>
				</tr>
			</thead>
			<tbody>

				<tr>
					<td><a href='/bis/sysmgmt/usrmgmt/update?code=${users.code}'>修改</a></td>
					<td>${users.code}</td>
					<td>${users.name}</td>
					<td>${users.departments.code}&ensp;${users.departments.name}</td>
					<td><c:if test='${users.is_valid == "N"}'>否</c:if> <c:if
							test='${users.is_valid == "Y"}'>是</c:if></td>
				</tr>

			</tbody>
		</table>

		<h2>所屬群組列表</h2>
		<table class="data_table">
			<thead>
				<tr>
					<th>代碼</th>
					<th>名稱</th>
					<th style="width: 450px">說明</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users.groupsList}" var="groups">
					<tr class="${groups.id}">
						<td>${groups.sym}</td>
						<td>${groups.name}</td>
						<td>${groups.desc}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</div>