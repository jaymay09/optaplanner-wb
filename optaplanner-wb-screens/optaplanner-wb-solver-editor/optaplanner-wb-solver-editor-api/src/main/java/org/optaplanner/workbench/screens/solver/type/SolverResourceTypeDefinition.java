/*
 * Copyright 2015 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.optaplanner.workbench.screens.solver.type;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.uberfire.backend.vfs.Path;
import org.uberfire.workbench.category.Category;
import org.uberfire.workbench.category.Others;
import org.uberfire.workbench.type.ResourceTypeDefinition;

@ApplicationScoped
public class SolverResourceTypeDefinition
        implements ResourceTypeDefinition {

    private Category category;

    public SolverResourceTypeDefinition() {
    }

    @Inject
    public SolverResourceTypeDefinition(Others category) {
        this.category = category;
    }

    @Override
    public String getShortName() {
        return "solver";
    }

    @Override
    public String getDescription() {
        return "Solver Configuration";
    }

    @Override
    public String getPrefix() {
        return "";
    }

    @Override
    public String getSuffix() {
        return "solver.xml";
    }

    @Override
    public int getPriority() {
        return 10;
    }

    @Override
    public String getSimpleWildcardPattern() {
        return "*." + getSuffix();
    }

    @Override
    public boolean accept(final Path path) {
        return path.getFileName().endsWith("." + getSuffix());
    }

    @Override
    public Category getCategory() {
        return this.category;
    }
}
