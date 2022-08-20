/*
 * Copyright 2022 ABSA Group Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.github.kevinwallimann.ssyaj.javaagent;

import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;

import java.util.Objects;

public class YarnClientImplSubmitApplicationMatcher {
    private final static ElementMatcher<TypeDescription> yarnClientApplicationMatcher = ElementMatchers
            .hasSuperType(target -> Objects.equals(target.getCanonicalName(), "org.apache.hadoop.yarn.api.records.ApplicationId"));

    private final static ElementMatcher<MethodDescription> methodMatcher = ElementMatchers
            .named("submitApplication")
//            .and(ElementMatchers.takesArguments(1))
//            .and(ElementMatchers.returns(yarnClientApplicationMatcher))
            .and(ElementMatchers.isPublic());

    private final static ElementMatcher<TypeDescription> typeMatcher =
            ElementMatchers.hasSuperType(ElementMatchers.named("org.apache.hadoop.yarn.client.api.impl.YarnClientImpl"));

    public static ElementMatcher<TypeDescription> getTypeMatcher() {
        return typeMatcher;
    }

    public static ElementMatcher<MethodDescription> getMethodMatcher() {
        return methodMatcher;
    }
}
