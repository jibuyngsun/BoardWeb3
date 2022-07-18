package com.ezen;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ezen.board.domain.Board;
import com.ezen.board.domain.Member;
import com.ezen.board.domain.Role;
import com.ezen.persistence.BoardRepository;
import com.ezen.persistence.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {
	
	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private BoardRepository boardRepo;
	
	@Test
	@Ignore
	public void testInsert() {
		Member member1 = new Member();		
		member1.setId("member1");
		member1.setPassword("1234");
		member1.setName("이순신");
		member1.setRole(Role.ROLE_MEMBER);
		member1.setEnabled(true);
		
		memberRepo.save(member1);
		
		Member member2 = new Member();	
		member2.setId("member2");
		member2.setPassword("4321");
		member2.setName("장보고");
		member2.setRole(Role.ROLE_ADMIN);
		member2.setEnabled(true);
		
		memberRepo.save(member2);
		
		for(int i=1; i<=3; i++) {
			Board board = new Board();
			
			board.setMember(member1);
			board.setTitle("이순신이 등록한 게시글" + i);
			board.setContent("이순신이 등록한 게시글 내용" + i);
			board.setCreateDate(new Date());
			board.setCnt(0L);
			
			//boardRepo.save(board);			
			}
			memberRepo.save(member1);
		
		for(int i=1; i<=3; i++) {
			Board board = new Board();
				
			board.setMember(member2);
			board.setTitle("장보고가 등록한 게시글" + i);
			board.setContent("장보고가 등록한 게시글 내용" + i);
			board.setCreateDate(new Date());
			board.setCnt(0L);
			
			//boardRepo.save(board);
			}
			memberRepo.save(member2);
		}
	
	@Test
	@Ignore
	public void testGetBoard() {
		Board board = boardRepo.findById(1L).get(); // get() - Optional객체에서 데이터를 추출하는 메소
		
		System.out.println(board);
	}
	
	@Test
	public void testGetBoardList() {
		Member member = memberRepo.findById("member1").get();
		
		System.out.printf("<<<%s의 게시글>>>", member.getName());
		System.out.println("----------------------------------");
		List<Board> boardList = member.getBoardList();
		
		for(Board board : boardList) {
			System.out.println(board.toString());
		}
	}
}
