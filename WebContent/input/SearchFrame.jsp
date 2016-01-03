<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List, domain.Book" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book Management System</title>
</head>

<link rel="stylesheet" href="/book/input/Frame.css">
<link rel="stylesheet" href="/book/input/SearchResult.css">
<body>

<!-- ヘッダ -->
<jsp:include page="Header.html"/>

<!-- メインコンテンツ -->
<form action="/book/Search">
    <div id="contents">
        <div class="contents_inner">
            <article id="searchCondition">
                <jsp:include page="SearchCondition.html"/>
            </article>
            
            <div class="searchResult">
            <div class="zasshiResult">
            <%
            List<String> result = (List<String>)request.getAttribute("result");
            for(int i = 0; i < result.size(); ++i) {
                out.println(result.get(i));
              }
              %>
              <!-- 
            List<Book> list = (List<Book>)request.getAttribute("list");
            if(list.isEmpty()) {
              }
              else {
                for(int i = 0; i < list.size(); ++i) {
                Book book = list.get(i);
                   }
                 }
                 -->
                 </div>
            </div>
        </div>
    </div>
</form>
    
    <footer>
    </footer>
</body>
</html>

