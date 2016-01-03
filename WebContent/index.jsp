<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList, java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book Management System</title>
</head>
<body>
    <%
        List<String> result = new ArrayList<String>();
        result.add("<h1>検索結果がここに表示されます。</h1>");
        request.setAttribute("result", result);
    %>
    <jsp:include page="input/SearchFrame.jsp"/>
</body>
</html>