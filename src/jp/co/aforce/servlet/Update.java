package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.Bean;
import jp.co.aforce.dao.MemberDAO;
import jp.co.aforce.tool.Check;
import jp.co.aforce.tool.Messages;
import jp.co.aforce.tool.Required;

@WebServlet("/jp.co.aforce.servlet/update")
public class Update extends HttpServlet{
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.sendRedirect("../views/update.jsp");
		}


		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			HttpSession session = request.getSession();

			String member_id = request.getParameter("member_id");
			String last_name = request.getParameter("last_name");
			String first_name = request.getParameter("first_name");
			String sex = request.getParameter("sex");
			String birth_year = request.getParameter("birth_year");
			String birth_month = request.getParameter("birth_month");
			String birth_day = request.getParameter("birth_day");
			String job = request.getParameter("job");
			String phone_number = request.getParameter("phone_number");
			String mail_address = request.getParameter("mail_address");

			Required required = new Required();
			String error = required.empty(last_name, first_name, sex, birth_year, birth_month, birth_day, job, phone_number, mail_address);

			//空文字になるとき
			if(!error.equals("")) {
				session.setAttribute("msg", error + Messages.W_CCM0001);
				request.getRequestDispatcher("../views/update.jsp").forward(request, response);
			} else {
				Check check = new Check();

				try {
					Bean bean = check.put(last_name, first_name, sex, birth_year, birth_month, birth_day, job, phone_number, mail_address);
					MemberDAO dao = new MemberDAO();
					dao.update(bean, member_id);

					session.setAttribute("msg", Messages.I_WKK0003);
					session.removeAttribute("updateBean");
					session.removeAttribute("memberId");
					request.getRequestDispatcher("../views/update.jsp").forward(request, response);

				} catch (Exception e) {
					request.setAttribute("msg", Messages.E_WKK0005);
					request.getRequestDispatcher("../views/update.jsp").forward(request, response);
				}
			}
		}
}

