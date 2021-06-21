package security;

import com.example.demo.models.AuthGroup;
import com.example.demo.models.Learner;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class AppUserPrincipal implements UserDetails {
	private Learner learner;
	private List<AuthGroup> authGroups;

	public AppUserPrincipal(Learner learner, List<AuthGroup> authGroups) {
		this.learner = learner;
		this.authGroups = authGroups;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if(null == authGroups){
			return Collections.emptySet();
		}
		Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();
		authGroups.forEach(authGroup -> {
			grantedAuthorities.add(new SimpleGrantedAuthority(authGroup.getAAuthGroup()));
		});
		return grantedAuthorities;

		// return Collections.singleton(new SimpleGrantedAuthority("USER"));
	}

	@Override
	public String getPassword() {
		return this.learner.getPassword();
	}

	@Override
	public String getUsername() {
		return this.learner.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
