package ar.utn.edu.labiii.practicalabfinal.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;


@Configuration
    public class MappersConfig {

        @Bean
        public ModelMapper modelMapper() {
            return new ModelMapper();
        }

        @Bean("mergerMapper")
        public ModelMapper mergerMapper() {
            ModelMapper mapper =  new ModelMapper();
            mapper.getConfiguration()
                    .setPropertyCondition(Conditions.isNotNull());
            return mapper;
        }

        @Bean
        public ObjectMapper objectMapper() {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
            return objectMapper;
        }

    }


