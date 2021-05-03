package proxy;

/**
 * @author: laizc
 * @date: created in 2021/5/4
 * @desc:
 **/
public class GamePlayer implements IGamePlayer{

    private String name = "";

    public GamePlayer(String name) {
        this.name = name;
    }

    @Override
    public void login(String user, String password) {
        System.out.println("登录名" + user + "用户名" + this.name);
    }

    @Override
    public void killBoss() {
        System.out.println(this.name + "在打怪");
    }

    @Override
    public void upgrade() {
        System.out.println(this.name + "在升级");
    }
}
