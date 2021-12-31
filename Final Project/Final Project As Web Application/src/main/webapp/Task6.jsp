<%--
  Created by IntelliJ IDEA.
  User: Moham
  Date: 7/2/2021
  Time: 1:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.*" %>

<html>
<head>
    <title>Task 6</title>
</head>
<body>
<h2>Task 6: Find Out The Most Popular Job Titles.<br></h2>
<form action="TaskSelector" method="post">
    <input id="id" name="id" type="hidden" value="12">
    <input type="submit" value="Home">
</form>


<%
    Object val2 = request.getAttribute("Task6");
    String val = String.valueOf(val2);
%>


<%
    String fName = val;
    String thisLine;
    int count = 0;
    FileInputStream fis = new FileInputStream(fName);
    DataInputStream myInput = new DataInputStream(fis);

    int i = 0;
%>
<table>
    <%
        int counter = 0;
        while ((thisLine = myInput.readLine()) != null) {
            String strar[] = thisLine.split(",");
            for (int j = 0; j < strar.length; j++) {
                if (i != 0) {
                    String[] head = strar[j].split(",");
                    String show = "";
                    for (int m = 0; m < (head.length); m++) {
                        show = head[m] + ", ";
                    }
                    out.print("  " + show + " ");
                } else {
                    String[] head = strar[j].split(",");
                    String show = "";
                    for (int m = 0; m < (head.length); m++) {
                        show = head[m] + ", ";
                    }
                    out.print(" <b>" + show + "</b> ");
                }
            }
            out.print("<br>");
            i++;
        }
    %>
</table>
</body>
</html>
