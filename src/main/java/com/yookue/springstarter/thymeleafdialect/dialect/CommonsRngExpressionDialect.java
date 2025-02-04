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

package com.yookue.springstarter.thymeleafdialect.dialect;


import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.dialect.IExpressionObjectDialect;
import org.thymeleaf.expression.IExpressionObjectFactory;
import com.yookue.springstarter.thymeleafdialect.factory.CommonsRngExpressionFactory;


/**
 * {@link org.thymeleaf.dialect.IExpressionObjectDialect} for apache commons-rng
 *
 * @author David Hsing
 * @see org.thymeleaf.standard.StandardDialect
 * @see org.thymeleaf.spring6.dialect.SpringStandardDialect
 */
public class CommonsRngExpressionDialect extends AbstractDialect implements IExpressionObjectDialect {
    private static final String DIALECT_NAME = "CommonsRngDialect";    // $NON-NLS-1$
    private static final IExpressionObjectFactory FACTORY_INSTANCE = new CommonsRngExpressionFactory();

    public CommonsRngExpressionDialect() {
        super(DIALECT_NAME);
    }

    @Override
    public IExpressionObjectFactory getExpressionObjectFactory() {
        return FACTORY_INSTANCE;
    }
}
