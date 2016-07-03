package Administrator;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import action.ActionFunction;
import dao.ProductDAO;
import pojo.Data;
import pojo.Message;

public class Function{
	private ProductDAO pdao;
	private String id;
	private String password;
	
	private String transmitStringA;
	private String transmitStringB;
	
	private ActionFunction actionFunction;
	
	private Message message;
	private List<Message> messages;
	
	private Data data;
	private List<Data> datas;
	
	//登陆验证
	public String login(){ 
		Map m = ActionContext.getContext().getSession();
		
		System.out.println(id+"+++++++++"+password);
		if(password.equals("123") && id.equals("a")){
			m.put("name", "Administrator");
			
			id = "";
			password = "";
			
			transmitStringA = "登陆成功！";
			return "success";
		}
		
		return "login";
	}
	
	public String main(){
		transmitStringA = "";
		return "main";
	}
	
	//退出
	public String exit(){
		Map m = ActionContext.getContext().getSession();
		
		m.put("name", null);
		
		return "exit";
	}
	
	
	
	public String datas(){
		
		return "datas";
	}
	public String data(){
		datas = pdao.find("from Data d where d.type=?",transmitStringB);
		
		return "data";
	}
	//修改信息
	public String editData(){
		int id = data.getId();
		data = pdao.get(Data.class, id);
		
		if(null == data){
			transmitStringA = "找不到信息";
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
		
		return "editData";
	}
	//提交修改结果
	public String updateData(){
		boolean verificationResult = actionFunction.verificationNull(data.getName(), data.getContent());
		
		if(verificationResult){
			transmitStringA = "输入为空";
			return "error";
		}
		else{
			transmitStringA = "";
			pdao.update(data);
		}
		
		
		
		datas = pdao.find("from Data d where d.type=?",transmitStringB);
		return "updateData";
	}
	
	//删除
	public String deleteData(){
		int id = data.getId();
		data = pdao.get(Data.class, id);
		
		if(null == data){
			transmitStringA = "找不到信息";
			return "error";
		}
		else{
			transmitStringA = "";
		}
		
		pdao.delete(data);

		datas = pdao.find("from Data d where d.type=?",transmitStringB);
		return "deleteData";
	}
	
	
	
	
	public String message(){
		messages = pdao.find("from Message m");
		
		return "message";
	}
	
	//修改信息
	public String editMessage(){
		int id = message.getId();
		message = pdao.get(Message.class, id);
		
		if(null == message){
			transmitStringA = "找不到信息";
			return "error";
		}
		else{
			transmitStringA = "";
		}
		
		//是否超出限制字数
		boolean limitNumber = actionFunction.dataLimitNumber(message.getName(), message.getContent(), 25, 800);
		if(limitNumber){
			transmitStringA = "超出异常！";
			return "error";
		}
		else{
			transmitStringA = "";
		}
		
		return "editMessage";
	}
	//提交修改结果
	public String updateMessage(){
		boolean verificationResult = actionFunction.verificationNull(message.getName(), message.getContent());
		
		if(verificationResult){
			transmitStringA = "输入为空";
			return "error";
		}
		else{
			transmitStringA = "";
			pdao.update(message);
		}
		
		
		
		messages = pdao.find("from Message m");
		return "updateMessage";
	}
	
	//删除
	public String deleteMessage(){
		int id = message.getId();
		message = pdao.get(Message.class, id);
		
		if(null == message){
			transmitStringA = "找不到信息";
			return "error";
		}
		else{
			transmitStringA = "";
		}
		
		pdao.delete(message);
		
		
		messages = pdao.find("from Message m");
		return "deleteMessage";
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
	
	
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id = id;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
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
	
	
	public void setData(Data data){
		this.data = data;
	}
	public Data getData(){
		return data;
	}
	public void setDatas(List<Data> datas){
		this.datas = datas;
	}
	public List<Data> getDatas(){
		return datas;
	}
	
	public void setMessage(Message message){
		this.message = message;
	}
	public Message getMessage(){
		return message;
	}
	public void setMessages(List<Message> messages){
		this.messages = messages;
	}
	public List<Message> getMessages(){
		return messages;
	}
}
