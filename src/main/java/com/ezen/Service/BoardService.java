package com.ezen.Service;

import org.springframework.data.domain.Page;

import com.ezen.board.domain.Board;


public interface BoardService {


	Board getBoard(Board board);

	void insertBoard(Board board);

	void updateBoard(Board board);

	void deleteBoard(Board board);
	
	Page<Board> getBoardList();
}