## LearnSpringBootApp
```
package com.learning.coding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnSpringBootApp {
    public static void main(String[] args) {
        SpringApplication.run(LearnSpringBootApp.class, args);
    }
}
```
## CurrencyConfigurationController
```
package com.learning.coding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CurrencyConfigurationController {

    @Autowired
    private CurrencyServiceConfiguration configuration;

    @RequestMapping("/currency-configuration")
    public CurrencyServiceConfiguration retrieveAllCourses() {
        return configuration;
    }
}
```
## CurrencyServiceConfiguration
```
package com.learning.coding;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "currency-service")
@Component
public class CurrencyServiceConfiguration {
    private String url;
    private String username;
    private String key;

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
}
```
## application.properties
```
spring.application.name=spring-boot
logging.level.org.springframework=debug
spring.profiles.active=dev

currency-service.url=http://default.learning.com
currency-service.username=defaultusername
currency-service.key=defaultkey
```
## application-dev.properties
```
logging.level.org.springframework=trace


currency-service.url=http://dev.learning.com
currency-service.username=devusername
currency-service.key=devkey
```