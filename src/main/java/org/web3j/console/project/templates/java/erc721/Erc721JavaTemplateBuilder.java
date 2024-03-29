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

import org.web3j.console.project.templates.TemplateBuilder;

public class Erc721JavaTemplateBuilder implements TemplateBuilder {

    private String tokenName;
    private String tokenSymbol;
    private String[] defaultOperators;

    protected String mainJavaClass;
    protected String gradleBuild;
    protected String gradleSettings;
    protected String gradlewWrapperSettings;
    protected String gradlewBatScript;
    protected String gradlewScript;
    protected String gradlewWrapperJar;
    protected String packageNameReplacement;
    protected String projectNameReplacement;

    public Erc721JavaTemplateBuilder withMainJavaClass(String mainJavaClass) {
        this.mainJavaClass = mainJavaClass;
        return this;
    }

    public Erc721JavaTemplateBuilder withGradleBuild(String gradleBuild) {
        this.gradleBuild = gradleBuild;
        return this;
    }

    public Erc721JavaTemplateBuilder withGradleSettings(String gradleSettings) {
        this.gradleSettings = gradleSettings;
        return this;
    }

    public Erc721JavaTemplateBuilder withWrapperGradleSettings(String gradlewWrapperSettings) {
        this.gradlewWrapperSettings = gradlewWrapperSettings;
        return this;
    }

    public Erc721JavaTemplateBuilder withGradleBatScript(String gradlewBatScript) {
        this.gradlewBatScript = gradlewBatScript;
        return this;
    }

    public Erc721JavaTemplateBuilder withGradleScript(String gradlewScript) {
        this.gradlewScript = gradlewScript;
        return this;
    }

    public Erc721JavaTemplateBuilder withGradlewWrapperJar(String gradlewWrapperJar) {
        this.gradlewWrapperJar = gradlewWrapperJar;
        return this;
    }

    public Erc721JavaTemplateBuilder withPackageNameReplacement(String packageNameReplacement) {
        this.packageNameReplacement = packageNameReplacement;
        return this;
    }

    public Erc721JavaTemplateBuilder withProjectNameReplacement(String projectNameReplacement) {
        this.projectNameReplacement = projectNameReplacement;
        return this;
    }

    public Erc721JavaTemplateBuilder withTokenName(String tokenName) {
        this.tokenName = tokenName;
        return this;
    }

    public Erc721JavaTemplateBuilder withTokenSymbol(String tokenSymbol) {
        this.tokenSymbol = tokenSymbol;
        return this;
    }

    @Override
    public Erc721JavaTemplateProvider build() {
        return new Erc721JavaTemplateProvider(
                mainJavaClass,
                null,
                null,
                gradleBuild,
                gradleSettings,
                gradlewWrapperSettings,
                gradlewBatScript,
                gradlewScript,
                gradlewWrapperJar,
                packageNameReplacement,
                projectNameReplacement,
                tokenName,
                tokenSymbol);
    }
}
