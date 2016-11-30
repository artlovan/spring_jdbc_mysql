package org.javadriven.spring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@SpringBootApplication
@RestController
public class Application {

	@Autowired
	private JdbcTemplate template;

	@RequestMapping(value = "/stocks", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<?> stacks() {
		return template.queryForList("SELECT * FROM stock");
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
