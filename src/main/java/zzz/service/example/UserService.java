/**
 * 
 */
package zzz.service.example;

/**
 * @author scott.gardner
 *
 */
public class UserService extends AbstractService implements BaseService<String, Integer> {

	/**
	 * @param serviceConfig
	 */
	public UserService(ServiceConfig serviceConfig) {
		super(serviceConfig);		// TODO Auto-generated constructor stub
	}

	@Override
	public String call(Integer request) {
		String source;
		if (request > 5) 
			source = getPrimary();
		else
			source = getSecondary();
		return "User Service: " + source;
	}

}
