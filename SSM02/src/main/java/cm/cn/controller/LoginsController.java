package cm.cn.controller;

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

import cm.cn.dao.CommonDao;
import cm.cn.service.LoginService;


@Controller
@Scope("prototype")
public class LoginsController {
	@Resource(name="loginService")
	LoginService loginService;

	@RequestMapping(value= "/login",method =RequestMethod.GET )
	public String login1() {
		return "login";
	}

	@RequestMapping(value= "/login",method =RequestMethod.POST )
	@ResponseBody
	public String login2(@RequestParam Map map,HttpSession session) {
		Map map1 = (Map) loginService.find(map);
		//System.out.println(map);
		//System.out.println(map1);
		if((map1.get("count")+"").equals("1")) {
			session.setAttribute("username", map.get("username")+"");
			return "main";
		}else {
			return "error";
		}
	}
	
	@RequestMapping(value= "/re",method =RequestMethod.GET)
	public String re1() {
		return "re";
	}

	@RequestMapping(value= "/re",method =RequestMethod.POST)
	@ResponseBody
	public String re2(@RequestParam Map map) {
		//System.out.println(map);
		Integer i = (Integer) loginService.save(map);
		if(i>0) {
			return "login";
		}else {
			return "error";
		}
	}

	@RequestMapping(value= "/getName")
	@ResponseBody
	public String getName(HttpSession session) {

		String username=session.getAttribute("username")+"";
		//System.out.println(username);
		return username;
	}
}
