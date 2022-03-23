package com.cap.datareporting.common.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

public class UserPassOpenIdToken extends UsernamePasswordToken {

    public UserPassOpenIdToken(){
        super();
    }

    public String getLoginType() {
        return loginType;
    }
    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    // 0为用户密码登录，1为第三方登录登录
    private String loginType = "0";

    public UserPassOpenIdToken(final String username, final String password,
                               String loginType) {
        super(username, password);
        this.loginType = loginType;

    }


}
