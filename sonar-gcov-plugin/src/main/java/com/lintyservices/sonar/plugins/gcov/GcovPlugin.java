/*
 * SonarQube Linty Gcov :: Plugin
 * Copyright (C) 2019-2020 Linty Services
 * mailto:contact@linty-services.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package com.lintyservices.sonar.plugins.gcov;

import com.google.common.collect.ImmutableList;
import org.sonar.api.CoreProperties;
import org.sonar.api.Plugin;
import org.sonar.api.config.PropertyDefinition;
import org.sonar.api.resources.Qualifiers;

import java.util.List;

public final class GcovPlugin implements Plugin {

  public static final String ENABLE_COVERAGE = "sonar.gcov.enableCoverage";

  public List<Object> getExtensions() {
    return ImmutableList.of(
      PropertyDefinition.builder(ENABLE_COVERAGE)
        .category(CoreProperties.CATEGORY_CODE_COVERAGE)
        .subCategory("Gcov")
        .name("Enable coverage")
        .description("Enable parsing of gcov files and display of coverage results in sonarqube.")
        .defaultValue("true")
        .onQualifiers(Qualifiers.PROJECT)
        .build(),

      GcovSensor.class);
  }

  @Override
  public void define(Context context) {
    context.addExtensions(getExtensions());
  }
}