package cn.gov.chinatax.gt4.swrdsm.core.advice;


import com.tencent.gov.goff.common.v2.core.configuration.ExceptionHandlerController;
import com.tencent.gov.goff.common.v2.core.util.IDUtils;
import com.tencent.gov.goff.common.v2.pojo.bean.ServerResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import static com.tencent.gov.goff.common.v2.pojo.bean.ErrorCode.INVALID_PARAMETER;

/**
 * 全局异常处理器
 *
 * 扩展goff的全局异常处理、避免一些异常信息直接抛出 status为500的情况  继承 {@link ExceptionHandlerController}
 *
 * @author huax
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ExceptionHandlerController {


    public GlobalExceptionHandler(){
        super();
    }

    /**
     * 处理 Validator 校验不通过产生的异常
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<ServerResponse<Object>> constraintViolationExceptionHandler(ConstraintViolationException ex) {
        log.warn("[constraintViolationExceptionHandler] esg={}", ex.getMessage());
        ConstraintViolation<?> constraintViolation = ex.getConstraintViolations().iterator().next();
        String requestId = MDC.get("X-B3-TraceId") != null ? MDC.get("X-B3-TraceId") : IDUtils.randomUUID();
        if (log.isDebugEnabled()) {
            log.error(ex.getMessage(), ex);
        }
        ServerResponse<Object> fail = ServerResponse.fail(INVALID_PARAMETER, ex.getMessage() + constraintViolation.getMessage());
        fail.getResponse().setRequestId(requestId);
        return new ResponseEntity(fail, HttpStatus.OK);
    }

    @ExceptionHandler(value = BindException.class)
    public ResponseEntity<ServerResponse<Object>> bindExceptionHandler(BindException ex) {
        log.warn("[constraintViolationExceptionHandler] esg={}", ex.getMessage());
        FieldError fieldError = ex.getFieldError();
        assert fieldError != null; // 断言，避免告警
        String requestId = MDC.get("X-B3-TraceId") != null ? MDC.get("X-B3-TraceId") : IDUtils.randomUUID();
        if (log.isDebugEnabled()) {
            log.error(ex.getMessage(), ex);
        }
        ServerResponse<Object> fail = ServerResponse.fail(INVALID_PARAMETER,fieldError.getDefaultMessage());
        fail.getResponse().setRequestId(requestId);
        return new ResponseEntity(fail, HttpStatus.OK);
    }
}
