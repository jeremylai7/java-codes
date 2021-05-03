package proxy;

import java.util.Date;

/**
 * @author: laizc
 * @date: created in 2021/5/4
 * @desc:
 **/
public class GamePlayerProxy implements IGamePlayer{

    private IGamePlayer iGamePlayer;

    public GamePlayerProxy(IGamePlayer iGamePlayer) {
        this.iGamePlayer = iGamePlayer;
    }

    //代练
    @Override
    public void login(String user, String password) {
        this.iGamePlayer.login(user,password);
    }

    //代练
    @Override
    public void killBoss() {
        this.iGamePlayer.killBoss();
    }

    @Override
    public void upgrade() {
        this.iGamePlayer.upgrade();
    }

    public static void main(String[] args) {
        //定义玩家
        IGamePlayer gamePlayer = new GamePlayer("张三");
        //定义代练
        IGamePlayer proxy = new GamePlayerProxy(gamePlayer);
        //开始打游戏
        System.out.println("开始时间："+ new Date());
        proxy.login("zhangsan","1234");
        proxy.killBoss();
        proxy.upgrade();
        System.out.println("结束时间：" + new Date());

    }
}
