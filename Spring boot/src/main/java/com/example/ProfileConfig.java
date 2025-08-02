package com.example;

import com.example.profile.DevProfile;
import com.example.profile.ProductionProfile;
import com.example.profile.SystemProfile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProfileConfig {

    @Value("${netology.profile.dev:false}")
    private boolean isDev;

    @Bean
    public SystemProfile systemProfile() {
        if (isDev) {
            System.out.println("Creating DevProfile bean");
            return new DevProfile();
        } else {
            System.out.println("Creating ProductionProfile bean");
            return new ProductionProfile();
        }
    }
} 