package com.questions;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Question2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Connection connection = MyConnection.getMyConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("select id, total_absence from stagiaire order by total_absence desc ");
            ResultSet rs = ps.executeQuery();
            ArrayList<int[]> array = new ArrayList();
            while(rs.next()){
                array.add(new int[]{rs.getInt(1), rs.getInt(2)});
            }
            request.setAttribute("resultat2", array);
            request.getRequestDispatcher("question2.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Question2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
