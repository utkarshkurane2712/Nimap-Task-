package com.Nimap.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Configuration
public class CloudConfiguration {
	
	@Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dxodqyqss",
                "api_key", "755452512793819",      
                "api_secret", "IjTn2uF_ydOc3Dl6FgYqAdI_Jdg"));
    }

}
