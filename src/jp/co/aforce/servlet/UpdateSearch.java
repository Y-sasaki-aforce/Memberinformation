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
import jp.co.aforce.tool.Messages;

@WebServlet("/jp.co.aforce.servlet/update-search")
public class UpdateSearch extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			String member_id = request.getParameter("member_id");

			if(member_id.equals("") || member_id.equals(null)) {
				request.setAttribute("msg", "会員番号" + Messages.W_CCM0001);
				request.getRequestDispatcher("../views/update.jsp").forward(request, response);
			}else {
				MemberDAO dao = new MemberDAO();

				try {
					//beanにdaoの会員番号検索情報をセット
					Bean bean = dao.findByMemberId(member_id);

					//nullでないとき
					if(bean != null) {
						session.setAttribute("member_id", member_id);
						request.setAttribute("member", bean);
						request.getRequestDispatcher("../views/update.jsp").forward(request, response);
					}else {
						request.setAttribute("msg", Messages.E_WKK0003);
						request.getRequestDispatcher("../views/update.jsp").forward(request, response);
					}
				} catch (Exception e) {
					e.printStackTrace();

				}
			}
    }
}

