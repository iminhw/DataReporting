package com.cap.datareporting;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author mz
 */
@MapperScan("com.**.dao")// 对自动生存得到的mapper 配置这个不用单个添加@Mapper
@SpringBootApplication
public class DataReportingApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataReportingApplication.class, args);
	}

}
