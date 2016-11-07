/**
 * 
 */
package zzz.template.example;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.synacor.ConfigCsiData;
import com.synacor.ServiceType;

/** Present the URI endpoint data as a collection.
 * 
 * @author scott.gardner
 *
 */
public class Endpoints implements Iterable<String> {

	private final ConfigCsiData config;
	private final ServiceType serviceType;
	private String primaryUrl;
	private String secondaryUrl;
	
	public Endpoints(ConfigCsiData config, ServiceType serviceType) {
		this.config = config;
		this.serviceType = serviceType;
		switch (serviceType) {
		case USER_PROFILE:
			primaryUrl = config.getPrimaryProfileUri();
			secondaryUrl = config.getSecondaryProfileUri();
			break;
		case VIDEO_PACKAGES:
			primaryUrl = config.getPrimaryVideoUri();
			secondaryUrl = config.getSecondaryVideoUri();
			break;
		default:
			throw new IllegalStateException("Can only get know service type");
		}
	}


	/* (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<String> iterator() {
		return new UrlIterator(config);
	}

	private static final class UrlIterator implements Iterator<String> {
		private final ConfigCsiData config;
		private boolean done = false;
		private boolean onPrimary = true;
		
		public UrlIterator(ConfigCsiData config) {
			this.config = config;
		}

		@Override
		public boolean hasNext() {
			return !done;
		}

		@Override
		public String next() {
			if (done) throw new NoSuchElementException("no more URLs");
			if (onPrimary){
				onPrimary = false;
				return config.getPrimaryUri();
			}
			else {
				done = true;
				return config.getSecondaryUri();
			}
		}
		
		 public void remove() {
			 throw new UnsupportedOperationException("Cannot remove URLs from configuration");
		 }

	}
}
