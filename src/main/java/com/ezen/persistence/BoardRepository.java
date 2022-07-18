package com.ezen.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ezen.board.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {
	
	@Query("SELECT b FROM Board b")
	Page<Board> getBoardList(Pageable paging);
	
	/*
	// 쿼리메소드를 이용한 게시글 조회
	List<Board> findByTitle(String searchKeyword);
	
	// 게시글의 내용을 키워드로 검색
	List<Board> findByContentContaining(String searchKeyword);
	
	// 여러조건 사용하기
	List<Board> findByTitleContainingOrContentContaining(String title, String content);
	
	// 정렬하기
	List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);
	
	// 페이징 처리 조회
	//List<Board> findByTitleContaining(String searchKeyword, Pageable paging);
	Page<Board> findByTitleContaining(String searchKeyword, Pageable paging);
	*/
	/*
	// 위치기반 파라미터 사용하기
	@Query("SELECT b FROM Board b WHERE b.title LIKE %?1% ORDER BY b.seq DESC")
	List<Board> queryAnnotationTest1(String searchKeyword);
	
	
	// 이름기반 파라미터 사용하기
	@Query("SELECT b FROM Board b WHERE b.title LIKE %:keyword% ORDER BY b.seq DESC")
	List<Board> queryAnnotationTest2(@Param("keyword") String searchKeyword);
	
	// 특정 변수만 조회하기
	@Query("SELECT b.seq, b.title, b.writer, b.createDate "
			+ "FROM Board b WHERE b.title LIKE %?1% ORDER BY b.seq DESC")
	List<Object[]> queryAnnotationTest3(String searchKeyword);
	
	// Native 쿼리(데이터베이스 SQL 문법 사용)
	@Query(value="SELECT seq, title, writer, create_date "
			+ "FROM board WHERE title LIKE '%'||?1||'%' "
			+ "ORDER BY seq DESC",
			nativeQuery=true)
	List<Object[]> queryAnnotationTest4(String searchKeyword);
	
	
	@Query("SELECT b FROM Board b ORDER BY b.seq DESC")
	List<Board> queryAnnotationTest5(Pageable paging);
	*/
}
