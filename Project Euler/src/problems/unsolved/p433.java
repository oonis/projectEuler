
package problems.unsolved;
import util.Problem;

import java.math.BigInteger;

/**
 *
 * @author Sam
 */
public class p433 implements Problem{
    public static void main(String[] args) {
        System.out.println( "Solution::" + new p433().run() );
    }
    
    @Override
    public String getTitle(){
        return "Steps in Euclid's algorithm";
    }
    
    @Override
    public int getID(){
        return 433;
    }
    
    @Override
    public String run(){
        BigInteger count = BigInteger.ZERO;
        for( BigInteger i = BigInteger.ONE; i.compareTo(new BigInteger("5000000")) <= 0; i = i.add(BigInteger.ONE) ){
            for( BigInteger j = BigInteger.ONE; j.compareTo(new BigInteger("5000000")) <= 0; j = j.add(BigInteger.ONE) ){
                count = count.add( E(i,j) );
            }
            System.out.println(i);
        }
        
        return count.toString();
    }
    
    private BigInteger E( BigInteger i, BigInteger j ){
        BigInteger ret = GCD( i,j,BigInteger.ONE );
        return ret;
    }
    
    private BigInteger GCD( BigInteger i,BigInteger j,BigInteger n ){
        BigInteger i1 = j;
        BigInteger j1 = i.mod(j);
        if( j1.compareTo( BigInteger.ZERO ) == 0 ){
            return n;
        }else{
            return GCD( i1,j1,n.add(BigInteger.ONE) );
        }
    }
    
}
