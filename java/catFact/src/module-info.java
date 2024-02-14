module catFact {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires org.json;
	
	opens application to javafx.graphics, javafx.fxml;
}
