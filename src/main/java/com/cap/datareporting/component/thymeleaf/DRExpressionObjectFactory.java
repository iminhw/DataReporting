package com.cap.datareporting.component.thymeleaf;

import com.cap.datareporting.component.thymeleaf.utility.DictUtil;
import com.cap.datareporting.component.thymeleaf.utility.ParamUtil;
import org.thymeleaf.context.IExpressionContext;
import org.thymeleaf.expression.IExpressionObjectFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @program: DataReporting
 * @description:
 * @author: MinHw or mz
 * @create: 2022-03-25 16:42
 **/
public class DRExpressionObjectFactory implements IExpressionObjectFactory {

    public static final String DICT_UTIL_NAME = "dicts";
    public static final DictUtil DICT_UTIL_OBJECT = new DictUtil();
    public static final String PARAM_UTIL_NAME = "params";
    public static final ParamUtil PARAM_UTIL_OBJECT = new ParamUtil();

    @Override
    public Set<String> getAllExpressionObjectNames() {
        Set<String> names = Collections.unmodifiableSet(new LinkedHashSet<String>(Arrays.asList(
                DICT_UTIL_NAME,
                PARAM_UTIL_NAME
        )));
        return names;
    }

    @Override
    public Object buildObject(IExpressionContext context, String expressionObjectName) {
        if (DICT_UTIL_NAME.equals(expressionObjectName)) {
            return DICT_UTIL_OBJECT;
        }
        if(PARAM_UTIL_NAME.equals(expressionObjectName)){
            return PARAM_UTIL_OBJECT;
        }
        return null;
    }

    @Override
    public boolean isCacheable(String expressionObjectName) {
        return expressionObjectName != null;
    }
}
