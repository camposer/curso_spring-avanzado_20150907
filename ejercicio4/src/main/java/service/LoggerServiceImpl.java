package service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LoggerServiceImpl implements LoggerService {
	@Value("${logger.rutaArchivo}")
	private String rutaArchivo;

	@Override
	public void log(String mensaje) {
		mensaje += "\n";
		try {
			Files.write(new File(rutaArchivo).toPath(), 
					mensaje.getBytes(), 
					StandardOpenOption.CREATE, 
					StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
