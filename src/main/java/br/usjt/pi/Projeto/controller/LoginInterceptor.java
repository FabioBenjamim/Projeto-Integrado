package br.usjt.pi.Projeto.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor  extends  HandlerInterceptorAdapter{

	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler)throws Exception {

		HttpSession session = request.getSession();

		if (session.getAttribute("usuarioLogado") == null)
			response.sendRedirect("/");
		return true;
	}
}
