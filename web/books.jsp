<%@ page import="servletandjsp.Book" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: a.talismanov
  Date: 23.06.2016
  Time: 8:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Books</title>
  </head>
  <body>

  <%--<%--%>
    <%--List<Book> bookList = (List<Book>) request.getAttribute("bookList");--%>
  <%--%>--%>


  <ul>
      <% List<Book> bookList = (List<Book>) request.getAttribute("bookList"); %>
      <% System.out.println("bookList.size() " + bookList.size());  %>
      <% for (Book book : bookList) {%>
        <% System.out.println("book.getId()" + book.getId()); %>
        <% System.out.println("book.getName()" + book.getName()); %>
           <li>Скриптлетами Id: <% book.getId(); %>  Name: <%book.getName();%>   </li>
      <%}%>
  </ul>

  <ul>
    <c:forEach items="${bookList}" var="book">
      <li>Id: ${book.id}, Name: ${book.name}</li>
    </c:forEach>
  </ul>

  </body>
</html>
