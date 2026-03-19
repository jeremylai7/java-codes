package recurve;

/**
 * @author: laizc
 * @date: created in 2022/6/26
 * @desc: 评论
 **/
public class Multistage {

    public Multistage(Integer id, Integer parentId, String message) {
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
}
