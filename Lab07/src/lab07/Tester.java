package lab07;

public class Tester extends Postfixer {
	
public static void main(String[] args) throws Exception {
        
        if (!(PostfixConvertor(new String("(4+5)")).equals("45+")))
            System.err.println("test1 failed --> should have been 45+");
        
        if (!(PostfixConvertor(new String("((4+5)*6)")).equals("45+6*")))
            System.err.println("test2 failed --> should have been 45+6*");
        
        if (!(PostfixConvertor(new String("((4+((5*6)/7))-8)")).equals("456*7/+8-")))
            System.err.println("test3 failed --> should have been 456*7/+8-");
        
        if (!(PostfixConvertor(new String("((4+5*(6-7))/8)")).equals("4567-*+8/")))
            System.err.println("test4 failed --> should have been 4567-*+8/");
        
        if (!(PostfixConvertor(new String("(9+(8*7-(6/5^4)*3)*2)")).equals("987*654^/3*-2*+")))
            System.err.println("test5 failed --> should have been 987*654^/3*-2*+");
        
        System.out.println("Testing Done!!!");


}
}

