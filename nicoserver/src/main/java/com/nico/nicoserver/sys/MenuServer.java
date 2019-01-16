package com.nico.nicoserver.sys;

import com.nico.nicoserver.entity.YqMenu;
import com.nico.nicoserver.mapper.MenuRepository;
import com.nico.nicoserver.vo.MenuChildren;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @version 1.0.0
 * @ClassName MenuServer
 * @Description TODO
 * @Date 2019/1/15 0015 14:42
 */
@Controller
@RequestMapping("/menu")
public class MenuServer {
    @Autowired
    MenuRepository menuRepository;

    @ResponseBody
    @RequestMapping("/query")
    public List<MenuChildren> query(){
        List<YqMenu> list = menuRepository.findAll();
        List<MenuChildren> list1 = new ArrayList<MenuChildren>();
        for (YqMenu y : list) {
           MenuChildren children = new MenuChildren();
           children.setYqMenu(y);
           list1.add(children);
        }
        return getChildPerms(list1,0);
    }

    /**
     * 根据父节点的ID获取所有子节点
     *
     * @param list 分类表
     * @param parentId 传入的父节点ID
     * @return String
     */
    public List<MenuChildren> getChildPerms(List<MenuChildren> list, int parentId)
    {
        List<MenuChildren> returnList = new ArrayList<MenuChildren>();
        for (Iterator<MenuChildren> iterator = list.iterator(); iterator.hasNext();)
        {
            MenuChildren t = (MenuChildren) iterator.next();

            // 一、根据传入的某个父节点ID,遍历该父节点的所有子节点
            if (t.getYqMenu().getParentId() == parentId)
            {
                recursionFn(list, t);
                //children.setYqMenu(t);
                returnList.add(t);
            }
        }
        return returnList;
    }

    /**
     * 递归列表
     *
     * @param list
     * @param t
     */
    private void recursionFn(List<MenuChildren> list, MenuChildren t)
    {
        // 得到子节点列表
        List<MenuChildren> childList = getChildList(list, t);
        t.setChildren(childList);
        for (MenuChildren tChild : childList)
        {
            if (hasChild(list, tChild))
            {
                // 判断是否有子节点
                Iterator<MenuChildren> it = childList.iterator();
                while (it.hasNext())
                {
                    MenuChildren n = (MenuChildren) it.next();
                    recursionFn(list, n);
                }
            }
        }
    }

    /**
     * 得到子节点列表
     */
    private List<MenuChildren> getChildList(List<MenuChildren> list, MenuChildren t)
    {
        List<MenuChildren> tlist = new ArrayList<MenuChildren>();
        Iterator<MenuChildren> it = list.iterator();
        while (it.hasNext())
        {
            MenuChildren n = (MenuChildren) it.next();
            if (n.getYqMenu().getParentId() == t.getYqMenu().getMenuId())
            {
                tlist.add(n);
            }
        }
        return tlist;
    }

    /**
     * 判断是否有子节点
     */
    private boolean hasChild(List<MenuChildren> list, MenuChildren t)
    {
        return getChildList(list, t).size() > 0 ? true : false;
    }
}
