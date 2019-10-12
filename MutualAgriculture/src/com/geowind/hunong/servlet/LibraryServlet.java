package com.geowind.hunong.servlet;

import static com.geowind.hunong.util.PathUtil.APageOfTable_N;
import static com.geowind.hunong.util.PathUtil.ArticleBeginId;
import static com.geowind.hunong.util.PathUtil.ArticleEndId;
import static com.geowind.hunong.util.PathUtil.ServerIP;
import static com.geowind.hunong.util.PathUtil.TabBegin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geowind.hunong.entity.ArticleSim;
import com.geowind.hunong.util.DBHelperSim;
import com.geowind.hunong.util.LibraryKeywordSearch;
import com.google.gson.Gson;

/**
 * Servlet implementation class LibraryServlet
 */
public class LibraryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String method = null;
		try {
			method = request.getParameter("method");
			if (method.equals("searchLib")) {
				SearchMethod(request, response);
			} else if (method.equals("getArticles")) {
				GetArticlesMethod(request, response);
			} else {
				return;
			}
		} catch (NullPointerException e) {
			return;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void SearchMethod(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String keyword = request.getParameter("keyword");
//		System.out.println("library serlvet op=" + keyword);
		// String keyword = request.getParameter("keyword");
		List<ArticleSim> ArticleMeg = LibraryKeywordSearch.GetMatchArticlesURL(keyword);
		for (int i = 0; i < ArticleMeg.size(); i++) {
			ArticleSim now = ArticleMeg.get(i);
			now.url = "http://" + ServerIP + ":8080/MutualAgriculture/LibraryHTML/" + now.id + ".html";
		}
		// System.out.println("IP="+ServerIP);
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		String msg = gson.toJson(ArticleMeg);

		out.print(msg);
		out.flush();
		out.close();
	}

	// 辅助搜索，由于在分页搜索按条件搜索时可能会出现或不足的情况，需要向后延续。
	// 记录当前向后延续到了哪里,并从那里继续往下查找
	private int[] beginOfSearch = new int[9];
	private boolean isFirstGet = true;

	private void GetArticlesMethod(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String category = request.getParameter("category");
		String nowPage = request.getParameter("nowPage");

		// 10001 10010
		int type = Integer.parseInt(category); // 需要查的文章类别
		int pagN = Integer.parseInt(nowPage); // 当前分页数目

		// 如果当前分页是第一页（即第0页),对当前类别给定初始值。
		if (isFirstGet) {
			for (int i = 0; i < 9; i++)
				beginOfSearch[i] = ArticleBeginId;
			isFirstGet = false;
		}
		if (pagN == TabBegin) {
			beginOfSearch[type] = ArticleBeginId;
		}

		List<ArticleSim> res = new ArrayList<>();

		while (res.size() < APageOfTable_N && beginOfSearch[type] <= ArticleEndId) {

			int begin_page = beginOfSearch[type];
			int end_page = begin_page + (APageOfTable_N - res.size()) - 1;
			beginOfSearch[type] = end_page + 1;

			String sql = "select * from article ";
			if (category.equals("0")) {
				sql += "where articleId between " + begin_page + " and " + end_page;
			} else {
				sql += "where classification=1" + category + " and articleId between " + begin_page + " and "
						+ end_page;
			}

			res.addAll(DBHelperSim.GetArticleSimUseSql(sql));
		}

		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		String msg = gson.toJson(res);

		out.print(msg);
		out.flush();
		out.close();
	}

}
