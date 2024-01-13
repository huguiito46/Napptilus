package com.napptilus;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


/** Esta clase extiende SpringBootServletInitializer para permitir el despliegue de la
 * aplicación como un archivo WAR en un contenedor de servlets.
 */
public class ServletInitializer extends SpringBootServletInitializer {

	/** Configura la aplicación Spring Boot para el despliegue en un contenedor de servlets.
	 * @param application La instancia de SpringApplicationBuilder representa la aplicación Spring Boot.
	 * @return La instancia de SpringApplicationBuilder configurada.
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(NapptilusApplication.class);
	}

}
