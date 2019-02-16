package com.nico.nicoclient.sys;

import org.springframework.context.annotation.Configuration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sysclient {

  public static void main(String[] args){

      String str = "95867299";
      //String pattern = "^[0-9a-z-]{3,5}b$";
      String pattern = "^[0-9a-z_-]{3,8}$";
      Pattern r = Pattern.compile(pattern);
      Matcher m = r.matcher(str);
      System.out.println(m.matches());
  }
  /**
   * @author Administrator
   * @Date  2019/1/2 0002 16:14
   * @Param
   * @return
   * @version 1.0.0
   */

  public void cc(String cc){

  }
}
