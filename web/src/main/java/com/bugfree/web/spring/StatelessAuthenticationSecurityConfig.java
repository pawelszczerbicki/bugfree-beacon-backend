package com.bugfree.web.spring;

import com.bugfree.web.auth.SocialAuthenticationSuccessHandler;
import com.bugfree.web.auth.SocialUserService;
import com.bugfree.web.auth.StatelessAuthenticationFilter;
import com.bugfree.web.auth.UserAuthenticationUserIdSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;


@EnableWebSecurity
@Configuration
public class StatelessAuthenticationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SocialAuthenticationSuccessHandler socialAuthenticationSuccessHandler;

    @Autowired
    private StatelessAuthenticationFilter statelessAuthenticationFilter;

    @Autowired
    private UserAuthenticationUserIdSource userIdSource;

    @Autowired
    private SocialUserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        final SpringSocialConfigurer socialConfigurer = new SpringSocialConfigurer();
        socialConfigurer.addObjectPostProcessor(new ObjectPostProcessor<SocialAuthenticationFilter>() {
            @Override
            public <O extends SocialAuthenticationFilter> O postProcess(O socialAuthenticationFilter) {
                socialAuthenticationFilter.setAuthenticationSuccessHandler(socialAuthenticationSuccessHandler);
                return socialAuthenticationFilter;
            }
        });

        http.addFilterBefore(statelessAuthenticationFilter, AbstractPreAuthenticatedProcessingFilter.class)
        .apply(socialConfigurer.userIdSource(userIdSource));
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    protected SocialUserService userDetailsService() {
        return userService;
    }
}
