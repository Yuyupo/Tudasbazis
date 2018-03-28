package tkvnmsz.tudastar.handlerinterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import tkvnmsz.tudastar.session.SessionData;

public class UserAddingHandlerInterceptor extends HandlerInterceptorAdapter {
	/*@Autowired
	private SessionData sessionData;
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		if( modelAndView != null ) {
			ModelMap modelMap = modelAndView.getModelMap();
			modelMap.addAttribute("user", sessionData.getUser());
		}
	}*/
}
