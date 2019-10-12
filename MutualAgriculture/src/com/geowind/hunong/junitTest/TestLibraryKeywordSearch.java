package com.geowind.hunong.junitTest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.geowind.hunong.entity.ArticleSim;
import com.geowind.hunong.util.LibraryKeywordSearch;

public class TestLibraryKeywordSearch {

	String[] keyword = { "我", "我的", "我是", "我是关键字" };
	int[] listLen = { 1, 0, 1, 1 };

	@Before
	public void init() {

	}

	@Test
	public void test() {

		System.out.println(keyword.length);
		List<ArticleSim> res = LibraryKeywordSearch.GetMatchArticlesURL("红萝卜");
		System.out.println(res.get(0).imgURL);
		assertEquals(listLen[1], res.size());
	}

}
