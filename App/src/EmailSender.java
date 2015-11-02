import java.util.Properties;

import javax.mail.Session;

	    
   public class EmailSender {
      public  static void emailInitiazer(String args[])  {
    	    try{
	       String smtpHostServer = "bagate.verizon.com";
	       String emailID = "vignesh.velappan@verizon.com";
	       Properties props = System.getProperties();
	       props.put("mail.smtp.host", smtpHostServer);
	       Session session = Session.getDefaultInstance(props, null);
	       EmailUtil.sendEmail(session, emailID, "End 2 End Automation Testing Results", "Please refer the attachment for the recent automation test ...");
	       System.out.println("main sent successfully");
    	   }catch(Exception excep){
    		   excep.printStackTrace();
    	   }
      }
   }