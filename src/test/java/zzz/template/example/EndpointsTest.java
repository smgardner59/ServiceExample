package zzz.template.example;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import com.synacor.ConfigCsiData;

public class EndpointsTest {
	private ConfigCsiData config = new ConfigCsiData();
	private Endpoints endpoints = new Endpoints(config);
	private Iterator<String> epIterator ;
	
	@Before
	public void setUp() throws Exception {
		epIterator = endpoints.iterator();
	}

	@Test
	public void testIterator() {
		assertThat(epIterator, is(notNullValue()));
		assertThat(epIterator.hasNext(), is(true));
	}

	@Test
	public void testIteratorFunctionFirstEntry() {
		String firstUrl = null;
		firstUrl = epIterator.next();
		assertThat(firstUrl, is(notNullValue()));
		assertThat(firstUrl, is("http://abc.com/primary"));
		assertThat(epIterator.hasNext(), is(true));
	}
	
	@Test
	public void testIteratorFunctionSecondEntry() {
		@SuppressWarnings("unused")
		String firstUrl = epIterator.next();
		assertThat(epIterator.hasNext(), is(true));
		String secondUrl = null;
		secondUrl = epIterator.next();
		assertThat(secondUrl, is(notNullValue()));
		assertThat(secondUrl, is("http://abc.com/secondary"));
	}
	
	@Test
	public void testReadPastEnd() {
		String uriString = epIterator.next();
		uriString = epIterator.next();
		assertThat(uriString, is("http://abc.com/secondary"));
		assertThat(epIterator.hasNext(), is(false));
		try {
			uriString = epIterator.next();
			fail("exception should be thrown when reading past the end");
		} catch (Exception e) {
			// swallow the exception, it is what we wanted.
		}
		
	}
	
	@Test
	public void testNoRemoveOperation() {
		assertThat(epIterator.hasNext(), is(true));
		try {
			epIterator.remove();
			fail("Remove not supported");
		} 
		catch (UnsupportedOperationException e) {
			// Swallow the exception, it is what we wanted.
		}
	}
	
}
