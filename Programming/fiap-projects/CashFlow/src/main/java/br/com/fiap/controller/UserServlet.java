package br.com.fiap.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import br.com.fiap.bean.User;
import br.com.fiap.dao.UserDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.DAOFactory;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private UserDAO userDAO;

	@Override
	public void init() throws ServletException {
		super.init();
		userDAO = DAOFactory.getUserDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String name = request.getParameter("nm_user");
			int cpf = Integer.parseInt(request.getParameter("cpf_user"));
			String email = request.getParameter("ds_user_email");

			User user = new User(0, name, cpf, email);
			userDAO.insertUser(user);

			request.setAttribute("msg", "usuario cadastrado");
		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "erro ao cadastrar");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "por favor, valide os dados");
		}
		request.getRequestDispatcher("cadastro-usuario.jsp").forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			List<User> lista = userDAO.getAllUsers();
			request.setAttribute("users", lista);
			request.getRequestDispatcher("lista-usuario.jsp").forward(request, response);	
	}

}
