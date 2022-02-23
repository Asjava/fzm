package com.fzm.zookeeper.restful.formatter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.format.Formatter;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Locale;

public class DollarToCentFormatter implements Formatter<Long> {
    @Override
    public Long parse(String dollar, Locale locale) throws ParseException {
        if(StringUtils.isNoneBlank(dollar)) {
            BigDecimal bigDecimal = BigDecimal.valueOf(Double.valueOf(dollar)).multiply(BigDecimal.valueOf(100)).setScale(0);
            return Long.valueOf(bigDecimal.toString());
        }
        return 0L;
    }

    @Override
    public String print(Long object, Locale locale) {
        return object.toString();
    }
}
