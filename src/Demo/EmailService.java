package Demo;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

//String from = "rcb.medical.record.system@gmail.com"; // Your mail id
//String pass = "rcb@1234"; // Your Password

public class EmailService {

	public boolean SendingEmail(Email email) {

		final String username = "rcb.medical.record.system@gmail.com";
		final String password = "rcb@1234";

		Properties props = new Properties();

		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("rcb.medical.record.system@gmail.com"));// ur email
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getEmail()));// u will send
																										// to
			message.setSubject("Use this code as Sequrity code ");
			message.setText("code 000000000000000000 ");
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			Multipart multipart = new MimeMultipart();

			System.out.println("sending");
			Transport.send(message);
			System.out.println("Done");
			return true;

		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return false;
	}

}
