import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.*;
public class javasendmail{
	public static void sendmail(String receipent)
	{
	System.out.println("Preparing to send mail...........");
	Properties prope=new Properties();
	prope.put("mail.smtp.auth","true");
	//prope.put("mail.smtp.starttls", "true");
	prope.put("mail.smtp.starttls.enable", "true");
	prope.put("mail.smtp.host", "smtp.gmail.com");
	prope.put("mail.smtp.port","587");
	
	String username="demopanther56@gmail.com";
	String password="panther%56";
	
	Session session=Session.getInstance(prope,new Authenticator() {
		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(username,password);
		}
	});
	Message message=prepareMessage(session,username,receipent);
	try {
		Transport.send(message);
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	System.out.println("Sent successfully............");
	}
	private static Message prepareMessage(Session session,String username,String recepitent)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Subject of e-mail:");
		String sub=sc.nextLine();
		System.out.println("Enter the text of e-mail:");
		String text=sc.nextLine();
		Message message=new MimeMessage(session);
		try
		{
			message.setFrom(new InternetAddress(username));
			message.setRecipient(Message.RecipientType.TO,new InternetAddress(recepitent));
			
			message.setSubject(sub);
			message.setText(text);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}
}