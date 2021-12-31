<%--
  Created by IntelliJ IDEA.
  User: Moham
  Date: 7/2/2021
  Time: 1:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tasks</title>
</head>
<body>
<h3>Choose Task: </h3>

<h3> Task 1: Read Wuzzuf Dataset And Convert It to DataFrame And Display It. </h3>
<h3> Task 2: Display Structure And Summary Of The Data. </h3>
<h3> Task 3: Clean The Data From Null Values And Duplications. </h3>
<h3> Task 4: Count The Jobs For Each Company And Display In Order. </h3>
<h3> Task 5: Visualize The Count Of Jobs For Each Company In Pie Chart. </h3>
<h3> Task 6: Find Out The Most Popular Job Titles. </h3>
<h3> Task 7: Visualize The Most Popular Job Titles In Bar Chart. </h3>
<h3> Task 8: Find out the most popular areas. </h3>
<h3> Task 9: Visualize The Most Popular Areas In Bar Chart. </h3>
<h3> Task 10: Print Skills One By One And How Many Each Repeated. </h3>
<h3> Task 11: Factorize The YearsExp Feature And Convert It To Numbers In New Column. </h3>


<form action="TaskSelector" method="post">
    <label>Task Number: </label>
    <!-- <input type="text" name="name"> -->
    <input type="number" id="id" name="id" min="1" max="11"><br>
    <input type="submit" value="send">
</form>



</body>
</html>
