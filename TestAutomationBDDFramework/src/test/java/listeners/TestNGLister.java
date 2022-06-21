package listeners;

import org.testng.annotations.Listeners;

@Listeners(listeners.Listeners.class)

public class TestNGLister {
	
	public void test1() {
		System.out.println("inside test 1 ");
	}
	

}
