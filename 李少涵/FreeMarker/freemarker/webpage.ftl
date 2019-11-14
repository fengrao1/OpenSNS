<!DOCTYPE>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
<title>TestNG Report</title>
<style type="text/css">
table {margin-bottom:10px;border-collapse:collapse;empty-cells:show}th,td {border:1px solid #009;padding:.25em .5em}th {vertical-align:bottom}td {vertical-align:top}table a {font-weight:bold}.stripe td {background-color: #E6EBF9}.num {text-align:right}.passedodd td {background-color: #3F3}.passedeven td {background-color: #0A0}.skippedodd td {background-color: #DDD}.skippedeven td {background-color: #CCC}.failedodd td,.attn {background-color: #F33}.failedeven td,.stripe .attn {background-color: #D00}.stacktrace {white-space:pre;font-family:monospace}.totop {font-size:85%;text-align:center;border-bottom:2px solid #000}.invisible {display:none}
</style>
</head>
<body>
<table>
<tr>
	<th>Test</th>
	<th># Case</th>
	<th># Passed</th>
	<th># Failed</th>
	<th>Date</th>
	<th>Included Groups</th>
	<th>Excluded Groups</th>
</tr>
<tr>
	<th colspan="7">Default suite</th>
</tr>
<tr>
	<td>Default test</td>
	<td class="num">${casesize}</td>
	<td class="num">${passedcasesize}</td>
	<td class="num attn">${failedcasesize}</td>
	<td>${date}</td>
	<td></td>
	<td></td>
</tr>
</table>
<table id='summary'>
	<thead>
		<tr>
			<th>status</th>
			<th>Class</th>
			<th>Method</th>
			<th>Time (ms)</th>
		</tr>
	</thead>
	<!-- <tbody>
		<tr><th colspan="4">Default suite</th></tr>
	</tbody> -->
	<tbody id="t0">
		<#list resultList as result>
			<#if result.status==1>
				<tr bgcolor="blue">
					<td>success</td>
			<#else>
				<tr bgcolor="orange">
					<td>fail</td>
			</#if>
					<td>${result.testName}</td>
					<td>${result.className}</td>
					<td>${result.duration}</td>
				</tr>
		</#list>
	</tbody>
</table>





		<!-- <tr><th colspan="4">Default test &#8212; failed</th></tr>
			<tr class="failedeven">
				<td rowspan="1">com.edu.test.SkuListTest</td>
				<td><a href="#m0">TestSkuList1</a></td>
				<td rowspan="1">1568785166350</td>
				<td rowspan="1">1183</td>
			</tr>
		<tr><th colspan="4">Default test &#8212; passed</th></tr>
			<tr class="passedeven">
				<td rowspan="3">com.edu.test.SkuListTest</td>
				<td><a href="#m1">TestSkuList2</a></td>
				<td rowspan="1">1568785167542</td><td rowspan="1">104</td>
			</tr>
			<tr class="passedeven">
				<td><a href="#m2">TestSkuListById</a></td>
				<td rowspan="1">1568785167650</td>
				<td rowspan="1">97</td>
			</tr>
			<tr class="passedeven">
				<td><a href="#m3">TestSkuListByWrongIdType</a></td>
				<td rowspan="1">1568785167749</td>
				<td rowspan="1">90</td>
			</tr> -->

</body>
</html>
