/*
 * Copyright 2019 Web3 Labs LTD.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package org.web3j.console.project.unit.gen.templates;

import java.lang.reflect.Type;
import java.util.List;
import javax.lang.model.element.Modifier;

import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeName;
import org.junit.jupiter.api.Test;
import org.testcontainers.shaded.org.apache.commons.lang.ArrayUtils;

import static org.web3j.console.project.utills.NameUtils.returnTypeAsLiteral;
import static org.web3j.console.project.utills.NameUtils.toCamelCase;

public class Load extends Template {
    public Load(
            final Class contractName,
            final Type returnType,
            final List<Class> deployArguments,
            final List<ParameterSpec> methodParameters) {
        this.contractName = contractName;
        this.returnType = returnType;
        this.deployArguments = deployArguments;
        this.methodParameters = methodParameters;
    }

    @Override
    public MethodSpec generate() {
        return MethodSpec.methodBuilder("testLoad")
                .addAnnotation(Test.class)
                .addModifiers(Modifier.PUBLIC)
                .returns(TypeName.VOID)
                .addParameters(methodParameters)
                .addStatement("// Make sure to change the placeholder arguments.")
                .addStatement("$L = $T.load(" + customParameters() + ")", arguments())
                .build();
    }

    @Override
    Object[] arguments() {
        return ArrayUtils.addAll(
                new Object[] {toCamelCase(returnTypeAsLiteral(returnType, false)), returnType},
                dynamicArguments());
    }
}