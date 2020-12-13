<%@ page import="static com.yoyling.utils.Constants.USERINFO_SESSION" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TITLE</title>
</head>
<body>

<%
    if (session.getAttribute(USERINFO_SESSION)!=null) {
%>
        <jsp:forward page = "/WEB-INF/pages/index.jsp"/>
<%
    }else {
%>
        <jsp:forward page = "/WEB-INF/pages/login.jsp" />
<%
    }
%>
</body>
</html>
