package cm.cn.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import cm.cn.service.LoginService;


@Controller
@Scope("prototype")
public class MainController {

	@RequestMapping("/main")
	public String toMain() {
		return "main";
	}
	
	@RequestMapping("/exit")
	public String exit(HttpSession session,HttpServletResponse response) {
		session.invalidate();	//注销
		/*try {
			response.sendRedirect("login");			//也是重定向 但是返回值写null
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return "redirect:login";		//重定向
	}
	
}
