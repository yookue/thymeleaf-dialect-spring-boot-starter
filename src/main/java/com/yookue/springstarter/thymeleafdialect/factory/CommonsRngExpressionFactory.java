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

package com.yookue.springstarter.thymeleafdialect.factory;


import java.util.Set;
import jakarta.annotation.Nullable;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.rng.simple.RandomSource;
import org.thymeleaf.context.IExpressionContext;
import org.thymeleaf.expression.IExpressionObjectFactory;
import com.yookue.commonplexus.javaseutil.util.CollectionPlainWraps;


/**
 * {@link org.thymeleaf.expression.IExpressionObjectFactory} for apache commons-rng
 *
 * @author David Hsing
 * @reference "https://dzone.com/articles/creating-an-expression-objets-using-thymeleaf"
 * @see org.thymeleaf.standard.expression.StandardExpressionObjectFactory
 * @see org.thymeleaf.spring6.expression.SpringStandardExpressionObjectFactory
 */
@SuppressWarnings({"JavadocDeclaration", "JavadocLinkAsPlainText"})
public class CommonsRngExpressionFactory implements IExpressionObjectFactory {
    private static final String RANDOM_PROVIDER = "randomProvider";    // $NON-NLS-1$

    @Override
    public Object buildObject(@Nullable IExpressionContext context, @Nullable String expression) {
        return StringUtils.equals(expression, RANDOM_PROVIDER) ? RandomSource.JDK.create() : null;
    }

    @Override
    public Set<String> getAllExpressionObjectNames() {
        return CollectionPlainWraps.unmodifiableSet(RANDOM_PROVIDER);
    }

    @Override
    public boolean isCacheable(@Nullable String expression) {
        return StringUtils.equals(expression, RANDOM_PROVIDER);
    }
}
