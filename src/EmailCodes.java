import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailCodes {

    public static void main(String[] args) {
	try {
	    String host = "smtp.gmail.com";
	    Properties props = new Properties();
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.host", host);
	    props.put("mail.smtp.port", "25");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    Session mailSession = Session.getDefaultInstance(props,
		    new MyAuthenticator());

	    // Session session = Session.getInstance(props,null);
	    MimeMessage msg = new MimeMessage(mailSession);
	    InternetAddress sender = new InternetAddress(
		    "dougchang25@gmail.com", "doug chang");
	    msg.setFrom(sender);
	    InternetAddress[] toList = { new InternetAddress(
		    "dougc@stanfordalumni.org") };

	    msg.setRecipients(Message.RecipientType.TO, toList);
	    msg.setSubject("Amazon AWS code for Hackerdojo Data Mining Class");
	    msg.setSentDate(new Date());
	    msg.setText("code here");
	    Transport.send(msg);
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}

class MyAuthenticator extends Authenticator {
    MyAuthenticator() {
	super();
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
	return new PasswordAuthentication("dougchang25", "");
    }
}