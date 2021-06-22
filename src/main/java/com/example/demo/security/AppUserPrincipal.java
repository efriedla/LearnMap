//package com.example.demo.security;
//
//import com.example.demo.models.AuthGroup;
//import com.example.demo.models.Learner;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.*;
//
///**
// * this is where the Auth finds the users credentials
// * ALSO known as AppUserDetails
//**/
//public class AppUserPrincipal
//		implements UserDetails
//{
//	private Learner learner;
//	private List<AuthGroup> authGroups;
//
//	public AppUserPrincipal(Learner learner, List<AuthGroup> authGroups) {
//		this.learner = learner;
//		this.authGroups = authGroups;
//	}
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		if(null == authGroups){
//			return Collections.emptySet();
//		}
//		// init
//		Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();
//		// has a username and a group looped through and back into grantedAuthorities
//		authGroups.forEach(authGroup -> {
//			grantedAuthorities.add(new SimpleGrantedAuthority(authGroup.getAAuthGroup()));
//		});
//		// ["ROLE_ADMIN", "ROLE_USER", "WRITE]
//		return grantedAuthorities;
//
//	}
//
//	@Override
//	public String getPassword() {
//		return this.learner.getPassword();
//	}
//
//	@Override
//	public String getUsername() {
//		return this.learner.getUsername();
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		return true;
//	}
//}
