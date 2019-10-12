package com.geowind.hunong.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by Kui on 2016/7/23.
 */
public interface LibraryDao {

	public List<Map<String, Object>> selectTitle(int category, int begin);

	public List<Map<String, Object>> selectTitle(int begin);

}
