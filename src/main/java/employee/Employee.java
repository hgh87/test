package employee;

public class Employee implements IEmployee {

	private int numberOfLoginClick = 0;

	public void setUsername(String username) {
		// TODO Auto-generated method stub

	}

	public void setPassword(String password) {
		// TODO Auto-generated method stub

	}

	public int numberOfLoginClick() {
		// TODO Auto-generated method stub
		numberOfLoginClick = numberOfLoginClick + 1;
		return numberOfLoginClick;
	}

}
