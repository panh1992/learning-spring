package pan.springframework.bean;

import pan.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserDao {

    private static Map<String, String> data = new HashMap<>();

    static {
        data.put("10001", "测试，北京，朝阳");
        data.put("10002", "八杯水，上海，尖沙咀");
        data.put("10003", "阿毛，香港，铜锣湾");
    }

    public String queryUserName(String uId) {
        return data.get(uId);
    }

}
