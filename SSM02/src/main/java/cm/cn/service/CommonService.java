package cm.cn.service;

import java.util.List;
import java.util.Map;

public interface CommonService {

	public Integer save(Object object);

	public Integer upd(Object object);

	public Integer del(Object object);
	
	public  Object  find(Map map);

	public  List<?> query(Map map);
	
}
