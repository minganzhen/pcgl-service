package cn.gov.chinatax.gt4.swrdsm.util.encryption;

import java.util.Random;

/**
 * 创建随机数工具类
 */
public class RandomUtil {
    private static RandomUtil randomUtil;
    private Random random;

    public static synchronized RandomUtil getInstance() {
        if (randomUtil == null) {
            randomUtil = new RandomUtil();
            randomUtil.random = new Random();
        }
        return randomUtil;
    }

    /**
     * 创建字典偏移随机值
     * @return
     */
    public int getDictOffset(){
        int offset = random.nextInt(15)+5;
        if(offset == 10){
            offset = getDictOffset();
        }
        return offset;
    }


    /**
     *  创建字典偏移随机值
     * @return
     */
    public int getBlockMoveOffset(){
        Random random = new Random();
        return random.nextInt(5)+1;
    }
}
