package TestNG;
//4 types of groups
//TestGroups,ExclusionGroups,MetaGroups(groups of groups),PartialGroups
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

@Ignore
@Test
public class Groups1 {
	
	@Ignore
	@Test(groups = {"smoke"})
	public void Test1() {
		System.out.println("Test1");
	}
	
	@Test(groups = {"smoke","functional"})
	public void Test2() {
		System.out.println("Test2");
	}
	
	@Test(groups = {"functional","regression"})
	public void Test3() {
		System.out.println("Test3");
	}

}
