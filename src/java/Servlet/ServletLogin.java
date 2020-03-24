package Servlet;

import Controlador.gUsuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.Usuario;


@WebServlet(name = "ServletLogin", urlPatterns = {"/ServletLogin"})
public class ServletLogin extends HttpServlet {

private String url;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().invalidate();
         url=request.getParameter("patch");
        RequestDispatcher rd=getServletContext().getRequestDispatcher("/login.jsp");
        rd.forward(request, response);
    
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
      
        Usuario usuarioTemp = new Usuario();
        usuarioTemp.setUsuario(Integer.parseInt(request.getParameter("user")));
        usuarioTemp.setContraseña(Integer.parseInt(request.getParameter("password")));
        gUsuario g=new gUsuario();
        Usuario usuarioTemp2 = new Usuario();
        usuarioTemp2 = g.buscarUsuario(usuarioTemp);
        if(usuarioTemp2!= null)
        {
            Usuario u = new Usuario();
            u = usuarioTemp2;
            request.getSession().setAttribute("usuario", u);
            if(url==null || url.isEmpty())
            {
                 response.sendRedirect(""); 
            }else
            {
              response.sendRedirect(url);
            }          
        }else
        {
            if(url==null || url.isEmpty())
            {
              response.sendRedirect("ServletLogin");  
            }else
            {
              response.sendRedirect("ServletLogin?patch="+url);  
            }    
        }
    }


}