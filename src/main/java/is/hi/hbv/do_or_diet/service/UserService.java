/**
 * 
 */
package is.hi.hbv.do_or_diet.service;

import org.springframework.stereotype.Service;

import is.hi.hbv.do_or_diet.model.User;

/**
 * @author heida
 *
 */
@Service("userService")
public interface UserService 
{
	public User findUserByEmail(String email);
	public void saveUser(User user);
}
