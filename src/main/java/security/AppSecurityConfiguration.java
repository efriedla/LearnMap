package security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AppSecurityConfiguration
		extends WebSecurityConfigurerAdapter
{
	//3
	@Autowired
	private AppUserDetailsService  appUserDetailsService;

	public DaoAuthenticationProvider authenticationProvider(){
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService((UserDetailsService) appUserDetailsService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder(4));
		return provider;

	}
	//4
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
	//1
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.csrf().disable()


				.authorizeRequests()
				.antMatchers("/learner/register").permitAll()
				.antMatchers("/").permitAll()
				.antMatchers("/console/**").hasAuthority("ROLE_ADMIN")
				.antMatchers("/learner/**").hasAnyAuthority("ROLE_USER","ROLE_ADMIN")
				.anyRequest().authenticated()
				.and()
				.formLogin().loginPage("/login").usernameParameter("email").passwordParameter("password")
				.loginProcessingUrl("/login/authenticate")
				.defaultSuccessUrl("/")
				.failureUrl("/login?error=true")
				.permitAll()
//				.formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password").loginProcessingUrl("/login/authenticate").defaultSuccessUrl("/").failureUrl("/login?error=true").permitAll()
				.and()
				.logout().invalidateHttpSession(true)
				.clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/")
				.permitAll()
				.and()
				.exceptionHandling()
				.accessDeniedPage("/403");
	}

	//2
	@Override
	public void configure(final WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/imgs/**");
	}
}
