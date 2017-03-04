package login;

import com.vaadin.ui.Window.Notification;
import employee.*;

public class LoginController {

	private final LoginModel loginModel;
	private final LoginFormView loginFormView;
	private Notification errorNotification;
	private String message;

	public LoginController(LoginFormView loginFormView) {
		this.loginModel = new LoginModel();
		this.loginFormView = loginFormView;
	}

	public Notification checkFieldsForLogin(IEmployee iEmployee) {
		message = "";
		loginModel
				.setUserName(loginFormView.getUser() != null ? (String) loginFormView
						.getUser().getValue() : "");
		loginModel
				.setPassword(loginFormView.getPassword() != null ? (String) loginFormView
						.getPassword().getValue() : "");

		if (loginModel.getUserName().isEmpty()
				&& loginModel.getPassword().isEmpty()) {
			message += "Please Enter Username and Password";
			loginFormView.getUser().focus();
		} else if (loginModel.getUserName().isEmpty()) {
			message += "Please Enter Username";
			loginFormView.getUser().setValue("");
			loginFormView.getUser().focus();
		} else if (loginModel.getPassword().isEmpty()) {
			message += "Please Enter password";
			loginFormView.getPassword().setValue("");
			loginFormView.getPassword().focus();
		} else {
			iEmployee.setUsername(loginModel.getUserName());
			iEmployee.setPassword(loginModel.getPassword());
			message += "login was successful! number of your clicked: ";
			message += "\n"+iEmployee.numberOfLoginClick();
			errorNotification = new Notification("login:", message.toString(),
					Notification.TYPE_TRAY_NOTIFICATION);
			errorNotification.setPosition(Notification.POSITION_CENTERED);
			errorNotification.setDelayMsec(2000);
			return errorNotification;
		}

		errorNotification = new Notification("error:", message.toString(),
				Notification.TYPE_ERROR_MESSAGE);
		errorNotification.setPosition(Notification.POSITION_CENTERED);
		errorNotification.setDelayMsec(2000);
		return errorNotification;
	}

}
