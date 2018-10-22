/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.pubManager;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author madave91
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    
    public static final Contact DEFAULT_CONTACT = new Contact("David Madacsi","","madave91@gmail.com");
    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(Arrays.asList("application/json","application/xml"));
    public static Collection<VendorExtension> collection = new ArrayList<VendorExtension>();
    public static final ApiInfo DEFAULT_API_INFO =  
            new ApiInfo("PubManager",
                    "PubManager Documentation", 
                    "1.0", "urn:tos", 
                    DEFAULT_CONTACT, 
                    "Apache 2.0", 
                    "http://www.apache.org/licenses/LICENSE-2.0", 
                    collection
    );
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO)
                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES);
    }
}

