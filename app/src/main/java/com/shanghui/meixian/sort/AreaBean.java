package com.shanghui.meixian.sort;

import java.util.List;

/**
 * Created by WeiChao.Xia on 2017/3/24.
 */
public class AreaBean {
    /**
     * id ：获取热门城市
     * ID : 1 获取省市
     * name : 北京市
     */
    private List<AreaBean> been;

    public List<AreaBean> getBeen() {
        return been;
    }

    public void setBeen(List<AreaBean> been) {
        this.been = been;
    }

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String ID;
    private String name;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
