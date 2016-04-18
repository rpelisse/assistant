/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2016, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.set.assistant.evaluator.impl.payload;

import java.util.Map;

import org.jboss.set.aphrodite.domain.Issue;
import org.jboss.set.assistant.data.payload.DependencyIssue;
import org.jboss.set.assistant.evaluator.PayloadEvaluator;
import org.jboss.set.assistant.evaluator.PayloadEvaluatorContext;

/**
 * @author wangc
 *
 */
public class PayloadIssueEvaluator implements PayloadEvaluator {

    public static final String KEY = "payloadDependency";

    @Override
    public String name() {
        return "PayloadIssue Evaluator";
    }

    @Override
    public void eval(PayloadEvaluatorContext context, Map<String, Object> data) {

        Issue dependecyIssue = context.getIssue();

        data.put(KEY, new DependencyIssue(dependecyIssue.getURL(), dependecyIssue.getTrackerId().orElse("N/A"),
                dependecyIssue.getStatus(), dependecyIssue.getType()));
    }
}
