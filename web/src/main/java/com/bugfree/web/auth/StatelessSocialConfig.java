package com.bugfree.web.auth;

import com.bugfree.commons.config.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.*;
import org.springframework.social.connect.mem.InMemoryUsersConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.linkedin.connect.LinkedInConnectionFactory;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;

import static com.bugfree.commons.config.Keys.*;

@Configuration
@EnableSocial
public class StatelessSocialConfig extends SocialConfigurerAdapter {

    @Autowired
    private ConnectionSignUp autoSignUpHandler;

    @Autowired
    private SocialUserService userService;

    @Autowired
    private ConfigService conf;

    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer cf, Environment env) {
        cf.addConnectionFactory(new FacebookConnectionFactory(conf.get(FACEBOOK_APP_ID), conf.get(FACEBOOK_APP_SECRET)));
        cf.addConnectionFactory(new TwitterConnectionFactory(conf.get(TWITTER_KEY), conf.get(TWITTER_SECRET)));
        cf.addConnectionFactory(new LinkedInConnectionFactory(conf.get(LINKED_IN_KEY), conf.get(LINKED_IN_SECRET)));
    }

    @Override
    public UserIdSource getUserIdSource() {
        // retrieve the UserId from the UserAuthentication in the security context
        return new UserAuthenticationUserIdSource();
    }

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        InMemoryUsersConnectionRepository repo = new InMemoryUsersConnectionRepository(connectionFactoryLocator);

        repo.setConnectionSignUp(autoSignUpHandler);

        return repo;
    }

    @Bean
    @Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
    public Facebook facebook(ConnectionRepository repository) {
        Connection<Facebook> connection = repository.findPrimaryConnection(Facebook.class);
        return connection != null ? connection.getApi() : null;
    }
}
