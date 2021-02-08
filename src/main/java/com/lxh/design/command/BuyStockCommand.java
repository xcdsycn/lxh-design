package com.lxh.design.command;

/**
 * @Description 买入命令
 * @Author lxh
 * @Date 2021/2/8 15:55
 **/
public class BuyStockCommand implements Command {
    private Stock abcStock;

    public BuyStockCommand(Stock abcStock) {
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.buy();
    }
}
