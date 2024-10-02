package com.uts.restaurant.controller;

import com.uts.restaurant.model.dao.DBManager;
import com.uts.restaurant.model.AccessLogs;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewAccessLogsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        AccessLogs accessLogs = null;
        try {
            accessLogs = manager.getAccessLogs();
        }
        catch (SQLException ex) {           
            Logger.getLogger(ViewAccessLogsServlet.class.getName()).log(Level.SEVERE, null, ex);       
        }
        session.setAttribute("accessLogs", accessLogs);
        request.getRequestDispatcher("view-access-logs.jsp").include(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        AccessLogs accessLogs = null;
        try {
            accessLogs = manager.getAccessLogs();
        }
        catch (SQLException ex) {           
            Logger.getLogger(ViewAccessLogsServlet.class.getName()).log(Level.SEVERE, null, ex);       
        }
        session.setAttribute("accessLogs", accessLogs);
        request.getRequestDispatcher("view-access-logs.jsp").include(request, response);
    }
}
