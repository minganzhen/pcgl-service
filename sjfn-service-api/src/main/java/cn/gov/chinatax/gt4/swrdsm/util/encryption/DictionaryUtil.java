package cn.gov.chinatax.gt4.swrdsm.util.encryption;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 创建加密解密字典，分别为大写、小写单独匹配，字典格式为{A=X，B=Y，C=Z，...,a=r,b=s,c=t...}
 * 对应字典则由传入的随机数来生成
 */
public class DictionaryUtil {
    private static DictionaryUtil dictionaryUtil;

    private final static char[] STRL = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    };

    private final static char[] STRU = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    public static ThreadLocal<Map> threadLocal = new ThreadLocal();

    public int[] getOffset() {
        initThreadLocal();
        return (int[]) threadLocal.get().get("offset");
    }

    public void setOffset(int[] offset) {
        initThreadLocal();
        threadLocal.get().put("offset", offset);
    }

    public Map<Character, Character> getDictionary() {
        initThreadLocal();
        return (Map<Character, Character>)threadLocal.get().get("dictionary");

    }

    public void setDictionary(Map<Character, Character> dictionary) {
        initThreadLocal();
        threadLocal.get().put("dictionary", dictionary);
    }

    public Map<Character, Character> getReverseDictionary() {
        initThreadLocal();
        return (Map<Character, Character>)threadLocal.get().get("reverseDictionary");
    }

    public void setReverseDictionary(Map<Character, Character> reverseDictionary) {
        initThreadLocal();
        threadLocal.get().put("reverseDictionary", reverseDictionary);
    }

    public static synchronized DictionaryUtil getInstance() {
        if (threadLocal.get() == null || dictionaryUtil == null) {
            dictionaryUtil = new DictionaryUtil();
            initThreadLocal();
        }
        return dictionaryUtil;
    }

    private static void initThreadLocal() {
        if (threadLocal.get() == null) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap<String, Object>() {
                {
                    put("reverseDictionary", new HashMap<Character, Character>());
                    put("dictionary", new HashMap<Character, Character>());
                }
            };
            DictionaryUtil.threadLocal.set(concurrentHashMap);
        }
    }

    /**
     * 创建字典，无论是加密还是解密都需要使用传入的偏移值来创建
     * 加密时使用的是随机数来创建，解密时是使用密文中记录的偏移值来创建
     */
    public void createDictionary() {
        char[] newStrL = STRL.clone();
        char[] newStrU = STRU.clone();
        int index = newStrL.length - getOffset()[0];
        //创建小写字母加密、解密字典
        for (int i = 0; i < newStrL.length; i++) {
            char tmpchar = newStrL[i];
            if(i < index){
                newStrL[i] += getOffset()[0];
            }else{
                newStrL[i] -= index;
            }
            getDictionary().put(tmpchar,newStrL[i]);
            getReverseDictionary().put(newStrL[i],tmpchar);
        }
        index = newStrU.length - getOffset()[1];
        //创建大写字母加密、解密字典
        for (int i = 0; i < newStrU.length; i++) {
            char tmpchar = newStrU[i];
            if(i < index){
                newStrU[i] += getOffset()[1];
            }else{
                newStrU[i] -= index;
            }
            getDictionary().put(tmpchar,newStrU[i]);
            getReverseDictionary().put(newStrU[i],tmpchar);
        }
    }

    public String caesar(String str){
        return getString(str, getDictionary());
    }

    public String reverseCaesar(String str){
        return getString(str, getReverseDictionary());
    }

    /**
     * 根据字典翻译字符串
     * @param str
     * @param dictionary
     * @return
     */
    private String getString(String str, Map<Character, Character> dictionary) {
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0 ; i < str.length() ; i ++){
            Character ch = str.charAt(i);
            stringBuffer.append(dictionary.get(ch)==null?ch: dictionary.get(ch));
        }
        return stringBuffer.toString();
    }
}
