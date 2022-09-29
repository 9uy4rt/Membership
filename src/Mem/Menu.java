package Mem;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Menu extends DB implements DateCheck {
	public void select() {
		String str1, str2, str3, birth, str4, day, str5, str6, call, cell;
		Scanner scanner = new Scanner(System.in);
		String email = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
		String callNumber = "^\\d{2,4}-\\d{3,4}-\\d{4}$";
		String cellNumber = "^\\d{3}-\\d{3,4}-\\d{4}$";
		String birthdayCheck = "\\d{4}";
		boolean run = true;
		while (run) {
			try {
				System.out.println(
						"-----------------------------------------------------------------------------------------");
				System.out.println("메뉴를 선택하세요.\n");
				System.out.println("1. 회원가입 2. 회원검색 3. 회원삭제 4. 회원목록 5. 종료");
				int num = scanner.nextInt();
				System.out.println(
						"-----------------------------------------------------------------------------------------");
				if (num == 1) {
					System.out.println("가입할 회원정보를 입력하세요.");
					while (true) {
						System.out.println("1. 아이디를 입력하세요(8자리이내).");
						str1 = scanner.next();
						System.out.println(
								"-----------------------------------------------------------------------------------------");
						if (id_check_sql(str1) == false) {
							break;
						}
					}

					while (true) {
						System.out.println("2. 비밀번호를 입력하세요(10자리이내).");
						str2 = scanner.next();
						System.out.println(
								"-----------------------------------------------------------------------------------------");
						if (pw_check_sql(str2) == false) {
							break;
						}
					}
					System.out.println("3. 성명을 입력하세요.");
					str3 = scanner.next();
					System.out.println(
							"-----------------------------------------------------------------------------------------");
					while (true) {
						System.out.println("4. 생년월일을 입력하세요.");
						System.out.println(" 4-1. 출생년도를 입력하세요(ex.1998).");
						birth = scanner.next();
						if (!Pattern.matches(birthdayCheck, birth)) {
							System.out.println("출생연도 형식이 잘못됬습니다.");
							continue;
						}
						while (true) {
							System.out.println(" 4-2. 월일을 입력하세요(ex.0916).");
							day = scanner.next();
							if (!Pattern.matches(birthdayCheck, day)) {
								System.out.println("월일 형식이 잘못됬습니다.");
								continue;
							} else {
								break;
							}
						}
						System.out.println(
								"-----------------------------------------------------------------------------------------");
						if (day.equals(date)) {
							System.out.println("생일 축하합니다.");
							break;
						}
						break;
					}
					while (true) {
						System.out.println("5. 닉네임을 입력하세요(8자리이내).");
						str4 = scanner.next();
						System.out.println(
								"-----------------------------------------------------------------------------------------");
						if (nik_check_sql(str4) == false) {
							break;
						}
					}
					while (true) {
						System.out.println("6. 이메일을 입력하세요.");
						str5 = scanner.next();
						System.out.println(
								"-----------------------------------------------------------------------------------------");
						if (!Pattern.matches(email, str5)) {
							System.out.println("이메일 형식이 잘못됬습니다.");
							continue;
						}
						if (email_check_sql(str5) == false) {
							break;
						}
					}
					while (true) {
						System.out.println("7. 전화번호를 입력하세요(-포함).");
						call = scanner.next();
						System.out.println(
								"-----------------------------------------------------------------------------------------");
						if (!Pattern.matches(callNumber, call)) {
							System.out.println("전화번호 형식이 잘못됬습니다.");
							continue;
						}
						if (call_check_sql(call) == false) {
							break;
						}
					}
					while (true) {
						System.out.println("8. 휴대폰번호를 입력하세요(-포함).");
						cell = scanner.next();
						System.out.println(
								"-----------------------------------------------------------------------------------------");
						if (!Pattern.matches(cellNumber, cell)) {
							System.out.println("휴대폰 번호 형식이 잘못됬습니다.");
							continue;
						}
						if (cell_check_sql(cell) == false) {
							break;
						}
					}
					System.out.println("9. 주소를 입력하세요.");
					str6 = scanner.next();
					System.out.println(
							"-----------------------------------------------------------------------------------------");
					insert_sql(str1, str2, str3, birth, day, str4, str5, call, cell, str6);

				} else if (num == 2) {
					System.out.println("검색할 회원의 ID를 입력하세요.");
					String search = scanner.next();
					browse_sql(search);
					System.out.println(
							"-----------------------------------------------------------------------------------------");
				} else if (num == 3) {
					System.out.println("삭제할 회원의 ID를 입력하세요.");
					String delete = scanner.next();
					delete_sql(delete);
					System.out.println(
							"-----------------------------------------------------------------------------------------");
				} else if (num == 4) {
					print_sql();
					System.out.println(
							"-----------------------------------------------------------------------------------------");
				} else if (num == 5) {
					System.out.println("시스템을 종료합니다.");
					run = false;
					scanner.close();
					System.out.println(
							"-----------------------------------------------------------------------------------------");
				} else {
					System.out.println("잘못된 입력입니다.");
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
}