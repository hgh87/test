package login;

import com.vaadin.terminal.UserError;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Layout.MarginInfo;
import com.vaadin.ui.themes.Reindeer;

public class LoginFormView {
	
	private static final String NAME = "Please Login For Use Application";
	private TextField user;
	private PasswordField password;
	
	public HorizontalLayout view(Button loginButton){
		HorizontalLayout viewLayout = new HorizontalLayout();

		// Create the user name input field
		user = new TextField("Username:");
		user.setWidth("75%");
		user.setRequired(true);
		user.setInputPrompt("Your Username");
		user.setRequired(true);
		user.setMaxLength(15);
		user.setNullSettingAllowed(false);
		user.setComponentError(new UserError("please fill out your username!"));
		//user.setRequiredError("please fill out your username!");
		user.setSelectionRange(3, 15);
		user.setValidationVisible(true);

		// Create the password input field
		password = new PasswordField("Password:");
		password.setWidth("75%");
		password.setRequired(true);
		password.setMaxLength(15);
		password.setNullSettingAllowed(false);
		password.setComponentError(new UserError("please fill out your password!"));
		//password.setRequiredError("please fill out your password!");
		password.setSelectionRange(3, 15);
		password.setValidationVisible(true);

		// Create panel
		HorizontalLayout fields = new HorizontalLayout();
		fields.addComponentAsFirst(user);
		fields.addComponent(password);
		fields.addComponent(loginButton);
		fields.setCaption(NAME);
		fields.setSpacing(true);
		fields.setMargin(new MarginInfo(true, true, true, false));
		fields.setSizeUndefined();

		// Create Layout for view
		viewLayout.addComponent(fields);
		viewLayout.setSizeFull();
		viewLayout.setComponentAlignment(fields, Alignment.MIDDLE_CENTER);
		viewLayout.setStyleName(Reindeer.LAYOUT_BLUE);
    	return viewLayout;
    }

	public TextField getUser() {
		return user;
	}

	public void setUser(TextField user) {
		this.user = user;
	}

	public PasswordField getPassword() {
		return password;
	}

	public void setPassword(PasswordField password) {
		this.password = password;
	}

	

}
