<#assign base=request.contextPath /> ///这里的request.contextPath ,request这个变量名必须与javaconfig中的setRequestContextAttribute设置的一样，才能取值；
<!DOCTYPE html>
<html>
<body>
<h1>aaaaa</h1>
<form method="post" action="save">
	url:<input type="text" name="url" /><br/>
	title:<input type="text" name="title" /><br/>
	<input type="submit" value="提交" />
</form>
</body>
</html>