package myConnection;

import Commodity.commodity;
import Orderinfor.orderinfor;

import java.sql.*;
import java.util.ArrayList;

public class myconnection {
    static String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=CommoditySystem";
    private static Connection dbConn = null;

    public static Connection getConn() {
        try {
            //1.加载驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("加载驱动成功！");
            //2.连接
            dbConn = DriverManager.getConnection(dbURL, "sa", "123456");
            System.out.println("连接数据库成功！");
            return dbConn;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("连接数据库失败！");
            return null;
        }
    }

    public static ArrayList<commodity> querycomm(String name){
        ArrayList<commodity> results= new ArrayList<>();
        Connection conn=getConn();
        String sql ="select * from commodityInfor where commName =?";
        try {
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1,name);
            ResultSet set=p.executeQuery();
            while(set.next()){
                String commId;String classifyId;String brandId;String commName;String commSize;String modelNumber;String unitOfMeasure;float marketPrice;float salePrice;float costPrice;String commPhoto;String commIntro;float inventoryNum;
                commId=set.getString("commId");
                classifyId=set.getString("classifyId");
                brandId=set.getString("brandId");
                commName=set.getString("commName");
                commSize=set.getString("commSize");
                modelNumber=set.getString("modelNumber");
                unitOfMeasure=set.getString("unitOfMeasure");
                marketPrice=set.getFloat("marketPrice");
                salePrice=set.getFloat("salePrice");
                costPrice=set.getFloat("costPrice");
                commPhoto=set.getString("commPhoto");
                commIntro=set.getString("commIntro");
                inventoryNum=set.getFloat("inventoryNum");
                commodity info=new commodity(commId,classifyId,brandId,commName,commSize,modelNumber,unitOfMeasure,
                        marketPrice,salePrice,costPrice,commPhoto,commIntro,inventoryNum);
                results.add(info);
            }
            conn.close();
            p.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return results;
    }

    public static ArrayList<orderinfor> queryorder(String no){
        ArrayList<orderinfor> results= new ArrayList<>();
        Connection conn=getConn();
        String sql ="select * from orderInfor where orderId =?";

        PreparedStatement p = null;
        try {
            p = conn.prepareStatement(sql);
            p.setString(1,no);
            ResultSet set=p.executeQuery();
            while(set.next()){
                String orderId,customerId,custPhone,custName,custAdress,postCode,orderTime;
                float orderMoney;
                orderId= set.getString("orderId");
                customerId= set.getString("customerId");
                custPhone= set.getString("custPhone");
                custName=set.getString("custName");
                custAdress=set.getString("custAdress");
                postCode= set.getString("postCode");
                orderTime= set.getString("orderTime");
                orderMoney= set.getFloat("orderMoney");
                orderinfor info =new orderinfor(orderId,customerId,custPhone,custName,custAdress,
                        postCode,orderTime,orderMoney);
                results.add(info);
            }
            conn.close();
            p.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return results;
    }
    public static boolean addcomm(commodity comm){
        Connection conn=getConn();
        String sql="insert into commodityInfor values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1,comm.getCommId());
            p.setString(2,comm.getClassifyId());
            p.setString(3,comm.getBrandId());
            p.setString(4,comm.getCommName());
            p.setString(5,comm.getCommSize());
            p.setString(6, comm.getModelNumber());
            p.setString(7,comm.getUnitOfMeasure());
            p.setFloat(8,comm.getMarketPrice());
            p.setFloat(9,comm.getSalePrice());
            p.setFloat(10,comm.getCostPrice());
            p.setString(11,comm.getCommPhoto());
            p.setString(12,comm.getCommIntro());
            p.setFloat(13,comm.getInventoryNum());
            p.executeUpdate();
            p.close();
            conn.close();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
