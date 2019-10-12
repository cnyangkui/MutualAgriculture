package com.geowind.hunong.util;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class DBHelper {

	private static DataSource dataSource;

	static {
		try { // Class.forName(DRIVER_CLASS_NAME);
			Properties props = new Properties();
			InputStream in = DBHelper.class.getClassLoader()
					.getResourceAsStream("db.properties");
			props.load(in);

			// 使用连接池技术，数据源DBCP
			dataSource = BasicDataSourceFactory.createDataSource(props);
			LogManager.logger.debug("加载数据库属性元素构建数据源成功");
		} catch (Exception e) {
			LogManager.logger.error("加载数据库属性元素构建数据源失败", e);
		}
	}

	/**
	 * 连接数据库
	 * 
	 * @return
	 */
	public static Connection getConn() {
		Connection con = null;
		try {
			con = dataSource.getConnection();
			LogManager.logger.debug("数据库连接成功");
		} catch (Exception e) {
			LogManager.logger.error("数据库连接失败", e);
		}
		return con;
	}


	/**
	 * 关闭数据库连接
	 * 
	 * @param con
	 * @param st
	 * @param rs
	 */
	public static void close(Connection con, Statement st, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
				LogManager.logger.debug("关闭结果集完成");
			} catch (SQLException e) {
				LogManager.logger.error("关闭结果集失败", e);
			}
		}

		if (st != null) {
			try {
				st.close();
				LogManager.logger.debug("关闭执行工具完成");
			} catch (SQLException e) {
				LogManager.logger.error("关闭执行工具失败", e);
			}
		}

		if (con != null) {
			try {
				con.close();
				LogManager.logger.debug("关闭数据库连接完成");
			} catch (SQLException e) {
				LogManager.logger.error("关闭数据库连接失败");
			}
		}
	}

	/**
	 * 增、删、改
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public static int doUpdate(String sql, Object... params) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = getConn();
			LogManager.logger.debug("要执行的sql语句:" + sql);
			ps = con.prepareStatement(sql);
			setParams(ps, params);
			LogManager.logger.debug("sql执行工具创建成功");
		} catch (SQLException e) {
			LogManager.logger.error("sql执行工具创建失败", e);
		}

		try {
			result = ps.executeUpdate();
			LogManager.logger.debug("处理数据成功，处理数据的条数为:" + result);
		} catch (SQLException e) {
			LogManager.logger.error("处理数据失败", e);
		} finally {
			close(con, ps, null);
		}
		return result;
	}

	/**
	 * 设置参数
	 * 
	 * @param ps
	 * @param params
	 */
	private static void setParams(PreparedStatement ps, Object... params) {

		if (params == null || params.length == 0) {
			return;
		}
		int flag = 0;
		try {
			for (int i = 0; i < params.length; i++) {
				flag = i + 1;
				Object obj = params[i];
				if(obj != null) {
					if (obj instanceof InputStream) {
						ps.setBinaryStream(i + 1, (InputStream) obj);
					} else {
						ps.setObject(i + 1, obj);
					}
				} else {
					ps.setObject(i + 1, obj);
				}
				
			}
		} catch (SQLException e) {
			LogManager.logger.error(String.format("注入第%d个值失败", flag), e);
		}

	}

	/**
	 * 查 单个
	 * 
	 * @param sql
	 * @param objs
	 * @return
	 */
	public static Map<String, Object> doQueryOne(String sql, Object... objs) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Map<String, Object> results = null;

		try {
			con = getConn();
			ps = con.prepareStatement(sql);
			setParams(ps, objs);
			LogManager.logger.debug("sql执行工具创建成功");
		} catch (SQLException e) {
			LogManager.logger.error("sql执行工具创建失败", e);
		}

		try {
			rs = ps.executeQuery();
			LogManager.logger.debug("执行sql取到返回数据成功");
		} catch (SQLException e) {
			LogManager.logger.error("执行sql取到返回数据失败", e);
		}

		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();

			if (rs.next()) {
				results = new HashMap<String, Object>();
				for (int i = 1; i <= columnCount; i++) {
					Object obj = rs.getObject(i);
					/*
					 * if(obj instanceof BLOB) { BLOB blob = (BLOB)
					 * rs.getBlob(i); obj = blob.getBinaryStream(); }
					 */
					results.put(rsmd.getColumnName(i).toLowerCase(), obj);
				}
			}
			LogManager.logger.debug("取出结果集数据完成");
		} catch (SQLException e) {
			LogManager.logger.error("取出结果集数据失败", e);
		} finally {
			close(con, ps, rs);
		}
		return results;
	}
	
	public static Map<String, Object> doQueryOne(String sql, List<Object> objs) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Map<String, Object> results = null;

		try {
			con = getConn();
			ps = con.prepareStatement(sql);
			setParams(ps, objs);
			LogManager.logger.debug("sql执行工具创建成功");
		} catch (SQLException e) {
			LogManager.logger.error("sql执行工具创建失败", e);
		}

		try {
			rs = ps.executeQuery();
			LogManager.logger.debug("执行sql取到返回数据成功");
		} catch (SQLException e) {
			LogManager.logger.error("执行sql取到返回数据失败", e);
		}

		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();

			if (rs.next()) {
				results = new HashMap<String, Object>();
				for (int i = 1; i <= columnCount; i++) {
					Object obj = rs.getObject(i);
					/*
					 * if(obj instanceof BLOB) { BLOB blob = (BLOB)
					 * rs.getBlob(i); obj = blob.getBinaryStream(); }
					 */
					results.put(rsmd.getColumnName(i).toLowerCase(), obj);
				}
			}
			LogManager.logger.debug("取出结果集数据完成");
		} catch (SQLException e) {
			LogManager.logger.error("取出结果集数据失败", e);
		} finally {
			close(con, ps, rs);
		}
		return results;
	}

	/**
	 * 查 多个
	 * 
	 * @param sql
	 * @param objs
	 * @return
	 */
	public static List<Map<String, Object>> doQuery(String sql, Object... objs) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Map<String, Object>> results = null;
		try {
			con = getConn();
			ps = con.prepareStatement(sql);
			setParams(ps, objs);
			LogManager.logger.debug("sql执行工具创建成功");
		} catch (SQLException e) {
			LogManager.logger.error("sql执行工具创建失败", e);
		}

		try {
			rs = ps.executeQuery();
			LogManager.logger.debug("执行sql取到返回数据成功");
		} catch (SQLException e) {
			LogManager.logger.error("执行sql取到返回数据失败", e);
		}

		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			results = new ArrayList<Map<String, Object>>();
			while (rs.next()) {
				Map<String, Object> record = new HashMap<String, Object>();

				for (int i = 1; i <= columnCount; i++) {
					Object obj = rs.getObject(i);
					/*
					 * if(obj instanceof BLOB) { BLOB blob = (BLOB)
					 * rs.getBlob(i); obj = blob.getBinaryStream(); }
					 */
					record.put(rsmd.getColumnName(i).toLowerCase(), obj);
					// record.put(rsmd.getColumnName(i).toLowerCase(),
					// rs.getObject(i));
				}
				results.add(record);
			}
			LogManager.logger.debug("取出结果集数据完成");
		} catch (SQLException e) {
			LogManager.logger.error("取出结果集数据失败", e);
		} finally {
			close(con, ps, rs);
		}
		return results;
	}
	
	public static List<Map<String, Object>> doQuery(String sql, List<Object> objs) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Map<String, Object>> results = null;
		try {
			con = getConn();
			ps = con.prepareStatement(sql);
			setParams(ps, objs);
			LogManager.logger.debug("sql执行工具创建成功");
		} catch (SQLException e) {
			LogManager.logger.error("sql执行工具创建失败", e);
		}

		try {
			rs = ps.executeQuery();
			LogManager.logger.debug("执行sql取到返回数据成功");
		} catch (SQLException e) {
			LogManager.logger.error("执行sql取到返回数据失败", e);
		}

		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			results = new ArrayList<Map<String, Object>>();
			while (rs.next()) {
				Map<String, Object> record = new HashMap<String, Object>();

				for (int i = 1; i <= columnCount; i++) {
					Object obj = rs.getObject(i);
					/*
					 * if(obj instanceof BLOB) { BLOB blob = (BLOB)
					 * rs.getBlob(i); obj = blob.getBinaryStream(); }
					 */
					record.put(rsmd.getColumnName(i).toLowerCase(), obj);
					// record.put(rsmd.getColumnName(i).toLowerCase(),
					// rs.getObject(i));
				}
				results.add(record);
			}
			LogManager.logger.debug("取出结果集数据完成");
		} catch (SQLException e) {
			LogManager.logger.error("取出结果集数据失败", e);
		} finally {
			close(con, ps, rs);
		}
		return results;
	}

	public static <T> List<T> find(String sql, Class<T> c, Object... objs) {
		List<T> list = new ArrayList<T>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = getConn();
			ps = con.prepareStatement(sql);
			setParams(ps, objs);
			LogManager.logger.debug("sql执行工具创建成功");
		} catch (SQLException e) {
			LogManager.logger.error("sql执行工具创建失败", e);
		}

		try {
			rs = ps.executeQuery();
			LogManager.logger.debug("执行sql取到返回数据成功");
		} catch (SQLException e) {
			LogManager.logger.error("执行sql取到返回数据失败", e);
		}

		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();

			// 获取返回结果集中每个列的列名，因为java对象中的注值是调用setter来实现的，所以我们需要知道这个列的值要往哪个属性里面注入
			String[] colNames = new String[columnCount];
			for (int i = 0; i < columnCount; i++) {
				colNames[i] = rsmd.getColumnName(i + 1);
			}
			// 获取给定类的所有的方法
			Method[] methods = c.getMethods();

			T t;
			String cname = null;
			String mname = null;
			String ctype = null;
			Object obj = null;
			String colname = null;
			while (rs.next()) {// 判断结果集是否还有数据（数据是一条记录的方式取出）
				// 每循环一次就是一条记录，每条记录对应一个对象，所为我们先实例化一个对象，以便注值
				t = c.newInstance();
				// 循环将每一个列的值注入到对应的属性中，那么此时我们先必须要找到对应的属性的setter方法
				for (int i = 0; i < columnCount; i++) {
					colname = colNames[i];
					cname = "set" + colname;
					if (methods != null && methods.length > 0) {
						for (Method md : methods) {
							// 取出当前循环的方法的方法名
							mname = md.getName();
							// 比较当前循环的方法名是否根cname相等
							if (cname.equalsIgnoreCase(mname)) {
								// 因为java类中的方法存在同名的情况，即有方法重载，我们必须限制参数类型来找到对应的方法进行注入
								obj = rs.getObject(colname);
								if (obj != null) {
									// 获取这个对象的数据类型
									ctype = obj.getClass().getSimpleName();
									if ("BigDecimal".equals(ctype)) {
										md.invoke(t, rs.getInt(colname));
									} else if ("Integer".equals(ctype)) {
										md.invoke(t, rs.getInt(colname));
									} else {
										md.invoke(t, rs.getString(colname));
									}
								} else {

								}
							}
						}
					}
				}
				list.add(t);
			}
			LogManager.logger.debug("取出结果集数据完成");
		} catch (Exception e) {
			LogManager.logger.error("取出结果集数据失败", e);
		} finally {
			close(con, ps, rs);
		}
		return list;
	}

	public static Map<String, String> find(String sql, Object... objs) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Map<String, String> results = null;

		try {
			con = getConn();
			ps = con.prepareStatement(sql);
			setParams(ps, objs);
			LogManager.logger.debug("sql执行工具创建成功");
		} catch (SQLException e) {
			LogManager.logger.error("sql执行工具创建失败", e);
		}

		try {
			rs = ps.executeQuery();
			LogManager.logger.debug("执行sql取到返回数据成功");
		} catch (SQLException e) {
			LogManager.logger.error("执行sql取到返回数据失败", e);
		}

		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();

			if (rs.next()) {
				results = new HashMap<String, String>();
				for (int i = 1; i <= columnCount; i++) {
					Object obj = rs.getObject(i);
					/*
					 * if(obj instanceof BLOB) { BLOB blob = (BLOB)
					 * rs.getBlob(i); obj = blob.getBinaryStream(); }
					 */
					results.put(rsmd.getColumnName(i).toLowerCase(),
							rs.getString(i));
				}
			}
			LogManager.logger.debug("取出结果集数据完成");
		} catch (SQLException e) {
			LogManager.logger.error("取出结果集数据失败", e);
		} finally {
			close(con, ps, rs);
		}
		return results;
	}

	private static void setParams(PreparedStatement ps, List<Object> params) {

		if (params == null || params.size() == 0) {
			return;
		}
		int flag = 0;
		try {
			for (int i = 0, len = params.size(); i < len; i++) {
				flag = i + 1;
				String paramType = params.get(i).getClass().getName();

				if(params.get(i)!= null ) {
					if (Integer.class.getName().equals(params)) {
						ps.setInt(i + 1, (int) params.get(i));
					} else if (Double.class.getName().equals(paramType)) {
						ps.setDouble(i + 1, (double) params.get(i));
					} else if (String.class.getName().equals(paramType)) {
						ps.setString(i + 1, (String) params.get(i));
					} else {
						ps.setObject(i + 1, params.get(i));
					}
				} else {
					ps.setObject(i + 1, params.get(i));
				}
				

			}
		} catch (SQLException e) {
			LogManager.logger.error(String.format("注入第%d个值失败", flag), e);
		}

	}
	
	public static <T> List<T> find(String sql, Class<T> c, List<Object> objs) {
		List<T> list = new ArrayList<T>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = getConn();
			ps = con.prepareStatement(sql);
			setParams(ps, objs);
			LogManager.logger.debug("sql执行工具创建成功");
		} catch (SQLException e) {
			LogManager.logger.error("sql执行工具创建失败", e);
		}

		try {
			rs = ps.executeQuery();
			LogManager.logger.debug("执行sql取到返回数据成功");
		} catch (SQLException e) {
			LogManager.logger.error("执行sql取到返回数据失败", e);
		}

		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();

			// 获取返回结果集中每个列的列名，因为java对象中的注值是调用setter来实现的，所以我们需要知道这个列的值要往哪个属性里面注入
			String[] colNames = new String[columnCount];
			for (int i = 0; i < columnCount; i++) {
				colNames[i] = rsmd.getColumnName(i + 1);
			}
			// 获取给定类的所有的方法
			Method[] methods = c.getMethods();

			T t;
			String cname = null;
			String mname = null;
			String ctype = null;
			Object obj = null;
			String colname = null;
			while (rs.next()) {// 判断结果集是否还有数据（数据是一条记录的方式取出）
				// 每循环一次就是一条记录，每条记录对应一个对象，所为我们先实例化一个对象，以便注值
				t = c.newInstance();
				// 循环将每一个列的值注入到对应的属性中，那么此时我们先必须要找到对应的属性的setter方法
				for (int i = 0; i < columnCount; i++) {
					colname = colNames[i];
					cname = "set" + colname;
					if (methods != null && methods.length > 0) {
						for (Method md : methods) {
							// 取出当前循环的方法的方法名
							mname = md.getName();
							// 比较当前循环的方法名是否根cname相等
							if (cname.equalsIgnoreCase(mname)) {
								// 因为java类中的方法存在同名的情况，即有方法重载，我们必须限制参数类型来找到对应的方法进行注入
								obj = rs.getObject(colname);
								if (obj != null) {
									// 获取这个对象的数据类型
									ctype = obj.getClass().getSimpleName();
									if ("BigDecimal".equals(ctype)) {
										md.invoke(t, rs.getInt(colname));
									} else if ("Integer".equals(ctype)) {
										md.invoke(t, rs.getInt(colname));
									} else {
										md.invoke(t, rs.getString(colname));
									}
								} else {

								}
							}
						}
					}
				}
				list.add(t);
			}
			LogManager.logger.debug("取出结果集数据完成");
		} catch (Exception e) {
			LogManager.logger.error("取出结果集数据失败", e);
		} finally {
			close(con, ps, rs);
		}
		return list;
	}
	
	
	public static Map<String, String> find(String sql, List<Object> objs) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Map<String, String> results = null;

		try {
			con = getConn();
			ps = con.prepareStatement(sql);
			setParams(ps, objs);
			LogManager.logger.debug("sql执行工具创建成功");
		} catch (SQLException e) {
			LogManager.logger.error("sql执行工具创建失败", e);
		}

		try {
			rs = ps.executeQuery();
			LogManager.logger.debug("执行sql取到返回数据成功");
		} catch (SQLException e) {
			LogManager.logger.error("执行sql取到返回数据失败", e);
		}

		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();

			if (rs.next()) {
				results = new HashMap<String, String>();
				for (int i = 1; i <= columnCount; i++) {
					Object obj = rs.getObject(i);
					/*
					 * if(obj instanceof BLOB) { BLOB blob = (BLOB)
					 * rs.getBlob(i); obj = blob.getBinaryStream(); }
					 */
					results.put(rsmd.getColumnName(i).toLowerCase(),
							rs.getString(i));
				}
			}
			LogManager.logger.debug("取出结果集数据完成");
		} catch (SQLException e) {
			LogManager.logger.error("取出结果集数据失败", e);
		} finally {
			close(con, ps, rs);
		}
		return results;
	}
}
