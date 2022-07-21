package reflect.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: laizc
 * @Date: created in 2022-07-21
 */
@Getter
@Setter
public class Company {

    public Company(Integer id,  Integer areaId, String areaName) {
        this.id = id;
        this.areaId = areaId;
        this.areaName = areaName;
    }

    /**
     * 公司id
     */
    private Integer id;

    /**
     * 区域id
     */
    private Integer areaId;

    /**
     * 区域名称
     */
    private String areaName;

}
