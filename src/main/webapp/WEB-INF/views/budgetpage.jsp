<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enter Budget Details</title>
</head>
<body>
    <h2>Enter Budget Details</h2>
    <form action="submitBudget" method="post">

        <div>
            <label for="amount">Amount:</label>
            <input type="number" id="amount" name="amount" required />
        </div>
        <div>
            <label for="description">Description:</label>
            <textarea id="description" name="description"></textarea>
        </div>
        <div>
            <button type="submit">Submit</button>
        </div>
    </form>
</body>
</html>
