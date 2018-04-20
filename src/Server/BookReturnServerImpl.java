package Server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookReturnDaoImpl;

@WebServlet(name = "BookReturnServerImpl", urlPatterns = { "/library1" })
public class BookReturnServerImpl extends HttpServlet{
	BookReturnDaoImpl dao = new BookReturnDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		int bookid = Integer.parseInt(req.getParameter("bookid"));
		boolean flag = dao.returnbook(username, bookid);
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		if (flag == true)
			out.print("归还成功！");
		else
			out.print("归还失败！");
	}
}
