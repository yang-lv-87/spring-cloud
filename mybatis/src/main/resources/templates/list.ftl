<#assign base=request.contextPath />
<!DOCTYPE html>
<html>
<body>
<h1>aaaaa</h1>
<table height="100" border="0" cellspacing="1" bgcolor="#000000">
	<tr bgcolor="#FFFFFF">
	<td>id</td>
	<td>url</td>
	<td>title</td>
	</tr>
	<#list list as item>
	<tr bgcolor="#FFFFFF">
	<td>${item.id}</td>
	<td>${item.url}</td>
	<td>${item.title}</td>
	</tr>
	</#list>
</table>
</body>
</html>