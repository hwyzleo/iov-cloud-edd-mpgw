package net.hwyz.iov.cloud.edd.mpgw.filter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * SEC-EIAM-DSN-CR-002：认证入口放行路径测试。
 * <p>
 * 登录与 OIDC 授权端点必须在未登录时可达（不受 Nacos 白名单配置影响）；受保护路径仍需令牌。
 *
 * @author hwyz_leo
 * @since 2026-11-17
 */
class AuthPublicPathsTest {

    private static final List<String> PUBLIC_PATHS = List.of(
            "/auth/login",
            "/auth/oauth2/authorize",
            "/auth/oauth2/login",
            "/auth/oauth2/token");

    @Test
    @DisplayName("登录与 OIDC 授权端点放行")
    void authEndpointsArePublic() {
        for (String path : PUBLIC_PATHS) {
            assertTrue(AuthFilter.matches(path, PUBLIC_PATHS), path + " 应放行");
        }
    }

    @Test
    @DisplayName("业务接口与带子路径的伪前缀不放行")
    void protectedPathsRequireToken() {
        assertFalse(AuthFilter.matches("/system/user/list", PUBLIC_PATHS));
        assertFalse(AuthFilter.matches("/auth/logout", PUBLIC_PATHS));
        assertFalse(AuthFilter.matches("/auth/oauth2/authorize/evil", PUBLIC_PATHS));
    }
}
