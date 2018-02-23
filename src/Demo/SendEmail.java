package Demo;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmail {

	public static void SendingEmail(String Email, String Body) throws AddressException, MessagingException {

		String host = "smtp.gmail.com";
		String from = "myEmail"; // Your mail id
		String pass = "myPassword"; // Your Password
		Properties props = System.getProperties();
		props.put("mail.smtp.starttls.enable", "true"); // added this line
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.password", pass);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, pass);
			}
		});

		try {
			Message message = new MimeMessage(session);

			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(Email));// u will send to Email
			message.setSubject("Use this code as Sequrity code ");
			message.setText(Body);
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			Multipart multipart = new MimeMultipart();

			System.out.println("sending");
			Transport.send(message);
			System.out.println("Done");

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}