package com.codegym.service;

import com.codegym.repository.IBlogRepository;
import com.codegym.service.blog.BlogService;
import com.codegym.service.blog.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.mockito.Mockito;

@Configuration
@ComponentScan(basePackages = "com.codegym.service")
public class BlogServiceTestConfig {
    @Autowired
    private IBlogRepository blogRepository;

    @Bean
    public IBlogService blogService() {
        return new BlogService(blogRepository);
    }

    @Bean
    public IBlogRepository blogRepository() {
        return Mockito.mock(IBlogRepository.class);
    }
}
