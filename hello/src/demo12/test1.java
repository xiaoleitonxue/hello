package demo12;

import org.junit.Assert;
import org.junit.Test;

public class test1 {
    @Test
    public void testprintnumber(){
        test.printNumber("hello");
        test.printNumber("");
        test.printNumber(null);
    }
    @Test
    public void testgetMaxIndex(){
        int maxIndex1 = test.getMaxIndex("hello");
        System.out.println(maxIndex1);
        int  maxIndex2 = test.getMaxIndex(null);
        System.out.println(maxIndex2);
        int maxIndex3 = test.getMaxIndex("");
        System.out.println(maxIndex3);

        Assert.assertEquals("错误",5, maxIndex1);
        Assert.assertEquals("错误",-1, maxIndex2);
        Assert.assertEquals("错误",-1, maxIndex3);
    }
}
