package data.action;

import java.util.List;

import action.ActionFunction;
import dao.ProductDAO;
import pojo.Data;
import pojo.DataBackups;


public class DataAction {
	private ProductDAO pdao;
	private ActionFunction actionFunction;
	
	private Data data;
	private List<Data> datas;
	
	private List<Data> datasJAVA;
	private List<Data> datasSQL;
	private List<Data> datasOTHER;
	
	
	private String transmitStringA;
	private String transmitStringB;
	//左侧分栏的显示
	public String add(){
		datasJAVA = pdao.find("from Data d where d.type=?", "JAVA");
		datasSQL = pdao.find("from Data d where d.type=?", "SQL");
		datasOTHER = pdao.find("from Data d where d.type=?", "OTHER");
		
		
		return "add";
	}
	
	//保存信息
	public String save(){
		//验证输入是否为空
		boolean verificationResult = actionFunction.verificationNull(data.getName(), data.getContent());
		if(verificationResult){
			transmitStringA = "输入为空";
			return "error";
		}
		else{
			transmitStringA = "";
		}
		
		//是否超出限制字数
		boolean limitNumber = actionFunction.dataLimitNumber(data.getName(), data.getContent(), 240, 800000);
		if(limitNumber){
			transmitStringA = "超出异常！";
			return "error";
		}
		else{
			transmitStringA = "";
		}
		
		
		//验证类型
		boolean verifyResult = actionFunction.verificationNonChar(data.getType());
		if(verifyResult){
			transmitStringA = "";
		}
		else{
			transmitStringA = "没有选择信息的类型！";
			return "error";
		}
		
		
		//保存信息验证是否重复
		boolean saveError = actionFunction.saveData(data);
		
		if(saveError){
			transmitStringA = "";
		}
		else{
			transmitStringA = "输入信息重复！";
			return "error";
		}
		
		
		datasJAVA = pdao.find("from Data d where d.type=?", "JAVA");
		datasSQL = pdao.find("from Data d where d.type=?", "SQL");
		datasOTHER = pdao.find("from Data d where d.type=?", "OTHER");
		return "save";
	}
	
	public String show(){
		int id = data.getId();
		//查找信息
		data = pdao.get(Data.class, id);
		
		if(null == data){
			
			transmitStringA = "未知错误！";
			return "error";
		}
		
		datasJAVA = pdao.find("from Data d where d.type=?", "JAVA");
		datasSQL = pdao.find("from Data d where d.type=?", "SQL");
		datasOTHER = pdao.find("from Data d where d.type=?", "OTHER");
		return "show";
	}
	
	public String edit(){
		
		datasJAVA = pdao.find("from Data d where d.type=?", "JAVA");
		datasSQL = pdao.find("from Data d where d.type=?", "SQL");
		datasOTHER = pdao.find("from Data d where d.type=?", "OTHER");
		return "edit";
	}
	
	
	public String updata(){
		pdao.update(data);
		
		DataBackups d = pdao.get(DataBackups.class, data.getId());
		
		d.setType(data.getType());
		
		pdao.update(d);
		
		datasJAVA = pdao.find("from Data d where d.type=?", "JAVA");
		datasSQL = pdao.find("from Data d where d.type=?", "SQL");
		datasOTHER = pdao.find("from Data d where d.type=?", "OTHER");
		return "updata";
	}
	
	public String find(){
		//System.out.println("-----------"+transmitStringB);
		
		//验证输入是否为空
		boolean verificationResult = actionFunction.verificationNull(transmitStringB, "不使用");
		if(verificationResult){
			transmitStringA = "输入为空";
		}
		else{
			transmitStringA = "";
			datas = pdao.find("from Data d where d.name like ?", "%" + transmitStringB + "%");

			if(0 == datas.size()){
				transmitStringA = "没有找到！";
			}
		}
				
				
		
		
		
		datasJAVA = pdao.find("from Data d where d.type=?", "JAVA");
		datasSQL = pdao.find("from Data d where d.type=?", "SQL");
		datasOTHER = pdao.find("from Data d where d.type=?", "OTHER");
		return "find";
	}
	
	
	public void setDatasJAVA(List<Data> datasJAVA){
		this.datasJAVA = datasJAVA;
	}
	public List<Data> getDatasJAVA(){
		return datasJAVA;
	}
	public void setDatasSQL(List<Data> datasSQL){
		this.datasSQL = datasSQL;
	}
	public List<Data> getDatasSQL(){
		return datasSQL;
	}
	public void setDatasOTHER(List<Data> datasOTHER){
		this.datasOTHER = datasOTHER;
	}
	public List<Data> getDatasOTHER(){
		return datasOTHER;
	}
	
	
	
	public void setDatas(List<Data> datas){
		this.datas = datas;
	}
	public List<Data> getDatas(){
		return datas;
	}	
	public void setData(Data data){
		this.data = data;
	}
	public Data getData(){
		return data;
	}
	
	
	
	public void setPdao(ProductDAO pdao){
		this.pdao = pdao;
	}
	public ProductDAO getPdao(){
		return pdao;
	}
	
	public void setActionFunction(ActionFunction actionFunction){
		this.actionFunction = actionFunction;
	}
	public ActionFunction getActionFunction(){
		return actionFunction;
	}
	
	
	
	
	public String getTransmitStringA(){
		return transmitStringA;
	}
	public void setTransmitStringA(String transmitStringA){
		this.transmitStringA = transmitStringA;
	}
	
	public String getTransmitStringB(){
		return transmitStringB;
	}
	public void setTransmitStringB(String transmitStringB){
		this.transmitStringB = transmitStringB;
	}
}
