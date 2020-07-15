package spms.bind;

public interface DataBinding {
	
	/* 자동으로 생성해야할 VO 객체의 정보를 반환하는 역할 
	 * 배열 : 모든 정보를 받기위해서
	 * 오브젝트 : 모든 객체의 최상위 역할*/
	public Object[] getDataBinders();
	
}
