package cn.gov.chinatax.gt4.swrdsm.core.assertions;

import cn.gov.chinatax.gt4.swrdsm.util.constant.Constant;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.tencent.gov.goff.common.v2.core.exception.GoffException;
import com.tencent.gov.goff.common.v2.pojo.bean.IErrorCode;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Supplier;


/**
 * AssertUtil 断言工具类
 *
 * @author huax
 */
public class AssertUtil {

    /*判断字符串非空*/
    public static void isNotNull(String str, String... message) {
        if (StrUtil.isBlank(str)) {
            execute(message);
        }
    }

    /*判断对象非空*/
    public static void isNotNull(Object obj, String... message) {
        if (ObjectUtil.isNull(obj)) {
            execute(message);
        }
    }

    /*判断字符串非空*/
    public static void isNotNull(String str, RuntimeException e) {
        if (StrUtil.isBlank(str)) {
            execute(e);
        }
    }

    /*判断对象非空*/
    public static void isNotNull(Object obj, RuntimeException e) {
        if (ObjectUtil.isNull(obj)) {
            execute(e);
        }
    }

    public static void isNull(@Nullable Object object, Supplier<String> messageSupplier) {
        if (object != null) {
            execute(nullSafeGet(messageSupplier));
        }
    }

    /*判断字符串非空*/
    public static void isNull(@Nullable Object object, IErrorCode errorCode) {
        if (object != null) {
            execute(errorCode);
        }
    }

    /*判断字符串非空*/
    public static void isNotNull(String str, IErrorCode errorCode) {
        if (StrUtil.isBlank(str)) {
            execute(errorCode);
        }
    }

    public static void isNotNull(@Nullable Object object, Supplier<String> messageSupplier) {
        if (object == null) {
            execute(nullSafeGet(messageSupplier));
        }
    }

    /*判断对象非空*/
    public static void isNotNull(Object obj, IErrorCode errorCode) {
        if (ObjectUtil.isNull(obj)) {
            execute(errorCode);
        }
    }

    /* 判断数组不为空 */
    public static void isNotEmpty(Collection collection, String... message) {
        if (ObjectUtil.isEmpty(collection)) {
            execute(message);
        }
    }

    /* 判断数组不为空 */
    public static void isNotEmpty(Collection collection, IErrorCode errorCode) {
        if (ObjectUtil.isEmpty(collection)) {
            execute(errorCode);
        }
    }

    /* 判断数组不为空 */
    public static void isNotEmpty(Collection collection, RuntimeException e) {
        if (ObjectUtil.isEmpty(collection)) {
            execute(e);
        }
    }

    /*判断结果是否为真*/
    public static void isTrue(Boolean isTrue, String... message) {
        if (!isTrue) {
            execute(message);
        }
    }

    public static void isTrue(boolean expression, Supplier<String> messageSupplier) {
        if (!expression) {
            execute(nullSafeGet(messageSupplier));
        }
    }

    /*判断结果是否为真*/
    public static void isTrue(Boolean isTrue, Consumer consumer, Object object, RuntimeException e) {
        if (!isTrue) {
            consumer.accept(object);
            execute(e);
        }
    }

    /*判断结果是否为真*/
    public static void isTrue(Boolean isTrue, Consumer consumer, Object object, String... message) {
        if (!isTrue) {
            consumer.accept(object);
            execute(message);
        }
    }

    /*判断结果是否为真*/
    public static void isTrue(Boolean isTrue, Consumer consumer, Object object, IErrorCode errorCod) {
        if (!isTrue) {
            consumer.accept(object);
            execute(errorCod);
        }
    }

    /*判断结果是否为真*/
    public static void isTrue(Boolean isTrue, IErrorCode errorCode) {
        if (!isTrue) {
            execute(errorCode);
        }
    }

    /*判断结果是否为真*/
    public static void isTrue(Boolean isTrue, RuntimeException e) {
        if (!isTrue) {
            execute(e);
        }
    }

    /*最终执行方法*/
    private static void execute(String... message) {

        String msg = Constant.Msg.ERROR_MESSAGE;
        if (message != null && message.length > 0) {
            msg = message[0];
        }
        throw new GoffException(Constant.CodeStr.FAILURE, msg);

    }

    /*最终执行方法*/
    private static void execute(RuntimeException e) {
        throw e;
    }

    /*最终执行方法*/
    private static void execute(IErrorCode errorCode) {
        throw new GoffException(errorCode);
    }


    @Nullable
    private static String nullSafeGet(@Nullable Supplier<String> messageSupplier) {
        return messageSupplier != null ? (String) messageSupplier.get() : null;
    }
}
