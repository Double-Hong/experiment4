import java.util.ArrayList;

import Commodity.commodity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import myConnection.myconnection;
public class zhuz {

    public static void main(String[] args) {
        ArrayList<commodity> comm;
        comm=myconnection.querycomm("可乐");
        Gson gson =new GsonBuilder().create();
        System.out.println(gson.toJson(comm));
    }
}
