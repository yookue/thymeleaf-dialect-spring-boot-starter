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

package com.yookue.springstarter.thymeleafdialect.property;


import java.io.Serializable;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.Ordered;
import com.yookue.springstarter.thymeleafdialect.config.ThymeleafDialectAutoConfiguration;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * Properties for thymeleaf dialect
 *
 * @author David Hsing
 */
@ConfigurationProperties(prefix = ThymeleafDialectAutoConfiguration.PROPERTIES_PREFIX)
@Getter
@Setter
@ToString
public class ThymeleafDialectProperties implements Serializable {
    /**
     * Indicates whether to enable this starter or not
     * <p>
     * Default is {@code true}
     */
    private Boolean enabled = true;

    /**
     * Commons lang dialect attributes
     */
    private final CommonsLangDialect commonsLangDialect = new CommonsLangDialect();

    /**
     * Commons rng dialect attributes
     */
    private final CommonsRngDialect commonsRngDialect = new CommonsRngDialect();


    /**
     * Properties for commons lang
     *
     * @author David Hsing
     */
    @Getter
    @Setter
    @ToString
    public static class CommonsLangDialect implements Serializable {
        /**
         * Indicates whether to enable this dialect or not
         * <p>
         * Default is {@code true}
         */
        private Boolean enabled = true;

        /**
         * The priority order for processing thymeleaf engine bean
         * <p>
         * Default is {@code Ordered.LOWEST_PRECEDENCE - 1000}
         */
        private Integer processorOrder = Ordered.LOWEST_PRECEDENCE - 1000;
    }


    /**
     * Properties for commons rng
     *
     * @author David Hsing
     */
    @Getter
    @Setter
    @ToString
    public static class CommonsRngDialect implements Serializable {
        /**
         * Indicates whether to enable this dialect or not
         * <p>
         * Default is {@code true}
         */
        private Boolean enabled = true;

        /**
         * The priority order for processing thymeleaf engine bean
         * <p>
         * Default is {@code Ordered.LOWEST_PRECEDENCE - 1000}
         */
        private Integer processorOrder = Ordered.LOWEST_PRECEDENCE - 1000;
    }
}
