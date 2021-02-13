package com.lxh.design.command;

/**
 * @Description 卖出命令，注意 在命令中是要 设置命令 的 执行对象 的
 *
 * 借助于stock对象实现命令执行，那么一个命令可以借助于多个对象实现业务功能
 * @Author lxh
 * @Date 2021/2/8 15:56
 **/
public class SellStockCommand implements Command {
    private Stock abcStock;

    public SellStockCommand(Stock abcStock) {
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.sell();
    }
}
