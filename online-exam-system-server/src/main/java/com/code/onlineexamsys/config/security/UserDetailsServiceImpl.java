package com.code.onlineexamsys.config.security;

import com.code.onlineexamsys.entity.Role;
import com.code.onlineexamsys.entity.User;
import com.code.onlineexamsys.repository.UserRepository;
import com.code.onlineexamsys.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("用户不存在");
        }
        List<Role> roles = userRoleRepository.findRolesByUserId(user.getId());
        List<String> role = roles.stream()
                .map(Role::getName)
                .toList();
        return new AuthUser(user,role);
    }
}
