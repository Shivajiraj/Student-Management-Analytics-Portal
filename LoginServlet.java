package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
            	    "jdbc:mysql://trolley.proxy.rlwy.net:20416/railway?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",
            	    "root",
            	    "roasjGBKmitUikschrYkKXEvRavKOTsH"
            	);

            String query = "SELECT * FROM users WHERE email=? AND password=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                String role = rs.getString("role");

                HttpSession session = request.getSession();

                session.setAttribute("userEmail", email);
                session.setAttribute("role", role);

                if(role.equals("admin")) {

                    response.sendRedirect("adminHome.html");

                } else {

                    response.sendRedirect("userHome.html");
                }

            } else {

                response.sendRedirect("LoginPage.html?error=invalid");
            }

            con.close();

        } catch (Exception e) {

        	e.printStackTrace();
        }
    }
}
