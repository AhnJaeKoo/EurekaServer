package com.enuri.eureka.banner;

import org.springframework.boot.Banner;
import org.springframework.boot.ResourceBanner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public class BannerPrinter {

	private ConfigurableApplicationContext context;

	public BannerPrinter(ConfigurableApplicationContext context) {
		this.context = context;
	}

	public void print(Class<?> clazz) {
		Banner banner = getTextBanner();
	    banner.printBanner(context.getEnvironment(), clazz, System.out);
	}

	private Banner getTextBanner() {
		ResourceLoader resourceLoader = new DefaultResourceLoader(null);
		Resource resource = resourceLoader.getResource("banner.txt");
		if (resource.exists()) {
			return new ResourceBanner(resource);
		}
		return null;
	}
}
