package cm.cn.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface CommonDao {
	
	public Integer save(Object object);

	public Integer upd(Object object);

	public Integer del(Object object);
	
	public  Object  find(Map map);

	public  List<?> query(Map map);

	
}
