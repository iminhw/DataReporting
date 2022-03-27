package com.cap.datareporting.component.fileUpload.config;

import com.cap.datareporting.common.utils.SpringContextUtil;
import com.cap.datareporting.component.fileUpload.FileUpload;
import com.cap.datareporting.component.fileUpload.config.properties.UploadProjectProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class UploadFileConfigurer implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        UploadProjectProperties properties = SpringContextUtil.getBean(UploadProjectProperties.class);
        registry.addResourceHandler(properties.getStaticPath())
                .addResourceLocations("file:" + FileUpload.getUploadPath());
    }
}
