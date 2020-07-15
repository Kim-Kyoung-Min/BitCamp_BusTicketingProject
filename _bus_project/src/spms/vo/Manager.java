package spms.vo;

public class Manager {
	protected int ticket;
	protected String pathCode;	//경로 코드
	protected String departure;	//출발지 이름
	protected String arrive;	//도착지 이름
	protected String price;		//요금
	
	protected int busNo;		//버스넘버
	protected String busCom;	//버스회사 이름
	protected int seats;		//좌석수
	
	protected String departureDate;	//출발날짜
	protected String departureTime;	//출발시간
	protected String arriveTime;	//도착시간
	protected int spareSeat;		//남은 좌석수
	
	public String getPathCode() {
		return pathCode;
	}
	public Manager setPathCode(String pathCode) {
		this.pathCode = pathCode;
		return this;
	}
	
	public int getTicket() {
		return ticket;
	}
	public Manager setTicket(int ticket) {
		this.ticket = ticket;
		return this;
	}
	public String getDeparture() {
		return departure;
	}
	public Manager setDeparture(String departure) {
		this.departure = departure;
		return this;
	}
	
	
	public String getArrive() {
		return arrive;
	}
	public Manager setArrive(String arrive) {
		this.arrive = arrive;
		return this;
	}
	
	public String getPrice() {
		return price;
	}
	public Manager setPrice(String price) {
		this.price = price;
		return this;
	}
	
	public int getBusNo() {
		return busNo;
	}
	
	public Manager setBusNo(int busNo) {
		this.busNo = busNo;
		return this;
	}
	public String getBusCom() {
		return busCom;
	}
	public Manager setBusCom(String busCom) {
		this.busCom = busCom;
		return this;
	}
	public int getSeats() {
		return seats;
	}
	public Manager setSeats(int seats) {
		this.seats = seats;
		return this;
	}
	public String getDepartureDate() {
		return departureDate;
	}
	public Manager setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
		return this;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public Manager setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
		return this;
	}
	public String getArriveTime() {
		return arriveTime;
	}
	public Manager setArriveTime(String arriveTime) {
		this.arriveTime = arriveTime;
		return this;
	}
	public int getSpareSeat() {
		return spareSeat;
	}
	public Manager setSpareSeat(int spareSeat) {
		this.spareSeat = spareSeat;
		return this;
	}
	@Override
	public String toString() {
		return "Manager [pathCode=" + pathCode + ", departure=" + departure + ", arrive=" + arrive + ", price=" + price
				+ ", busNo=" + busNo + ", busCom=" + busCom + ", seats=" + seats + ", departureDate=" + departureDate
				+ ", departureTime=" + departureTime + ", arriveTime=" + arriveTime + ", spareSeat=" + spareSeat + "]";
	}
}
