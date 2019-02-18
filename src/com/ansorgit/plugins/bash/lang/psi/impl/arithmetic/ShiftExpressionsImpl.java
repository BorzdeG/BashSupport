/*
 * Copyright (c) Joachim Ansorg, mail@ansorg-it.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ansorgit.plugins.bash.lang.psi.impl.arithmetic;

import com.ansorgit.plugins.bash.lang.lexer.BashTokenTypes;
import com.ansorgit.plugins.bash.lang.psi.api.arithmetic.ShiftExpression;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.Nullable;

/**
 * @author jansorg
 */
public class ShiftExpressionsImpl extends AbstractExpression implements ShiftExpression {
    public ShiftExpressionsImpl(final ASTNode astNode) {
        super(astNode, "AritShiftExpr", Type.TwoOperands);
    }

    @Nullable
    @Override
    protected Long compute(long currentValue, IElementType operator, Long nextExpressionValue) {
        if (operator == BashTokenTypes.ARITH_SHIFT_RIGHT) {
            return currentValue >> nextExpressionValue;
        }

        if (operator == BashTokenTypes.ARITH_SHIFT_LEFT) {
            return currentValue << nextExpressionValue;
        }

        return null;
    }
}