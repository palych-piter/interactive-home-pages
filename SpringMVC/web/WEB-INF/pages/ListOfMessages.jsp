<%@ page import="core.HibernateUtil" %>
<%@ page import="core.Message" %>
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

<%
    // Prep work
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session connection_session = sessionFactory.openSession();
    //Session connection_session = sessionFactory.getCurrentSession();

    // Get All Messages
    SQLQuery query = connection_session.createSQLQuery
            ("SELECT id, content, picture_link, \"timestamp\", user_pkey\n" +
                    "FROM \"Message\";");
    query.addEntity(Message.class);
    List messages = query.list();

    MessageTableGen tableHTML = new MessageTableGen();
    tableHTML.printMessageTable(messages, out);

%>

<% connection_session.close(); %>

</body>
</html>
