/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.blanco.tests.jms.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ablanco
 */
public class HelloMsgServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Request received: ");
        try {
            String parameter = request.getParameter("person");
            Context ctx = new InitialContext();
            Object object = ctx.lookup("jms/hello_queue");
            Queue queue = (Queue)object;
            Object factory = ctx.lookup("jms/helloQueueConnectionFactory");
            QueueConnectionFactory qFactory = (QueueConnectionFactory) factory;
            try {
                QueueConnection con = qFactory.createQueueConnection();
                Session session = 
                con.createSession(true, Session.AUTO_ACKNOWLEDGE);
                TextMessage msg = session.createTextMessage();
                msg.setText(parameter);
                session.createProducer(queue).send(msg);
                session.close();
            } catch (JMSException ex) {
                Logger.getLogger(HelloMsgServlet.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
            response.getOutputStream().println("Message Sent!!!!");
        } catch (NamingException ex) {
            Logger.getLogger(HelloMsgServlet.class.getName()).log(Level.SEVERE, 
                    null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
