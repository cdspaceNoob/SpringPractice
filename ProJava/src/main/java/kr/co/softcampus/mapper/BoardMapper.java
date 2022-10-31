package kr.co.softcampus.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

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
	void addContentInfo(ContentBean writeContentBean);
	
	@Select("select board_info_name "
			+ "from board_info_table "
			+ "where board_info_idx = #{board_info_idx}")
	String getBoardInfoName(int board_info_idx);	// board_info_name 하나를 넘기는 것이니 String을 반환 타입으로 한다.
}
