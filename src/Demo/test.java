package Demo;

public class test {

	public static void main(String[] args) {
		SendEmail send = new SendEmail();
		Email email = new Email();
		email.setEmail("rohancbandara@gmail.com");
		email.setBody("email");
		try {
			boolean result = send.SendingEmail(email);
			if (result) {
				System.out.println("sucess");
			}
			else {
				System.out.println("sfagdgsrg");
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
