/**
 * 
 */
package zzz.template.example;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.synacor.ConfigCsiData;

/** Present the URI endpoint data as a collection.
 * 
 * @author scott.gardner
 *
 */
public class Endpoints implements Iterable<String> {

	private final ConfigCsiData config;
	
	public Endpoints(ConfigCsiData config) {
		this.config = config;
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
