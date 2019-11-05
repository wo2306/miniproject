package kosta.mvc.view;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import kosta.mvc.controller.CommentController;
import kosta.mvc.controller.WeatherController;
import kosta.mvc.model.dto.CommentDTO;

public class MenuView {
	static Scanner sc = new Scanner(System.in);

	public static void menuPrint() {
		while (true) {
			System.out.println("-----메뉴 선택-----");
			System.out.println("1. 전체 검색    2. 지역 검색     3. 종료");
			String select = sc.next();

			switch (select) {
			case "1":
				WeatherController.searchAll();
				CommentController.selectAll();
				break;
			case "2":
				System.out.println("지역을 입력하세요");
				String location = sc.next();
				WeatherController.dustSearch(location);
				CommentController.selectLoction(location);
				break;
			case "3":
				sc.close();
				System.exit(0);
			}
			commentMenu();
		}
	}
	
	public static void commentMenu() {
		String select = null;
		while (true) {
			System.out.println("1. 댓글 작성  2. 댓글 수정   3. 댓글 삭제   4. 이전 메뉴로");
			select = sc.next();
			String name;
			String content;
			SimpleDateFormat formatter;
			Date currentTime;
			String dTime;
			switch (select) {
			case "1":
				System.out.println("이름 입력");
				name = sc.next();
				System.out.println("내용 입력");
				content = sc.next();
				formatter = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.KOREA);
				currentTime = new Date();
				dTime = formatter.format(currentTime);
				CommentController.insert(new CommentDTO(name, content, dTime));
				break;
			case "2":
				System.out.println("이름 입력");
				name = sc.next();
				System.out.println("내용 입력");
				content = sc.next();
				formatter = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.KOREA);
				currentTime = new Date();
				dTime = formatter.format(currentTime);
				CommentController.insert(new CommentDTO(name, content, dTime));
				break;
			case "3":
				System.out.println("이름 입력");
				name = sc.next();
				CommentController.delete(name);
				break;
			case "4":
				System.out.println("이전 메뉴로 돌아갑니다");
				return;
			}
		}
		
	}
}