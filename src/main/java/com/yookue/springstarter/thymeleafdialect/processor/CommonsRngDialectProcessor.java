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

package com.yookue.springstarter.thymeleafdialect.processor;


import jakarta.annotation.Nonnull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.thymeleaf.TemplateEngine;
import com.yookue.springstarter.thymeleafdialect.dialect.CommonsRngExpressionDialect;
import lombok.Getter;
import lombok.Setter;


/**
 * {@link org.springframework.beans.factory.config.BeanPostProcessor} for {@link com.yookue.springstarter.thymeleafdialect.dialect.CommonsRngExpressionDialect}
 *
 * @author David Hsing
 */
@Getter
@Setter
public class CommonsRngDialectProcessor implements BeanPostProcessor, Ordered {
    private final CommonsRngExpressionDialect dialect = new CommonsRngExpressionDialect();
    private int order = 0;

    @Override
    public Object postProcessAfterInitialization(@Nonnull Object bean, @Nonnull String beanName) throws BeansException {
        if (bean instanceof TemplateEngine instance) {
            instance.addDialect(dialect);
        }
        return bean;
    }
}
