package servlet;

import controlador.gMaterias;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.Materia;


@WebServlet(name = "ServletListarMateria", urlPatterns = {"/ServletListarMateria"})
public class ServletListarMateria extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        gMaterias gm=new gMaterias();
        request.setAttribute("vecMaterias", gm.listarMaterias());
        RequestDispatcher rd=getServletContext().getRequestDispatcher("/listarMaterias.jsp");
        rd.forward(request, response);     
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            gMaterias gm=new gMaterias();
    Materia m=new Materia();
    m.setId(Integer.parseInt(request.getParameter("txt_idEliminar")));
    gm.eliminarMateria(m.getId());
    request.setAttribute("vecMaterias", gm.listarMaterias());
    RequestDispatcher rd=getServletContext().getRequestDispatcher("/listarMaterias.jsp");
    rd.forward(request, response);
      
    }


}
