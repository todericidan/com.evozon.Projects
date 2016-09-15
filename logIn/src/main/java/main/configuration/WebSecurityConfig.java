package main.configuration;

import main.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer.AuthorizedUrl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    SecurityService userDetailsService ;

    public WebSecurityConfig() {
    }

    protected void configure(HttpSecurity http) throws Exception {
        ((HttpSecurity)((FormLoginConfigurer)((HttpSecurity)((AuthorizedUrl)((AuthorizedUrl)http
                .authorizeRequests()
                .antMatchers(new String[]{"/", "/home","/index.html"}))
                .permitAll()
                .anyRequest())
                .authenticated()
                .and())
                .formLogin()
                .loginPage("/login")
                .permitAll())
                .and())
                .logout()
                .permitAll()
                .and().csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
                //inMemoryAuthentication().withUser("user").password("password").roles(new String[]{"USER"});
    }
}
