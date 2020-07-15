package spms.controls;

import java.util.Map;
import spms.annotation.Component;
import spms.bind.DataBinding;
import spms.dao.BusDao;
import spms.vo.Bus;

@Component("/bus/add.do")
public class BusAddController implements Controller, DataBinding {
	
	BusDao busDao = null;
	
	public BusAddController setMemberDao(BusDao busDao) {
		this.busDao = busDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		
		return new Object[] {
				"bus", spms.vo.Bus.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		Bus bus = (Bus)model.get("bus");
		if(bus.getEmail() == null) {
			return "/auth/MemberForm.jsp";
		}
		else {
			busDao.insert(bus);
			return "redirect:../search/searchFrom.jsp";
		}
		
	}
	
	
}
 