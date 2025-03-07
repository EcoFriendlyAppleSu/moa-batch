package dev.indie.app.moa.batch.common.setting.models.configs

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

/**
 * Data Source를 hikari 설정에서 가져오도록 함.
 * Api Project와 다르게
 */
@Configuration
class DataSourceConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    fun hikariConfig(): HikariConfig {
        return HikariConfig()
    }

    @Bean
    fun dataSource(): DataSource {
        return HikariDataSource(hikariConfig())
    }
}
