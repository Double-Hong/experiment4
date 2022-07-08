package Commodity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import myConnection.myconnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(value = "/querycommServlet")
public class querycommServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String commName=req.getParameter("commname");
        ArrayList<commodity> comm =myconnection.querycomm(commName);
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter pw=resp.getWriter();
        Gson gson=new GsonBuilder().create();
        pw.write(gson.toJson(comm));
        System.out.println(gson.toJson(comm));
        pw.close();
    }
}
