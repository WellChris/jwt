package com.sixian.jwt.framework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Auther: ${WM}
 * @Date: 2019/1/31 15:10
 * @Description:
 *
 *  有的版本WebMvcConfigurationSupport这个接口会失效
 *  直接实现WebMvcConfigurer （官方推荐）
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor())
                .addPathPatterns("/**");
    }

    /**
     * 除了这种注入方式还可以用 @Autowired 的方式注入，否则会报错
     * @return
     */
    @Bean
    public AuthenticationInterceptor authenticationInterceptor() {
        return new AuthenticationInterceptor();
    }
}
