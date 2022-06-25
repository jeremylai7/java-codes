package recurve;


import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: laizc
 * @date: created in 2022/6/25
 * @desc: 递归实现评论树形结构
 **/
public class ViewComment {

    public ViewComment() {}

    public ViewComment(Integer id,Integer parentId,String message) {
        this.id = id;
        this.parentId = parentId;
        this.message = message;
    }

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
    private List<ViewComment> children = new ArrayList<>();

    public static void main(String[] args) {
        List<ViewComment> commentList = new ArrayList<>();
        ViewComment comment1 = new ViewComment(1,-1,"我是留言1");
        ViewComment comment2 = new ViewComment(2,-1,"我是留言2");
        ViewComment comment3 = new ViewComment(3,1,"回复留言1");
        ViewComment comment4 = new ViewComment(4,1,"回复留言1");
        ViewComment comment5 = new ViewComment(5,2,"回复留言2");
        ViewComment comment6 = new ViewComment(6,3,"回复留言3");
        commentList.add(comment1);
        commentList.add(comment2);
        commentList.add(comment3);
        commentList.add(comment4);
        commentList.add(comment5);
        commentList.add(comment6);
        List<ViewComment> viewCommentList = new ArrayList<>();
        //添加非回复评论
        for (ViewComment comment : commentList) {
            if (comment.getParentId() == -1) {
                ViewComment viewComment = new ViewComment();
                BeanUtils.copyProperties(comment,viewComment);
                viewCommentList.add(viewComment);
            }
        }
        for(ViewComment viewComment : viewCommentList) {
            add(viewComment,commentList);
        }
        System.out.println(viewCommentList);





    }

    private static void add(ViewComment rootViewComment, List<ViewComment> commentList) {
        for (ViewComment comment : commentList) {
            if (rootViewComment.getId().equals(comment.getParentId())) {
                ViewComment viewComment = new ViewComment();
                BeanUtils.copyProperties(comment,viewComment);
                rootViewComment.getChildren().add(viewComment);
                add(viewComment,commentList);
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

    public List<ViewComment> getChildren() {
        return children;
    }

    public void setChildren(List<ViewComment> children) {
        this.children = children;
    }
}
