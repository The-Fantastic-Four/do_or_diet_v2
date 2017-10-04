/**
 * UserServiceImplementation enables user management
 * @author Ragnheiður Ásta Karlsdóttir rak4@hi.is
 * @author Viktor Alex Brynjarsson vab18@hi.is
 */
package is.hi.hbv.do_or_diet.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import is.hi.hbv.do_or_diet.model.Role;
import is.hi.hbv.do_or_diet.model.User;
import is.hi.hbv.do_or_diet.repository.RoleRepository;
import is.hi.hbv.do_or_diet.repository.UserRepository;

@Service("userService")
public class UserServiceImplementation implements UserService 
{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public User findUserByEmail(String email) 
	{
		return userRepository.findByEmail(email);
	}

	@Override
	public void saveUser(User user) 
	{
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);
		Role userRole = roleRepository.findByRole("ADMIN");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		
		userRepository.save(user);
	}

}
