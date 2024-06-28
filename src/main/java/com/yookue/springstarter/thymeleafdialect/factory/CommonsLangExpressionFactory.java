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
import javax.annotation.Nullable;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.lang3.math.NumberUtils;
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
 * @see org.thymeleaf.spring5.expression.SpringStandardExpressionObjectFactory
 */
@SuppressWarnings({"InstantiationOfUtilityClass", "JavadocDeclaration", "JavadocLinkAsPlainText"})
public class CommonsLangExpressionFactory implements IExpressionObjectFactory {
    private static final String ARRAY_UTILS_NAME = "arrayUtils";    // $NON-NLS-1$
    private static final String BOOLEAN_UTILS_NAME = "booleanUtils";    // $NON-NLS-1$
    private static final String CHAR_UTILS_NAME = "charUtils";    // $NON-NLS-1$
    private static final String NUMBER_UTILS_NAME = "numberUtils";    // $NON-NLS-1$
    private static final String OBJECT_UTILS_NAME = "objectUtils";    // $NON-NLS-1$
    private static final String RANDOM_UTILS_NAME = "randomUtils";    // $NON-NLS-1$
    private static final String RANDOM_STRING_UTILS_NAME = "randomStringUtils";    // $NON-NLS-1$
    private static final String REGEX_UTILS_NAME = "regexUtils";    // $NON-NLS-1$
    private static final String STRING_UTILS_NAME = "stringUtils";    // $NON-NLS-1$
    private static final String SYSTEM_UTILS_NAME = "systemUtils";    // $NON-NLS-1$

    private static final Set<String> ALL_EXPRESSION_NAMES = CollectionPlainWraps.unmodifiableSet(ARRAY_UTILS_NAME, BOOLEAN_UTILS_NAME, CHAR_UTILS_NAME, NUMBER_UTILS_NAME, OBJECT_UTILS_NAME, RANDOM_UTILS_NAME, RANDOM_STRING_UTILS_NAME, REGEX_UTILS_NAME, STRING_UTILS_NAME, SYSTEM_UTILS_NAME);

    private static final ArrayUtils ARRAY_UTILS_INSTANCE = new ArrayUtils();
    private static final BooleanUtils BOOLEAN_UTILS_INSTANCE = new BooleanUtils();
    private static final CharUtils CHAR_UTILS_INSTANCE = new CharUtils();
    private static final NumberUtils NUMBER_UTILS_INSTANCE = new NumberUtils();
    private static final ObjectUtils OBJECT_UTILS_INSTANCE = new ObjectUtils();
    private static final RandomUtils RANDOM_UTILS_INSTANCE = new RandomUtils();
    private static final RandomStringUtils RANDOM_STRING_UTILS_INSTANCE = new RandomStringUtils();
    private static final RegExUtils REGEX_UTILS_INSTANCE = new RegExUtils();
    private static final StringUtils STRING_UTILS_INSTANCE = new StringUtils();
    private static final SystemUtils SYSTEM_UTILS_INSTANCE = new SystemUtils();

    @Override
    public Object buildObject(@Nullable IExpressionContext context, @Nullable String expression) {
        if (StringUtils.isBlank(expression)) {
            return null;
        }
        switch (expression) {
            case ARRAY_UTILS_NAME:
                return ARRAY_UTILS_INSTANCE;
            case BOOLEAN_UTILS_NAME:
                return BOOLEAN_UTILS_INSTANCE;
            case CHAR_UTILS_NAME:
                return CHAR_UTILS_INSTANCE;
            case NUMBER_UTILS_NAME:
                return NUMBER_UTILS_INSTANCE;
            case OBJECT_UTILS_NAME:
                return OBJECT_UTILS_INSTANCE;
            case RANDOM_UTILS_NAME:
                return RANDOM_UTILS_INSTANCE;
            case RANDOM_STRING_UTILS_NAME:
                return RANDOM_STRING_UTILS_INSTANCE;
            case REGEX_UTILS_NAME:
                return REGEX_UTILS_INSTANCE;
            case STRING_UTILS_NAME:
                return STRING_UTILS_INSTANCE;
            case SYSTEM_UTILS_NAME:
                return SYSTEM_UTILS_INSTANCE;
            default:
                return null;
        }
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
