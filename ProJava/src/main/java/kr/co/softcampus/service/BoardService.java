package kr.co.softcampus.service;

import java.io.File;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.softcampus.beans.ContentBean;
import kr.co.softcampus.beans.UserBean;
import kr.co.softcampus.dao.BoardDao;

@Service
@PropertySource("/WEB-INF/properties/option.properties")
public class BoardService {

	@Value("${path.upload}")
	private String path_upload;
	
	@Autowired
	private BoardDao boardDao;
	
	@Resource(name="loginUserBean")
	private UserBean loginUserBean;
	
	// 파일 자체를 업로드하고 파일의 이름을 구하는 메서드. 
	private String saveUploadFile(MultipartFile upload_file) {
		String file_name = System.currentTimeMillis() + "_" + upload_file.getOriginalFilename();	// 날짜 및 시각을 붙여서 중복되는 이름이 없도록.
		
		try {
			upload_file.transferTo(new File(path_upload + "/" + file_name));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return file_name;
	}//eom
	
	public void addContentInfo(ContentBean writeContentBean) {
//		System.out.println(writeContentBean.getContent_subject());
//		System.out.println(writeContentBean.getContent_text());
//		System.out.println(writeContentBean.getUpload_file().getSize());
		
		MultipartFile upload_file = writeContentBean.getUpload_file();
		
		if(upload_file.getSize() > 0) {
			String file_name = saveUploadFile(upload_file);		// 위 메서드(saveUploadFile)를 실행하여 업로드 수행 및 파일 이름을 가져온다.
//			System.out.println(file_name);
			writeContentBean.setContent_file(file_name);		// setter: 파일 이름.
		}
		
		writeContentBean.setContent_writer_idx(loginUserBean.getUser_idx());	// setter: 업로드하는 사용자의 idx.
		
		// board_idx는 자동으로 주입되어 있다. 
		
		boardDao.addContentInfo(writeContentBean);
	}//eom
	
	public String getBoardInfoName(int board_info_idx) {
		return boardDao.getBoardInfoName(board_info_idx);
	}//eom
}
