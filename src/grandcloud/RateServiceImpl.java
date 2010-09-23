package grandcloud;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * This is a sample service that demonstrates the join point for the sample advice in SystemTiming.
 * <p/>
 * Two of the methods are declared with different annotation values to demonstrate passing annotation values
 * into advice.
 *
 * @author Ryan
 */
@Service("rateServiceBean")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class RateServiceImpl implements RateService {

    private int workDone;

    /**
     * this method will be advised because it has the timed annotation
     */
    @Timed(timingNotes = "this is a slow service")
    public void doWork(ServiceRequest serviceRequest) {
        try {
            Thread.sleep(100); //sleep for a short time to simulate doing something
        } catch (InterruptedException e) {
            System.out.println("e = " + e);
        }
        workDone++;
        System.out.println("Work performed");
    }

    /**
     * this method will be advised because it has the timed annotation
     */
    @Timed(timingNotes = "this is a fast service")
    public void doMoreWork(String genericParam) {
        workDone++;
        System.out.println("more work performed");
    }


    /**
     * This method will not be advised because it does not have the Timed annotation
     */
    public void doEvenMoreWork() {
        workDone++;
        System.out.println("even more work performed");
    }


    @Override
    public String toString() {
        return "RateServiceImpl{" +
                "workDone=" + workDone +
                '}';
    }
}
