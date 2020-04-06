package cn.edu.haue.taxi.util;

import java.util.Date;
import java.util.UUID;

public class UUIDUtil {
    public static String randomId() {
        return UUID.randomUUID().toString().replaceAll("-", "") + "-" + new Date().getTime();
    }

    public static String SerialNum() {
        int num = UUID.randomUUID().hashCode();
        num = num < 0 ? -num : num;
        return String.valueOf(num).substring(0,6);
    }

}