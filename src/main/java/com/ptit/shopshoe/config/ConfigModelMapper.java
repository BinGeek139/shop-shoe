package com.ptit.shopshoe.config;

import com.ptit.shopshoe.common.ImageCommon;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigModelMapper {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
    @Bean
    public ImageCommon imageCommon(){
        return new ImageCommon();
    }
}
