package Server;

import dao.MoneyDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by 22787 on 2017/12/2.
 */
@WebServlet(name = "moneyserverimpl", urlPatterns = { "/money" })
public class MoneyServerImpl extends HttpServlet {
	MoneyDaoImpl dao = new MoneyDaoImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String usemoney = req.getParameter("usemoney1");
		int a;
		try {
			a = Integer.parseInt(usemoney);
			dao.usemoney(username, a);
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.print(a);
			out.flush();
			out.close();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

	}
}
