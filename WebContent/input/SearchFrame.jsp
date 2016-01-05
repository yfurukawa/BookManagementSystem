<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@page import="java.util.List, domain.Book"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1/jquery-ui.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1/i18n/jquery.ui.datepicker-ja.min.js"></script>
<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1/themes/redmond/jquery-ui.css" >
<script>
  $(function() {
    $("#datepicker").datepicker();
    $("#datepicker").datepicker("option", "showOn", 'both');
    $("#datepicker").datepicker("option", "buttonImageOnly", true);
    $("#datepicker").datepicker("option", "buttonImage", '1150_32.png');
  });
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book Management System</title>
</head>

<link rel="stylesheet" href="/book/input/Frame.css">
<link rel="stylesheet" href="/book/input/SearchResult.css">
<body>

  <!-- ヘッダ -->
  <jsp:include page="Header.html" />

  <!-- メインコンテンツ -->
  <form action="/book/Search">
    <div id="contents">
      <div class="contents_inner">
        <article id="searchCondition">
            <jsp:include page="SearchCondition.html" />
            <jsp:include page="contactInformation.txt" />
        </article>
        <article="information">
        <h2>連絡事項</h2>
        <h3>
            <jsp:include page="InformationMessage.txt" />
        </h3>
        </article>
        <div class="searchResult">
          <div class="zasshiResult">
            <%
                List<String> result = (List<String>) request.getAttribute("result");
                for (int i = 0; i < result.size(); ++i) {
                    out.println(result.get(i));
                }
            %>
          </div>
        </div>
      </div>
    </div>
  </form>

  <footer> </footer>
</body>
</html>

