package com.ilegra.frapkiewicz.challenge.repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.ilegra.frapkiewicz.challenge.report.SalesReport;

@Component
public class Repository {

	private final String homePath;
	private final Path pathDataIn;
	private final Path pathDataOut;
	private final String extension;
	
	
	public Repository() throws IOException {
		extension = ".dat";
		homePath = System.getProperty("user.home");
		pathDataIn = Paths.get(homePath + "/data/in");
		pathDataOut = Paths.get(homePath + "/data/out");
		
		if(!Files.exists(pathDataIn))
			Files.createDirectories(pathDataIn);
		
		if(!Files.exists(pathDataOut))
			Files.createDirectories(pathDataOut);
	}
	
	
	public List<String> getSalesData() {
		List<String> files = new ArrayList<String>();
		
		getAllDataFilePath().parallelStream().forEach( cutAndPastInto(files) );
		
		return files;
	}

	public void save(SalesReport report){
		 Path fullPathDataOut = Paths.get( pathDataOut + "/" + report.getName() +".done.dat");
		try {
			Files.write(fullPathDataOut, report.getResume().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private List<String> getAllDataFilePath() {
		try(Stream<Path> walk = Files.walk(pathDataIn)){
			 return walk.filter(Files::isRegularFile)
					 .filter(fullFileName -> fullFileName.toString().endsWith(extension))
					 .map(Path::toString)
					 .collect(Collectors.toList());
		}catch (IOException e) {
			e.printStackTrace();
			return new ArrayList<String>();
		}
	}
	
	private Consumer<String> cutAndPastInto(List<String> files){
		return filePathText -> {
			try {
				Path filePath = Paths.get(filePathText);
				files.addAll( Files.readAllLines( filePath ) );
				Files.delete(filePath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		};
	}
}
