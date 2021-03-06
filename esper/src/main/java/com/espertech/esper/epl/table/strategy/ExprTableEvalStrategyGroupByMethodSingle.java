/*
 * *************************************************************************************
 *  Copyright (C) 2006-2015 EsperTech, Inc. All rights reserved.                       *
 *  http://www.espertech.com/esper                                                     *
 *  http://www.espertech.com                                                           *
 *  ---------------------------------------------------------------------------------- *
 *  The software in this package is published under the terms of the GPL license       *
 *  a copy of which has been included with this distribution in the license.txt file.  *
 * *************************************************************************************
 */

package com.espertech.esper.epl.table.strategy;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.epl.expression.core.ExprEvaluator;
import com.espertech.esper.epl.expression.core.ExprEvaluatorContext;

public class ExprTableEvalStrategyGroupByMethodSingle extends ExprTableEvalStrategyGroupByMethodBase {

    private final ExprEvaluator groupExpr;

    public ExprTableEvalStrategyGroupByMethodSingle(TableAndLockProviderGrouped provider, int index, ExprEvaluator groupExpr) {
        super(provider, index);
        this.groupExpr = groupExpr;
    }

    public Object evaluate(EventBean[] eventsPerStream, boolean isNewData, ExprEvaluatorContext exprEvaluatorContext) {
        Object groupKey = groupExpr.evaluate(eventsPerStream, isNewData, exprEvaluatorContext);
        return evaluateInternal(groupKey, exprEvaluatorContext);
    }
}
