/*
 * Copyright (c) 2022 Unikue Ltd. All rights reserved.
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

package cn.unikue.springstarter.thymeleafdialect.config;


import java.util.Optional;
import jakarta.annotation.Nonnull;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBooleanProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.Thymeleaf;
import cn.unikue.springstarter.thymeleafdialect.processor.CommonsLangDialectProcessor;
import cn.unikue.springstarter.thymeleafdialect.processor.CommonsRngDialectProcessor;
import cn.unikue.springstarter.thymeleafdialect.property.ThymeleafDialectProperties;


/**
 * Configuration of {@link org.thymeleaf.dialect.IDialect} for various dialects
 *
 * @author David Hsing
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnBooleanProperty(prefix = ThymeleafDialectAutoConfiguration.PROPERTIES_PREFIX, name = "enabled", matchIfMissing = true)
@ConditionalOnClass(value = Thymeleaf.class)
@AutoConfigureAfter(value = ThymeleafAutoConfiguration.class)
@EnableConfigurationProperties(value = ThymeleafDialectProperties.class)
public class ThymeleafDialectAutoConfiguration {
    public static final String PROPERTIES_PREFIX = "spring.thymeleaf-dialect";    // $NON-NLS-1$
    public static final String LANG_DIALECT_PROCESSOR = "commonsLangDialectProcessor";    // $NON-NLS-1$
    public static final String RNG_DIALECT_PROCESSOR = "commonsRngDialectProcessor";    // $NON-NLS-1$

    @Bean(name = LANG_DIALECT_PROCESSOR)
    @ConditionalOnBooleanProperty(prefix = PROPERTIES_PREFIX + ".commons-lang-dialect", name = "enabled", matchIfMissing = true)
    @ConditionalOnMissingBean(name = LANG_DIALECT_PROCESSOR)
    public CommonsLangDialectProcessor langDialectProcessor(@Nonnull ThymeleafDialectProperties properties) {
        CommonsLangDialectProcessor result = new CommonsLangDialectProcessor();
        Optional.ofNullable(properties.getCommonsLangDialect().getProcessorOrder()).ifPresent(result::setOrder);
        return result;
    }

    @Bean(name = RNG_DIALECT_PROCESSOR)
    @ConditionalOnBooleanProperty(prefix = PROPERTIES_PREFIX + ".commons-rng-dialect", name = "enabled", matchIfMissing = true)
    @ConditionalOnMissingBean(name = RNG_DIALECT_PROCESSOR)
    public CommonsRngDialectProcessor rngDialectProcessor(@Nonnull ThymeleafDialectProperties properties) {
        CommonsRngDialectProcessor result = new CommonsRngDialectProcessor();
        Optional.ofNullable(properties.getCommonsLangDialect().getProcessorOrder()).ifPresent(result::setOrder);
        return result;
    }
}
