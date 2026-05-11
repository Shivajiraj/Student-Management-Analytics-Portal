package p1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/FetchStudentServlet")
public class FetchStudentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String studentId =
        request.getParameter("student_id");

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con =
            DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/student_management_system",
            "root",
            "934600");

            // BASIC DETAILS

            String q1 =
            "SELECT * FROM basic_details " +
            "WHERE student_id=?";

            PreparedStatement ps1 =
            con.prepareStatement(q1);

            ps1.setString(1, studentId);

            ResultSet rs1 =
            ps1.executeQuery();

            // ACADEMIC DETAILS

            String q2 =
            "SELECT * FROM academic_details " +
            "WHERE student_id=?";

            PreparedStatement ps2 =
            con.prepareStatement(q2);

            ps2.setString(1, studentId);

            ResultSet rs2 =
            ps2.executeQuery();

            if(rs1.next()){

                request.setAttribute(
                "student_id",
                studentId);

                request.setAttribute(
                "full_name",
                rs1.getString("full_name"));

                request.setAttribute(
                "email",
                rs1.getString("email"));

                request.setAttribute(
                "phone",
                rs1.getString("phone"));

                request.setAttribute(
                "gender",
                rs1.getString("gender"));
            }

            if(rs2.next()){

                request.setAttribute(
                "branch",
                rs2.getString("branch"));

                request.setAttribute(
                "year_of_study",
                rs2.getString("year_of_study"));

                request.setAttribute(
                "section",
                rs2.getString("section"));

                request.setAttribute(
                "cgpa",
                rs2.getString("cgpa"));
            }

            request.getRequestDispatcher(
            "updateStudent.jsp")
            .forward(request,response);

            con.close();

        } catch(Exception e){

            e.printStackTrace();
        }
    }
}