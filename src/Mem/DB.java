//package Mem;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class DB {
//	Connection connection;
//	String oracle_url;
//	String user_id;
//	String user_password;
//
//	public DB() {
//		this.oracle_url = "jdbc:oracle:thin:@localhost:1521:xe";
//		this.user_id = "membership";
//		this.user_password = "membership";
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//			System.out.println("JDBC 드라이버가 존재하지 않음.");
//		}
//		try {
//			this.connection = DriverManager.getConnection(this.oracle_url, this.user_id, this.user_password);
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("DB 연결실패.");
//		}
//	}
//
//	public void insert_sql(String mem_id, String mem_pw, String mem_name, int mem_birth, String mem_nik,
//			String mem_email, String mem_call, String mem_cell, String mem_live) {
//		String query = "INSERT INTO MEMBERSHIP(MEM_ID,MEM_PW,MEM_NAME,MEM_BIRTH,MEM_NIK,MEM_EMAIL,MEM_CALL,MEM_CELL,MEM_LIVE) VALUES(?,?,?,?,?,?,?,?,?)";
//		PreparedStatement preparedStatement = null;
//		try {
//			this.connection = DriverManager.getConnection(this.oracle_url, this.user_id, this.user_password);
//			preparedStatement = this.connection.prepareStatement(query);
//			preparedStatement.setString(1, mem_id);
//			preparedStatement.setString(2, mem_pw);
//			preparedStatement.setString(3, mem_name);
//			preparedStatement.setInt(4, mem_birth);
//			preparedStatement.setString(5, mem_nik);
//			preparedStatement.setString(6, mem_email);
//			preparedStatement.setString(7, mem_call);
//			preparedStatement.setString(8, mem_cell);
//			preparedStatement.setString(9, mem_live);
//			preparedStatement.executeUpdate();
//			preparedStatement.close();
//			this.connection.close();
//			System.out.println("회원가입이 완료되었습니다.\n");
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println(
//					"-----------------------------------------------------------------------------------------");
//			System.out.println("회원가입에 실패했습니다.");
//		}
//	}
//
//	public boolean check_sql(String str1, int num) {
//		String query = "SELECT * FROM MEMBERSHIP";
//		try {
//			this.connection = DriverManager.getConnection(this.oracle_url, this.user_id, this.user_password);
//			Statement statement = this.connection.createStatement();
//			ResultSet result_set = statement.executeQuery(query);
//			while (result_set.next()) {
//				if (str1.equals(result_set.getString(num))) {
//					return true;
//				}
//			}
//			result_set.close();
//			statement.close();
//			this.connection.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
//
//	public void browse_sql(String search) {
//		String query = "SELECT * FROM MEMBERSHIP";
//		try {
//			this.connection = DriverManager.getConnection(this.oracle_url, this.user_id, this.user_password);
//			Statement statement = this.connection.createStatement();
//			ResultSet result_set = statement.executeQuery(query);
//			while (result_set.next()) {
//				if (search.equals(result_set.getString(1))) {
//					System.out.print("아이디: " + result_set.getString(1) + "\n");
//					System.out.print("비밀번호: " + result_set.getString(2) + "\n");
//					System.out.print("성명: " + result_set.getString(3) + "\n");
//					System.out.print("생년월일: " + result_set.getInt(4) + "\n");
//					System.out.print("닉네임: " + result_set.getString(5) + "\n");
//					System.out.print("이메일: " + result_set.getString(6) + "\n");
//					System.out.print("전화번호: " + result_set.getInt(7) + "\n");
//					System.out.print("휴대폰번호: " + result_set.getInt(8) + "\n");
//					System.out.print("주소: " + result_set.getString(9) + "\n\n");
//				}
//			}
//			result_set.close();
//			statement.close();
//			this.connection.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("회원검색을 실패했습니다.");
//		}
//	}
//
//	public void delete_sql(String delete) {
//		String query = "DELETE FROM Membership WHERE MEM_ID = ? ";
//		PreparedStatement preparedStatement = null;
//		try {
//			this.connection = DriverManager.getConnection(this.oracle_url, this.user_id, this.user_password);
//			preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setString(1, delete);
//			int drop = preparedStatement.executeUpdate();
//			if (drop > 0) {
//				System.out.println("회원삭제를 성공했습니다.");
//			} else {
//				System.out.println("회원삭제에 실패했습니다.");
//			}
//
//			preparedStatement.close();
//			this.connection.close();
//		} catch (Exception e) {
//			System.out.println("회원삭제에 실패했습니다.");
//			e.printStackTrace();
//		}
//	}
//
//	public void print_sql() {
//		String query = "SELECT * FROM MEMBERSHIP";
//		try {
//			this.connection = DriverManager.getConnection(this.oracle_url, this.user_id, this.user_password);
//			Statement statement = this.connection.createStatement();
//			ResultSet result_set = statement.executeQuery(query);
//			while (result_set.next()) {
//				System.out.print("아이디: " + result_set.getString(1) + "\n");
//				System.out.print("비밀번호: " + result_set.getString(2) + "\n");
//				System.out.print("성명: " + result_set.getString(3) + "\n");
//				System.out.print("생년월일: " + result_set.getInt(4) + "\n");
//				System.out.print("닉네임: " + result_set.getString(5) + "\n");
//				System.out.print("이메일: " + result_set.getString(6) + "\n");
//				System.out.print("전화번호: " + result_set.getInt(7) + "\n");
//				System.out.print("휴대폰번호: " + result_set.getInt(8) + "\n");
//				System.out.print("주소: " + result_set.getString(9) + "\n\n");
//			}
//			result_set.close();
//			statement.close();
//			this.connection.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("회원목록 출력을 실패했습니다.");
//		}
//	}
//}

package Mem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	Connection connection;
	String oracle_url;
	String user_id;
	String user_password;

	public DB() {
		this.oracle_url = "jdbc:oracle:thin:@localhost:1521:xe";
		this.user_id = "membership";
		this.user_password = "membership";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("JDBC 드라이버가 존재하지 않음.");
		}
		try {
			this.connection = DriverManager.getConnection(this.oracle_url, this.user_id, this.user_password);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DB 연결실패.");
		}
	}

	public void insert_sql(String mem_id, String mem_pw, String mem_name, String mem_birth, String mem_day,
			String mem_nik, String mem_email, String mem_call, String mem_cell, String mem_live) {
		String query = "INSERT INTO MEMBERSHIP(MEM_ID,MEM_PW,MEM_NAME,MEM_BIRTH,MEM_NIK,MEM_EMAIL,MEM_CALL,MEM_CELL,MEM_LIVE) VALUES(?,?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = null;
		try {
			this.connection = DriverManager.getConnection(this.oracle_url, this.user_id, this.user_password);
			preparedStatement = this.connection.prepareStatement(query);
			preparedStatement.setString(1, mem_id);
			preparedStatement.setString(2, mem_pw);
			preparedStatement.setString(3, mem_name);
			preparedStatement.setString(4, mem_birth + mem_day);
			preparedStatement.setString(5, mem_nik);
			preparedStatement.setString(6, mem_email);
			preparedStatement.setString(7, mem_call);
			preparedStatement.setString(8, mem_cell);
			preparedStatement.setString(9, mem_live);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			this.connection.close();
			System.out.println("회원가입이 완료되었습니다.\n");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(
					"-----------------------------------------------------------------------------------------");
			System.out.println("회원가입에 실패했습니다.");
		}
	}

	public boolean id_check_sql(String str1) {
		String query = "SELECT * FROM MEMBERSHIP";
		try {
			this.connection = DriverManager.getConnection(this.oracle_url, this.user_id, this.user_password);
			Statement statement = this.connection.createStatement();
			ResultSet result_set = statement.executeQuery(query);
			while (result_set.next()) {
				if (str1.equals(result_set.getString(1)) == false) {
					break;
				} else {
					System.out.println("이미 사용중인 아이디입니다.");
					return true;
				}
			}
			result_set.close();
			statement.close();
			this.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("잘못된 입력입니다.");
			return true;
		}
		return false;
	}

	public boolean pw_check_sql(String str2) {
		String query = "SELECT * FROM MEMBERSHIP";
		try {
			this.connection = DriverManager.getConnection(this.oracle_url, this.user_id, this.user_password);
			Statement statement = this.connection.createStatement();
			ResultSet result_set = statement.executeQuery(query);
			while (result_set.next()) {
				if (str2.equals(result_set.getString(2)) == false) {
					break;
				} else {
					System.out.println("이미 사용중인 비밀번호입니다.");
					return true;

				}
			}
			result_set.close();
			statement.close();
			this.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("잘못된 입력입니다.");
			return true;
		}
		return false;
	}

	public boolean nik_check_sql(String str4) {
		String query = "SELECT * FROM MEMBERSHIP";
		try {
			this.connection = DriverManager.getConnection(this.oracle_url, this.user_id, this.user_password);
			Statement statement = this.connection.createStatement();
			ResultSet result_set = statement.executeQuery(query);
			while (result_set.next()) {
				if (str4.equals(result_set.getString(5)) == false) {
					break;
				} else {
					System.out.println("이미 사용중인 닉네임입니다.");
					return true;

				}
			}
			result_set.close();
			statement.close();
			this.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("잘못된 입력입니다.");
			return true;
		}
		return false;
	}

	public boolean email_check_sql(String str5) {
		String query = "SELECT * FROM MEMBERSHIP";
		try {
			this.connection = DriverManager.getConnection(this.oracle_url, this.user_id, this.user_password);
			Statement statement = this.connection.createStatement();
			ResultSet result_set = statement.executeQuery(query);
			while (result_set.next()) {
				if (str5.equals(result_set.getString(6)) == false) {
					break;
				} else {
					System.out.println("이미 사용중인 이메일입니다.");
					return true;

				}
			}
			result_set.close();
			statement.close();
			this.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("잘못된 입력입니다.");
			return true;
		}
		return false;
	}

	public boolean call_check_sql(String call) {
		String query = "SELECT * FROM MEMBERSHIP";
		try {
			this.connection = DriverManager.getConnection(this.oracle_url, this.user_id, this.user_password);
			Statement statement = this.connection.createStatement();
			ResultSet result_set = statement.executeQuery(query);
			while (result_set.next()) {
				if (call.equals(result_set.getString(7)) == false) {
					break;
				} else {
					System.out.println("이미 사용중인 전화번호입니다.");
					return true;

				}
			}
			result_set.close();
			statement.close();
			this.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("잘못된 입력입니다.");
			return true;
		}
		return false;
	}

	public boolean cell_check_sql(String cell) {
		String query = "SELECT * FROM MEMBERSHIP";
		try {
			this.connection = DriverManager.getConnection(this.oracle_url, this.user_id, this.user_password);
			Statement statement = this.connection.createStatement();
			ResultSet result_set = statement.executeQuery(query);
			while (result_set.next()) {
				if (cell.equals(result_set.getString(8)) == false) {
					break;
				} else {
					System.out.println("이미 사용중인 휴대폰번호입니다.");
					return true;

				}
			}
			result_set.close();
			statement.close();
			this.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("잘못된 입력입니다.");
			return true;
		}
		return false;
	}

	public void browse_sql(String search) {
		String query = "SELECT * FROM MEMBERSHIP";
		try {
			this.connection = DriverManager.getConnection(this.oracle_url, this.user_id, this.user_password);
			Statement statement = this.connection.createStatement();
			ResultSet result_set = statement.executeQuery(query);
			while (result_set.next()) {
				if (search.equals(result_set.getString(1))) {
					System.out.print("아이디: " + result_set.getString(1) + "\n");
					System.out.print("비밀번호: " + result_set.getString(2) + "\n");
					System.out.print("성명: " + result_set.getString(3) + "\n");
					System.out.print("생년월일: " + result_set.getInt(4) + "\n");
					System.out.print("닉네임: " + result_set.getString(5) + "\n");
					System.out.print("이메일: " + result_set.getString(6) + "\n");
					System.out.print("전화번호: " + result_set.getString(7) + "\n");
					System.out.print("휴대폰번호: " + result_set.getString(8) + "\n");
					System.out.print("주소: " + result_set.getString(9) + "\n\n");
				}
			}
			result_set.close();
			statement.close();
			this.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("회원검색을 실패했습니다.");
		}
	}

	public void delete_sql(String delete) {
		String query = "DELETE FROM Membership WHERE MEM_ID = ? ";
		PreparedStatement preparedStatement = null;
		try {
			this.connection = DriverManager.getConnection(this.oracle_url, this.user_id, this.user_password);
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, delete);
			int drop = preparedStatement.executeUpdate();
			if (drop > 0) {
				System.out.println("회원삭제를 성공했습니다.");
			} else {
				System.out.println("회원삭제에 실패했습니다.");
			}

			preparedStatement.close();
			this.connection.close();
		} catch (Exception e) {
			System.out.println("회원삭제에 실패했습니다.");
			e.printStackTrace();
		}
	}

	public void print_sql() {
		String query = "SELECT * FROM MEMBERSHIP";
		try {
			this.connection = DriverManager.getConnection(this.oracle_url, this.user_id, this.user_password);
			Statement statement = this.connection.createStatement();
			ResultSet result_set = statement.executeQuery(query);
			while (result_set.next()) {
				System.out.print("아이디: " + result_set.getString(1) + "\n");
				System.out.print("비밀번호: " + result_set.getString(2) + "\n");
				System.out.print("성명: " + result_set.getString(3) + "\n");
				System.out.print("생년월일: " + result_set.getInt(4) + "\n");
				System.out.print("닉네임: " + result_set.getString(5) + "\n");
				System.out.print("이메일: " + result_set.getString(6) + "\n");
				System.out.print("전화번호: " + result_set.getString(7) + "\n");
				System.out.print("휴대폰번호: " + result_set.getString(8) + "\n");
				System.out.print("주소: " + result_set.getString(9) + "\n\n");
			}
			result_set.close();
			statement.close();
			this.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("회원목록 출력을 실패했습니다.");
		}
	}
}
