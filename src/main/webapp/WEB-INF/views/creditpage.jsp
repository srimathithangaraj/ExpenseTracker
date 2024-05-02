<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Credit Page</title>
</head>
<body>
    <h2>Enter Credit Information</h2>
    <form action="submitcredit" method="post">
        <label for="date">Date:</label><br>
        <input type="date" id="credit_date" name="credit_date" required><br>

        <label for="amount">Amount:</label><br>
        <input type="number" id="credit_amount" name="credit_amount"  required><br>

        <label for="title">Title:</label><br>
        <input type="text" id="credit_title" name="credit_title" required><br>

        <label for="description">Description:</label><br>
        <textarea id="credit_description" name="credit_description" rows="4" cols="50" required></textarea><br><br>

        <input type="submit" value="Submit">
    </form>
</body>
</html>
