package com.newer.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.newer.domain.User;
import com.newer.service.UserService;
import com.newer.util.MyConstants;

@Controller
@RequestMapping("login")
//将名字为：MyConstants.SESSSION_USER的属性同时绑定到session中
@SessionAttributes(MyConstants.SESSSION_USER)
public class LoginController {
	@Autowired
	private UserService userService;
  
	//controller接收jsp页面参数的方式：
	
	//JSP  => controller
	//1.形参传值（参数名与控件名相同)
	//2.对象传值（对象的属性名与与控件名相同）
	//3.HttpServletRequest手动接收值
	//4.访问地址中传值@PathVariable（restful风格中）
	
	//controller => jsp
	 //1.Model ModelMap Map
	 //2.ModelAndView 
	 //....
	
	//访问路径：login/login
	@RequestMapping("login")
	public String login(String uname,String upwd,Model model ) {
		User user=this.userService.login(uname, upwd);
		if (user!=null) {
			model.addAttribute(MyConstants.SESSSION_USER, user);
			return "redirect:/main";  //重定向控制层
		}else {
			model.addAttribute("msg", "用户名或密码不对");
			return "forward:/index.jsp";
		}
	}
	
	/**
	 * 注销
	 * @return
	 */
	@RequestMapping("logout")
	public String  logout(HttpSession session,SessionStatus sessionStatus) {
		session.invalidate();
		sessionStatus.setComplete();
		return "redirect:/index.jsp";
	}
}
