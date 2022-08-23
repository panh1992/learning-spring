package pan.springframework.bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao {

    private static Map<String, String> data = new HashMap<>();


    static {
        data.put("10001", "树獭");
        data.put("10002", "八杯水");
        data.put("10003", "阿毛");
    }

    public String queryUserName(String uId) {
        return data.get(uId);
    }

}
