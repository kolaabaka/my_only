package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.String;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONObject;



public class request {

		public static String REQ( String site ) {
			
			StringBuffer content = new StringBuffer();
			
			try {
				URL url = new URL( site );
				URLConnection cont = url.openConnection();
				
				String line_buf = "";
				BufferedReader buffer = new BufferedReader( new InputStreamReader( cont.getInputStream() ) );
		
				do {
					line_buf = buffer.readLine();
					content.append( line_buf );
					
				}while( line_buf != null );
				
				buffer.close();
			}catch( Exception e ){
				System.out.print("Something go wrong..");
			}				
			return content.toString();			
		
		}
		
		
		public static void main( String[] args ) {
			
			String site = "https://catfact.ninja/fact";

			String ans = REQ( site );
			
			JSONObject JS = new JSONObject( ans );
			
			System.out.print( JS.get("fact") );
		}
		
}
