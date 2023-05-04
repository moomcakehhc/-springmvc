package com.it.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({"com.it.controller", "com.it.config"})
@EnableWebMvc
public class SpringMvcConfig {

}
