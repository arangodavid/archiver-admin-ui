package com.mycervello.adb.config.spring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mycervello.adb.config.AppProps;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
	
	//
	//Constants
	//
	public static final List<String> STATIC_RESOURCE_FOLDERS = Arrays.asList("assets", "dist");
	//
	
	//
	//Variables
	//
	@Autowired
	private AppProps appProps;
	//
	
	//
	//Private methods
	//
	private String getTemplateForAllPageUrls()
	{
		final List<String> exceptionsToPath = new ArrayList<>();
		//exclude folders with static resources
		exceptionsToPath.addAll(STATIC_RESOURCE_FOLDERS);
		//exclude UI API
		exceptionsToPath.add(appProps.getUiApiPath());
		
		//Example of expression that ignores 2 sub-paths:
		//{pathWithExceptions:^(?!ui-api$|another-api$).*$}/**. The part in curly braces is a RegEx
		//that uses negative lookahead
		String allUrlsButExceptions = "/{pathWithExceptions:^(?!"
			+ String.join("|", exceptionsToPath) + "$).*$}/**";
		return allUrlsButExceptions;
	}
	//

	//
	//Public methods
	//
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		//This application is SPA, i.e. all URL-requests, except the ones to our API and resources,
		//must be redirected to the main page - index.html
		//- the default root address
		registry.addViewController("/").setViewName("index");
		//- all other URLs for pages
		registry.addViewController(this.getTemplateForAllPageUrls()).setViewName("index");
	}
	
	
//	We don't need this method for now, because all static resources are located in the default
//	"static" folder. But we can always uncomment it to change the folder.
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		List<String> resourceFoldersTemplates = new ArrayList<>();
//		for (String resourceFolder : STATIC_RESOURCE_FOLDERS) {
//			resourceFoldersTemplates.add("/**/" + resourceFolder + "/**");
//		}
//		
//		registry.addResourceHandler(resourceFoldersTemplates.toArray(new String[0]))
//			.setCachePeriod(Integer.MAX_VALUE)
//			.addResourceLocations("classpath:/static/");
//	}
	//
}