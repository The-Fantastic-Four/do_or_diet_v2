/**
 * UserService describes classes that enable user management
 * 
 * @author Ragnheiður Ásta Karlsdóttir rak4@hi.is
 * @author Viktor Alex Brynjarsson vab18@hi.is
 */
package is.hi.hbv.do_or_diet.service;

import org.springframework.stereotype.Service;

import is.hi.hbv.do_or_diet.model.User;

@Service("userService")
public interface UserService
{
	public User findUserByEmail(String email);

	public void saveUser(User user);
}
