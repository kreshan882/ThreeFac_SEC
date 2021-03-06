/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcs.utill;

import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.Security;
import javax.crypto.Cipher;
import org.jpos.iso.ISOUtil;

/**
 *
 * @author Kreshan
 */
public class SSLHelper {

public static void main(String arg[]){
    String encmsg="77FC9B8EE567AC5842C5FE9E5BDDA0F8DA77E8E1F6EFE16C1D2E382DC09E9E99E5A3F4D64B83015CDDA35D2AF6FCFC094658793DC3EF60B90A00D22E8E62BDCC2B9DEEE53169F3AC978942026E3500746B57C5AE89A72F8A0713260237B4FEA0B97F31BCA8725D94E7C5DEDDDEDE998D1B19ED5387B03B27F95E34684F5EB9FA76C22D5F153F1AE8A8852190F077A603E2F0DF68B7AA857FDBE7D9C422458447D0CAE104F84951E1F2FEBBB5756975113B8436091D40C69AB090DB3308C262EEE2E37139D627F4889DBE5052C9FE688B78F462EC7668AE11194BD711C534B7D125DBAC17E1C60B0B9BFA26CB7D5DD3D5DB617C1BA7083E494B897DA14F1B108C";
    String res=SSLHelper.decrypetByPrivateKEY(encmsg);
    System.out.println(">>>"+res);
    
}


    public static String decrypetByPrivateKEY(String encMsg){
        String decryption="";
        try{ 
                Provider PKI_PROVIDER = new org.bouncycastle.jce.provider.BouncyCastleProvider();
		Security.addProvider(PKI_PROVIDER);
                SysConfiguration.RSA_PrivateKey=SSLHelper.getPrivateKey();

                Cipher cipher = Cipher.getInstance("RSA/NONE/PKCS1Padding","BC");
                cipher.init(Cipher.DECRYPT_MODE, SysConfiguration.RSA_PrivateKey);
                byte[] res = cipher.doFinal(ISOUtil.hex2byte(encMsg));
                decryption= new String(res);
        }catch(Exception e){
            e.printStackTrace();
        }
       return decryption;
    }
        
 

     private static PrivateKey getPrivateKey() throws Exception {
             KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
             FileInputStream fi = new FileInputStream(new File(SysConfiguration.FILE_PATH));
	     ks.load(fi, SysConfiguration.KS_PW.toCharArray());
	     PrivateKey pk = (PrivateKey)ks.getKey(SysConfiguration.ALIES, SysConfiguration.KEW_PW.toCharArray());
        return pk;
    }
}
