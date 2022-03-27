package com.cap.datareporting.component.fileUpload.config.properties;

import com.cap.datareporting.common.utils.ToolUtil;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 项目-文件上传配置项
 */
@Data
@Component
//https://blog.csdn.net/m0_37626813/article/details/78558010
//Component把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>
@ConfigurationProperties(prefix = "project.upload")
public class UploadProjectProperties {

    /**
     * 上传文件路径
     */
    private String filePath;

    /**
     * 上传文件静态访问路径
     */
    private String staticPath = "/upload/**";
    /**
     * 上传文件静态访问路径
     */
    private String jarPath = "/**";

    /**
     * 获取文件路径
     */
    public String getFilePath() {
        if (filePath == null) {
            return ToolUtil.getProjectPath() + "/upload/";
        }
        return filePath;
    }
}
