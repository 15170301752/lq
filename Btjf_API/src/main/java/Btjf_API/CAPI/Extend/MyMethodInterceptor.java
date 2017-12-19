package Btjf_API.CAPI.Extend;

import org.testng.*;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by wl on 2016/8/22.
 */
public class MyMethodInterceptor implements IMethodInterceptor {
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context){
        List<IMethodInstance> newList = new ArrayList<IMethodInstance>();
        HashMap<String,IMethodInstance> map1 = new HashMap<String, IMethodInstance>();
        LinkedHashMap<String,IMethodInstance> map2  = new LinkedHashMap<String, IMethodInstance>();
        List<String> testngList = new ArrayList<String>();
        List<String> classMehtodList = new ArrayList<String>();
        classMehtodList.add("C");
        classMehtodList.add("B");
        classMehtodList.add("D");
        classMehtodList.add("A");
        System.out.println(methods.size());
        System.out.println( context.getCurrentXmlTest());
        String className = context.getCurrentXmlTest().toString();
        String calssname = className.substring(className.indexOf("class=")+"class=".length(),className.indexOf("]  packages")) ;
        System.out.println( calssname);
        Class<?> clazz = null;
        try {
            clazz = Class.forName(calssname);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Method[] methodss = clazz.getMethods();
        for(int i=0;i<methodss.length;i++){
            String methodName = methodss[i].getName();
            System.out.println(methodName);
        }

//        System.out.println( context.getClass().getName());
//        System.out.println( context.getName());
        int flag = 0;
        for(IMethodInstance m:methods){
            String methodName = m.getMethod().getMethodName();
            testngList.add(methodName);
        }
        for(int i=0;i<classMehtodList.size();i++){
            if(!(testngList.contains(classMehtodList.get(i)))){
                classMehtodList.remove(classMehtodList.get(i));
                i--;
            }
        }
        for(IMethodInstance m:methods){
            String methodName = m.getMethod().getMethodName();
            map1.put(methodName,m);
            map2.put(classMehtodList.get(flag),m);
        }
        Set<String> set = map2.keySet();
        for(String key:set){
            map2.put(key, map1.get(key));
            newList.add(map2.get(key));
        }
        return newList;
    }
    public static void main(String[] args){
        List<String> l1 = new ArrayList<String>();
        List<String> l2 = new ArrayList<String>();
//        l1.add("A");
        l1.add("B");
        l1.add("C");
//        l1.add("D");
        l2.add("C");
        l2.add("B");
        l2.add("D");
        l2.add("A");
        for(int i=0;i<l2.size();i++){
            if(!(l1.contains(l2.get(i)))){
                l2.remove(l2.get(i));
                i--;
            }
            continue;
        }
        System.out.println(l2.toString());
    }


}
