package application;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.String;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONObject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class controller {

    @FXML
    private Button btn;

    @FXML
    private Text txt;
    
    @FXML
    void call() {
    	btn.setOnAction( event -> {
    		
    		String ans = REQ("https://catfact.ninja/fact");
    		
    		JSONObject JS = new JSONObject( ans );
    		
    		txt.setText( ( String )JS.get("fact") );
    		
    	});	
    }
    
    private static String REQ( String site ) {
		
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
    
}