package foo;

import login.LoginController;
import login.LoginFormView;
import com.vaadin.addon.touchkit.ui.TouchKitApplication;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import employee.Employee;
import employee.IEmployee;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class MyVaadinApplication extends TouchKitApplication implements
		ClickListener {

	private LoginFormView loginFormView;
	private LoginController loginController;
	private final IEmployee iEmployee = new Employee();

	@Override
	public void onBrowserDetailsReady() {
		try {
			startView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void startView() {
		// Create login button here for ClickEvent event
		Button loginButton = new Button("Login", this);
		loginButton.addStyleName("small default");
		// Create loginFormView here for login form view
		loginFormView = new LoginFormView();
		// Show login form view
		getMainWindow().addComponent(loginFormView.view(loginButton));
	}

	public void buttonClick(ClickEvent event) {
		try {
			// Create loginController here for check login form input
			loginController = new LoginController(loginFormView);
			// Check fields empty in login form and Show message for users
			getMainWindow().showNotification(
					loginController.checkFieldsForLogin(iEmployee));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}