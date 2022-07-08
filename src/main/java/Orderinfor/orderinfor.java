package Orderinfor;

public class orderinfor {
    String orderId,customerId,custPhone,custName,custAdress,postCode,orderTime;
    float orderMoney;

    public orderinfor(String orderId, String customerId, String custPhone,
                      String custName, String custAdress, String postCode,
                      String orderTime, float orderMoney) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.custPhone = custPhone;
        this.custName = custName;
        this.custAdress = custAdress;
        this.postCode = postCode;
        this.orderTime = orderTime;
        this.orderMoney = orderMoney;
    }
}
