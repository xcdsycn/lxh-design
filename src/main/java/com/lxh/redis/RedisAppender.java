package com.lxh.redis;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import com.google.common.util.concurrent.AtomicLongMap;
import org.apache.commons.codec.binary.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RedisAppender extends AppenderBase<ILoggingEvent> {
    public static final AtomicLongMap<String> ATOMIC_LONG_MAP = AtomicLongMap.create();
    static {
        //自定义Appender加入到logback的rootLogger中
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        Logger rootLogger = loggerContext.getLogger(Logger.ROOT_LOGGER_NAME);
    }
    @Override
    protected void append(ILoggingEvent iLoggingEvent) {
        if(iLoggingEvent.getLevel() == Level.ERROR) {
            // 以分钟为单位，也就是说一分钟内的key都是相同的，所以才会有这样的结果
            // 这里是设置时间Key的一种技巧
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
            String key = dateTimeFormatter.format(LocalDateTime.now());
            long errorCount = ATOMIC_LONG_MAP.incrementAndGet(key);
            if( errorCount > 10) {
                //
                System.out.println("报警，redis异常超10次，但是没有时间区间");
            }
            // 清理历史统计数据，上面是报完了警了，需要清理历史数据，清历史数据的一种很好的办法
            for( String oldKey : ATOMIC_LONG_MAP.asMap().keySet()){
                if(!StringUtils.equals(key,oldKey)) {
                    ATOMIC_LONG_MAP.remove(oldKey);
                }
            }
        }

    }

    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
        String key = dateTimeFormatter.format(LocalDateTime.now());
        System.out.println(key);
	}
}
