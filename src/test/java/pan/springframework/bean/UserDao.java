package pan.springframework.bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao {

    private final Map<String, String> data = new HashMap<>();

    public void initDataMethod() {
        System.out.println("执行：init-method");
        data.put("10001", "树獭");
        data.put("10002", "八杯水");
        data.put("10003", "阿毛");
    }

    public void destroyDataMethod() {
        System.out.println("执行：destroy-method");
        data.clear();
    }

    public String queryUserName(String uId) {
        return data.get(uId);
    }

}
