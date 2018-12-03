package zenjob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import zenjob.config.CategoryMapper;

@SpringBootApplication
//@EnableConfigurationProperties(CategoryMapper.class)
public class App
{
	public static void main( String[] args )
	{
		SpringApplication.run(App.class);
	}
}