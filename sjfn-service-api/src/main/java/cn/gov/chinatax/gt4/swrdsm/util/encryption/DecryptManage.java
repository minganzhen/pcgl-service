package cn.gov.chinatax.gt4.swrdsm.util.encryption;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.math.BigInteger;

/**
 * 加密解密工具类
 */
@Component
public class DecryptManage {

    private static DictionaryUtil dictionaryUtil = DictionaryUtil.getInstance();
    private static MoveBlockUtil moveBlockUtil = MoveBlockUtil.getInstance();
    private static Base64Util base64Util = Base64Util.getInstance();
    private static RandomUtil randomUtil = RandomUtil.getInstance();

    /**
     * 解密
     *
     * @param string
     * @return
     */
    public String decryptText(String string) {
        try {
            int[] n = getOffset(string);
            if (string.contains("%23")) {
                string = string.replace("%23", "#");
            }
            string = string.substring(string.indexOf("#") + 1, string.length());
            string = doMove(n[2], string);
            string = doReverseCaesar(new int[]{n[0], n[1]}, string);
            string = decrypt(string);
        } catch (Exception e) {
            System.err.println("decryptText Exception, please check text");
        }
        DictionaryUtil.threadLocal.remove();
        MoveBlockUtil.threadLocal.remove();
        return string;
    }

    /**
     * 加密
     *
     * @param string
     * @return
     */
    public String encryptText(String string) {
        try {
            if (StringUtils.hasText(string)) {
                string = encrypt(string);
                int[] dictOffset = new int[]{getDictOffset(), getDictOffset()};
                string = doCaesar(dictOffset, string);
                int blockOffset = getBlockOffset();
                string = doMove(blockOffset, string);
                string = setOffset(string, dictOffset, blockOffset);
            }
        } catch (Exception e) {
            System.err.println("encryptText Exception, please check text ");
        }
        DictionaryUtil.threadLocal.remove();
        MoveBlockUtil.threadLocal.remove();
        return string;
    }

    /**
     * 凯撒变换
     *
     * @param offset
     * @param str
     * @return
     */
    private String doCaesar(int[] offset, String str) {
        dictionaryUtil.setOffset(offset);
        dictionaryUtil.createDictionary();
        return dictionaryUtil.caesar(str);
    }

    /**
     * 反凯撒变换
     *
     * @param offset
     * @param str
     * @return
     */
    private String doReverseCaesar(int[] offset, String str) {
        dictionaryUtil.setOffset(offset);
        dictionaryUtil.createDictionary();
        return dictionaryUtil.reverseCaesar(str);
    }

    /**
     * 块位移
     *
     * @param offset
     * @param str
     * @return
     */
    private String doMove(int offset, String str) {
        moveBlockUtil.setOffnum(offset);
        return moveBlockUtil.blockMove(str);
    }

    /**
     * base64加密
     *
     * @param str
     * @return
     */
    private String encrypt(String str) {
        str = base64Util.encrypt(str);
        return str;
    }

    /**
     * base64解密
     *
     * @param str
     * @return
     */
    private String decrypt(String str) {
        str = base64Util.decrypt(str);
        return str;
    }

    /**
     * 获取字典偏移随机值
     *
     * @return
     */
    private int getDictOffset() {
        return randomUtil.getDictOffset();
    }

    /**
     * 获取位移偏移随机值
     *
     * @return
     */
    private int getBlockOffset() {
        return randomUtil.getBlockMoveOffset();
    }

    /**
     * 将偏移值由36进制准换为10进制，并放入数组中使用
     *
     * @param str
     * @return
     */
    private int[] getOffset(String str) {
        if (str.contains("%23")) {
            str = str.replace("%23", "#");
        }
        str = str.substring(0, str.indexOf("#"));
        str = new BigInteger(str, 36).toString(10);
        return new int[]{Integer.parseInt(str.split("0")[0]), Integer.parseInt(str.split("0")[1]), Integer.parseInt(str.split("0")[2])};
    }

    /**
     * 将偏移值合并由10进制变为36进制，从而进行加密
     *
     * @param string
     * @param dictOffset
     * @param blockOffset
     * @return
     */
    private String setOffset(String string, int[] dictOffset, int blockOffset) {
        String bg = new BigInteger(dictOffset[0] + "0" + dictOffset[1] + "0" + blockOffset + "0", 10).toString(36);
        string = bg + "#" + string;
        return string;
    }
}
