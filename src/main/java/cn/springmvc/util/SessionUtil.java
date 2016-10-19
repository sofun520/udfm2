package cn.springmvc.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtil<T> {

	@SuppressWarnings("unchecked")
	public T getSession(HttpServletRequest request, String paramName) {
		HttpSession session = request.getSession();
		return (T) session.getAttribute(paramName);
	}

}
