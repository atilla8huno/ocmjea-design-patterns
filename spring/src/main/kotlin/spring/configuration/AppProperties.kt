package spring.configuration

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "sample.app")
class AppProperties {
    var title: String = "default"
}
