package utility;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.testng.annotations.Test;




public class url_Checker {
	URLConnection urlConnection;
	HttpURLConnection httpURLConnection;
	@Test
	public boolean urlCheck(String imgURL) throws Exception {
		URL url = new URL(imgURL);
		urlConnection = url.openConnection();
		httpURLConnection = (HttpURLConnection) urlConnection;
		Thread.sleep(3000);
		httpURLConnection.connect();
		
		if(httpURLConnection.getResponseCode() == 200) {
			
			System.out.println(" -- "+httpURLConnection.getResponseCode()+ " -- "+ httpURLConnection.getResponseMessage());
			return true;
		}else{
			
			System.err.println(" -- "+httpURLConnection.getResponseCode()+ " -- "+ httpURLConnection.getResponseMessage());
			return false;
		}
	}
}
