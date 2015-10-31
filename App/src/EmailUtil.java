import java.util.Date;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailUtil {
	public static void sendEmail(Session session, String toEmail,
			String subject, String body) {
		try {
			MimeMessage msg = new MimeMessage(session);
			// set message headers
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");
			msg.setFrom(new InternetAddress("jagan.kumar.rajamani@verizon.com",
					"NoReply-JD"));
			msg.setReplyTo(InternetAddress.parse(
					"jagan.kumar.rajamani@verizon.com", false));
			msg.setSubject(subject, "UTF-8");
			msg.setText(body, "UTF-8");
			msg.setSentDate(new Date());
			msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse("vignesh.velappan@verizon.com,manju.x.thampy@verizon.com", false));
			System.out.println("Message is ready");
			
			/*// Create the message part
	         BodyPart messageBodyPart = new MimeBodyPart();

	         // Now set the actual message
	         messageBodyPart.setText("Hi\n" + "\tPlease find the attachemnt for performance\n" + "Thanks");

	         // Create a multipar message
	         Multipart multipart = new MimeMultipart();
			
			// Set text message part
	         multipart.addBodyPart(messageBodyPart);

	         // Part two is attachment
	         messageBodyPart = new MimeBodyPart();
	         String filename = "C:/Users/Administrator/git/Service/App/Test.html";
	         DataSource source = new FileDataSource(filename);
	         messageBodyPart.setDataHandler(new DataHandler(source));
	         messageBodyPart.setFileName("Performace.html");
	         multipart.addBodyPart(messageBodyPart);

	         // Send the complete message parts
	         msg.setContent(multipart);*/
			
			
			Transport.send(msg);
			System.out.println("Email Sent Successfully!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}