package Server;

/**
 * Created by 22787 on 2017/12/3.
 */

import dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

@WebServlet(name = "PasswordServerImpl", urlPatterns = { "/password" })
public class PasswordServerImpl extends HttpServlet {
	UserDaoImpl dao = new UserDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String old = req.getParameter("old");
		String new1 = req.getParameter("new1");
		String new2 = req.getParameter("new2");
		String username = req.getParameter("username");
		boolean flag = false;
		PrintWriter out = resp.getWriter();
		if (new1.indexOf(new2) != -1 && old.indexOf(new1) == -1&&new2.indexOf(new1) != -1 && new1.indexOf(old) == -1) {
			 if (dao.loginUser(username, old)) {
			dao.rePassword(username, new1);

			out.print("yes");

			 } else {
			out.print("no"); }
		} else {

			out.print("no");
		}
		out.flush();
		out.close();
	}
}
