/**
 * 
 */
package br.com.empresa.sgpbid.util;

import java.security.NoSuchAlgorithmException;

import org.junit.Test;

import junit.framework.Assert;

/**
 * 23 de jun de 2016
 * @author roberto.conceicao
 *
 */
public class TestCriptografiaUtil {

	
	@Test	
	public void testMD5Sucesso(){		
		try {
			Assert.assertEquals("9f9d51bc70ef21ca5c14f307980a29d8", CriptografiaUtil.md5("bob"));
			Assert.assertEquals("b71985397688d6f1820685dde534981b", CriptografiaUtil.md5("jean"));
			Assert.assertEquals("0b99c246bcb803eb4afc107419cd79b9", CriptografiaUtil.md5("sgp"));
		} catch (NoSuchAlgorithmException e) {		
			Assert.fail();
		}
	}
}
