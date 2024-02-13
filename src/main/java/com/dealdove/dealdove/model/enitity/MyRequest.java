package com.dealdove.dealdove.model.enitity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
public class MyRequest {
        private String name;
        private String email;

        private String password;

}
