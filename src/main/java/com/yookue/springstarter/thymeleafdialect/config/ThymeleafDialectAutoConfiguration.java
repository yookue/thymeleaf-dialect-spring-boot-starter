/*
 * Copyright (c) 2022 Yookue Ltd. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.yookue.springstarter.thymeleafdialect.config;


import java.util.Optional;
import javax.annotation.Nonnull;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.Thymeleaf;
import com.yookue.springstarter.thymeleafdialect.processor.CommonsLangDialectProcessor;
import com.yookue.springstarter.thymeleafdialect.property.ThymeleafDialectProperties;


/**
 * Configuration of {@link org.thymeleaf.dialect.IDialect} for various dialects
 *
 * @author David Hsing
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnProperty(prefix = ThymeleafDialectAutoConfiguration.PROPERTIES_PREFIX, name = "enabled", havingValue = "true", matchIfMissing = true)
@ConditionalOnClass(value = Thymeleaf.class)
@AutoConfigureAfter(value = ThymeleafAutoConfiguration.class)
@EnableConfigurationProperties(value = ThymeleafDialectProperties.class)
public class ThymeleafDialectAutoConfiguration {
    public static final String PROPERTIES_PREFIX = "spring.thymeleaf-dialect";    // $NON-NLS-1$

    @Bean
    @ConditionalOnProperty(prefix = PROPERTIES_PREFIX + ".commons-lang-dialect", name = "enabled", havingValue = "true", matchIfMissing = true)
    @ConditionalOnMissingBean
    public CommonsLangDialectProcessor commonsLangDialectProcessor(@Nonnull ThymeleafDialectProperties properties) {
        CommonsLangDialectProcessor result = new CommonsLangDialectProcessor();
        Optional.ofNullable(properties.getCommonsLangDialect().getProcessorOrder()).ifPresent(result::setOrder);
        return result;
    }
}
