package cn.springmvc.util;

import java.util.HashMap;
import java.util.Map;

public class Const {

	public static int SUCCESS = 0;
	public static int FAILED = 1;
	public static String INNER_ERROR = "100000";
	public static String WRONG_USER_OR_PASS = "100001";

	public static String getErrDes(String errCode) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(INNER_ERROR, "内部程序错误");
		map.put(WRONG_USER_OR_PASS, "用户名或密码错误");
		return (String) map.get(errCode);
	}
}
