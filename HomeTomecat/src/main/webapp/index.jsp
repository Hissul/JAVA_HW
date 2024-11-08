
<!DOCTYPE html>
<html>

	<head>
		<style><%@ include file="/WEB-INF/styles.css" %></style>
		<meta charset="UTF-8">
		<title>Tomecat Homework</title>
	</head>
	
	<body>
		<h2>Tomecat Homework</h2>
		
		<div class='wrapper'>
			<form class='form' action='spending' method='post'>
				<div class='inputDiv'>
					<label for='purpose'>Reasons for spending?</label>
					<input type='text' id='purpose' name='purpose' required>
				</div>
					
				<div class='inputDiv'>
					<label for='amount'>How much</label>
					<input type='text' id='amount' name='amount' required>
				</div>
				
				<div class='formSubmit'>
					<input type='submit' value='Save'>
				</div>
			</form>
		</div>
		
		<div class='wrapper'>
			<form class='form' action='spending' method='get'>
				<div class='formSubmit'>
					<input type='submit' value='Get all spendings'>
				</div>
			</form>
		</div>
	</body>
	
</html>
