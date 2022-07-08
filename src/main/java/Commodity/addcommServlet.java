package Commodity;

import com.alibaba.fastjson.JSONObject;
import myConnection.myconnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/addcommServlet")
public class addcommServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String commId;String classifyId;String brandId;String commName;String commSize;String modelNumber;String unitOfMeasure;String marketPrice2;String salePrice2;String costPrice2;String commIntro;String inventoryNum2;
        commId=req.getParameter("commId");
        classifyId=req.getParameter("classifyId");
        brandId=req.getParameter("brandId");
        commName=req.getParameter("commName");
        commSize=req.getParameter("commSize");
        modelNumber=req.getParameter("modelNumber");
        unitOfMeasure=req.getParameter("unitOfMeasure");
        marketPrice2=req.getParameter("marketPrice");
        salePrice2=req.getParameter("salePrice");
        costPrice2=req.getParameter("costPrice");
        commIntro=req.getParameter("commIntro");
        inventoryNum2=req.getParameter("inventoryNum");
        float marketPrice=Float.parseFloat(marketPrice2);
        float salePrice=Float.parseFloat(salePrice2);
        float costPrice=Float.parseFloat(costPrice2);
        float inventoryNum=Float.parseFloat(inventoryNum2);
        commodity comm=new commodity(commId,classifyId,brandId,
                commName,commSize,modelNumber,unitOfMeasure,
                marketPrice,salePrice,costPrice,"",commIntro,inventoryNum);
        JSONObject o=new JSONObject();
        if(myconnection.addcomm(comm)){
            o.put("code","ok");
            System.out.println("ok");
        }
        else{
            o.put("code","no");
            System.out.println("no");
        }
        PrintWriter pw=resp.getWriter();
        pw.print(o);
        pw.close();
    }
}
