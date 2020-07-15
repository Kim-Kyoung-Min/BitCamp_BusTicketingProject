package spms.controls;

import java.util.Map;

import spms.annotation.Component;
import spms.bind.DataBinding;
import spms.dao.ManagerDao;
import spms.vo.Manager;

@Component("/search/update.do")
public class ManagerUpdateController implements Controller, DataBinding {

	ManagerDao managerDao = null;

	public ManagerUpdateController setMemberDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
			"manager", spms.vo.Manager.class 
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		Manager manager = (Manager)model.get("manager");
		model.put("test", managerDao.update(manager));
		System.out.println(model.toString());
		return "/auth/againsearchFromLogOut.jsp";
		}
	}
