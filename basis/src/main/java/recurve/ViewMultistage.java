package recurve;


import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: laizc
 * @date: created in 2022/6/25
 * @desc: 递归实现评论树形结构
 **/
public class ViewMultistage {

    public ViewMultistage() {}

    /**
     * id
     */
    private Integer id;

    /**
     * 父类id
     */
    private Integer parentId;

    /**
     * 消息
     */
    private String message;

    /**
     * 回复列表
     */
    private List<ViewMultistage> children = new ArrayList<>();

    public static void main(String[] args) {
        List<Multistage> multistageList = new ArrayList<>();
        Multistage multistage1 = new Multistage(1,-1,"留言1");
        Multistage multistage2 = new Multistage(2,-1,"留言2");
        Multistage multistage3 = new Multistage(3,1,"留言3，回复留言1");
        Multistage multistage4 = new Multistage(4,1,"留言4，回复留言1");
        Multistage multistage5 = new Multistage(5,2,"留言5，回复留言2");
        Multistage multistage6 = new Multistage(6,3,"留言6，回复留言3");
        multistageList.add(multistage1);
        multistageList.add(multistage2);
        multistageList.add(multistage3);
        multistageList.add(multistage4);
        multistageList.add(multistage5);
        multistageList.add(multistage6);
        // 添加首节点
        ViewMultistage root = new ViewMultistage();
        root.setId(-1);
        // 递归添加
        add(root,multistageList);
        List<ViewMultistage> viewMultistageList = root.getChildren();
        System.out.println(viewMultistageList);





    }

    private static void add(ViewMultistage rootViewMultistage, List<Multistage> multistageList) {
        for (Multistage multistage : multistageList) {
            if (rootViewMultistage.getId().equals(multistage.getParentId())) {
                ViewMultistage viewMultistage = new ViewMultistage();
                BeanUtils.copyProperties(multistage, viewMultistage);
                rootViewMultistage.getChildren().add(viewMultistage);
                add(viewMultistage, multistageList);
            }
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ViewMultistage> getChildren() {
        return children;
    }

    public void setChildren(List<ViewMultistage> children) {
        this.children = children;
    }
}
