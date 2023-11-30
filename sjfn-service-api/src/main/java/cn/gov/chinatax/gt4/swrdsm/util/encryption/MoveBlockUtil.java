package cn.gov.chinatax.gt4.swrdsm.util.encryption;

/**
 * 块移位，主要是根据偏移值来截取字符串，然后进行块位移，例如 1 2 3 位移后成为 3 2 1
 */
public class MoveBlockUtil {
    private static MoveBlockUtil moveBlockUtil;

    public static ThreadLocal<Integer> threadLocal;

    public int getOffnum() {
        return threadLocal.get();
    }

    public void setOffnum(int offnum) {
        threadLocal.set(offnum);
    }

    public static synchronized MoveBlockUtil getInstance() {
        if (moveBlockUtil == null || threadLocal == null) {
            moveBlockUtil = new MoveBlockUtil();
            threadLocal = new ThreadLocal<>();
        }
        return moveBlockUtil;
    }

    public String blockMove(String string) {
        StringBuffer symbol = new StringBuffer();
        string = recordSymbol(string,symbol);
        StringBuffer stringBuffer = new StringBuffer();
        int length = string.length();
        int blockLength = length / getOffnum();
        int modLength = length % getOffnum();
        for (int i = getOffnum(); i > 0; i--) {
            stringBuffer.append(string.substring(blockLength * (i - 1), blockLength * i));
        }
        ////长度除偏移值如果有余数，将余数长度字符串放到最后
        if (modLength > 0) {
            stringBuffer.append(string.substring(blockLength * getOffnum(), string.length()));
        }
        stringBuffer.append(symbol);
        return stringBuffer.toString();
    }

    /**
     * 处理base64加密字符串最后的等号
     * @param string
     * @param symbol
     * @return
     */
    private String recordSymbol(String string,StringBuffer symbol){
        if(string.lastIndexOf("=")==(string.length()-1)){
            symbol.append("=");
            string = string.substring(0,string.length()-1);
            string = recordSymbol(string,symbol);
        }
        return string;
    }
}
