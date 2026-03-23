package demo12.demo8;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class proxyutil {
    public static servise getProxy(star s){
        servise s1 = (servise) Proxy.newProxyInstance(
                s.getClass().getClassLoader(),
                s.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        String methodName = method.getName();
                        if (methodName.equals("sing")){
                            System.out.println("I'm before sing");
                            System.out.println("money1000");
                        }else if (methodName.equals("dance")){
                            System.out.println("I'm before dance");
                            System.out.println("money20000");
                        }
                        Object result = method.invoke(s, args);
                        return result;
                    }
                });
        return s1;
    }
}
