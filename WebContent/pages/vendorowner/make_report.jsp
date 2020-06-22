<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Make report</title>
</head>
<body>
	<div>
		<form action="MakeReportController" method="get" id="download_form">
			<label for="start_date">Start date:</label>
			<input type="date" id="start_date" name="input_start_date"
					>
			<label for="end_date">End date:</label>
			<input type="date" id="end_date" name="input_end_date"
					>
			<button id="btn_compile" type="submit">Compile</button>
		</form>
		
	</div>
</body>
</html>