package com.amplituhedron.javacrud.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Value("${DATABASE_URL}")
    private String databaseUrl;

    @Bean
    @Primary
    public DataSource dataSource() {
        if (databaseUrl == null || databaseUrl.isBlank()) {
            throw new IllegalStateException("DATABASE_URL environment variable is not set");
        }

        String jdbcUrl = databaseUrl;

        // Step 1: Ensure it starts with jdbc:postgresql://
        if (jdbcUrl.startsWith("postgresql://")) {
            jdbcUrl = "jdbc:" + jdbcUrl;
        }

        // Step 2: Add port 5432 if missing (common with Render internal URLs)
        if (jdbcUrl.startsWith("jdbc:postgresql://") && !jdbcUrl.contains(":5432")) {
            // Insert :5432 after the host
            int atIndex = jdbcUrl.indexOf("@");
            if (atIndex > 0) {
                int slashAfterHost = jdbcUrl.indexOf("/", atIndex);
                if (slashAfterHost > 0) {
                    jdbcUrl = jdbcUrl.substring(0, slashAfterHost) + ":5432" + jdbcUrl.substring(slashAfterHost);
                }
            }
        }

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(jdbcUrl);
        config.setDriverClassName("org.postgresql.Driver");

        return new HikariDataSource(config);
    }
}
