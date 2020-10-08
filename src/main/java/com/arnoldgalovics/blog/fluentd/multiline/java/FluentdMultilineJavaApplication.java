package com.arnoldgalovics.blog.fluentd.multiline.java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@SpringBootApplication
@EnableScheduling
public class FluentdMultilineJavaApplication {
	private final static Logger log = LoggerFactory.getLogger(FluentdMultilineJavaApplication.class);

	@Autowired
	private ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(FluentdMultilineJavaApplication.class, args);
	}

	@Scheduled(fixedRate = 5000)
	public void log() {
		log.info("This is \na multiline\n\n\nlog");
	}

	private void m() {
	}

	@Scheduled(fixedRate = 10000)
	public void logException() {
		try {
			applicationContext.getBean("test");
		} catch (Exception e) {
			throw new RuntimeException("Error happened", e);
		}
	}
}
