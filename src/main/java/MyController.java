

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class MyController implements Initializable {
	
	@FXML
	private BorderPane root;
	
	@FXML
	private BorderPane root2;
    
    @FXML
    private TextField textField;

    @FXML
    private TextField textField2;

    @FXML
    private TextField putText;

    @FXML
    private Button buttonOne;

    @FXML
    private Button buttonTwo;
    
    //static so each instance of controller can access to update 
    private static String textEntered = "";
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
        
	}
    //method so that the controller created for second view can update the text
    //field with the text from the first view
    public void setText(){
        putText.setText(textEntered);
//        System.out.println("hello from setText");
    }

    public void setText2(){
        textField.setText(textEntered);
        System.out.println("hello from setText");
    }
	
	public void b1Method(ActionEvent e) throws IOException{

        textEntered = textField.getText(); //get text entered by user
        System.out.println(textEntered);

        //get instance of the loader class
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Myfxml.fxml"));
        Parent root = loader.load(); //load view into parent
        MyController myctr = loader.getController();//get controller created by FXMLLoader
//        myctr.setText();
        myctr.textField2.setText(textEntered + " : from the center text field!");//use MyLoader class method for setText()
        myctr.buttonOne.setDisable(true);
        myctr.buttonOne.setText("pressed");
//        root2.getStylesheets().add("/styles/style2.css");//set style

        root2.getScene().setRoot(root);//update scene graph
        
        /*
		Parent root = FXMLLoader.load(getClass()
                .getResource("/FXML/Myfxml.fxml"));
		 
		 root2.getScene().setRoot(root);
         */
	}

    public void b2Method(ActionEvent e) throws IOException{

        textEntered = textField.getText(); //get text entered by user
        System.out.println(textEntered);

        //get instance of the loader class
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Myfxml.fxml"));
        Parent root = loader.load(); //load view into parent
        MyController myctr = loader.getController();//get controller created by FXMLLoader
        myctr.textField.clear();
        myctr.textField2.clear();
        // replace string textfield right
        myctr.textField2.setText("final string goes here");
        myctr.buttonOne.setDisable(false);
        myctr.buttonOne.setText("button one");
        root2.getScene().setRoot(root);//update scene graph

        /*
		Parent root = FXMLLoader.load(getClass()
                .getResource("/FXML/Myfxml.fxml"));

		 root2.getScene().setRoot(root);
         */
    }

}
