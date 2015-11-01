import org.testng.annotations.Test;

public class TestCase1 {
	
	@Test
	public void serviceCall() throws Exception{
		ServiceCall.restServiceCall();
		System.out.println("test service ...");
	}

}
