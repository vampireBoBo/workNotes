package com.beijia.mapper;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.beijia.bean.ColumnBean;
import com.beijia.bean.DatabaseBean;
import com.beijia.bean.TableBean;

public class BaseDao {

	private Connection conn;
	private DatabaseMetaData dbMetaData;
	private ResultSet tbrs;
	private ResultSet colrs;
	private DatabaseBean db;
	
	public BaseDao(DatabaseBean db){
		this.db = db;
	}

	/**
	 * 得到connection
	 * 
	 * @return
	 */
	public Connection getConn() {
		try {
			Class.forName(db.getClassName());
			try {
				System.out.println(db.getUri()+db.getDatabase()+db.getUserName()+db.getPassWord());
				conn = DriverManager
						.getConnection(db.getUri()+db.getDatabase(),db.getUserName(),db.getPassWord());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 拿到所有表数据，以及表中的列数据
	 * */
	public static List<TableBean> getAllMetaData(DatabaseBean db){
		BaseDao dao = new BaseDao(db);
		List<TableBean> tbs = null;
		try{
			dao.getConn();
			dao.dbMetaData = dao.conn.getMetaData();
			dao.tbrs = dao.dbMetaData.getTables(null, "%", "%", new String[]{"TABLE","VIEW"});
			tbs = new ArrayList<TableBean>();
			while(dao.tbrs.next()){
				TableBean tb = new TableBean();
				tb.setDbName(dao.tbrs.getString("TABLE_CAT"));
				tb.setDomainName(dao.tbrs.getString("TABLE_SCHEM"));
				tb.setTableName(dao.tbrs.getString("TABLE_NAME"));
				dao.colrs = dao.dbMetaData.getColumns(null, "%", tb.getTableName(), "%");
				List<ColumnBean> tbCols = new ArrayList<ColumnBean>();
				try{
					while(dao.colrs.next()){
						ColumnBean cb = new ColumnBean();
						cb.setColName(dao.colrs.getString("COLUMN_NAME"));
						cb.setColType(dao.colrs.getString("TYPE_NAME"));
						cb.setDataSize(dao.colrs.getInt("COLUMN_SIZE"));
						cb.setDigits(dao.colrs.getInt("DECIMAL_DIGITS"));
						cb.setNullable(dao.colrs.getInt("NULLABLE"));
						tbCols.add(cb);
					}
				}finally{
					if (dao.colrs != null) {
						dao.colrs.close();
					}
				}
				tb.setColumns(tbCols);
				tbs.add(tb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dao.closeAll();	
		}
		return tbs;
	}
	
	/**
	 * 根据表名，从指定数据库中拿到表信息
	 * */
	public static TableBean getMetaData(String tableName,DatabaseBean db){
		BaseDao dao = new BaseDao(db);
		TableBean tb = new TableBean();
		try{
			dao.getConn();
			dao.dbMetaData = dao.conn.getMetaData();
			dao.tbrs = dao.dbMetaData.getTables(null, "%", tableName, new String[]{"TABLE","VIEW"});
			if(dao.tbrs.next()){
				tb.setDbName(dao.tbrs.getString("TABLE_CAT"));
				tb.setDomainName(dao.tbrs.getString("TABLE_SCHEM"));
				tb.setTableName(dao.tbrs.getString("TABLE_NAME"));
				dao.colrs = dao.dbMetaData.getColumns(null, "%", tb.getTableName(), "%");
				List<ColumnBean> tbCols = new ArrayList<ColumnBean>();
				try{
					while(dao.colrs.next()){
						ColumnBean cb = new ColumnBean();
						cb.setColName(dao.colrs.getString("COLUMN_NAME"));
						cb.setColType(dao.colrs.getString("TYPE_NAME"));
						cb.setDataSize(dao.colrs.getInt("COLUMN_SIZE"));
						cb.setDigits(dao.colrs.getInt("DECIMAL_DIGITS"));
						cb.setNullable(dao.colrs.getInt("NULLABLE"));
						tbCols.add(cb);
					}
				}finally{
					if (dao.colrs != null) {
						dao.colrs.close();
					}
				}
				tb.setColumns(tbCols);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dao.closeAll();	
		}
		return tb;
	}


	/**
	 * 关闭连接
	 */
	public void closeAll() {
		try {
			if (tbrs != null) {
				tbrs.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}