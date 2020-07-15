package spms.controls;

import java.util.Map;

import spms.annotation.Component;
import spms.bind.DataBinding;
import spms.dao.BusDao;
import spms.vo.Bus;

@Component("/bus/update.do")
public class BusUpdateController implements Controller, DataBinding {

	BusDao busDao = null;

	public BusUpdateController setMemberDao(BusDao busDao) {
		this.busDao = busDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
			"no", Integer.class,   
			"bus", spms.vo.Bus.class 
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		Bus bus = (Bus)model.get("bus");
		
		if (bus.getEmail() == null) {
			Integer no = (Integer) model.get("no");
			Bus detailInfo = busDao.selectOne(no);
			model.put("bus", detailInfo);
			return "/auth/MemberUpdateForm.jsp";
		}

		else {							  
			busDao.update(bus);  
			return "redirect:../search/searchFrom.jsp"; 
		}
	}
}
