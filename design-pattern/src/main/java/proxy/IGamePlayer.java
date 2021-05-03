package proxy;

/**
 * @author: laizc
 * @date: created in 2021/5/3
 * @desc: 游戏者
 **/
public interface IGamePlayer {

    //登录
    void login(String user,String password);

    //杀怪
    void killBoss();

    //升级
    void upgrade();

}
