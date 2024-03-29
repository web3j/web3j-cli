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
package org.web3j.console.project;

public class Erc721ProjectCreatorConfig extends ProjectCreatorConfig {
    private final String tokenName;
    private final String tokenSymbol;

    public Erc721ProjectCreatorConfig(
            String projectName,
            String packageName,
            String outputDir,
            Boolean withJar,
            Boolean withTests,
            String tokenName,
            String tokenSymbol) {
        super(projectName, packageName, outputDir, withJar, withTests);
        this.tokenName = tokenName;
        this.tokenSymbol = tokenSymbol;
    }

    public String getTokenName() {
        return tokenName;
    }

    public String getTokenSymbol() {
        return tokenSymbol;
    }
}
