package grandcloud;

/**
 * It is necessary for the service to implement an interface so that Spring AOP can use the Java Dynamic Proxy
 * capabilities and does not have to use cglib
 *
 * @author Ryan Knight
 */
public interface RateService {

    // annotating the interface did not work?
    // @Timed(logNotes = "doWork service")
    void doWork(ServiceRequest serviceRequest);

    void doMoreWork(String genericParam);

    void doEvenMoreWork();
}
