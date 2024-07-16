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
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.BeanUtils;
import org.thymeleaf.context.IExpressionContext;
import org.thymeleaf.expression.IExpressionObjectFactory;
import com.yookue.commonplexus.javaseutil.util.CollectionPlainWraps;
import com.yookue.commonplexus.javaseutil.util.StringUtilsWraps;


/**
 * {@link org.thymeleaf.expression.IExpressionObjectFactory} for apache commons-lang3
 *
 * @author David Hsing
 * @reference "https://dzone.com/articles/creating-an-expression-objets-using-thymeleaf"
 * @see org.thymeleaf.standard.expression.StandardExpressionObjectFactory
 * @see org.thymeleaf.spring6.expression.SpringStandardExpressionObjectFactory
 */
@SuppressWarnings({"JavadocDeclaration", "JavadocLinkAsPlainText"})
public class CommonsLangExpressionFactory implements IExpressionObjectFactory {
    private static final String ARRAY_UTILS_NAME = "arrayUtils";    // $NON-NLS-1$
    private static final String BOOLEAN_UTILS_NAME = "booleanUtils";    // $NON-NLS-1$
    private static final String CHAR_UTILS_NAME = "charUtils";    // $NON-NLS-1$
    private static final String NUMBER_UTILS_NAME = "numberUtils";    // $NON-NLS-1$
    private static final String OBJECT_UTILS_NAME = "objectUtils";    // $NON-NLS-1$
    private static final String RANDOM_STRING_UTILS_NAME = "randomStringUtils";    // $NON-NLS-1$
    private static final String REGEX_UTILS_NAME = "regexUtils";    // $NON-NLS-1$
    private static final String STRING_UTILS_NAME = "stringUtils";    // $NON-NLS-1$
    private static final String SYSTEM_UTILS_NAME = "systemUtils";    // $NON-NLS-1$

    private static final Set<String> ALL_EXPRESSION_NAMES = CollectionPlainWraps.unmodifiableSet(ARRAY_UTILS_NAME, BOOLEAN_UTILS_NAME, CHAR_UTILS_NAME, NUMBER_UTILS_NAME, OBJECT_UTILS_NAME, RANDOM_STRING_UTILS_NAME, REGEX_UTILS_NAME, STRING_UTILS_NAME, SYSTEM_UTILS_NAME);

    @Override
    public Object buildObject(@Nullable IExpressionContext context, @Nullable String expression) {
        if (StringUtils.isBlank(expression)) {
            return null;
        }
        return switch (expression) {
            case ARRAY_UTILS_NAME -> BeanUtils.instantiateClass(ArrayUtils.class);
            case BOOLEAN_UTILS_NAME -> BeanUtils.instantiateClass(BooleanUtils.class);
            case CHAR_UTILS_NAME -> BeanUtils.instantiateClass(CharUtils.class);
            case NUMBER_UTILS_NAME -> BeanUtils.instantiateClass(NumberUtils.class);
            case OBJECT_UTILS_NAME -> BeanUtils.instantiateClass(ObjectUtils.class);
            case RANDOM_STRING_UTILS_NAME -> BeanUtils.instantiateClass(RandomStringUtils.class);
            case REGEX_UTILS_NAME -> BeanUtils.instantiateClass(RegExUtils.class);
            case STRING_UTILS_NAME -> BeanUtils.instantiateClass(StringUtils.class);
            case SYSTEM_UTILS_NAME -> BeanUtils.instantiateClass(SystemUtils.class);
            default -> null;
        };
    }

    @Override
    public Set<String> getAllExpressionObjectNames() {
        return ALL_EXPRESSION_NAMES;
    }

    @Override
    public boolean isCacheable(@Nullable String expression) {
        return StringUtilsWraps.equalsAny(expression, ALL_EXPRESSION_NAMES);
    }
}
