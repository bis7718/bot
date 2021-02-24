<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="edit_div">
	<form action="order_chang" method="post">
		<table class="edit_job_table">
			<caption>調整工作內容</caption>
			<tfoot>
				<tr>
					<td colspan="2"><input type="submit" value="送出"
						onclick="var reply = confirm('確定送出?')"></td>
				</tr>
			</tfoot>
			<tbody>
				<tr>
				    <td class="tdLabel">原執行工作:</td>
					<td><select id="origin">
							<c:forEach items="${jobsList}" var="jobs">
								<option value=""></option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td class="tdLabel">前一項工作:</td>
					<td><select id="previous">
							<c:forEach items="${jobsList}" var="jobs">
								<option value=""></option>
							</c:forEach>
					</select></td>
				</tr>
			</tbody>
		</table>
	</form>

</div>