/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import dao.VehicleDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Vehicle;

/**
 *
 * @author PC
 */
public class VehicleDeleteServlet extends HttpServlet {

    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int vehiID = Integer.parseInt(request.getParameter("id"));
        
        VehicleDAO vehicleDAO = new VehicleDAO();
        vehicleDAO.deleteVehicle(vehicleDAO.getVehicle(vehiID));
        
        response.sendRedirect(request.getContextPath() + "/admin/manage-vehicle.jsp");
        
    }

    
}
