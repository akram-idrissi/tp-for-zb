package com.questions;

import java.sql.ResultSet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Question1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        if (action != null) {
            Connection connection = MyConnection.getMyConnection();
            PreparedStatement ps;
            ResultSet rs;

            switch (action) {
                case "rechercher":
                    try {
                    ps = connection.prepareStatement("select * from absence where id = " + request.getParameter("id-absence-r"));
                    rs = ps.executeQuery();
                    if(rs.next())
                        request.setAttribute("resultat", rs);
                } catch (SQLException ex) {
                    Logger.getLogger(Question1.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
                case "ajouter":
                    try {
                    ps = connection.prepareStatement("insert into absence (date_absence, idS, idM, type_absence) values(?, ?, ?, ?)");
                    ps.setString(1, request.getParameter("date-absence-a"));
                    ps.setInt(2, Integer.parseInt(request.getParameter("id-stagiaire-a")));
                    ps.setInt(3, Integer.parseInt(request.getParameter("id-module-a")));
                    ps.setString(4, request.getParameter("type-absence-a"));
                    ps.executeUpdate();
                    updateTotalAbsence(request.getParameter("id-stagiaire-a"), true);
                } catch (SQLException ex) {
                    Logger.getLogger(Question1.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
                case "supprimer":
                    try {
                    updateTotalAbsence(request.getParameter("id-absence-s"), false);
                    ps = connection.prepareStatement("delete from Absence where id = " + request.getParameter("id-absence-s"));
                    ps.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(Question1.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
                default:
                    throw new AssertionError();
            }
           
            request.getRequestDispatcher("question1.jsp").forward(request, response);
        }
    }

    public void updateTotalAbsence(String id, boolean increment) {
        Connection connection = MyConnection.getMyConnection();
        PreparedStatement ps;
        try {
            if (increment) {
                ps = connection.prepareStatement("update stagiaire set total_absence = total_absence + 1 "
                        + "where id = " + id);
            } else {
                ps = connection.prepareStatement("update stagiaire set total_absence = total_absence - 1 "
                        + "where id = (select idS from absence where id = " + id + ")");
            }

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Question1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
