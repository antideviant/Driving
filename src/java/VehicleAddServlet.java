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
public class VehicleAddServlet extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String vehiName = request.getParameter("vehi_name");
        String vehiType = request.getParameter("vehi_type");
        String vehiPlatNo = request.getParameter("vehi_platno");
        String vehiStatus = "AVAILABLE";
        
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName(vehiName);
        vehicle.setVehicleType(vehiType);
        vehicle.setVehiclePlatNo(vehiPlatNo);
        vehicle.setVehicleStatus(vehiStatus);
        
        VehicleDAO vehicleDAO = new VehicleDAO();
        vehicleDAO.addVehicle(vehicle);
        
        response.sendRedirect(request.getContextPath() + "/admin/manage-vehicle.jsp");
        
    }


}
