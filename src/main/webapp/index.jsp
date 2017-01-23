<!doctype html public "-//w3c//dtd html 4.0 transitional//en">

  <%@ page contentType="text/html; charset=UTF-8" %>
  <%@ page import="java.util.*, java.text.*, main.java.LinearCalculator" %>
  <%@ page import="exceptions.ExceptionOfEverything" %>


<html>
      <head>
          <title>Страница JSP</title>
          <meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
     </head>

     <body>
     <p><%
         LinearCalculator.getInstance().inicializeCrud();
     %></p>
          Добро пожаловать! Сегодня <%= getFormattedDate() %>
          <form name="test" method="post" action="index.jsp">
              <p><b>Введите операцию:</b><br>
                  <input type="text" size="40" name="operation">
              </p>
              <p>Результат:<Br>
                      <%= getResult(request)%>
              <p><input type="submit" value="Выполнить">
                  <input type="reset" value="Очистить"></p>
          </form>
          <input type="button" onclick="parent.location='history.jsp'" value="История">
     </body>
  </html>

  <%!
     String getFormattedDate ()
     {
          SimpleDateFormat sdf = new SimpleDateFormat ("dd.MM.yyyy hh:mm:ss");
          return sdf.format (new Date ());
     }
  %>
<%!
    String getResult(HttpServletRequest request)
    {
        String res = request.getParameter("operation");
        if (res != null)
            try {
                float result = LinearCalculator.getInstance().parseAndCalc(res);
                String str = String.valueOf(result);
                LinearCalculator.getInstance().putIntoDatabase(str);
                return str;
            } catch (ExceptionOfEverything e) {
                LinearCalculator.getInstance().putIntoDatabase(e.getMessage());
                return e.getMessage();
            }
        else return " ";
    }
%>