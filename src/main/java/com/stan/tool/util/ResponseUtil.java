package com.stan.tool.util;

import com.stan.tool.common.Constant;
import com.stan.tool.model.resp.RespVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @program: tool
 * @description: generate response body
 * @author: largebear229@gmail.com
 * @create: 2020-09-05 22:34
 **/
public class ResponseUtil {

    private static final Logger logger = LoggerFactory.getLogger(ResponseUtil.class);

    public static RespVO success(Object data) {
        RespVO respVO = new RespVO();
        respVO.setErrCode(Constant.Api.SUCCESS_CODE);
        respVO.setData(data);
        return respVO;
    }

    public static RespVO success() {
        return success(null);
    }

    public static RespVO error(String errMsg) {
        RespVO respVO = new RespVO();
        respVO.setErrCode(Constant.Api.FAILURE_CODE );
        respVO.setErrMsg(errMsg);
        return respVO;
    }

//    public static void main(String[] args) throws UnsupportedEncodingException {
//        String a = "he";
//        System.out.println(a.getBytes("ISO8859-1").length);
//        System.out.println(a.getBytes("UTF-8").length);
//        System.out.println(a.getBytes("UTF-16").length);
//        System.out.println(a.getBytes().length);
//        System.out.println(a.getBytes("ISO8859-1").toString());
//        System.out.println(a.getBytes("UTF-16").toString());
//        System.out.println(new String(a.getBytes("UTF-16"),"UTF-16"));
//
//        char b = 'e';
//    }

    public static void main(String[] args) {
//        int[] nums = new int[]{2,7,11,15};
//        int target = 9;
//        int[] result = twoSum(nums, target);
//        System.out.println(Arrays.stream(result).toArray().toString());

//        int test = 121;
//        boolean result = isPalindrome(test);

//        int x = Integer.MAX_VALUE;
//        System.out.println(x);

//        int total = romanToInt("IV");
//        System.out.println(total);
//        String a = "luo";
//        a.indexOf("3");

//        System.out.println(5/2);
//        int[] arr = new int[2];
//        char test = 1 + '0';
//        System.out.println(test);

//        String a = "1010";
//        String b = "1011";
//        String result = addBinary(a,b);
//        System.out.println(result);

//        int x;
//        int y = 0;
//        System.out.println(y);

//        Queue<Object> queue = new PriorityQueue<>();
//        queue.add(null);
//        System.out.println(queue.poll());


//        List<List<Integer>> result = generate(4);
//        System.out.println(result);
//        String test = new String();
//        int[] arr = test.codePoints().toArray();
        StringBuilder sb = new StringBuilder("ab");
        System.out.println(sb.reverse());
        System.out.println(sb);


    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++){
            map.put(nums[i],i);
        }
        Set<Integer> valueSet = map.keySet();
        for(int i=0; i<nums.length; ++i){
            if(valueSet.contains(target-nums[i]) && map.get(target - nums[i]) != i){
                result[0] = i;
                result[1] = map.get(target-nums[i]);
                break;
            }
        }
        return result;
    }

    public static boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }else if(x == 0){
            return true;
        }else{
            int[] all = new int[10];
            int tmp = x;
            int index=0;
            while(tmp!=0){
                all[index] = tmp%10;
                tmp = tmp/10;
                index++;
            }
            for(int i=0, j=all.length-1; i!=j; i++,j--){
                if(all[i] != all[j]){
                    return false;
                }
            }
            return true;
        }
    }

    public static int romanToInt(String s) {
        Map<Character,Integer> romanMap = new HashMap<>();
        romanMap.put('I',1);
        romanMap.put('V',5);
        romanMap.put('X',10);
        romanMap.put('L',50);
        romanMap.put('C',100);
        romanMap.put('D',500);
        romanMap.put('M',1000);
        char[] chars = s.toCharArray();
        int sum=0;
        for(int i=0; i<chars.length;++i){
            if(i>0 && romanMap.get(chars[i])>romanMap.get(chars[i-1])){
                sum=sum-romanMap.get(chars[i-1])*2+romanMap.get(chars[i]);
            }else{
                sum=sum+romanMap.get(chars[i]);
            }
        }
        return sum;

    }

    public static String addBinary(String a, String b) {
        int flag = 0;
        int tmp1 = 0;
        int tmp2 = 0;
        int delta = Math.abs(a.length()-b.length());
        String longOne;
        String shortOne;
        if(a.length()>=b.length()){
            longOne = a;
            shortOne = b;
        }else{
            longOne = b;
            shortOne = a;
        }
        char[] result = new char[longOne.length()];
        int sum;
        for(int i=longOne.length()-1; i>=0; --i){
            if(i-delta>=0){
                tmp1 = longOne.charAt(i) - '0';
                tmp2 = shortOne.charAt(i-delta) - '0';
            }else{
                tmp1 = longOne.charAt(i) - '0';
                tmp2 = 0;
            }
            sum = tmp1 + tmp2 + flag;
            if(sum >= 2){
                result[i] = Character.forDigit(sum%2,2);
                flag = 1;
            }else{
                result[i] = Character.forDigit(sum,2);;
                flag = 0;
            }
        }
        String last = String.valueOf(result);
        if(1 == flag){
            return "1"+last;
        }else{
            return last;
        }
    }

    public static int mySqrt(int x) {
        int left = 0, right = x;
        int mid;
        if(0 == x || 1 == x){
            return x;
        }
        while(left<right){
            mid = (left+right)/2;
            if(mid * mid > x){
                right = mid;
            }else{
                if(left == mid){
                    return left;
                }
                left = mid;
            }
        }
        return left;
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(1 == numRows){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            result.add(list);
            return result;
        }else if(2 == numRows){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            result.add(list);
            List<Integer> list1 = new ArrayList<>();
            list1.add(1);
            list1.add(1);
            result.add(list1);
            return result;
        }else{
            List<Integer> list = new ArrayList<>();
            list.add(1);
            result.add(list);
            List<Integer> list1 = new ArrayList<>();
            list1.add(1);
            list1.add(1);
            result.add(list1);
            for(int i=2; i<numRows; ++i){
                List<Integer> itemList = new ArrayList<>();
                for(int j=0; j<i+1; j++){
                    if(j == 0||j==i){
                        itemList.add(1);
                    }else{
                        itemList.add(result.get(i-1).get(j)+result.get(i-1).get(j-1));
                    }
                }
                result.add(itemList);
            }
            return result;
        }
    }
}