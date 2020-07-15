package spms.controls;

import java.util.Map;

import spms.annotation.Component;
import spms.dao.BusDao;

@Component("/bus/list.do")
public class BusListController implements Controller {
	
	BusDao busDao = null;
	
	public BusListController setMemberDao(BusDao busDao) {
		this.busDao = busDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		model.put("busmembers", busDao.selectList());

		return "/member/MemberList.jsp";
		
	}
}
