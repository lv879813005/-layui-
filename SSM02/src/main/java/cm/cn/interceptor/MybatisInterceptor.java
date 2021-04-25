package cm.cn.interceptor;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.xml.bind.PropertyException;

import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.executor.ExecutorException;
import org.apache.ibatis.executor.statement.BaseStatementHandler;
import org.apache.ibatis.executor.statement.PreparedStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;

import cm.cn.util.ReflectHelper;



/**
 * @author xing
 * 2019年9月24日下午10:31:45
 * Mybatis的拦截器这里做sql处理
 * 写入参数配置什么情况下被拦截
 */
@Intercepts({@Signature(type=StatementHandler.class,method="prepare",args={Connection.class,Integer.class})})
public class MybatisInterceptor  implements Interceptor {
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
				RoutingStatementHandler rsh=(RoutingStatementHandler)invocation.getTarget();
				BaseStatementHandler delegate = (BaseStatementHandler) ReflectHelper.getValueByFieldName(rsh, "delegate");
				MappedStatement mappedStatement = (MappedStatement) ReflectHelper.getValueByFieldName(delegate, "mappedStatement");	
				String id=mappedStatement.getId().toString();
				BoundSql boundSql = delegate.getBoundSql();
				Map map = (Map) rsh.getParameterHandler().getParameterObject();
//				if(id.substring(id.lastIndexOf(".")+1, id.length()).equals("query")) {
//					Integer limit =  (Integer.valueOf(map.get("limit")==null ? "10" : map.get("limit").toString()));
//					Integer page = (Integer.valueOf(map.get("page")==null ? "1" : map.get("page").toString())-1)*limit;
//					ReflectHelper.setValueByFieldName(boundSql, "sql", rsh.getBoundSql().getSql()+ " limit "+page+","+limit); 
//				}
				System.out.println("执行的sql："+rsh.getBoundSql().getSql());
				System.out.println("method："+id.substring(id.lastIndexOf(".")+1, id.length()));
				System.out.println("这是我获取的xml执行的id："+id);
				Object parameterObject = boundSql.getParameterObject();
				//修改提交的sql语句
				return invocation.proceed();
	}

	@Override
	public Object plugin(Object arg0) {
		return Plugin.wrap(arg0,this);
	}

	@Override
	public void setProperties(Properties properties) {
		String dbname = properties.getProperty("dbname")+"";
		String version = properties.getProperty("version")+"";
		System.out.println(dbname+"--------------,-------------"+version);
	}
}