package com.cap.datareporting.component.thymeleaf;

import com.cap.datareporting.component.thymeleaf.attribute.SelectDictAttrProcessor;
import com.cap.datareporting.component.thymeleaf.attribute.SelectListAttrProcessor;
import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.dialect.IExpressionObjectDialect;
import org.thymeleaf.expression.IExpressionObjectFactory;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;
import org.thymeleaf.templatemode.TemplateMode;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @program: DataReporting
 * @description:
 * @author: MinHw or mz
 * @create: 2022-03-25 16:40
 **/
public class DRDialect extends AbstractProcessorDialect implements IExpressionObjectDialect {

    private static final String NAME = "DRDialect";
    private static final String PREFIX = "dr";
    private IExpressionObjectFactory expressionObjectFactory = null;

    // 我们将设置此方言与“方言处理器”优先级相同
    // 标准方言, 以便处理器执行交错。
    public DRDialect() {
        super(NAME, PREFIX, StandardDialect.PROCESSOR_PRECEDENCE);
    }

    @Override
    public Set<IProcessor> getProcessors(String dialectPrefix) {
        Set<IProcessor> processors = new LinkedHashSet<IProcessor>();
        processors.add(new SelectDictAttrProcessor(TemplateMode.HTML, dialectPrefix));
        processors.add(new SelectListAttrProcessor(TemplateMode.HTML, dialectPrefix));
        return processors;
    }

    @Override
    public IExpressionObjectFactory getExpressionObjectFactory() {
        if (this.expressionObjectFactory == null) {
            this.expressionObjectFactory = new DRExpressionObjectFactory();
        }
        return this.expressionObjectFactory;
    }
}
