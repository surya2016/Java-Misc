package common;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
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

public class SendMail {

	
	public void sendEmail(String[] to, String from, File file, String fromTime, String toTime)
	{
		try {
		
		final String username = "email@gmail.com";
		final String password = "pass";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.setProperty("mail.smtp.socketFactory.port", "587");

		Session session = Session.getInstance(props,
		        new javax.mail.Authenticator() {
		            protected PasswordAuthentication getPasswordAuthentication() {
		                return new PasswordAuthentication(username, password);
		            }
		        });
		
		Message message = new MimeMessage(session);
		
		message.setFrom(new InternetAddress(from));

		
		InternetAddress[] addressTo = new InternetAddress[to.length];
		
		for(int i=0; i< to.length ; i++)
		{
			addressTo[i] = new InternetAddress(to[i]);
		}
		
		message.addRecipients(Message.RecipientType.TO, addressTo);

		message.setSubject("FireBase Migration Error List");
		
		//message.setText("Please check CSV for details.");
		
		// Create the message part
        BodyPart messageBodyPart = new MimeBodyPart();

        // Now set the actual message
        messageBodyPart.setText("PFA for Error List from "+fromTime+" to "+toTime);
        
        // Create a multipart message
        Multipart multipart = new MimeMultipart();

        // Set text message part
        multipart.addBodyPart(messageBodyPart);

        // Part two is attachment
        messageBodyPart = new MimeBodyPart();
        DataSource source = new FileDataSource(file);
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName(file.getName());
        multipart.addBodyPart(messageBodyPart);

        // Send the complete message parts
        message.setContent(multipart);
		
		Transport.send(message);
		
		} catch (MessagingException mxe) {
			mxe.printStackTrace();
		}
		
		
	}
	
	public static void main(String args[])
	{
		SendMail  sm = new SendMail();
		
		File f = new File(System.getProperty("user.dir")+"/src/main/resources/b2bAssignmentErr.csv");
		
		String [] to = new String [] {"email2@gmail.com"}; 
		
		sm.sendEmail(to, "email@gmail.com", f, "july 5", "july 6");
		
		System.out.println("Sent");
	}
}
