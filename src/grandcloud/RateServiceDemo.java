package grandcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * This demonstrates the rate service by having the rate service bean autowired into the class
 * and then calling the methods on the bean.
 *
 * @author Ryan Knight
 */
@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class RateServiceDemo {

    @Autowired
    private RateService rateService;

    public void setRateServiceImpl(RateService rateService) {
        this.rateService = rateService;
    }

    public void demoRateService(ServiceRequest serviceRequest) {
        this.rateService.doWork(serviceRequest);
        this.rateService.doMoreWork("NON-STANDARD REQUEST");
        this.rateService.doEvenMoreWork();
    }

    @Override
    public String toString() {
        return "RateServiceDemo{" +
                "rateServiceImpl=" + rateService +
                '}';
    }
}
