import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ServiceCall {
	private final static String USER_AGENT = "Mozilla/5.0";
	public static void restServiceCall(){
		try{
			//String url = "http://113.128.164.219:7001/RestServiceApp/verizon/employeeSearch";
			String url = "http://www.thomas-bayer.com/sqlrest/CUSTOMER/3/";
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", USER_AGENT);
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				System.out.println("hello" +inputLine);
				response.append(inputLine);
			}
			
		}catch(Exception excep){
			excep.printStackTrace();
		}
	}
	
}
