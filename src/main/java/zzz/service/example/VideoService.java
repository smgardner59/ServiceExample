/**
 * 
 */
package zzz.service.example;

/**
 * @author scott.gardner
 *
 */
public class VideoService extends AbstractService implements BaseService<String, String> {

	/**
	 * @param serviceConfig
	 */
	public VideoService(ServiceConfig serviceConfig) {
		super(serviceConfig);
	}

	@Override
	public String call(String request) {
		String source;
		if (request.equals("Hello")){
			source = getPrimary();
		}
		else {
			source = getSecondary();
		}
		return "Video Service: " + source;
	}

}
