package ru.dbd.services.security.storePrincipal;

import org.springframework.context.annotation.Profile;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.dbd.services.security.UserPrincipal;

/**
 * Created by vorh on 4/21/17.
 */

@Service
@Profile("prod")
public class StorePrincipalProd implements StorePrincipal {
    @Override
    public UserPrincipal user() {
        return (UserPrincipal) SecurityContextHolder.getContext().getAuthentication();
    }
}
