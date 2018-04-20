package Server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CardDaoImpl;

@WebServlet(name = "CardServerImpl", urlPatterns = { "/card" })
public class CardServerImpl extends HttpServlet{
	CardDaoImpl dao = new CardDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		int door = Integer.parseInt(req.getParameter("door")); 
		String name = req.getParameter("name");
		String work = req.getParameter("work");
		int money = Integer.parseInt(req.getParameter("money"));
		boolean flag = dao.addCard(username, password,door,name,work, money);
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		if (flag == true)
			out.print("注册成功！");
		else
			out.print("注册失败！");
	}
}
