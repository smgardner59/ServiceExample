/**
 * 
 */
package zzz.service.example;

/**
 * @author scott.gardner
 *
 */
public class AbstractService {
	private final ServiceConfig serviceConfig;

	public AbstractService(final ServiceConfig serviceConfig) {
		this.serviceConfig = serviceConfig;
	}
	
	public String getPrimary() {
		return serviceConfig.getPrimary();
	}
	
	public String getSecondary() {
		return serviceConfig.getSecondary();
	}
}
