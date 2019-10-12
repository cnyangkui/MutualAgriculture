package com.geowind.hunong.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.geowind.hunong.entity.ArticleSim;

public class LibraryKeywordSearch {

	public static List<String> ClearRepeatString(List<String> list) {
		Set<String> set = new TreeSet<>();
		List<String> res = new ArrayList<>();

		for (String string : list) {
			set.add(string);
		}
		for (String string : set) {
			res.add(string);
		}
		return res;
	}

	private static List<ArticleSim> ClearRepeatArticleSim(List<ArticleSim> list) {
		Set<String> set = new TreeSet<>();
		List<ArticleSim> res = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			ArticleSim n = list.get(i);
			if (!set.contains(n.id)) {
				set.add(n.id);
				res.add(n);
			}
		}
		return res;
	}

	public static List<ArticleSim> SearchMatchArticles(String keyword) {
		List<ArticleSim> res = new ArrayList<>();

		String sql = "select * from article where keyword='" + keyword + "'";
//		System.out.println(sql);
		res = DBHelperSim.GetArticleSimUseSql(sql);// 第一遍查询

		sql = "select * from article where keyword like '" + keyword + "%" + "'";
		res.addAll(DBHelperSim.GetArticleSimUseSql(sql));// 第一遍查询

		sql = "select * from article where keyword like '" + "%" + keyword + "%" + "'";
		res.addAll(DBHelperSim.GetArticleSimUseSql(sql));// 第一遍查询

		res = ClearRepeatArticleSim(res);

//		System.out.println("size = " + res.size());
		// System.out.println("article的长度="+_article.size());
		// 反向查询
		/********* 暂时先不写 ********/
		// 推荐查询
		/********* 暂时先不写 ********/

		return res;
	}

	// 这个方法获得html的url
	public static List<ArticleSim> GetMatchArticlesURL(String keyword) {
		return SearchMatchArticles(keyword);
	}
	
}
