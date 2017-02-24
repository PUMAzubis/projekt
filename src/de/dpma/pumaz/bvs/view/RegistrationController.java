package de.dpma.pumaz.bvs.view;

import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.logging.Logger;

import de.dpma.pumaz.bvs.MainApp;
import de.dpma.pumaz.bvs.dao.UserDAO;
import de.dpma.pumaz.bvs.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

public class RegistrationController {
	
	@FXML
	private Tooltip textFieldWorkerIdToolTip;
	
	@FXML
	private Tooltip textFieldFirstNameToolTip;
	
	@FXML
	private Tooltip textFieldLastNameToolTip;
	
	@FXML
	private Tooltip textFieldPasswordToolTip;
	
	@FXML
	private Tooltip buttonRegisterToolTip;
	
	@FXML
	private Tooltip buttonBackToolTip;
	
	@FXML
	private TextField workerIdTextField;
	
	@FXML
	private TextField firstNameTextField;
	
	@FXML
	private TextField lastNameTextField;
	
	@FXML
	private TextField passwordTextField;
	
	@FXML
	private Text workerIdText;
	
	@FXML
	private Text firstNameText;
	
	@FXML
	private Text lastNameText;
	
	@FXML
	private Text passwordText;
	
	@FXML
	private Text hintText;
	
	@FXML
	private Text headerText;
	
	@FXML
	private Button backButton;
	
	@FXML
	private Button completeButton;
	
	RootLayoutController root = new RootLayoutController();
	
	User searchUser;
	
	Logger log = Logger.getLogger(LoginController.class.getName());
	
	KeyEvent event;
	
	public RegistrationController() {
		
	}
	
	// Registrierungsangaben pr�fen und Registrierung durchf�hren
	public void handleRegister() throws SQLException {
		
		if (workerIdTextField.getText().isEmpty() || !isNumeric(workerIdTextField.getText())
				|| workerIdTextField.getText().length() > 5) {
			root.handleDialog("Ausweisnummer ung�ltig",
					"Es wurde keine g�ltige Ausweisnummer angegeben. Bitte geben Sie eine valide Ausweisnummer an und versuchen Sie es erneut.",
					"warning");
			
			log.info("Keine g�ltige Ausweisnummer");
			return;
		}
		
		if (passwordTextField.getText().isEmpty() || passwordTextField.getText().length() < 8) {
			root.handleDialog("Passwort unsicher",
					"Das von Ihnen angegebene Passwort erf�llt nicht unsere Sicherheitsstandards. Bitte geben Sie ein Passwort an, welches mindestens 8 Zeichen lang ist und versuchen Sie es erneut.",
					"warning");
			log.info("Unsicheres Passwort");
			return;
		}
		
		if (firstNameTextField.getText().isEmpty() || firstNameTextField.getText().length() < 2) {
			root.handleDialog("Vorname ung�ltig",
					"Der von Ihnen gew�hlte Vorname ist ung�ltig. Bitte �berpr�fen Sie die Eingabe und versuchen Sie es erneut.",
					"warning");
			log.info("Ung�ltiger Vorname");
			return;
		}
		
		if (lastNameTextField.getText().isEmpty() || lastNameTextField.getText().length() < 2) {
			root.handleDialog("Nachname ung�ltig",
					"Der von Ihnen gew�hlte Nachname ist ung�ltig. Bitte �berpr�fen Sie die Eingabe und versuchen Sie es erneut.",
					"warning");
			
			log.info("Ung�ltiger Nachname");
			return;
		}
		
		UserDAO UserDao = new UserDAO(MainApp.dbcon.getConnection());
		searchUser = UserDao.findUser(new User(Integer.parseInt(workerIdTextField.getText())));
		if (searchUser.getForename() != null) {
			root.handleDialog("Mitarbeiter bereits vorhanden",
					"Es wurde bereits ein Mitarbeiter mit dieser Ausweisnummer registriert. Bitte w�hlen Sie eine andere und versuchen Sie es erneut.",
					"warning");
			log.info("Mitarbeiter mit gleicher Ausweisnummer wurde gefunden, Registrierung nicht m�glich");
		}
		else {
			System.out.println("Mitarbeiter mit gleicher Ausweisnummer nicht gefunden, Registrierung fortfahren");
			UserDao.insertUser(new User(Integer.parseInt(workerIdTextField.getText()), firstNameTextField.getText(),
					lastNameTextField.getText(), passwordTextField.getText(), 0));
			root.handleDialog("Mitarbeiter erfolgreich angelegt", "", "info");
			log.info("Mitarbeiter angelegt");
			((Node) (event.getSource())).getScene().getWindow().hide();
		}
	}
	
	// Check ob String eine Zahl ist. Um die Ausweisnummer zu pr�fen.
	public static boolean isNumeric(String str) {
		
		NumberFormat formatter = NumberFormat.getInstance();
		ParsePosition pos = new ParsePosition(0);
		formatter.parse(str, pos);
		return str.length() == pos.getIndex();
	}
	
	public void handleKeyPressed(KeyEvent event) {
		
		this.event = event;
		switch (event.getCode()) {
		case ENTER:
			try {
				handleRegister();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
	}
	
	public void handleBack(ActionEvent event) {
		
		((Node) (event.getSource())).getScene().getWindow().hide();
	}
	
	public void handleLanguage() {
		
		// textFieldWorkerIdToolTip.setText("Type in your identification
		// number");
		// textFieldFirstNameToolTip.setText("Type in your first name");
		// textFieldLastNameToolTip.setText("Type in your last name");
		// textFieldPasswordToolTip.setText("Type in your password");
		// buttonRegisterToolTip.setText("Click to complete your registration");
		// buttonBackToolTip.setText("Click to get back to the last window");
		// workerIdTextField.setText("Identification number");
		// firstNameTextField.setText("First name");
		// lastNameTextField.setText("Last name");
		// passwordTextField.setText("Password");
		// workerIdText.setText("Identification number");
		// firstNameText.setText("First name");
		// lastNameText.setText("Last name");
		// passwordText.setText("Password");
		// hintText.setText("Fields marked with * are required ");
		// backButton.setText("Back");
		// completeButton.setText("Complete");
		// headerText.setText("Registration");
		
		// textFieldWorkerIdToolTip.setText("Ausweisnummer eingeben");
		// textFieldFirstNameToolTip.setText("Vorname eingeben");
		// textFieldLastNameToolTip.setText("Nachname eingeben");
		// textFieldPasswordToolTip.setText("Passwort eingeben");
		// buttonRegisterToolTip.setText("Dr�cken um Registration
		// abzuschliessen");
		// buttonBackToolTip.setText("Dr�cken um zur�ck zu gelangen");
		// workerIdTextField.setText("Ausweisnummer");
		// firstNameTextField.setText("Vorname");
		// lastNameTextField.setText("Nachname");
		// passwordTextField.setText("Passwort");
		// workerIdText.setText("Ausweisnummer");
		// firstNameText.setText("Vorname");
		// lastNameText.setText("Nachname");
		// passwordText.setText("Passwort");
		// hintText.setText("Mit * markierte Felder sind Pflichtfelder ");
		// backButton.setText("Zur�ck");
		// completeButton.setText("Abschlie�en");
		// headerText.setText("Registrieren");
	}
}
