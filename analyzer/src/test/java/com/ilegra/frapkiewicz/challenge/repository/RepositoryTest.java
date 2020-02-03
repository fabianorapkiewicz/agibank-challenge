package com.ilegra.frapkiewicz.challenge.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.FileSystemUtils;

import com.ilegra.frapkiewicz.challenge.config.AnalyzerProperties;

class RepositoryTest {

	private AnalyzerProperties properties;
	
	@BeforeEach
	void setUp() throws Exception {
		properties = new AnalyzerProperties();
		properties.setExtensionIn(".dat");
		properties.setExtensionOut(".done.dat");
		properties.setInputPath("/data/in");
		properties.setOutputPath("/data/out");
		properties.setUseHomePath(false);
		properties.setBasePath(Paths.get("src","test","resources").toString());
	}

	@AfterEach
	void tearDown() throws Exception {
		properties = null;
	}

	@Test
	void testDirectoryCreationWhenItDoesntExist() throws IOException {
		Path path = Paths.get(properties.getBasePath() + "/data");
		
		FileSystemUtils.deleteRecursively(path);
		
		assertFalse(Files.exists(path));
		
		new Repository(properties);
		
		assertTrue(Files.exists(path));
	}
	
	@Test
	void testWhenThereAreNoInputFiles() throws IOException {
		Repository repository = new Repository(properties);
		List<String> salesData = repository.getSalesData();
		assertTrue(salesData.isEmpty());
	}

}
