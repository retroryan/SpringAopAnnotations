package grandcloud;

/**
 * Created by IntelliJ IDEA.
 * User: retroryan
 * Date: Sep 13, 2010
 * Time: 3:56:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class ServiceRequest {

    String requestInfo;

    public ServiceRequest(String requestInfo) {
        this.requestInfo = requestInfo;
    }

    public String getRequestInfo() {
        return requestInfo;
    }

    public void setRequestInfo(String requestInfo) {
        this.requestInfo = requestInfo;
    }
}
