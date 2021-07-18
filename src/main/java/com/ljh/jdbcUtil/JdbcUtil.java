package com.ljh.jdbcUtil;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
/**
 * @author 123
 *@category  ������ 
 */

//�������ļ��Ļ��������������ӹ���(Ϊ�����ֶ�����������ҵ����ϣ���
public class JdbcUtil {
	private static Properties pp = new Properties();       
	private static InputStream is = null;
	
	//�����Ӷ��󱣴浽��ǰ�߳��У�������ӱ���ǰ�̹߳���
	private static ThreadLocal<Connection> tol = new ThreadLocal<>();
	
	static {
		is = JdbcUtil.class.getResourceAsStream("/jdbc.properties");
		try {
			pp.load(is);	//��key-value��ʽ���ļ�������
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			try {
				is.close();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		
	}
	
	//�������� --- ����ֻ����һ�Σ��޸��������ļ��޸�
	public static Connection getCon() throws Exception {
		//1����������
		Class.forName(pp.getProperty("driver"));	//д�������ļ���
		//2,��������		
		String url = pp.getProperty("url");
		String user = pp.getProperty("user");
		String password = pp.getProperty("password");
		
		////��threadLocal����֤һ����û������ ���û���򴴽� �� ��ֱ�ӷ���
		Connection conn = tol.get();	//�ȴ��߳���ȡֵ�ж���û������������
		if(conn == null) {	//��������ڴ������ӣ��������ø��������Ϊ�������
		conn = DriverManager.getConnection(url, user, password);
		tol.set(conn);
		}
		return conn;
	}
	//�ر���Դ��--DQL
	public static void close(Connection conn,PreparedStatement pstmt,ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(conn != null) {
				conn.close();
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//�ر���Դ��--DML
	public static void close(Connection conn,PreparedStatement pstmt) {
		try {
			if(pstmt != null) {
				pstmt.close();
			}
			if(conn != null) {
				conn.close();
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//���DML���ķ�װ
	/*��������
	 * �������Ͷ���
	 * �жϷ��͵Ķ���Ϊ��Ϊ��
	 * ��Ϊ�նԿɱ�α���
	 * �󶨲���
	 * �ý��������
	 */
	public static void updateEmp(String sql, Object...obj) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = JdbcUtil.getCon();
			pstmt = conn.prepareStatement(sql);
			//��
			for(int i = 0; i<obj.length; i++) {
				//ռλ���Ǵ�1��ʼ     �����Ǵ�0��ʼ
				pstmt.setObject(i+1, obj[i]);
			}
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt);
	}	}
}
