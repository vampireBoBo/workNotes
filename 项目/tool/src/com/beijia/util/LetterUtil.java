package com.beijia.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 首字母大小写转换工具类
 * */
public class LetterUtil {
	
	/**
	 * 首字母转小写
	 * */
    public static String toLowerCaseFirstOne(String s)
    {
        if(Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }
    /**
     * 首字母转大写
     * */
    public static String toUpperCaseFirstOne(String s)
    {
        if(Character.isUpperCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
    }
    
    /**
     * 从beginSymbol到endSymbol的切片数组
     * */
    public static String[] slice(String content, String beginSymbol, String endSymbol){
    	List<String> slices = new ArrayList<String>();
    	for (int i = 0; i < content.length(); ) {
    		int begin = i;
			i = content.indexOf(beginSymbol,i);
			if(i > -1){
				slices.add(content.substring(begin, i));
				int flg = content.indexOf(endSymbol, i);
				slices.add(content.substring(i+beginSymbol.length(), flg));
				i = flg+endSymbol.length();
			}else if(i == -1){
				String[] strArr = content.split(endSymbol);
				slices.add(strArr[strArr.length-1]);
				break;
			}else{
				break;
			}
		}
    	Object[] objArr = slices.toArray();
    	String[] strArr = new String[objArr.length];
    	for (int i = 0; i < strArr.length; i++) {
			strArr[i] = objArr[i].toString();
		}
    	return strArr;
    }

}
