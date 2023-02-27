/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

/**
 *
 * @author Martin
 */
@WebServlet(name = "imagen", urlPatterns = {"/imagen"})
public class imagen extends HttpServlet {



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("email");

        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecth?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true", "root", "1234");
            stmt = conn.prepareStatement("SELECT u.imagen FROM Usuario u WHERE email = ?");
            stmt.setString(1, userId);
            rs = stmt.executeQuery();

            if (rs.next()) {
                byte[] imageData = rs.getBytes("imagen");
                request.setAttribute("imageData", imageData);
            }
      
        } catch (SQLException ex) {
            Logger.getLogger(imagen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(imagen.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close resources
        }

    }
}
