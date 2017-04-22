package ru.dbd.configuraions;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.dbd.services.security.storePrincipal.StorePrincipal;
import ru.dbd.services.security.storePrincipal.StorePrincipalDev;

/**
 * Created by vorh on 4/3/17.
 */
@Configuration
@ComponentScan("ru.dbd")
@Import({PersistenceConf.class, WebMvcConf.class,SecurityConf.class})
public class AppConf {

}
