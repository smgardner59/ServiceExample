/**
 * 
 */
package zzz.service.example;


/**
 * @author scott.gardner
 *
 */
public interface BaseService<S, T> {
	public S call(T request);
}
