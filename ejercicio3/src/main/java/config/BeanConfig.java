package config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
	private static String DATE_PATTERN = "yyyy-MM-dd";
	
	@Bean
	public ModelMapper modelMapper() {
		Converter<String, Date> dateConverter = new AbstractConverter<String, Date>() {
			@Override
			protected Date convert(String text) {
				Date result = null;
				
				try {
					result = new SimpleDateFormat(DATE_PATTERN).parse(text);
				} catch (ParseException e) { }
				
				return result;
			}
		};
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addConverter(dateConverter);
		
		return modelMapper;
	}
}
