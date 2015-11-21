<%@ page import="core.HibernateUtil" %>
<%@ page import="core.vMessageList" %>
<%@ page import="html.MessageTableGen" %>
<%@ page import="org.hibernate.SQLQuery" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="java.util.List" %>

<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 10/29/2015
  Time: 5:55 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of Board Messages</title>
</head>
<body>
<h1>${message}</h1>

<form method="post">
    <input name="id" value="id" type="text"/><br>
    <input name="timestamp" value="timestamp " type="text"/><br>
    <input name="content" value="content" type="text"/><br>
    <input name="picture_link" value="picture_link" type="text"/><br>
    <input name="user" value="user" type="text"/>
    <input type="submit"/>
</form>

<%
    // Prep work
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session connection_session = sessionFactory.openSession();
    //Session connection_session = sessionFactory.getCurrentSession();


    // Get All Messages
    SQLQuery query = connection_session.createSQLQuery
            ("SELECT id, content, picture_link, \"timestamp\", \"user\"\n" +
                    "FROM vMessageList;");
    query.addEntity(vMessageList.class);
    List messages = query.list();

    MessageTableGen tableHTML = new MessageTableGen();
    tableHTML.printMessageTable(messages, out);

%>

<% connection_session.close(); %>

</body>
</html>
