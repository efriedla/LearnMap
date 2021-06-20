package security;

import com.example.demo.dao.IAuthGroupRepo;
import com.example.demo.dao.ILearnerRepo;
import com.example.demo.models.AuthGroup;
import com.example.demo.models.Learner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserDetailsService implements UserDetailsService {
	private final ILearnerRepo learnerRepo;
	private final IAuthGroupRepo authGroupRepo;

	@Autowired
	public AppUserDetailsService(ILearnerRepo learnerRepo, IAuthGroupRepo authGroupRepo) {
		this.learnerRepo = learnerRepo;
		this.authGroupRepo = authGroupRepo;
	}
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		return null;
//	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Learner> learner = learnerRepo.findBysUsername(username);
		if(learner.isEmpty())
			throw new UsernameNotFoundException("Cannot find Username: " + username);
		List<AuthGroup> authGroups = this.authGroupRepo.findByaUsername(username);
		return new AppUserPrincipal(learner.get(),authGroups);
	}
}
