package com.devbridge.sourcery.lectures.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAutoConfiguration
@EnableJpaRepositories
@EnableTransactionManagement
public class RepositoryConfiguration {
}
