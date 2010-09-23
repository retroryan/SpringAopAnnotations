package grandcloud;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Ryan Knight
 */
public class AopTestMain {

    public static void main(String[] args) throws Exception {

        //setup the spring context
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                "spring-config.xml");

        ServiceRequest serviceRequest = new ServiceRequest("TEST REQUEST INFO");
        //get two instances of the rate service demo to test the around advice is called properly
        RateServiceDemo rsd1 = (RateServiceDemo) ac.getBean("rateServiceDemo");
        rsd1.demoRateService(serviceRequest);
        System.out.println("rsd1 = " + rsd1);

        RateServiceDemo rsd2 = (RateServiceDemo) ac.getBean("rateServiceDemo");
        rsd2.demoRateService(serviceRequest);
        System.out.println("rsd2 = " + rsd2);

        RateService rateService = (RateService) ac.getBean("rateServiceBean");
        System.out.println("rateServiceImpl = " + rateService);

    }
}
