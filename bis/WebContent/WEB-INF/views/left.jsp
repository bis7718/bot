<%@page pageEncoding="UTF-8"%>

<s:set name="mainSym" value=""/>

<s:iterator value="#session.user.currentFunctionsList" status="status">
	<s:set name="tmpSym" value='sym.substring(0,sym.indexOf("_")+2)'/>
	<s:if test="#tmpSym!=#mainSym">
		<s:set name="mainSym" value="sym"/>
		<h3><s:property value="name"/></h3>
	</s:if>
	<s:else>
		<ul>
			<s:if test="url.indexOf(#session.user.methodInvoke) > 0">
				[<s:property value="name"/>]
			</s:if>
			<s:else>
				<li><a href='<s:property value="url"/>'><s:property value="name"/></a></li>
			</s:else>
		</ul>
	</s:else>
</s:iterator>
