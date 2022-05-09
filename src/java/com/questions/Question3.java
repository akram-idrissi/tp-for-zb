
package com.questions;

import java.sql.ResultSet;
import java.io.IOException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Question3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        Connection connection = MyConnection.getMyConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("select module.id, count(absence.id) from module join absence on module.id = absence.idM");
            ResultSet rs = ps.executeQuery();
            ArrayList<int[]> array = new ArrayList();
            while(rs.next()){
                array.add(new int[]{rs.getInt(1), rs.getInt(2)});
            }
            request.setAttribute("r1", array);
        } catch (SQLException ex) {
            Logger.getLogger(Question3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            PreparedStatement ps = connection.prepareStatement("select stagiaire.id, count(absence.id) from stagiaire join absence on stagiaire.id = absence.idS");
            ResultSet rs = ps.executeQuery();
            ArrayList<int[]> array = new ArrayList();
            while(rs.next()){
                array.add(new int[]{rs.getInt(1), rs.getInt(2)});
            }
            request.setAttribute("r2", array);
            
        } catch (SQLException ex) {
            Logger.getLogger(Question3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            PreparedStatement ps = connection.prepareStatement("select module.id, count(absence.id) from module join absence on module.id = absence.idM where absence.idS = " + request.getParameter("id-stagiaire-r"));
            ResultSet rs = ps.executeQuery();
            ArrayList<int[]> array = new ArrayList();
            while(rs.next()){
                array.add(new int[]{rs.getInt(1), rs.getInt(2)});
            }
            request.setAttribute("r3", array);
            
        } catch (SQLException ex) {
            Logger.getLogger(Question3.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.getRequestDispatcher("question3.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
