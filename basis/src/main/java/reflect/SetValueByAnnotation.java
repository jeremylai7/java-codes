package reflect;

import org.junit.Test;
import reflect.annotation.ColumnProperty;
import reflect.model.AreaStatistic;
import reflect.model.Company;

import javax.print.DocFlavor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: laizc
 * @Date: created in 2022-07-21
 * @desc: 通过注解设值
 */
public class SetValueByAnnotation {

    /**
     * 通过属性赋值
     */
    @Test
    public void test() throws IllegalAccessException {
        // 添加数据
        Company company5 = new Company(1,1,"华南");
        Company company1 = new Company(2,2,"华北");
        Company company2 = new Company(3,2,"华北");
        Company company3 = new Company(4,3,"华东");
        Company company4 = new Company(5,3,"华东");
        List<Company> companyList = new ArrayList<>();
        companyList.add(company5);
        companyList.add(company1);
        companyList.add(company2);
        companyList.add(company3);
        companyList.add(company4);

        // 解法1
        AreaStatistic areaStatistic = new AreaStatistic();
        for (Company company:companyList) {
            String areaName = company.getAreaName();
            if ("华南".equals(areaName)) {
                areaStatistic.setSouthChina(areaStatistic.getSouthChina()+1);
                areaStatistic.setSouthChinaId(company.getAreaId());
            } else if ("华北".equals(areaName)) {
                areaStatistic.setNorthChina(areaStatistic.getNorthChina()+1);
                areaStatistic.setNorthChinaId(company.getAreaId());
            } else if ("华东".equals(areaName)) {
                areaStatistic.setEastChina(areaStatistic.getEastChina()+1);
                areaStatistic.setEastChinaId(company.getAreaId());
            }
        }
        System.out.println(areaStatistic);
        // 解法二
        AreaStatistic areaStatistic2 = new AreaStatistic();
        for (Company company:companyList) {
            setAreaProperty(areaStatistic2,company.getAreaName(),company.getAreaId());
        }
        System.out.println(areaStatistic2);

    }

    private void setAreaProperty(AreaStatistic areaStatistic,String areaName,Integer areaId) throws IllegalAccessException {
        Class staticClass = areaStatistic.getClass();
        Field[] fields = staticClass.getDeclaredFields();
        for (Field field : fields) {
            ColumnProperty property = field.getAnnotation(ColumnProperty.class);
            String value = property.value();
            if (value != null) {
                int indexOf = value.indexOf("大区");
                if (indexOf != -1 && value.length() == 4) {
                    if (areaName.equals(value.substring(0,2))) {
                        field.setAccessible(true);
                        field.set(areaStatistic,(Integer) field.get(areaStatistic) + 1);
                        for (Field idField : fields) {
                            ColumnProperty idProperty = idField.getAnnotation(ColumnProperty.class);
                            String idValue = idProperty.value();
                            if (idValue.equals(areaName+"id")) {
                                idField.setAccessible(true);
                                idField.set(areaStatistic,areaId);
                                break;
                            }
                        }
                        break;
                    }
                }
            }
        }
    }

    /**
     * 根据注解累加字段值
     */
    @Test
    public void accumulate() throws IllegalAccessException {
        AreaStatistic statistic = new AreaStatistic();
        statistic.setEastChina(2);
        statistic.setNorthChina(3);
        statistic.setSouthChina(1);
        int sum = 0;
        Class staticClass = statistic.getClass();
        Field[] fields = staticClass.getDeclaredFields();
        for (Field field : fields) {
            ColumnProperty property = field.getAnnotation(ColumnProperty.class);
            String value = property.value();
            if (value.indexOf("大区") != -1) {
                field.setAccessible(true);
                sum += field.get(statistic) == null ? 0 : (Integer) field.get(statistic);
            }
        }
        System.out.println(sum);
    }

}
