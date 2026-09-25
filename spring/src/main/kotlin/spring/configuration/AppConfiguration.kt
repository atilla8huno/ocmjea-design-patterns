package spring.configuration

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Configuration
@EnableConfigurationProperties(AppProperties::class)
class AppConfiguration(
    @param:Value("\${sample.greeting:hi}") private val greeting: String
) {
    @Bean
    fun greetingPrefix(): String = greeting

    @Bean
    @Profile("dev")
    fun devFlag(): String = "dev"
}
