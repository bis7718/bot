<%@page pageEncoding="UTF-8"%>
	
	<s:iterator value="#session.user.menusList" status="status">
		<s:if test='link != ""'>
			<a href='<s:property value="link"/>'><s:property value="name"/></a>|
		</s:if>
		<s:else>
			<s:property value="name"/>|
		</s:else>
	</s:iterator>