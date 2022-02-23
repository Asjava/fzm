package com.fzm.zookeeper.restful.factory;

import com.fzm.zookeeper.restful.annotation.DollarToCentFormat;
import com.fzm.zookeeper.restful.formatter.DollarToCentFormatter;
import org.springframework.context.support.EmbeddedValueResolutionSupport;
import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Parser;
import org.springframework.format.Printer;

import java.util.HashSet;
import java.util.Set;

public class DollarToCentFormatAnnotationFormatterFactory extends EmbeddedValueResolutionSupport implements AnnotationFormatterFactory<DollarToCentFormat> {
    @Override
    public Set<Class<?>> getFieldTypes() {
        return new HashSet<Class<?>>(){
            {
                add(String.class);
                add(Long.class);
            }
        };
    }

    @Override
    public Printer<?> getPrinter(DollarToCentFormat annotation, Class<?> aClass) {
        DollarToCentFormatter formatter = new DollarToCentFormatter();
        return formatter;
    }

    @Override
    public Parser<?> getParser(DollarToCentFormat dollarToCentFormat, Class<?> aClass) {
        DollarToCentFormatter formatter = new DollarToCentFormatter();
        return formatter;
    }


}
