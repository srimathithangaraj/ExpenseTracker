<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Budget Planning App</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
    }

   .header {
           background-color: #f0f0f0;
           padding: 10px;
           text-align: center;
           position: relative;
       }
       .header .user-info {
           position: absolute;
           top: 10px;
           right: 10px;
       }
       .header .user-info a {
           text-decoration: none;
           color: #333;
           margin-left: 10px;
       }
    .transaction-options {
        display: flex;
        justify-content: center;
        margin-bottom: 20px;
    }
    .transaction-options form {
        margin-right: 10px; /* Add space between forms */
    }
    .transaction-options button {
        padding: 10px 20px;
        margin: 0 10px;
        font-size: 16px;
        cursor: pointer;
    }
    .transaction-history {
        margin: 0 auto;
        width: 80%;
        border-collapse: collapse;
    }
    .transaction-history th, .transaction-history td {
        border: 1px solid #ddd;
        padding: 8px;
        text-align: left;
    }
    .transaction-history th {
        background-color: #f2f2f2;
    }
</style>
</head>
<body>
<body>
<div class="header">
    <h2>Budget Planning App</h2>
    <div class="user-info">
        <span>Username: ${username}</span>
        <a href="/logout">Logout</a>
    </div>
    <p>Balance: $X | Budget: ${budget} | Expense: $XXXX</p>
</div>

<div class="transaction-options">
    <form action="budget" method="post">
        <button type="submit" name="submitAction" value="budget">Budget</button>
    </form>
    <form action="credit" method="post">
        <button type="submit" name="submitAction" value="credit">Credit</button>
    </form>
    <form action="debit" method="post">
        <button type="submit" name="submitAction" value="debit">Debit</button>
    </form>
</div>

<table class="transaction-history">
    <thead>
        <tr>
            <th>Type</th>
            <th>Date</th>
            <th>Title</th>
            <th>Amount</th>
            <th>Edit</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>Credit</td>
            <td>2024-04-30</td>
            <td>Salary</td>
            <td>$2500.00</td>
            <td>Edit</td>
        </tr>
        <tr>
            <td>Credit</td>
            <td>2024-04-29</td>
            <td>Bonus</td>
            <td>$1000.00</td>
            <td>Edit</td>
        </tr>
        <tr>
            <td>Debit</td>
            <td>2024-04-30</td>
            <td>Grocery</td>
            <td>-$50.00</td>
