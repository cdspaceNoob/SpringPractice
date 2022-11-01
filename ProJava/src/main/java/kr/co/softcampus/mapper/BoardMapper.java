package kr.co.softcampus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import kr.co.softcampus.beans.ContentBean;

public interface BoardMapper {

	@Insert("insert into content_table("
			+ "content_subject, "
			+ "content_text, "
			+ "content_file, "
			+ "content_writer_idx, "
			+ "content_board_idx, "
			+ "content_date"
			+ ") "
			+ "values("
			+ "#{content_subject}, "
			+ "#{content_text}, "
			+ "#{content_file}, "
			+ "#{content_writer_idx}, "
			+ "#{content_board_idx}, "
			+ "now()"
			+ ")"
			)
	@Options(useGeneratedKeys = true, keyProperty = "content_idx")
	void addContentInfo(ContentBean writeContentBean);
	
	@Select("select board_info_name "
			+ "from board_info_table "
			+ "where board_info_idx = #{board_info_idx}")
	String getBoardInfoName(int board_info_idx);	// board_info_name 하나를 넘기는 것이니 String을 반환 타입으로 한다.
	
	// 게시판 리스트 구성.
	@Select("select ct.content_idx, ct.content_subject, ut.user_name as content_writer_name, ct.content_date "
			+ "from content_table ct, user_table ut "
			+ "where ct.content_writer_idx = ut.user_idx "
			+ "and ct.content_board_idx = #{board_info_idx} "
			+ "order by ct.content_idx desc")	// alias를 붙이면 마찬가지로 자동 주입할 수 있게 된다. 하나의 VO에 넣어야 하므로 alias를 붙이고, VO에 필드를 추가해준다. 
	List<ContentBean> getContentList(int board_info_idx);
	
	// 게시글 읽기.
	@Select ("select ut.user_name as content_writer_name, ct.content_date, ct.content_subject, ct.content_text, ct.content_file "
			+ "from content_table ct, user_table ut "
			+ "where ct.content_writer_idx = ut.user_idx "
			+ "and content_idx=${content_idx}")
	ContentBean getContentInfo(int content_idx);
	
}
