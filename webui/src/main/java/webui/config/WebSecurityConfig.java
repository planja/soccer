package webui.config;


import infrastructure.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by admin on 25.10.2016.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private IUserService userService;


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // For User in database.
        auth.userDetailsService(userService);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        // The pages does not require login
        http.authorizeRequests().antMatchers(
                "/"
        ).permitAll();

        // page requires login as USER or ADMIN.
        // If no login, it will redirect to /login page.
       /* http.authorizeRequests().antMatchers(
                "/admin"
        ).access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN', 'ROLE_OPERATOR')");*/


        // For ADMIN only.
        http.authorizeRequests().antMatchers(
                "/admin",
                "/admindata"
        ).access("hasRole('ROLE_ADMIN')");

        http.authorizeRequests().antMatchers(
                "/invoice",
                "/getUserInvoicesForNonUser",
                "/updateInvoiceForNonUser",
                "/deleteInvoiceForNonUser/**"
        ).access("hasAnyRole('ROLE_ADMIN', 'ROLE_OPERATOR')");

        // When the user has logged in as XX.
        // But access a page that requires role YY,
        // AccessDeniedException will throw.
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/denied");

        // Config for Login Form
        http.authorizeRequests().and().formLogin()
                .loginProcessingUrl("/j_spring_security_check")
                .loginPage("/login")
                //.defaultSuccessUrl("/")
                .failureUrl("/loginfailure")
                .usernameParameter("login")
                .passwordParameter("password")
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/");

    }
}