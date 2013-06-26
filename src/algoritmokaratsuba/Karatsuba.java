package algoritmokaratsuba;

import java.math.BigInteger;

public class Karatsuba 
{
    public static BigInteger multiplicadorKaratsuba ( BigInteger num1, BigInteger num2 )
    {
        int posiciones = Math.max ( num1.bitLength( ), num2.bitLength ( ) );
 
        if ( posiciones <= 1000 ) 
           return num1.multiply ( num2 );
    
        posiciones = posiciones / 2;
 
        BigInteger w = num1.shiftRight ( posiciones );
        BigInteger x = num1.subtract ( w.shiftLeft ( posiciones ) );
        BigInteger y = num2.shiftRight ( posiciones );
        BigInteger z = num2.subtract ( y.shiftLeft ( posiciones ) );
 
        BigInteger p = multiplicadorKaratsuba ( w, y ); 
        BigInteger q = multiplicadorKaratsuba ( x, z ); 
        BigInteger r = multiplicadorKaratsuba ( x.add ( w ), z.add ( y ) ); 
        BigInteger z1 = r.subtract ( p ).subtract ( q ); 
 
        return p.shiftLeft ( 2 * posiciones ).add ( z1.shiftLeft ( posiciones ) ).add ( q );
    }
}
