/**
 * 
 */
package zzz.service.example;

/**
 * @author scott.gardner
 *
 */
public class ServiceConfig {
	private String primary;
	private String secondary;
	

	public ServiceConfig(String primary, String secondary) {
		this.primary = primary;
		this.secondary = secondary;
	}

	public String getPrimary() {
		return primary;
	}

	public String getSecondary() {
		return secondary;
	}

}
