package spring.app.application.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import spring.app.application.model.Account;
import spring.app.application.service.AccountService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImp implements UserDetailsService {
    private final AccountService accountService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountService.findByUsername(username);
        if(account == null) {
            throw new UsernameNotFoundException("User " + username + "not found");
        }
        if(account.getRoles()==null||account.getRoles().isEmpty()){
            throw new RuntimeException("User has no role");
        }
        List<SimpleGrantedAuthority> authorities = account.getRoles()
                .stream().map(role -> new SimpleGrantedAuthority(role.getName())).toList();
        return new User(account.getUsername(), account.getPassword(), account.isEnabled()
                ,!account.isExpired(), !account.isCredentialexpired()
                ,!account.isLocked(), authorities);
    }
}
