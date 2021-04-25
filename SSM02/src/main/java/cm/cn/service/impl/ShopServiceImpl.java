package cm.cn.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cm.cn.dao.ShopDao;
import cm.cn.dao.UserDao;
import cm.cn.service.ShopService;
@Service("shopService")
public class ShopServiceImpl implements ShopService {
	@Autowired
	private ShopDao shopDao;
	@Override
	public Integer save(Object object) {
		// TODO Auto-generated method stub
		try {
			return shopDao.save(object);
		}catch (Exception e) {
			System.out.println("异常");
			return null;
		}
	}

	@Override
	public Integer upd(Object object) {
		// TODO Auto-generated method stub
		try {
			return shopDao.upd(object);
		}catch (Exception e) {
			System.out.println("异常");
			return null;
		}
	}

	@Override
	public Integer del(Object object) {
		// TODO Auto-generated method stub
		try {
			return shopDao.del(object);
		}catch (Exception e) {
			System.out.println("异常");
			return null;
		}
	}

	@Override
	public Object find(Map map) {
		// TODO Auto-generated method stub
		try {
			return shopDao.find(map);
		}catch (Exception e) {
			System.out.println("异常");
			return null;
		}
	}

	@Override
	public List<?> query(Map map) {
		// TODO Auto-generated method stub
		try {
			return shopDao.query(map);
		}catch (Exception e) {
			System.out.println("异常");
			return null;
		}
	}

}
