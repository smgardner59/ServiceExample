/**
 * 
 */
package zzz.template.example;

import java.util.Iterator;
import com.cingular.csi.csi.namespaces.unifieddataaccessservices._213_0.wsdl.unifieddataaccessservicescsi_wsdl.CSIApplicationException;

/** 
 * <ol><em>Type Parameters</em>
 * <li>S stub class for SOAP</li>
 * <li>R request object for SOAP</li>
 * <li>O output (response) object from SOAP</li>
 * </ol>
 * 
 * @author scott.gardner
 *
 */
public abstract class TemplateBase<S, R, O> {

	/**
	 * 
	 */
	public TemplateBase(){
		// TODO Auto-generated constructor stub
	}
	
	
	public abstract O callSoapStub(final String urlString, R soapRequest) throws CSIApplicationException;
	
	/** This calls the SOAP service and retries with an alternative URL if 
	 *  the attempt fail due to connectivity.
	 *  
	 *  <p>
	 *  The retry logic is based on looping through the collection of endpoints
	 *  until we get one of two responses: the profile information is returned 
	 *  from the request. In this case the profile is returned. If the request
	 *  throws a NOT_FOUND exception, then a response with NOT_FOUND is created
	 *  and returned.
	 *  </p>
	 *  <p>
	 *  Any other exception will trigger the retry logic. The exception will be 
	 *  logged and the retry logic will check if there is another endpoint to 
	 *  check. If there is another endpoint, the process will start over. If 
	 *  there are no more endpoints the last exception will be rethrown.
	 *  </p>
	 *  <p>
	 *  The return statement at the end of the method is not reachable. But 
	 *  eclipse gets upset if it is not there.
	 *  </p>
	 *  
	 * @param endpoints
	 * @param soapRequest
	 * @return
	 */
	public O makeRequestWithRetry(Endpoints endpoints, R soapRequest) {
		O response = null;
		
		Iterator<String> endpointIter = endpoints.iterator();
		while (endpointIter.hasNext()){ 
			try {
				String urlString = endpointIter.next();
				response = callSoapStub(urlString, soapRequest);
				return response;
			} 
			catch (CSIApplicationException e) {
				String csiResponseCode = e.getFaultMessage().getCSIApplicationException().getResponse().getCode();
				// Log here.
				// Check if we have not found (a happy path response
				if (csiResponseCode.equals("300")) {
					// Create the response here.
					// return the response
				}
				else {
					if (!endpointIter.hasNext()) {
						// rethrow
					}
				}
			}
			catch (Exception e) {
				// Log exception here.
				// We know there is no happy case in this block, so just check if
				// the endpoint list is at the end.
				if (!endpointIter.hasNext()) {
					// rethrow
				}
			}
		}
		
		// This is not reachable.
		return response;
	}
}
