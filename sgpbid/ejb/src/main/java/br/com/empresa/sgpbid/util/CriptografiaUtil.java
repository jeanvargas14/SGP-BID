/**
 * 
 */
package br.com.empresa.sgpbid.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;


/**
 * 23 de jun de 2016
 * @author roberto.conceicao
 *
 */
public class CriptografiaUtil {

	private CriptografiaUtil(){}
	
	public static String md5(String senha) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("MD5");		
		md.update(senha.getBytes());
		BigInteger hash = new BigInteger(1, md.digest());
		String senhaCriptografada = hash.toString (16);
		while ( senhaCriptografada.length()<32){
			senhaCriptografada = "0" + senhaCriptografada ;
		}
		return senhaCriptografada;
	}
	
	public static String md5_Base64(String senha) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(senha.getBytes());
		return Base64.encodeBase64String(md.digest());		
	}
}
