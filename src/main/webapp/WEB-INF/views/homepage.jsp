<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="com.example.expensetracker.model.Credit"%>
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
    .edit-delete-buttons {
        display: flex;
        justify-content: space-between;
    }
</style>
</head>
<body>
<div class="header">
    <h2>Budget Planning App</h2>
    <div class="user-info">
        <span>Username: ${username}</span>
        <a href="/logout">Logout</a>
    </div>
    <p>Balance: ${credit} | Budget: ${budget} | Expense: $XXXX</p>
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

<h2>Credit Details</h2>
<table border="1" class="transaction-history">
    <tr>
        <th>Date</th>
        <th>Amount</th>
        <th>Title</th>
        <th>Description</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${creditList}" var="credit1">
        <tr>
            <td>${credit1.getCredit_date()}</td>
            <td>${credit1.credit_amount}</td>
            <td>${credit1.credit_title}</td>
            <td>${credit1.credit_description}</td>
            <td class="edit-delete-buttons">
                <form action="editCredit" method="post">
                                          <!-- Pass the credit detail's date and title as parameters -->
                                          <input type="hidden" name="credit_date" value="${credit1.getCredit_date()}">
                                          <input type="hidden" name="credit_amount" value="${credit1.getCredit_amount()}">
                                          <button type="submit" name="submitAction" value="edit">Edit</button>
                              </form>
                <form action="deleteCredit" method="post">
                            <!-- Pass the credit detail's date and title as parameters -->
                            <input type="hidden" name="credit_date" value="${credit1.getCredit_date()}">
                            <input type="hidden" name="credit_amount" value="${credit1.getCredit_amount()}">
                            <button type="submit" name="submitAction" value="delete">Delete</button>
                </form>

            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
