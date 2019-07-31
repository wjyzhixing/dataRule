package com.tauk.datarule.util;

import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.sql.DataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * 
 * @author zyb_s
 *
 */

public class JDBCHelperForOracle {
	//durid数据源
	private static DataSource dataSource;
	
	static {
		try {
			 InputStream inputStream = JDBCHelperForOracle.class.getClassLoader().getResourceAsStream("source-jdbc.properties");
	         Properties properties = new Properties();
	         properties.load(inputStream);
	         dataSource = DruidDataSourceFactory.createDataSource(properties);
	         
		} catch (Exception e) {
			e.printStackTrace();  
		}
	}
	
	private static JDBCHelperForOracle instance = null;
	
	/**
	 * 获取单例
	 * @return 单例
	 */
	public static JDBCHelperForOracle getInstance() {
		if(instance == null) {
			synchronized(JDBCHelperForOracle.class) {
				if(instance == null) {
					instance = new JDBCHelperForOracle();
				}
			}
		}
		return instance;
	}
	

    public  Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

	public int executeUpdate(String sql, Object[] params) {
		int rtn = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			conn.setAutoCommit(false);  
			
			pstmt = conn.prepareStatement(sql);
			
			if(params != null && params.length > 0) {
				for(int i = 0; i < params.length; i++) {
					pstmt.setObject(i + 1, params[i]);  
				}
			}
			
			rtn = pstmt.executeUpdate();
			
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();  
		} finally {
			try {
					if(conn != null) {
						conn.close();
					}
					if(pstmt != null) {
						pstmt.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		return rtn;
	}
	
	/**
	 * 执行查询SQL语句
	 * @param sql
	 * @param params
	 * @param callback
	 */
	public void executeQuery(String sql, Object[] params, 
			QueryCallback callback) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			if(params != null && params.length > 0) {
				for(int i = 0; i < params.length; i++) {
					pstmt.setObject(i + 1, params[i]);   
				}
			}
			
			rs = pstmt.executeQuery();
			
			callback.process(rs);  
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				if(conn != null) {
					conn.close();
				}
				if(pstmt != null){
					pstmt.close();
				}
				if(rs != null){
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public int[] executeBatch(String sql, List<Object[]> paramsList) {
		int[] rtn = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			if(conn==null){
				return null;
			}
			
			// 第一步：使用Connection对象，取消自动提交
			conn.setAutoCommit(false);  
			
			pstmt = conn.prepareStatement(sql);
			
			// 第二步：使用PreparedStatement.addBatch()方法加入批量的SQL参数
			if(paramsList != null && paramsList.size() > 0) {
				for(Object[] params : paramsList) {
					for(int i = 0; i < params.length; i++) {
						pstmt.setObject(i + 1, params[i]);  
					}
					pstmt.addBatch();
				}
			}
			
			// 第三步：使用PreparedStatement.executeBatch()方法，执行批量的SQL语句
			rtn = pstmt.executeBatch();
			
			// 最后一步：使用Connection对象，提交批量的SQL语句
			conn.commit();
		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			if(e.getMessage()!= null &&e.getMessage().indexOf("ORA-01461")!=-1){
//				Object[] obj =paramsList.get(0);
//				System.out.println("cellcolumnnames="+obj[0]+"	cellvalue="+obj[1]+"	label="+obj[2]+"	cellcolumnnamecount"+obj[3]);
//			}
			e.printStackTrace();  
		} finally {
			try {
				if(conn != null) {
					conn.close();
				}
				if(pstmt != null){
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return rtn;
	}
	
	
	public int[] executeBatch(String sql, List<Object[]> paramsList,String[] dataType) {
		int[] rtn = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			// 第一步：使用Connection对象，取消自动提交
			conn.setAutoCommit(false);  
			
			pstmt = conn.prepareStatement(sql);
			// 第二步：使用PreparedStatement.addBatch()方法加入批量的SQL参数
			if(paramsList != null && paramsList.size() > 0) {
				for(Object[] params : paramsList) {
					for(int i = 0; i < params.length; i++) {
						if(dataType[i].equals("Clob")){
							String text = (String)params[i];
							Reader clobReader = new StringReader(text); // 将 text转成流形式 
							pstmt.setCharacterStream(i+1, clobReader, text.length());// 替换sql语句中的？ 
						}else{
							pstmt.setObject(i + 1, params[i]);  
						}
						
					}
					pstmt.addBatch();
				}
			}
			
			// 第三步：使用PreparedStatement.executeBatch()方法，执行批量的SQL语句
			rtn = pstmt.executeBatch();
			
			// 最后一步：使用Connection对象，提交批量的SQL语句
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();  
		} finally {
			try {
				if(conn != null) {
					conn.close();
				}
				if(pstmt != null){
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return rtn;
	}
	
	
	/**
	 * 
	 * @author zyb_s
	 *
	 */
	public static interface QueryCallback {
		
		/**
		 * 处理查询结果
		 * @param rs 
		 * @throws Exception
		 */
		void process(ResultSet rs) throws Exception;
		
	}
	
	
	public static void main(String args[]){
		 String sql = "INSERT INTO dl_datalabel(cellcolumnnamecount,vcellcolumnnames,cellvalue,label) "
   		         + " VALUES(?,?,?,?)";
	
	List<Object[]> paramsList = new ArrayList<Object[]>();
	
	String[] dataType = {"int","Clob","String","String"};
	
	Object[] params = new Object[]{10,"1、城西运维站王宝红告知：东岭变168铁信试运行满24小时，已申请纳入调管，重合闸已投入运行。</br>2、收到送变电工程公司线路三班刘琪编号为：2012-12-03一种工作票一张，工作内容：132酒厂线配合新5号钢管杆组立，时间：2012年12月29日8：00-12月29日18：00时；收到送变电工程公司线路二班伊建忠编号为：2012-12-12一种工作票一张，工作内容：3591南指挥线配合凤虢线60#-64#施工跨越，时间：2012年12月29日8：00-12月29日18：00时；收到送变电工程公司线路三班徐晨编号为：2012-12-01一种工作票一张，工作内容：128风水配合虢凤线施工跨越，时间：2012年12月29日8：00-12月29日18：00时；收到送变电工程公司线路三班张来忠编号为：2012-12-02一种工作票一张，工作内容：134纸板厂线配合凤虢线60#-64#施工跨越，新5#钢管杆组立，时间：2012年12月29日8：00-12月29日18：00时；收到送变电工程公司线路一班王宏斌编号为：2012-12-04一种工作票一张，工作内容：126郭店线配合虢凤线新5#钢管杆组立，时间：2012年12月29日8：00-12月29日18：00时。</br>3、收到送变电工程公司线路三班刘琪编号为：2012-12-06一种工作票一张，工作内容：132酒厂线配合新5号钢管杆组立，时间：2012年12月30日8：00-12月30日18：00时；收到送变电工程公司线路二班伊建忠编号为：2012-12-14一种工作票一张，工作内容：3591南指挥线配合凤虢线60#-64#施工跨越，时间：2012年12月30日8：00-12月30日18：00时；收到送变电工程公司线路三班徐晨编号为：2012-12-04一种工作票一张，工作内容：128风水配合虢凤线施工跨越，时间：2012年12月30日8：00-12月30日18：00时；收到送变电工程公司线路三班张来忠编号为：2012-12-05一种工作票一张，工作内容：134纸板厂线配合凤虢线60#-64#施工跨越，新5#钢管杆组立，时间：2012年12月30日8：00-12月30日18：00时；收到送变电工程公司线路一班王宏斌编号为：2012-12-05一种工作票一张，工作内容：126郭店线配合虢凤线新5#钢管杆组立，时间：2012年12月30日8：00-12月30日18：00时。</br>4、向城东运维站周健芳下达：B29号令 凤翔变 3592凤彪开关运行转冷备用。</br>5、城东运维站周健芳汇报：7：08 B29号令 凤翔变 3592凤彪开关运行转冷备用执行完毕。</br>6、向彪角变张永全下达：口令1 彪角变 拉开35926彪凤进线刀闸。</br>7、彪角变张永全汇报：7：10 口令1 彪角变 拉开35926彪凤进线刀闸执行完毕。</br>8、向彪角变张永全下达：口令2  彪角变 35926彪凤进线刀闸线路侧接地并挂标示牌一块。</br>9、彪角变张永全汇报：7：17 口令2  彪角变 35926彪凤进线刀闸线路侧接地并挂标示牌一块执行完毕。</br>10、向城北运维站周健芳下达：B30号令 凤翔变 3592凤彪线路侧接地并挂标示牌一块。</br>11、城北运维站周健芳汇报：7：19 B30号令 凤翔变 3592凤彪线路侧接地并挂标示牌一块执行完毕。</br>12、许可送变电工程公司线路一班罗双云2012-12-11号电力线路第一种工作票工作3592线配合虢凤线57-60号施工跨越可以开工，时间到今日20：00时。</br>13、眉县变10KV相电压、线电压，101开关、102开关遥测值为死值。</br>14、通知城东运维站万建平并汇报自动化班任颖：21：00眉县变10KV相电压、线电压，101开关、102开关遥测值为死值。任：主站设备无问题。</br>15、城东运维站万建平汇报：由于眉县变远动设备老化，影响眉县变10KV电压、101开关、102开关遥测值，不影响保护正常运行，属一般缺陷，无备品，明日再处理。","测试","bbbbbbbbb"};
	paramsList.add(params);
	
	JDBCHelperForOracle jdbcHelper = JDBCHelperForOracle.getInstance();
	jdbcHelper.executeBatch(sql, paramsList);
	}
	
}
