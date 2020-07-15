package spms.controls;

import java.util.Map;

import spms.annotation.Component;
import spms.bind.DataBinding;
import spms.dao.ManagerDao;
import spms.vo.Manager;

@Component("/search/search.do")
public class ManagerListController implements Controller, DataBinding {

	ManagerDao managerDao;

	public ManagerListController setProjectDao(ManagerDao managerDao) {
		this.managerDao = managerDao; 

		return this;
	}

	@Override
	public Object[] getDataBinders() {

		return new Object[] { "manager", spms.vo.Manager.class };
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {

		Manager manager = (Manager) model.get("manager");
		model.put("test", managerDao.selectList(manager));
		return "/search/searchFromLogOut.jsp";
	}

}
