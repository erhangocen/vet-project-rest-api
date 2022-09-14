package veterinerProject.w34.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean // instance oluşturuyor.
    public Cloudinary cloudinary() {

        return	new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "**********",
                "api_key", "*************",
                "api_secret", "*************"
        ));
    }
}
