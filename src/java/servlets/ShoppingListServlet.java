package servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 794456
 */

public class ShoppingListServlet extends HttpServlet {
     HttpSession session;

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("GET Request");
        String logout = request.getParameter("logout");
          getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
     System.out.println("Done.");
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("POST Request");
       
       String username= request.getParameter("username");
       String register= request.getParameter("registername");
       
       if(register!=null){
         session = request.getSession();
         session.setAttribute("username", username);
       }
         String item=request.getParameter("item");
       
         //it will make an arraylist of items and fech it from the session itf it exists and if not it will initialize it in the if statement
      ArrayList<String> items = (ArrayList<String>)session.getAttribute("things");
      if(items==null){
          items=new ArrayList<String>();
      }
      
      if(request.getParameter("additem") != null && !(item.equals(""))){
        
          items.add(item);
          session.setAttribute("things", items);
      }
    String del=request.getParameter("delete");
    if(del!=null){
        System.out.println("delete");
        
        String radSelect = request.getParameter("radSelect");
                if (radSelect != null && !radSelect.equals("")) {
                    try {
                        int selected = Integer.parseInt(radSelect);
                       // ArrayList<String> items = (ArrayList<String>)session.getAttribute("items");
                        if (items == null) // For safety.
                            items = new ArrayList<String>();
                        items.remove(selected);
                        session.setAttribute("items",items);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    
                }
         
    }
    
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            System.out.println("Done.");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
