package net.hwyz.iov.cloud.edd.mpgw.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.hwyz.iov.cloud.framework.common.exception.ErrorCode;

/**
 * 管理后台网关错误码
 *
 * @author hwyz_leo
 */
@Getter
@AllArgsConstructor
public enum MpgwErrorCode implements ErrorCode {

    UNAUTHORIZED("001", "用户未认证");

    private final static String PREFIX = "801";

    private final String code;
    private final String message;

    @Override
    public String getCode() {
        return PREFIX + code;
    }

}
