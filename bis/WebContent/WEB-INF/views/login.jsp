<%@page pageEncoding="UTF-8"%>

<form action="login/loginbypwd" id="signin_f" method="post" autocomplete="off">
<table style="width:99%" summary="login form">
  <thead>
    <tr class="trFont"><th colspan="2">使用者登入</th></tr>
  </thead>
  <tbody>
    <tr class="trFont">
		<td><label for="username">員工編號：</label></td>
		<td><input id="username" name="username" type="text"></td>
	</tr>
    <tr class="trFont">
		<td><label for="password">密　碼：</label></td>
		<td><input id="password" name="password" type="password" /></td>
	</tr>
    <tr>
		<td colspan="2" style="text-align: center">
			<input name="commit" type="submit" value="送出">
			<input type="reset" value="清除">
		</td>
	</tr>
  </tbody>
</table>
</form>
<div>message : ${message}</div>
