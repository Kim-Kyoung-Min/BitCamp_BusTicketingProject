package spms.controls;

import java.util.Map;

import spms.annotation.Component;
import spms.bind.DataBinding;
import spms.dao.ManagerDao;

@Component("/search/delete.do")
public class ManagerDeleteController implements Controller, DataBinding {
	
	ManagerDao managerDao = null;
	
	public ManagerDeleteController setMemberDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
			"busNo", Integer.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		Integer busNo = (Integer) model.get("busNo");
		managerDao.delete(busNo); 
		
		return "/auth/againsearchFromLogOut.jsp";
	}
}