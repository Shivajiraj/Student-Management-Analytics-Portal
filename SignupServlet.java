package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");

        String email = request.getParameter("email");

        String password = request.getParameter("password");

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/student_management_system",
                "root",
                "934600"
            );

            String query =
            "INSERT INTO users(name,email,password,role) VALUES(?,?,?,'user')";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, name);

            ps.setString(2, email);

            ps.setString(3, password);

            int rows = ps.executeUpdate();

            if(rows > 0) {

                response.sendRedirect("LoginPage.html");

            } else {

                response.getWriter().println("Signup Failed");
            }

            con.close();

        } catch(Exception e) {

            response.getWriter().println(e.getMessage());
        }
    }
}