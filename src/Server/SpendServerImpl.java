package Server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MoneyDaoImpl;

/**
 * Created by 22787 on 2017/12/4.
 */
@WebServlet(name = "SpendServerImpl", urlPatterns = { "/spend" })
public class SpendServerImpl extends HttpServlet {
	MoneyDaoImpl dao = new MoneyDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		int spend = Integer.parseInt(req.getParameter("spend"));
		boolean flag = dao.usemoney(username, spend);
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		if (flag == true)
			out.print("花费成功！");
		else
			out.print("花费失败！");
	}
}
