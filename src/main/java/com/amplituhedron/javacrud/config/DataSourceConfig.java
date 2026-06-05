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
        String jdbcUrl = databaseUrl;

        // Convert Render's postgresql:// to jdbc:postgresql:// if needed
        if (jdbcUrl != null) {
            if (jdbcUrl.startsWith("postgresql://")) {
                jdbcUrl = "jdbc:" + jdbcUrl;
            } else if (!jdbcUrl.startsWith("jdbc:postgresql://")) {
                // Fallback: force correct format
                jdbcUrl = jdbcUrl.replaceFirst("^jdbc:postgresql://", "jdbc:postgresql://");
            }
        }

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(jdbcUrl);
        config.setDriverClassName("org.postgresql.Driver");

        return new HikariDataSource(config);
    }
}
