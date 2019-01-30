package com.lunzn.artist;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lunzn.artist.util.DesUtil;

/**
 * DataSource SqlSeesion配置
 * 像普通JAVA程序一样启动
 * 
 * @author  suhongpeng
 * @version  [版本号, 2018年10月12日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@EnableTransactionManagement
@ConfigurationProperties
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
@ServletComponentScan
public class Application
{
    private static Logger logger = Logger.getLogger(Application.class);
    
    //获取加密的key
    @Value("${encrypt.key}")
    private String decryptKey;
    
    //加载数据库连接参数
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public Properties getDBProperties()
    {
        return new Properties();
    }
    
    /**
     * DataSource配置
     * @return DataSource
     * @see [类、类#方法、类#成员]
     */
    @Bean
    public DataSource dataSource()
    {
        Properties properties = getDBProperties();
        try
        {
            // 解密
            properties.setProperty("password", DesUtil.decrypt(properties.getProperty("password"), decryptKey));
        }
        catch (Exception e)
        {
            logger.error("解密数据库密码失败");
            throw new RuntimeException("解密数据库密码失败");
        }
        PoolProperties pool = JSON.parseObject(JSONObject.toJSONString(properties), PoolProperties.class);
        pool.setDbProperties(properties);
        return new org.apache.tomcat.jdbc.pool.DataSource(pool);
    }
    
    /**
     * sqlsessionFactory配置
     * @return sqlsessionFactory
     * @throws Exception 异常
     * @see [类、类#方法、类#成员]
     */
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean()
        throws Exception
    {
        
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }
    
    /**
     * main start
     * @param args 参数
     * @see [类、类#方法、类#成员]
     */
    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
        logger.info("============= SpringBoot Start Success =============");
    }
}
