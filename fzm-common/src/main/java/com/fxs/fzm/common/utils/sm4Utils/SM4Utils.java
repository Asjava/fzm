package com.fxs.fzm.common.utils.sm4Utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SM4Utils
{
    public String secretKey = "HENG1AN2WEN3YIN4";
	private String iv = "";
    public boolean hexString = false;

	public SM4Utils()
	{
	}

	public String encryptData_ECB(String plainText)
	{
		try
		{
			SM4_Context ctx = new SM4_Context();
			ctx.isPadding = true;
			ctx.mode = SM4.SM4_ENCRYPT;

			byte[] keyBytes;
			keyBytes = secretKey.getBytes();
			SM4 sm4 = new SM4();
			sm4.sm4_setkey_enc(ctx, keyBytes);
			byte[] encrypted = sm4.sm4_crypt_ecb(ctx, plainText.getBytes("UTF-8"));
			String cipherText = new BASE64Encoder().encode(encrypted);
			if (cipherText != null && cipherText.trim().length() > 0)
			{
				Pattern p = Pattern.compile("\\s*|\t|\r|\n");
				Matcher m = p.matcher(cipherText);
				cipherText = m.replaceAll("");
			}
			return cipherText;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public String decryptData_ECB(String cipherText)
	{
		try
		{
			SM4_Context ctx = new SM4_Context();
			ctx.isPadding = true;
			ctx.mode = SM4.SM4_DECRYPT;
			byte[] keyBytes;
			keyBytes = secretKey.getBytes();
			SM4 sm4 = new SM4();
			sm4.sm4_setkey_dec(ctx, keyBytes);
			byte[] decrypted = sm4.sm4_crypt_ecb(ctx, new BASE64Decoder().decodeBuffer(cipherText));
			return new String(decrypted, "UTF-8");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public String encryptData_CBC(String plainText){
		try{
			SM4_Context ctx = new SM4_Context();
			ctx.isPadding = true;
			ctx.mode = SM4.SM4_ENCRYPT;

			byte[] keyBytes;
			byte[] ivBytes;

			keyBytes = secretKey.getBytes();
			ivBytes = iv.getBytes();

			SM4 sm4 = new SM4();
			sm4.sm4_setkey_enc(ctx, keyBytes);
			byte[] encrypted = sm4.sm4_crypt_cbc(ctx, ivBytes, plainText.getBytes("UTF-8"));
			String cipherText = new BASE64Encoder().encode(encrypted);
			if (cipherText != null && cipherText.trim().length() > 0)
			{
				Pattern p = Pattern.compile("\\s*|\t|\r|\n");
				Matcher m = p.matcher(cipherText);
				cipherText = m.replaceAll("");
			}
			return cipherText;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public String decryptData_CBC(String cipherText)
	{
		try
		{
			SM4_Context ctx = new SM4_Context();
			ctx.isPadding = true;
			ctx.mode = SM4.SM4_DECRYPT;

			byte[] keyBytes;
			byte[] ivBytes;
			if (hexString)
			{
				keyBytes = Util.hexStringToBytes(secretKey);
				ivBytes = Util.hexStringToBytes(iv);
			}
			else
			{
				keyBytes = secretKey.getBytes();
				ivBytes = iv.getBytes();
			}

			SM4 sm4 = new SM4();
			sm4.sm4_setkey_dec(ctx, keyBytes);
			byte[] decrypted = sm4.sm4_crypt_cbc(ctx, ivBytes, new BASE64Decoder().decodeBuffer(cipherText));
			return new String(decrypted, "UTF-8");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public String encryptData_ECB(String plainText, String secretKey)
	{
		try
		{
			SM4_Context ctx = new SM4_Context();
			ctx.isPadding = true;
			ctx.mode = SM4.SM4_ENCRYPT;

			byte[] keyBytes;
			keyBytes = secretKey.getBytes();
			SM4 sm4 = new SM4();
			sm4.sm4_setkey_enc(ctx, keyBytes);
			byte[] encrypted = sm4.sm4_crypt_ecb(ctx, plainText.getBytes("UTF-8"));
			String cipherText = new BASE64Encoder().encode(encrypted);
			if (cipherText != null && cipherText.trim().length() > 0)
			{
				Pattern p = Pattern.compile("\\s*|\t|\r|\n");
				Matcher m = p.matcher(cipherText);
				cipherText = m.replaceAll("");
			}
			return cipherText;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public String decryptData_ECB(String cipherText, String secretKey)
	{
		try
		{
			SM4_Context ctx = new SM4_Context();
			ctx.isPadding = true;
			ctx.mode = SM4.SM4_DECRYPT;

			byte[] keyBytes;
			keyBytes = secretKey.getBytes();
			SM4 sm4 = new SM4();
			sm4.sm4_setkey_dec(ctx, keyBytes);
			byte[] decrypted = sm4.sm4_crypt_ecb(ctx, new BASE64Decoder().decodeBuffer(cipherText));
			return new String(decrypted, "UTF-8");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) throws IOException
	{
//		String plainText ="{username: \"admin\", password: \"123456\", yanzhengma: \"\",serviceUrl: \"/home\"}";
//		//String plainText ="{orgUid: \"UID1\", appUserId: \"be0ffbddb21e46354202b0a2e67308e3a2977458\", pageNum: \"1\", pageSize: \"10\"}";
//		//String plainText ="{orgUid: \"1909199754\"}";
		SM4Utils sm4 = new SM4Utils();
//		sm4.secretKey = "HENG1AN2WEN3YIN4";
//		plainText.getBytes("UTF-8");
//		System.out.println("ECB模式");
//		String cipherText = sm4.encryptData_ECB(plainText);
//		System.out.println("密文: " + cipherText);
//		System.out.println("");
		String s = null;

		s = sm4.decryptData_ECB("oDrXyWwdPmDHAj8D50aVhBPR0iPFNmVlYpPjURsKUcxFRLzWhNqb9YtwVybqSmHR0xg1FFor+AJBcABoXqQmmlzTJYvYM1jaSg9MTEzDZNbZzIUB7EIbLgi5TFwG4YLZsmAMjxvU6E8DK4v68WqpG5CY/rxu+u7kmeWsgHuzZpfNrSRP6Ja3xIsO2v+PTuk8UCIgJq9ZkCwsXfJq/ZCHAcINWQ0fRutm9ob85A0RhFNGrUfkQbbWqPxEXtJ+pDH+LYZix3jzO74rU3TVyP893+kzFLXYGeSmy7g0cf5e1/ZU6US4vWDaaATu5aPuB66tXBkRoClRn3dDMJhPVg/3UzzoddW60xMgX58cVD0PTLZajjoEEmoi4avMzc3x5erSsbBJjEWFGt+EmzVVgbx4Tx+k8VC4vcUjpoxtiAcBYpbx4Tfz1YXtyqy1dfHxGT3P4yK8SJYiL9Qj0wsQ8pIOb/MRi//I1w4MgbdWAVipQtboUAAgvnvQWhBzZ+788XKC73+njCFZdY7iGuJ/J2D2hg==");
		System.out.println("明文: " + s);
		System.out.println("");

	}
}
