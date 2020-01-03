package com.aaa.repast.admin.framework.ftp;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/13 14:38
 * @Description
 **/
@Component
@ConfigurationProperties(prefix = "spring.ftp")
public class FtpProperties {
    //ftp服务器的ip地址
    private String ipAddr="192.168.1.4";
    //ftp服务器的端口号
    private Integer port=21;
    private String username="ftpuser";
    private String password="123456";
    // ftp服务器的根目录(图片的根目录)
    private String basePath="/home/ftp/www";
    //ftp服务器的显示地址
    private String httpPath="http://192.168.1.4";

    public String getIpAddr() {
        return ipAddr;
    }

    public Integer getPort() {
        return port;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getBasePath() {
        return basePath;
    }

    public String getHttpPath() {
        return httpPath;
    }
}
