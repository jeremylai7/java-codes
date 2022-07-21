package reflect.model;

import lombok.Getter;
import lombok.Setter;
import reflect.annotation.ColumnProperty;

/**
 * @Author: laizc
 * @Date: created in 2022-07-21
 */
@Getter
@Setter
public class AreaStatistic {

    @ColumnProperty("华东大区")
    private Integer eastChina = 0;

    @ColumnProperty("华东id")
    private Integer eastChinaId;

    @ColumnProperty("华南大区")
    private Integer southChina = 0;

    @ColumnProperty("华南id")
    private Integer southChinaId;

    @ColumnProperty("华北大区")
    private Integer northChina = 0;

    @ColumnProperty("华北id")
    private Integer northChinaId;

    @Override
    public String toString() {
        return "AreaStatistic{\n" +
                "华东Id=" + eastChinaId +
                ",华东=" + eastChina +
                ", \n华南Id=" + southChinaId +
                ", 华南=" + southChina +
                ", \n华北Id=" + northChinaId +
                ", 华北=" + northChina +
                '}';
    }
}
