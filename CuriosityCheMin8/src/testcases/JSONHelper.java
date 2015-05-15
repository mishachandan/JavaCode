package testcases;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONHelper {
	
	private static String filePath = "D:\\Misha\\Work\\EclipseWorkspace_Spring15_SE\\CuriosityCheMin8\\src\\testcases\\sample.json";

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		
		JSONObject obj = new JSONObject();

	      obj.put("name", "foo");
	      obj.put("num", new Integer(100));
	      obj.put("balance", new Double(1000.21));
	      obj.put("is_vip", new Boolean(true));
	      
	      JSONArray array =  new JSONArray();
	      
	      JSONObject araryobj1 = new JSONObject();
	      araryobj1.put("color", "red");
	      
	      array.add(araryobj1);
	      
	      JSONObject araryobj2 = new JSONObject();
	      araryobj2.put("color", "yellow");
	      
	      array.add(araryobj2);

	      obj.put("preferences", array);
	      System.out.print(obj);
	      
	     // writeJson(obj.toString());
	      readJson();
	}
	
	static void readJson(){
		JSONParser parser = new JSONParser();
		
		try{
			Object obj = parser.parse(new FileReader(filePath));
			JSONObject jsonObject = (JSONObject) obj;
			
			String name = (String) jsonObject.get("name");
			double balance = (double) jsonObject.get("balance");
			System.out.println(" ---- > Name: "+name+" --> balance: "+balance);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	static void writeJson(String jsonString) throws FileNotFoundException, UnsupportedEncodingException{
		 	      
	      PrintWriter writer = new PrintWriter(filePath);
	      writer.println(jsonString);
	      writer.close();
	}
}
