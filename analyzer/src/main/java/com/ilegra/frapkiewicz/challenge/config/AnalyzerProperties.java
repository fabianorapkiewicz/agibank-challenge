package com.ilegra.frapkiewicz.challenge.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AnalyzerProperties {
	
	@Value("${input.extension}")
	private String extensionIn;

	@Value("${input.path}")
	private String inputPath;
	
	@Value("${output.extension}")
	private String extensionOut;
	
	@Value("${output.path}")
	private String outputPath;

	public String getExtensionIn() {
		return extensionIn;
	}

	public void setExtensionIn(String extensionIn) {
		this.extensionIn = extensionIn;
	}

	public String getInputPath() {
		return inputPath;
	}

	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}

	public String getExtensionOut() {
		return extensionOut;
	}

	public void setExtensionOut(String extensionOut) {
		this.extensionOut = extensionOut;
	}

	public String getOutputPath() {
		return outputPath;
	}

	public void setOutputPath(String outputPath) {
		this.outputPath = outputPath;
	}
}
