package cm.cn.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cm.cn.dao.LoginDao;
import cm.cn.service.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDao loginDao;

	@Override
	public Integer save(Object object) {
		// TODO Auto-generated method stub
				try {
					return loginDao.save(object);
				}catch (Exception e) {
					System.out.println("异常");
					return null;
				}
	}

	@Override
	public Integer upd(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer del(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object find(Map map) {
		// TODO Auto-generated method stub
		try {
			return loginDao.find(map);
		}catch (Exception e) {
			System.out.println("异常");
			return null;
		}
	}

	@Override
	public List<?> query(Map map) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
