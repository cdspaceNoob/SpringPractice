package kr.co.softcampus.mapper;

import org.apache.ibatis.annotations.Insert;

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
}
