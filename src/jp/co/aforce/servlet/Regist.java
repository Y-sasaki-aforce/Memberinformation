package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.bean.Bean;
import jp.co.aforce.dao.MemberDAO;
import jp.co.aforce.tool.Check;
import jp.co.aforce.tool.Messages;
import jp.co.aforce.tool.Required;

@WebServlet("/jp.co.aforce.servlet/regist")
public class Regist extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("../views/regist.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String last_name = request.getParameter("last_name");
		String first_name = request.getParameter("first_name");
		String sex = request.getParameter("sex");
		String birth_year = request.getParameter("birth_year");
		String birth_month = request.getParameter("birth_month");
		String birth_day = request.getParameter("birth_day");
		String job = request.getParameter("job");
		String phone_number = request.getParameter("phone_number");
		String mail_address = request.getParameter("mail_address");

		//Requiredオブジェクトをインスタンス化
		Required required = new Required();

		String r = required.empty(last_name, first_name, sex, birth_year, birth_month, birth_day, job, phone_number, mail_address);
		if(!r.equals("")) {
			request.setAttribute("msg", r + Messages.W_CCM0001);
			request.getRequestDispatcher("../views/regist.jsp").forward(request, response);


			try {
				Check check = new Check();
				Bean bean = check.put(last_name, first_name, sex, birth_year, birth_month, birth_day, job, phone_number, mail_address);
				MemberDAO dao = new MemberDAO();

				int count = dao.search(bean);
				if(count >= 1) {
					request.setAttribute("msg", Messages.E_WKK0001);
					request.getRequestDispatcher("../views/regist.jsp").forward(request, response);
				} else if(count == 0) {
					dao.insert(bean);
					request.setAttribute("msg", Messages.I_WKK0001);
					request.getRequestDispatcher("../views/regist.jsp").forward(request, response);
				}

			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", Messages.E_WKK0002);
				request.getRequestDispatcher("../views/regist.jsp").forward(request, response);
			}
		}
	}
}


