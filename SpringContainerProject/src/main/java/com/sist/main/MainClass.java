package com.sist.main;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="C:\\SpringDev\\springstudy\\SpringContainerProject\\src\\main\\java\\com\\sist\\main\\app.xml";
		ApplicationContext app= new ApplicationContext(path);
		Board board=(Board)app.getBean("board");
		board.board_list();
		System.out.println(board);
		
		Board board1=(Board)app.getBean("board");
		board1.board_list();
		System.out.println(board1);
		
		Board board2=(Board)app.getBean("board");
		board2.board_list();
		System.out.println(board2);
	}

}
