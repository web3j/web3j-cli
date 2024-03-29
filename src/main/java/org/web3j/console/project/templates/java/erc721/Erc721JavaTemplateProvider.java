/*
 * Copyright 2024 Web3 Labs Ltd.
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
package org.web3j.console.project.templates.java.erc721;

import java.io.IOException;

import org.web3j.console.project.templates.java.JavaTemplateProvider;

public class Erc721JavaTemplateProvider extends JavaTemplateProvider {

    private final String tokenName;
    private final String tokenSymbol;

    protected Erc721JavaTemplateProvider(
            String mainJavaClass,
            String solidityContract,
            String pathToSolidityFolder,
            String gradleBuild,
            String gradleSettings,
            String gradlewWrapperSettings,
            String gradlewBatScript,
            String gradlewScript,
            String gradlewJar,
            String packageNameReplacement,
            String projectNameReplacement,
            String tokenName,
            String tokenSymbol) {
        super(
                mainJavaClass,
                solidityContract,
                pathToSolidityFolder,
                gradleBuild,
                gradleSettings,
                gradlewWrapperSettings,
                gradlewBatScript,
                gradlewScript,
                gradlewJar,
                packageNameReplacement,
                projectNameReplacement,
                null);
        this.tokenName = tokenName;
        this.tokenSymbol = tokenSymbol;
    }

    @Override
    public String loadMainJavaClass() throws IOException {
        return super.loadMainJavaClass()
                .replaceAll("<NAME>", tokenName)
                .replaceAll("<SYMBOL>", tokenSymbol);
    }
}
