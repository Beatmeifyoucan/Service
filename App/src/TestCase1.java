import org.testng.annotations.Test;

public class TestCase1 {
	
	@Test
	public void serviceCall() throws Exception{
		
		/** Service Call **/
/*		(new EmailSender()).emailInitiazer(null);*/
		
		ServiceCall.restServiceCall();
	}

}
