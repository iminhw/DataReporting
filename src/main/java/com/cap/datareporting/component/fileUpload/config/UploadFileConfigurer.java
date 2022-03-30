package com.cap.datareporting.component.fileUpload.config;

import com.cap.datareporting.common.utils.SpringContextUtil;
import com.cap.datareporting.component.fileUpload.FileUpload;
import com.cap.datareporting.component.fileUpload.config.properties.UploadProjectProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * https://www.cnblogs.com/to-red/p/11425770.html
 * https://blog.csdn.net/weixin_43575792/article/details/123418051
 * 静态资源配置    注入的目录不能使用中文！！！！！只能英文，否则无法访问
 */
@Configuration
public class UploadFileConfigurer implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        UploadProjectProperties properties = SpringContextUtil.getBean(UploadProjectProperties.class);
        registry.addResourceHandler(properties.getStaticPath())
                .addResourceLocations("file:" + FileUpload.getUploadPath());
    }
}
