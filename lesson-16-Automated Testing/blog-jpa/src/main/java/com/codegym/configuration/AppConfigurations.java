package com.codegym.configuration;

import com.codegym.formatter.CategoryFormatter;
import com.codegym.service.category.CategoryService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.format.FormatterRegistry;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan("com.codegym")
@EnableJpaRepositories("com.codegym.repository")
@EnableSpringDataWebSupport
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class AppConfigurations implements WebMvcConfigurer, ApplicationContextAware {
    @Value("${template.location.prefix}")
    private String templateLocationPrefix;
    @Value("${template.location.suffix}")
    private String templateLocationSuffix;
    @Value("${jpa.datasource.driver}")
    private String datasourceDriver;
    @Value("${jpa.datasource.url}")
    private String datasourceUrl;
    @Value("${jpa.datasource.username}")
    private String datasourceUsername;

    @Value("${jpa.datasource.password}")
    private String datasourcePassword;

    @Value("${hibernate.hbm2ddl.auto}")
    private String hibernateDdlAuto;

    @Value("${hibernate.dialect}")
    private String hibernateDialect;
    ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
    @Bean
    public SpringResourceTemplateResolver templateResolver(){
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix(templateLocationPrefix);
        templateResolver.setSuffix(templateLocationSuffix);
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding("UTF-8");
        return templateResolver;
    }
    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }
    @Bean
    public ThymeleafViewResolver viewResolver(){
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setCharacterEncoding("UTF-8");
        return viewResolver;
    }
    @Bean
    @Qualifier("entityManager")
    public EntityManager entityManager(EntityManagerFactory entityManagerFactory){
            return entityManagerFactory.createEntityManager();
    }
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean em= new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("com.codegym.model");
        JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(jpaVendorAdapter);
        em.setJpaProperties(properties());
        return em;
    }
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(datasourceDriver);
        dataSource.setUrl(datasourceUrl);
        dataSource.setUsername(datasourceUsername);
        dataSource.setPassword(datasourcePassword);
        return dataSource;
    }
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }
    Properties properties(){
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto",hibernateDdlAuto);
        properties.setProperty("hibernate.dialect", hibernateDialect);
        properties.setProperty("javax.persistence.validation.mode", "none");
        return properties;
    }
    @Override
    public void addFormatters(FormatterRegistry registry){
        registry.addFormatter(new CategoryFormatter(applicationContext.getBean(CategoryService.class)));
    }


}
