package pan.springframework.util;

/**
 * 用于解析字符串值的简单策略接口
 */
public interface StringValueResolver {

    String resolveStringValue(String strVal);

}
