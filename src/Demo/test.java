package Demo;

public class test {

	public static void main(String[] args) {
		SendEmail send = new SendEmail();
		try {
			send.SendingEmail("rohancbandara@gmail.com", "asfvsvgasvasasds");
			System.out.println("sucess ending");
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
