package cn.gov.chinatax.gt4.swrdsm.util.constant;

/**
 * @Copyright：Copyright (c) 2002-2023 Digitalchina CO.,LTD.  All rights reserved.
 * @Company：神州数码信息系统集成服务有限公司
 * @Department：税务地方大客户.CA
 * @Author：huax
 * @CreationTime：2023-03-01 10:31:00
 * @Version：1.0
 * @Compiler：1.8
 * @Description：Constant 全局常量
 */
public interface Constant {

    /**
     * UTF-8 字符集
     */
    String UTF8 = "UTF-8";

    /**
     * content-type 字符集
     */
    String CONTENT_TYPE = "application/json; charset=UTF-8";

    /**
     * GBK 字符集
     */
    String GBK = "GBK";

    /**
     * http请求
     */
    String HTTP = "http://";

    /**
     * https请求
     */
    String HTTPS = "https://";

    interface  BizConstant{

        Integer INSERT_NUM = 1000;

        Integer UPDATE_NUM = 500;
    }

    /* 时间 */
    interface DateFormatHandle{

        String YYYY = "yyyy";

        String YYYY_MM = "yyyy-MM";

        String YYYY_MM_DD = "yyyy-MM-dd";

        String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

        String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

        /* 时区 */
        String GMT_8 = "GMT+8";
    }

    interface  Msg{

        String SAVE_SUCCESS = "保存成功";

        String SAVE_FAILED = "保存失败";

        String SUCCESS ="操作成功";

        String FAILED ="操作失败";

        String ERROR_MESSAGE = "system erro[系统错误]";
    }

    /* 数字code */
    interface Code{

        /**
         * 操作成功
         */
        int SUCCESS = 200;

        /**
         * 操作失败
         */
        int FAILURE = 400;

        /**
         * 对象创建成功
         */
        int CREATED = 201;

        /**
         * 请求已经被接受
         */
        int ACCEPTED = 202;

        /**
         * 操作已经执行成功，但是没有返回数据
         */
        int NO_CONTENT = 204;

        /**
         * 资源已被移除
         */
        int MOVED_PERM = 301;

        /**
         * 重定向
         */
        int SEE_OTHER = 303;

        /**
         * 资源没有被修改
         */
        int NOT_MODIFIED = 304;

        /**
         * 参数列表错误（缺少，格式不匹配）
         */
        int BAD_REQUEST = 400;
        /**
         * 未授权
         */
        int UNAUTHORIZED = 401;

        /**
         * 访问受限，授权过期
         */
        int FORBIDDEN = 403;

        /**
         * 资源，服务未找到
         */
        int NOT_FOUND = 404;

        /**
         * 不允许的http方法
         */
        int BAD_METHOD = 405;

        /**
         * 资源冲突，或者资源被锁
         */
        int CONFLICT = 409;

        /**
         * 不支持的数据，媒体类型
         */
        int UNSUPPORTED_TYPE = 415;

        /**
         * 系统内部错误
         */
        int ERROR = 500;

        /**
         * 接口未实现
         */
        int NOT_IMPLEMENTED = 501;

        //非法签名
        Integer SIGN_FAIL_CODE = 405;
    }

    /* 字符code */
    interface CodeStr{
        /**
         * 操作成功
         */
        String SUCCESS = "200";
        /**
         * 操作失败
         */
        String FAILURE = "400";

        /**
         * 资源，服务未找到
         */
        String NOT_FOUND = "404";

        /**
         * 系统内部错误
         */
        String ERROR = "500";

    }
}
