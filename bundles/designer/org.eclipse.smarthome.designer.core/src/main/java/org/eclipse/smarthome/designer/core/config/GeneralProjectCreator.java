/**
 * Copyright (c) 2014,2017 Contributors to the Eclipse Foundation
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.smarthome.designer.core.config;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;

/**
 *
 * @author Oliver Libutzki - Initial contribution
 */
public class GeneralProjectCreator implements IProjectCreator {

    @Override
    public IProject createProject(String projectName) {
        IProject defaultProject = ResourcesPlugin.getWorkspace().getRoot().getProject("config");
        if (!defaultProject.exists()) {
            initialize(defaultProject);
        }
        return defaultProject;
    }

    private void initialize(IProject project) {
        try {
            IProjectDescription desc = ResourcesPlugin.getWorkspace().newProjectDescription(project.getName());
            desc.setNatureIds(new String[] { "org.eclipse.xtext.ui.shared.xtextNature" });
            project.create(desc, null);
            project.open(null);
        } catch (CoreException e) {
            e.printStackTrace();
        }
    }

}
