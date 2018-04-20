package Server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CardDelDaoImpl;

@WebServlet(name = "CardDelServerImpl", urlPatterns = { "/carddel" })
public class CardDelServerImpl extends HttpServlet{
	CardDelDaoImpl dao = new CardDelDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		boolean flag = dao.delCard(username);
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		if (flag == true)
			out.print("注销成功！");
		else
			out.print("注销失败！");
	}
}
