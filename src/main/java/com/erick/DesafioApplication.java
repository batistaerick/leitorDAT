package com.erick;

import java.io.File;

import com.erick.services.ReaderService;
import com.erick.services.WriterService;

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

		if (files != null) {
			for (File file : files) {
				WriterService.writeFile(file, ReaderService.readFiles(file));
			}
		}
	}
}