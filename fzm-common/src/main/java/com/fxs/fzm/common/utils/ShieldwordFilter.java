package com.fxs.fzm.common.utils;

import java.util.*;

/**
 * 屏蔽词过滤
 *
 * */

public class ShieldwordFilter {

    public static Map shieldWordMap = null;
    //最小匹配规则
    public static int minMatchTYpe = 1;
    //最大匹配规则
    public static int maxMatchType = 2;

    /**
     * 判断文字是否包含屏蔽字符
     * @param txt  文字
     * @param matchType  匹配规则&nbsp;1：最小匹配规则，2：最大匹配规则
     * @return 若包含返回true，否则返回false
     * @version 1.0
     */
    public static boolean isContaintshieldWord(String txt,int matchType){
        boolean flag = false;
        for(int i = 0 ; i < txt.length() ; i++){
            //判断是否包含屏蔽字符
            int matchFlag = CheckshieldWord(txt, i, matchType);
            //大于0存在，返回true
            if(matchFlag > 0){
                flag = true;
            }
        }
        return flag;
    }



    /**
     * 检查文字中是否包含屏蔽字符，检查规则如下：
     * @param txt
     * @param beginIndex
     * @param matchType
     * @return，如果存在，则返回屏蔽词字符的长度，不存在返回0
     * @version 1.0
     */
    public static int CheckshieldWord(String txt,int beginIndex,int matchType){
        //屏蔽词结束标识位：用于屏蔽词只有1位的情况
        boolean  flag = false;
        //匹配标识数默认为0
        int matchFlag = 0;
        char word = 0;
        Map nowMap = shieldWordMap;
        for(int i = beginIndex; i < txt.length() ; i++){
            word = txt.charAt(i);
            //获取指定key
            nowMap = (Map) nowMap.get(word);
            //存在，则判断是否为最后一个
            if(nowMap != null){
                //找到相应key，匹配标识+1
                matchFlag++;
                //如果为最后一个匹配规则,结束循环，返回匹配标识数
                if("1".equals(nowMap.get("isEnd"))){
                    //结束标志位为true
                    flag = true;
                    if(ShieldwordFilter.minMatchTYpe == matchType){
                        //最小规则，直接返回,最大规则还需继续查找
                        break;
                    }
                }
            }
            else{
                //不存在，直接返回
                break;
            }
        }
        //长度必须大于1，为词
        if(matchFlag < 1 || !flag){
            matchFlag = 0;
        }
        return matchFlag;
    }


    /**
     * 获取文字中的屏蔽词
     *
     * @param matchType 匹配规则&nbsp;1：最小匹配规则，2：最大匹配规则
     * @return
     * @version 1.0
     */
    public static Set<String> getshieldWord(String txt , int matchType){
        Set<String> shieldWordList = new HashSet<String>();

        for(int i = 0 ; i < txt.length() ; i++){
            //判断是否包含屏蔽字符
            int length = CheckshieldWord(txt, i, matchType);
            if(length > 0){
                //存在,加入list中
                shieldWordList.add(txt.substring(i, i+length));
                //减1的原因，是因为for会自增
                i = i + length - 1;
            }
        }

        return shieldWordList;
    }

    /**
     * 替换文字中的屏蔽词
     * @return
     * @version 1.0
     */
    public static String replaceShieldWord(String txt){
        String str = txt;
        for(int i = 0 ; i < txt.length() ; i++){
            //判断是否包含屏蔽字符
            int length = CheckshieldWord(txt, i, 2);
            //存在,加入list中
            if(length > 0){
                String oldWord = txt.substring(i, i+length);
                String newWord = newWord(length);
                str = str.replace(oldWord,newWord);
                //减1的原因，是因为for会自增
                i = i + length - 1;
            }
        }

        return str;
    }

    public static String newWord(int length){
        String newWord = "";
        for(int i = 0;i < length; i++){
            newWord += "*";
        }
        return newWord;
    }


    //将得到的屏蔽词库用一个DFA算法模型放到map中
    public static void addshieldWordToHashMap(Set<String> keyWordSet) {
        //初始化屏蔽词容器，减少扩容操作
        shieldWordMap = new HashMap(keyWordSet.size());
        String key = null;
        Map nowMap = null;
        Map<String, String> newWorMap = null;
        //迭代keyWordSet
        Iterator<String> iterator = keyWordSet.iterator();
        while(iterator.hasNext()){
            //关键字
            key = iterator.next();
            nowMap = shieldWordMap;
            for(int i = 0 ; i < key.length() ; i++){
                //转换成char型
                char keyChar = key.charAt(i);
                //获取
                Object wordMap = nowMap.get(keyChar);
                //如果存在该key，直接赋值
                if(wordMap != null){
                    nowMap = (Map) wordMap;
                } else {
                    //不存在则，则构建一个map，同时将isEnd设置为0，因为他不是最后一个
                    newWorMap = new HashMap<String,String>();
                    //不是最后一个
                    newWorMap.put("isEnd", "0");
                    nowMap.put(keyChar, newWorMap);
                    nowMap = newWorMap;
                }

                if(i == key.length() - 1){
                    //最后一个
                    nowMap.put("isEnd", "1");
                }
            }
        }
    }


    //读取屏蔽词 加到set集合中
    public static Set<String> changeshieldWord(List list){
        Set<String> set = new HashSet<String>();
        String str;
        for(int i = 0; i < list.size(); i++){
            str = list.get(i).toString();
            set.add(str);
        }
        return set;
    }

    // 初始化set屏蔽词库
    public static Map initKeyWord(List list){
        try {
            //读取屏蔽词库
            Set<String> keyWordSet = changeshieldWord(list);
            //将屏蔽词库加入到HashMap中
            addshieldWordToHashMap(keyWordSet);
            //spring获取application，然后application.setAttribute("shieldWordMap",shieldWordMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return shieldWordMap;
    }
}
