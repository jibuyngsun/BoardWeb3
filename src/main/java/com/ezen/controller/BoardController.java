package com.ezen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.Service.BoardService;
import com.ezen.board.domain.Board;
import com.ezen.board.domain.Member;
import com.ezen.persistence.BoardRepository;
import com.ezen.persistence.MemberRepository;



@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardRepository boardRepo;
	
	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private BoardService boardService;
	
	
	@RequestMapping("/getBoardList") 
	public String getBoardList(Model model) {

		List<Board> pageList = boardService.getBoardList().getContent();
		
		model.addAttribute("boardList", pageList);
		
		return "board/getBoardList";
	}
	
	@GetMapping("/getBoard")
	public String getBoardView(Model model, Board board) {
		model.addAttribute("board", boardService.getBoard(board));
		
		return "board/getBoard";
	}
	
	@GetMapping("/insertBoard")
	public String insertBoardView() {
		
		return "board/insertBoard";
	}
	
	@PostMapping("/insertBoard")
	public String insertBoard(Member member, Board board) {
		Member member1 = new Member();
		
		member1.setId("member1");
		board.setMember(member1);
		
		boardService.insertBoard(board);
		
	return "redirect:getBoardList";
	}
	
	@PostMapping("/updateBoard")
	public String updateBoard(Board board) {
		
		boardService.updateBoard(board);
		
		return "redirect:getBoardList";
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(Board board) {
		
		boardRepo.deleteById(board.getSeq());
		
		return "redirect:getBoardList";
	}
}





















