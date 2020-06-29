package com.zr.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.zr.servlet.dao.UserDao;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserDao userDao = new UserDao();

        if (username != null && password.equals(userDao.getOneUserByUsername(username).getPassword())) {
            resp.getWriter().write("Pass");
        } else {
            resp.getWriter().write("Fail");
        }
    }
}
