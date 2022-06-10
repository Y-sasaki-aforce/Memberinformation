package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.dao.MemberDAO;
import jp.co.aforce.tool.Messages;
import jp.co.aforce.tool.Required;

@WebServlet("/jp.co.aforce.servlet/delete")
public class Delete extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("../views/delete.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		String member_id = request.getParameter("member_id");

		//空文字チェック
		Required required = new Required();
		String error = required.nullCheckById(member_id);

		if(!error.equals("")) {
			request.setAttribute("msg", error + Messages.W_CCM0001);
			request.getRequestDispatcher("../views/delete.jsp").forward(request, response);


			MemberDAO dao = new MemberDAO();
			String delete_id = (String) session.getAttribute("member_id");

			try {
				int line = dao.delete(delete_id);

				if(line > 0) {
					request.setAttribute("msg", Messages.I_WKK0002);
					request.getRequestDispatcher("../views/delete.jsp").forward(request, response);
				}else {
					request.setAttribute("msg", Messages.E_WKK0004);
					request.getRequestDispatcher("../views/delete.jsp").forward(request, response);
				}
			} catch (Exception e) {
				request.setAttribute("msg", Messages.E_WKK0003);
				request.getRequestDispatcher("../views/delete.jsp").forward(request, response);
				e.printStackTrace();
			}


	}
	}

}
