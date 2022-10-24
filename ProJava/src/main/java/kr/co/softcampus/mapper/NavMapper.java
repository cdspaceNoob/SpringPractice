package kr.co.softcampus.mapper;
// 여기에 쿼리 작성.
// 얘도 Bean으로 써야 한다. ServletAppContext에서 Bean으로 등록해준다. 
import java.util.List;

import org.apache.ibatis.annotations.Select;

import kr.co.softcampus.beans.BoardInfoBean;

public interface NavMapper {
	@Select("select board_info_idx, board_info_name "
			+ "from board_info_table "
			+ "order by board_info_idx;")
	List<BoardInfoBean> getNavList();
}
