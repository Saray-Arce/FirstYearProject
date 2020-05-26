package gui;

public class Principal {

	public static void main(String[] args) {
		
		try {
			
			Login logarse = new Login();
			logarse.setVisible(true);
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
