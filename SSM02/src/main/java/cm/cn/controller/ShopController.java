package cm.cn.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cm.cn.service.ShopService;
import cm.cn.service.UserService;
import net.sf.json.JSONObject;

@Controller
@Scope("prototype")
@RequestMapping("shop")
public class ShopController {
	@Autowired
	ShopService shopService;

	@RequestMapping(value= "/shop",method =RequestMethod.GET )
	public String shop1() {
		return "shop/shop";
	}

	@RequestMapping(value= "/shop",method =RequestMethod.POST )
	@ResponseBody
	public String shop2(@RequestParam Map map,HttpSession session) {
		Map m1 = (Map) shopService.find(map);
		String count = m1.get("count")+"";
		String pages =  map.get("page") ==null ? "0" : map.get("page").toString();
		String limit =  map.get("limit") ==null ? "10" : map.get("limit").toString();
		Integer page = (Integer.parseInt(pages)-1)*10;
		Map m2 = new HashMap();
		m2.put("page", page+"");
		m2.put("limit", limit+"");
		List<?> m3 = (List<?>) shopService.query(m2);
		Map mm = new HashMap();
		mm.put("count", count);
		mm.put("msg", "");
		mm.put("code", 0);
		mm.put("data", m3);
		JSONObject jsonObject = JSONObject.fromObject(mm);
        return jsonObject.toString();
		
	}
	
	@RequestMapping(value= "/add",method =RequestMethod.GET)
	public String add1() {
		
		return "shop/add";
	}
	
	@RequestMapping(value= "/add",method =RequestMethod.POST )
	@ResponseBody
	public String add2(@RequestParam Map map) {
		Integer i = shopService.save(map);
		
		//System.out.println(map);
			if(i!=0) {
				return "add";
		}else {
			return "error";
		}
	}
	
	@RequestMapping(value= "/update",method =RequestMethod.GET)
	public String update1() {
		
		return "shop/update";
	}
	
	@RequestMapping(value= "/update",method =RequestMethod.POST )
	@ResponseBody
	public String update2(@RequestParam Map map) {
		//System.out.println(map);
		Map m = new HashMap<>();
		m.put("map", map);
		//System.out.println(m);
		Integer i = shopService.upd(m);
			if(i!=0) {
				return "update";
		}else {
			return "error";
		}
	}
	
	@RequestMapping(value= "/delete",method =RequestMethod.GET)
	public String delete1() {
		
		return "shop/delete";
	}
	
	@RequestMapping(value= "/delete",method =RequestMethod.POST )
	@ResponseBody
	public String delete2(String data) {
		Map map = JSON.parseObject(data);
		Integer i = shopService.del(map);
			if(i!=0) {
				return "delete";
		}else {
			return "error";
		}
	}
}
