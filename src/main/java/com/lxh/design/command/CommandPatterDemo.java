package com.lxh.design.command;

/**
 * @Description 这是使用命令模式的主程序
 * @Author lxh
 * @Date 2021/2/8 16:02
 **/
public class CommandPatterDemo {

	public static void main(String[] args) {
        Stock abcStock = new Stock();

        // 每个命令都要设置一个执行者，不见得是同一个执行者
        BuyStockCommand buyStockCommand = new BuyStockCommand(abcStock);
        SellStockCommand sellStockCommand = new SellStockCommand(abcStock);
        // 在这里是放到一个数组里，再统一调用执行，这样不需要针对每个命令单独调用
        // buyStockCommand.execute();
        // sellStockCommand.execute();
        // 这样有几十就需要写几十个，所以下面的做法会比较简捷
        Broker broker = new Broker();
        broker.acceptCommand(buyStockCommand);
        broker.acceptCommand(sellStockCommand);

        broker.execCommands();
	}
}
