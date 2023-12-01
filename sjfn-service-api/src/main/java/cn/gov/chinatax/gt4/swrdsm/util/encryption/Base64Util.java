package cn.gov.chinatax.gt4.swrdsm.util.encryption;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * 简单的base64加解密
 */
public class Base64Util {

    private static Base64Util base64Util;

    public static synchronized Base64Util getInstance(){

        if(base64Util==null){
            base64Util = new Base64Util();
        }

        return base64Util;
    }

    public String encrypt(String str){
        String returnString = null;
        returnString = Base64.getEncoder().encodeToString(str.getBytes(StandardCharsets.UTF_8));
        return returnString;
    }

    public String decrypt(String str){
        String returnString = null;
        byte[] base64decodedBytes = Base64.getDecoder().decode(str);
        returnString = new String(base64decodedBytes, StandardCharsets.UTF_8);
        return returnString;
    }
}
