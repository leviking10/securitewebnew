package com.groupeisi.securiteweb.servlet;

import com.groupeisi.securiteweb.dao.CompteDao;

import com.groupeisi.securiteweb.dto.CompteDto;
import com.groupeisi.securiteweb.entities.Compte;
import com.groupeisi.securiteweb.service.CompteDtoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(value="/compte", name="compte")
public class CompteServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;
    private static String VIEW_PATH = "/WEB-INF/views/comptes/";
    private CompteDao compteDao;
    @Override
    public void init() {

        compteDao = new CompteDao();
    }
    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
           // doGet(request, response);

            String username = request.getParameter("username");
            String password  = request.getParameter("password");
            if(username.equals("") && password.equals("")){
                request.setAttribute("error", "Veuillez renseigner tous les champs");
                this.getServletContext().getRequestDispatcher(VIEW_PATH + "add.jsp").forward(request, response);
            }else{
                CompteDao compteDAO = new CompteDao();
                Compte compte = new Compte();
                compte.setUsername(username);
                compte.setPassword(password);
                int result = compteDao.saveCompte(compte);
                if(result == 1){
                    request.setAttribute("success", "Crée avec succès");
                }else{
                    request.setAttribute("error", "Une erreur s'est produite");
                }

                response.sendRedirect("compte");
            }

        }
    @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("username");
            if(username == null){ // si l'utilisateur n'est pas authentifié
                response.sendRedirect("/logout");
            }else{
                String param = request.getParameter("param");
                if(param != null){
                    if(param.equals("add")){
                        this.getServletContext().getRequestDispatcher(VIEW_PATH + "add.jsp").forward(request, response);
                    }
                }else{
                    CompteDao compteDAO = new CompteDao();
                    Compte c = new Compte();
                    List<Compte> listCompte = compteDAO.getAllCompte();
                    request.setAttribute("listCompte", listCompte);
                    request.setAttribute("username", username);
                    this.getServletContext().getRequestDispatcher(VIEW_PATH + "list.jsp").forward(request, response);
                }
            }




        /*
        String action = request.getServletPath();

            try {
                switch (action) {
                    case "/new":
                        showNewForm(request, response);
                        break;
                    case "/insert":
                        insertUser(request, response);
                        break;
                    case "/delete":
                        deleteUser(request, response);
                        break;
                    case "/edit":
                        showEditForm(request, response);
                        break;
                    default:
                        listCompte(request, response);
                        break;
                }
            } catch (SQLException ex) {
                throw new ServletException(ex);
            }*/
        }

        private void listCompte(HttpServletRequest request, HttpServletResponse response)
                throws SQLException, IOException, ServletException {
            List < Compte > listCompte = compteDao.getAllCompte();
            request.setAttribute("listCompte", listCompte);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/comptes/list.jsp");
            dispatcher.forward(request, response);
        }

        private void showNewForm(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/comptes/add.jsp");
            dispatcher.forward(request, response);
        }

        private void showEditForm(HttpServletRequest request, HttpServletResponse response)
                throws SQLException, ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            Compte existingCompte =  compteDao.getCompte(id);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/comptes/add.jsp");
            request.setAttribute("compte", existingCompte);
            dispatcher.forward(request, response);

        }
    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

        }

        private void updateUser(HttpServletRequest request, HttpServletResponse response)
                throws SQLException, IOException {/*
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String email = request.getParameter("email");


            CompteDtoImpl book = new CompteDtoImpl();
            book.update(book);
            response.sendRedirect("list");*/
        }

        private void deleteUser(HttpServletRequest request, HttpServletResponse response)
                throws SQLException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            CompteDao.deleteCompte(id);
            response.sendRedirect("list");


    }
}
