package grandcloud;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * This class declares the aspects for the system.  In this example is an around advice for timing the length of methods
 * marked with the Timed annotation
 *
 * @author Ryan Knight
 * @see grandcloud.Timed
 */
@Aspect
public class SystemTiming {

    /**
     * This around advice adds timing to any method annotated with the Timed annotation.
     * It binds the annotation to the parameter timedAnnotation so that the values are available at runtime.
     * Also note that the retention policy of the annotation needs to be RUNTIME.
     *
     * @param pjp             - the join point for this advice
     * @param timedAnnotation - the Timed annotation as declared on the method
     * @return
     * @throws Throwable
     */

    @Around("@annotation( timedAnnotation )  && args(param)")
    public Object processSystemRequest(final ProceedingJoinPoint pjp, Timed timedAnnotation, final ServiceRequest param) throws Throwable {
        try {
            long start = System.currentTimeMillis();
            Object retVal = pjp.proceed();
            long end = System.currentTimeMillis();
            long differenceMs = end - start;

            MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
            Method targetMethod = methodSignature.getMethod();
            //get the value of timing notes as declared in the method annotation
            String timingNotes = timedAnnotation.timingNotes();
            String requestInfo = param.getRequestInfo();

            System.out.println(targetMethod.getDeclaringClass().getName() + "." + targetMethod.getName() + " took " + differenceMs + " ms : timing notes: " + timingNotes + " request info : " + requestInfo);
            return retVal;
        } catch (Throwable t) {
            System.out.println("error occured");
            throw t;
        }

    }

}
