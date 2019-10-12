package com.geowind.hunong.util;

import static com.geowind.hunong.util.PathUtil.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.geowind.hunong.entity.ArticleSim;

public class DBHelperSim {

	// other
	private static List<ArticleSim> sqlExecute(String sql) {
		List<ArticleSim> res = new ArrayList<>();

		try {
			Connection conn = DBHelper.getConn();
			Statement stmt = conn.createStatement(); // 创建Statement对象
			// System.out.println("成功连接到数据库！");
			// System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);// 创建数据对象
			while (rs.next()) {

				String id = rs.getString("articleId");
				// System.out.println(id_list.size());
				String title = rs.getString("title");
				String url = "http://" + ServerIP + ":8080/MutualAgriculture/LibraryHTML/" + id + ".html";
				String summary = rs.getString("summary");
				String imgUrl = "http://" + ServerIP + ":8080" + Lib_PictureURL+ rs.getString("imgUrl");
				res.add(new ArticleSim(id, title, summary, url,imgUrl));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public static List<ArticleSim> GetArticleSimUseSql(String sql) {

		return sqlExecute(sql);
	}
	// public static void main(String[] args) {
	// List<String> list = GetIdBykeyword("我是","select * from article where
	// keyword like '" + "%我是关键字" + "'");
	// System.out.println(list.get(0));
	// }

}
