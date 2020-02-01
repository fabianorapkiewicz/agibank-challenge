package com.ilegra.frapkiewicz.challenge.repository;

import java.io.File;
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

@Component
public class Repository {

	private String path = "/home/ilegra/DATA_IN/";
	private String extension = ".dat";
	
	public List<String> getSalesData() {
		List<String> files = new ArrayList<String>();
		
		getAllDataFilePath().parallelStream().forEach( readFileInto(files) );
		
		return files;
	}

	public void save(String resume) {
		System.out.println("-------------RELATÓRIO--------------");
		System.out.println(resume);
		System.out.println("------------------------------------");
	}

	private List<String> getAllDataFilePath() {
		try(Stream<Path> walk = Files.walk(Paths.get(path))){
			 return walk.filter(Files::isRegularFile)
					 .filter(fullFileName -> fullFileName.toString().endsWith(extension))
					 .map(Path::toString)
					 .collect(Collectors.toList());
		}catch (IOException e) {
			e.printStackTrace();
			return new ArrayList<String>();
		}
	}
	
	private Consumer<String> readFileInto(List<String> files){
		return pathOfFile -> {
			try {
				files.addAll( Files.readAllLines( Paths.get(pathOfFile)) );
			} catch (IOException e) {
				e.printStackTrace();
			}
		};
	}
}
