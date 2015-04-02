package tw.edu.ncu.cc.manage.security;

import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.openid.OpenIDAttribute;
import org.springframework.security.openid.OpenIDAuthenticationToken;
import org.springframework.stereotype.Service;

import tw.edu.ncu.cc.manage.config.SecurityConfig;
import tw.edu.ncu.cc.manage.entity.Person;
import tw.edu.ncu.cc.manage.service.login.IPersonService;

import com.google.inject.internal.Lists;

@Service
public class MyUserDetailService implements AuthenticationUserDetailsService<OpenIDAuthenticationToken> {

	private static final Logger logger = Logger.getLogger(MyUserDetailService.class);
	
	private static final String PREFIX = "https://portal.ncu.edu.tw/user/";
	
	@Autowired
	private IPersonService personService;
	
	/**
	 * STUDENT: 在校生
	 * FACULTY: 教職員
	 * ALUMNI: 校友
	 */
	private static final List<String> PERMIT_ROLES = Lists.newArrayList("STUDENT", "FACULTY", "ALUMNI");

	@Override
	public UserDetails loadUserDetails(OpenIDAuthenticationToken token) throws UsernameNotFoundException, NoSuchUserRoleException {
		
		logger.debug(token);
		
		checkRoleAvailibility(token);
		
		String account = ((String) token.getPrincipal()).substring(PREFIX.length());
		
		Optional<Person> person = this.personService.findByAccount(account);
		if (person.isPresent()) {
			return person.get();
		}
		
		throw new UsernameNotFoundException("Username not found for " + account);
	}

	/**
	 * make sure login user is allowed to access OAuth Management.
	 * @param token
	 */
	private void checkRoleAvailibility(OpenIDAuthenticationToken token) {
		
		List<OpenIDAttribute> attributes = token.getAttributes();
		for (OpenIDAttribute attribute : attributes) {
			if (isRoleAttribute(attribute)) {
				if (noSuchRoles(attribute)) {
					throw new NoSuchUserRoleException(token, PERMIT_ROLES);
				}
			}
		}
	}
	
	private boolean isRoleAttribute(OpenIDAttribute attribute) {
		return SecurityConfig.AX_NAME_ROLE.equals(attribute.getName());
	}
	
	private boolean noSuchRoles(OpenIDAttribute attribute) {
		List<String> roles = attribute.getValues();
		return CollectionUtils.intersection(roles, PERMIT_ROLES).isEmpty();
	}
}
