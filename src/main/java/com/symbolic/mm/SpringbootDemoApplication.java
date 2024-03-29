package com.symbolic.mm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class SpringbootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);

	}
	@Bean
	public LocaleResolver localeResolver(){
//		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
//	@Bean
//	public ResourceBundleMessageSource messageSource(){
//		ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
//		resourceBundleMessageSource.setBasename("messages");
//		return resourceBundleMessageSource;
//	}

}
