package com.lxh.design.chain;

/**
 * @Description 责任链模式
 * <p>
 * 1. 顾名思义，责任模式链为请求创建一系列接收者对象。
 * 2. 此模式基于请求的类型将请求的发送方和接收方分离。
 * 3. 这种模式是行为模式。
 * 4. 在这种模式中，通常每个接收器包含对另一个接收器的引用。
 * 5. 如果一个对象不能处理请求，则它将相同的对象传递给下一个接收者等等。
 * </p>
 * @Author lxh
 * @Date 2021/2/14 22:25
 **/
public class ChainPatternDemo {

    /**
     * 责任链装配
     * @return
     */
    private static AbstractLogger getChainOfLoggers() {
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        // 得到链
        AbstractLogger loggerChain = getChainOfLoggers();

        loggerChain.logMessage(AbstractLogger.INFO, "This is an information");
        System.out.println();
        loggerChain.logMessage(AbstractLogger.DEBUG, "This is a debug information");
        System.out.println();
        loggerChain.logMessage(AbstractLogger.ERROR, "This is an error information");
    }
}
