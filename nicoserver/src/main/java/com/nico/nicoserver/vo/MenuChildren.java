package com.nico.nicoserver.vo;

import com.nico.nicoserver.entity.YqMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @ClassName MenuChildren
 * @Description TODO
 * @Date 2019/1/15 0015 15:20
 */
public class MenuChildren {
    private  YqMenu yqMenu = new YqMenu();

    private List<MenuChildren> children = new ArrayList<MenuChildren>();

    public YqMenu getYqMenu() {
        return yqMenu;
    }

    public void setYqMenu(YqMenu yqMenu) {
        this.yqMenu = yqMenu;
    }

    public  List<MenuChildren> getChildren(){
        return  children;
    }

    public void setChildren(List<MenuChildren> children){
        this.children = children;
    }
}
