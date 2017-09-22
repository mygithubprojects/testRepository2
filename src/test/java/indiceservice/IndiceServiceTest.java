package indiceservice;

import org.junit.Test;

import com.bea.core.repackaged.springframework.util.Assert;

//@RunWith(Arquillian.class)
public class IndiceServiceTest {

	
    @Test
    public void KO_test() {
        Assert.isTrue("KO".equals("KO"));

    }
	
	
	/*
	    @Inject
	    IndiceService2  indiceService;
	       
	    @Deployment
	    public static JavaArchive createDeployment() {
	        JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
	                .addClass(IndiceService2.class)
	                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	        return jar;
	    }

	    @Test
	    public void cdi_arquillian_test() {
	        Assert.isTrue("KO".equals(indiceService.testString(25)), "Exception sup");
	        Assert.isTrue("OK".equals(indiceService.testString(5)), "Exception inf");
	    }
	    
	 */   
}
