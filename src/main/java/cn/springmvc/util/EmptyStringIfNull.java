package cn.springmvc.util;

/**
 * @(#)EmptyStringIfNull.java 1.0 2015年7月27日
 * @Copyright: Copyright 2010 - 2015 ISoftstone Co. Ltd. All Rights Reserved.
 * @Modification History:
 * @version: HYOM 1.0
 * @Date: 2015年7月27日
 * @Description: (Initialize)
 * @Reviewer:
 * @Review Date:
 */

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

/**
 * Mybatis在使用resultMap来映射查询结果中的列，如果查询结果中包含空值的列(不是null)，则Mybatis在映射的时候，不会映射这个字段
 * 
 * @author zzwang 74572
 */
public class EmptyStringIfNull implements TypeHandler<String> {
	public String getResult(ResultSet rs, String columnName)
			throws SQLException {
		return (rs.getString(columnName) == null) ? "" : rs
				.getString(columnName);
	}

	public String getResult(ResultSet rs, int columnIndex) throws SQLException {
		return (rs.getString(columnIndex) == null) ? "" : rs
				.getString(columnIndex);
	}

	public String getResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		return (cs.getString(columnIndex) == null) ? "" : cs
				.getString(columnIndex);
	}

	public void setParameter(PreparedStatement ps, int i, String parameter,
			JdbcType jdbcType) throws SQLException {
		ps.setString(i, parameter);
	}

}
