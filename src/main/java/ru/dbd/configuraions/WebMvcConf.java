package ru.dbd.configuraions;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by vorh on 4/12/17.
 */
@Configuration
@EnableWebMvc
@ComponentScan("ru.dbd")
public class WebMvcConf {
}
