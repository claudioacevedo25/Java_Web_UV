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


@WebServlet(name = "ServletMaterias", urlPatterns = {"/ServletMaterias"})
public class ServletMaterias extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            gMaterias gm=new gMaterias();
            Materia m=new Materia();            
        try{ m=gm.obtenerMateria(Integer.parseInt(request.getParameter("dat"))); }
        catch(Exception es) { } 
        request.setAttribute("materiaAeditar", m);
        RequestDispatcher rq=getServletContext().getRequestDispatcher("/AltaMateria.jsp");
        rq.forward(request, response);       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Materia m=new Materia();
        gMaterias gm=new gMaterias();
        m.setId(Integer.parseInt(request.getParameter("txt_id")));
        m.setNombre(request.getParameter("txt_nombre"));
        if(m.getId()!=0)
        {
            gm.actualizarMateria(m);
        }else
        {
            gm.cargarMateria(m);
        }
        request.setAttribute("vecMaterias", gm.listarMaterias());
        RequestDispatcher rd=getServletContext().getRequestDispatcher("/listarMaterias.jsp");
        rd.forward(request, response);  
                
    }


}
