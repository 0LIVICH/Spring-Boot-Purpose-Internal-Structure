package com.example;

import com.example.profile.DevProfile;
import com.example.profile.ProductionProfile;
import com.example.profile.SystemProfile;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProfileConfig {

    @Bean
    @ConditionalOnProperty(name = "netology.profile.dev", havingValue = "true")
    public SystemProfile devProfile() {
        System.out.println("Creating DevProfile bean");
        return new DevProfile();
    }

    @Bean
    @ConditionalOnProperty(name = "netology.profile.dev", havingValue = "false", matchIfMissing = true)
    public SystemProfile productionProfile() {
        System.out.println("Creating ProductionProfile bean");
        return new ProductionProfile();
    }
} 