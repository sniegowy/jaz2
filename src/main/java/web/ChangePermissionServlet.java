package web;

import model.User;
import repositories.UserRepository;
import repositories.UserRepositoryDummyImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/changePermission")
public class ChangePermissionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserRepository repository = new UserRepositoryDummyImpl();
        String email = request.getParameter("email");
        String permissionString = request.getParameter("permission");
        boolean permission = permissionString == null ? false : true;

        repository.changeUsersPremiumPermission(email, permission);

        response.sendRedirect("admin");
    }
}
