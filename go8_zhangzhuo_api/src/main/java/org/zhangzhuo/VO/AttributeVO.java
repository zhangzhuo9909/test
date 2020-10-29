package org.zhangzhuo.VO;


import org.zhangzhuo.entity.Attribute;
import org.zhangzhuo.entity.AttributeValue;

import java.util.List;

public class AttributeVO extends Attribute {

    private List<AttributeValue> values;

    @Override
    public String toString() {
        return "AttributeVO{" +
                "values=" + values +
                '}';
    }

    public List<AttributeValue> getValues() {
        return values;
    }

    public void setValues(List<AttributeValue> values) {
        this.values = values;
    }

    public AttributeVO() {
    }

    public AttributeVO(List<AttributeValue> values) {
        this.values = values;
    }
}
