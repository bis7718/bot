<%@page pageEncoding="UTF-8"%>
<script src="/nova/dwr/interface/BatchManagementAction.js" type="text/javascript"></script>
<script src="/nova/js/batchexec.js" type="text/javascript"></script>

<div id="content_wraps">
	<div id="select_div">
		<form action="" method="post">
			年份：
			<select id="yyyySelect1" name="yyyySelect" onchange="refreshMm(1)"></select>
			月份：
			<select id="mmSelect1" name="mmSelect" onchange="refreshSessionId(1)"></select>
			版本：
			<select id="sessionIdSelect1" name="sessionIdSelect"></select>
			報表群組：
			<select id="report_type" name="report[type]" onchange="rpt_typ_select(this)">
				<option value="">全部</option>
				<option value="ca_report">主管機關報表</option>
				<option value="ma_report">管理性報表</option>
			</select>
			報表類別：
			<s:select list="reportCategoriesList"
						name="reportCategoriesList"
						headerKey=""
						headerValue="全部"
						listKey="id"
						listValue="name"
						onchange="rpt_cat_select(this)"
						id="report_category"/>
			<s:select list="caReportCategoriesList"
						name="caReportCategoriesList"
						headerKey=""
						headerValue="全部"
						listKey="id"
						listValue="name"
						onchange="rpt_cat_select(this)"
						cssStyle="visibility: hidden"
						id="report_category_ca"/>
			<s:select list="maReportCategoriesList"
						name="maReportCategoriesList"
						headerKey=""
						headerValue="全部"
						listKey="id"
						listValue="name"
						onchange="rpt_cat_select(this)"
						cssStyle="visibility: hidden"
						id="report_category_ma"/>
			
			<hr>
			<div id="report_div">
			<h2 class="rpt_type ca_report" style="display: block;">主管機關報表</h2>
			<hr style="border: 1px solid rgb(204, 204, 204); width: 80%; display: block;" class="rpt_type ca_report">
			
			<s:iterator var="allList" value="caReportsTableList">
				<s:set name="currentCatId" value=""/>
				
				<h3 class='ca_report cat_<s:property value="#allList[0].reportCategories.id"/>' style="display: block;">
					<s:property value="#allList[0].reportCategories.name"/>
				</h3>
				<table class='data_table ca_report cat_<s:property value="#allList[0].reportCategories.id"/>' style="display: table;">
					<thead>
					<tr>
						<th style="width: 5em">報表編號</th>
						<th>報表名稱</th>
						<th>功能選單</th>
						<th style="width: 11em">下載</th>
					</tr>
					</thead>
					<tbody>
					<s:iterator value="#allList" status="status">
						<s:set name="reportName" value="name"/>
						<s:if test="#status.even"><tr class="even_row"></s:if>
						<s:else><tr class=""></s:else>  
							<td><s:property value="name"/></td>
							<td class="textAlignLeft"><s:property value="description"/></td>
							<td>
								<s:if test='gen_mode=="ALLBRN"'>全行</s:if>
								<s:elseif test='gen_mode=="BRN"'>
									<s:select list="departmentsList"
										name="departmentsList"
										theme="simple"
										listKey="code"
										listValue="code + ' ' + name"
										id="%{#reportName + '_BRN'}"/>
								</s:elseif> 
								<s:elseif test='gen_mode=="CCY"'>
									<s:select list="currenciesList"
										name="currenciesList"
										theme="simple"
										listKey="code"
										listValue="code + ' ' + name"
										id="%{#reportName + '_CCY'}"/>
								</s:elseif> 
							</td>
							<td>
								<a href="/nova/rptview/download.action?docType=pdf" target="_blank" onclick="dl_report('<s:property value="name"/>','<s:property value="gen_mode"/>',this)">PDF</a>
								<a href="/nova/rptview/download.action?docType=csv" target="_blank" onclick="dl_report('<s:property value="name"/>','<s:property value="gen_mode"/>',this)">CSV</a>
								<a href="/nova/rptview/download.action?docType=doc" target="_blank" onclick="dl_report('<s:property value="name"/>','<s:property value="gen_mode"/>',this)">報表邏輯說明-doc</a>
								<a href="/nova/rptview/download.action?docType=odt" target="_blank" onclick="dl_report('<s:property value="name"/>','<s:property value="gen_mode"/>',this)">報表邏輯說明-odt</a>
							</td>
						</tr>
					</s:iterator>
					</tbody>
				</table>
			</s:iterator>
			
			<h2 class="rpt_type ma_report" style="display: block;">管理性報表</h2>
			<hr style="border: 1px solid rgb(204, 204, 204); width: 80%; display: block;" class="rpt_type ma_report">
			<s:iterator var="allList" value="maReportsTableList">
				<s:set name="currentCatId" value=""/>
				
				<h3 class='ma_report cat_<s:property value="#allList[0].reportCategories.id"/>' style="display: block;">
					<s:property value="#allList[0].reportCategories.name"/>
				</h3>
				<table class='data_table ma_report cat_<s:property value="#allList[0].reportCategories.id"/>' style="display: table;">
					<thead>
					<tr>
						<th style="width: 5em">報表編號</th>
						<th>報表名稱</th>
						<th>功能選單</th>
						<th style="width: 11em">下載</th>
					</tr>
					</thead>
					<tbody>
					<s:iterator value="#allList" status="status">
						<s:set name="reportName" value="name"/>
						<s:if test="#status.even"><tr class="even_row"></s:if>
						<s:else><tr class=""></s:else>  
							<td><s:property value="name"/></td>
							<td class="textAlignLeft"><s:property value="description"/></td>
							<td>
								<s:if test='gen_mode=="ALLBRN"'>全行</s:if>
								<s:elseif test='gen_mode=="BRN"'>
									<s:select list="departmentsList"
										name="departmentsList"
										theme="simple"
										listKey="code"
										listValue="code + ' ' + name"
										id="%{#reportName + '_BRN'}"/>
								</s:elseif> 
								<s:elseif test='gen_mode=="CCY"'>
									<s:select list="currenciesList"
										name="currenciesList"
										theme="simple"
										listKey="code"
										listValue="code + ' ' + name"
										id="%{#reportName + '_CCY'}"/>
								</s:elseif> 
							</td>
							<td>
								<a href="/nova/rptview/download.action?docType=pdf" target="_blank" onclick="dl_report('<s:property value="name"/>','<s:property value="gen_mode"/>',this)">PDF</a>
								<a href="/nova/rptview/download.action?docType=csv" target="_blank" onclick="dl_report('<s:property value="name"/>','<s:property value="gen_mode"/>',this)">CSV</a>
								<a href="/nova/rptview/download.action?docType=doc" target="_blank" onclick="dl_report('<s:property value="name"/>','<s:property value="gen_mode"/>',this)">報表邏輯說明-doc</a>
								<a href="/nova/rptview/download.action?docType=odt" target="_blank" onclick="dl_report('<s:property value="name"/>','<s:property value="gen_mode"/>',this)">報表邏輯說明-odt</a>
							</td>
						</tr>
					</s:iterator>
					</tbody>
				</table>
			</s:iterator>
			
		
		</form>
	</div>

	
</div>
