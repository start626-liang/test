package pojo;


public class DataLog {

	private int id;
	private String type;
	private String name;
	private String lastDate;
	private String isNull;
	private String firstDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setLastDate(String lastDate){
		this.lastDate = lastDate;
	}
	public String getLastDate(){
		return lastDate;
	}
	public void setType(String type){
		this.type = type;
	}
	public String getType(){
		return type;
	}
	public void setIsNull(String isNull){
		this.isNull = isNull;
	}
	public String getIsNull(){
		return isNull;
	}
	public void setFirstDate(String firstDate){
		this.firstDate = firstDate;
	}
	public String getFirstDate(){
		return firstDate;
	}
}
