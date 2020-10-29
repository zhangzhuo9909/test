package org.zhangzhuo.filter;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class GoodsFilter implements Filter {
    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }
}
