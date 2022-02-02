package com.ilegra.desafio;

import java.io.File;

import com.ilegra.desafio.services.Reader;
import com.ilegra.desafio.services.Writer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class DesafioApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}

	@Scheduled(fixedDelay = 10000L)
	public void write() {
		File[] files = new File(System.getProperty("user.home") + "\\data\\in").listFiles();

		for (int i = 0; i < files.length; i++) {
			Writer.writeFile(files[i], Reader.readFiles(files[i]));
		}
	}
}