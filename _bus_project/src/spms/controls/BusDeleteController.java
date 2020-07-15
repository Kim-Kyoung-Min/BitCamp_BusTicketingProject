package spms.controls;

import java.util.Map;

import spms.annotation.Component;
import spms.bind.DataBinding;
import spms.dao.BusDao;

@Component("/bus/delete.do")
public class BusDeleteController implements Controller, DataBinding {
	
	BusDao busDao = null;
	
	public BusDeleteController setMemberDao(BusDao busDao) {
		this.busDao = busDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
			"no", Integer.class	
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		int no = (Integer)model.get("no"); 
		busDao.delete(no); 
		
		return "redirect:../search/searchFrom.jsp";
	}
}