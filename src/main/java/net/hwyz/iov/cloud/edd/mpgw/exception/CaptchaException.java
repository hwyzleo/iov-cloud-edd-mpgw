package net.hwyz.iov.cloud.edd.mpgw.exception;

/**
 * 验证码错误异常类
 *
 * @author hwyz_leo
 */
public class CaptchaException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CaptchaException(String msg) {
        super(msg);
    }
}
