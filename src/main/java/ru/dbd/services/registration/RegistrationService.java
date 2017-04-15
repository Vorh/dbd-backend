package ru.dbd.services.registration;

import ru.dbd.models.registration.StatusRegistration;
import ru.dbd.models.user.User;

/**
 * Created by vorh on 4/15/17.
 */
public interface RegistrationService {


    StatusRegistration register(User user);

    void recoveryAccess();
}
