<!doctype html public "-//w3c//dtd html 4.0 transitional//en">

  <%@ page contentType="text/html; charset=UTF-8" %>
  <%@ page import="java.util.*, java.text.*" %>

  <html>
      <head>
          <title>Простейшая страница JSP</title>
          <meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
     </head>

     <body>
          Добро пожаловать! Сегодня <%= getFormattedDate() %>
          Добро пожаловать!  <!--%= new Hello().printHello() %-->
          <form method="post">
              <form method="post" action="servlet-parameters">
                  <p><b>Введите операцию:</b><br>
                      <input type="text" size="40">
                  </p>
                  <p><input type="submit" value="Выполнить">
                      <input type="reset" value="Очистить"></p>
                  <p>Результат выполнения:<Br>
                      <textarea name="comment" cols="40" rows="3">
                          <%= request.getParameter("result")%>
                      </textarea></p>
              </form>
          </form>
     </body>
  </html>

  <%!
     String getFormattedDate ()
     {
          SimpleDateFormat sdf = new SimpleDateFormat ("dd.MM.yyyy hh:mm:ss");
          return sdf.format (new Date ());
     }
  %>