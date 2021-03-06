package problems.solved;
import util.Problem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sam
 */
public class p22 implements Problem{
    public static void main(String[] args){
        
        System.out.println( "Solution::" + new p22().run() );
    }
    
    @Override
    public String getTitle(){
        return "Names scores";
    }
    
    @Override
    public int getID(){
        return 22;
    }
    
    @Override
    public String run(){
        long b = 0;
        try {
            String[] a = Import( "C:\\Users\\Sam\\Desktop\\names.txt" ); // hm...
            
            for( int i = 0; i < a.length; i++ )
                b += tally( a[i] ) * ( i + 1 );
            
            
        } catch (IOException ex) {
            Logger.getLogger(p22.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return String.valueOf(b);
    }
    
    public static String[] Import( String path ) throws IOException{
        BufferedReader a;
        String s = "ERROR";
        try {
             a = new BufferedReader(new FileReader(path));
            //a = new BufferedReader( InputStreamReader( p22.class.getResourceAsStream("/input_files/names.txt") ) );
             s = a.readLine();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(p22.class.getName()).log(Level.SEVERE, null, ex);
        }
        //String[] b = a[0].split( ',' ); // otherwsise it's just a giant elememt
        //Array.sort( b );
        
        String names[] = s.split( "," );
        for( int i = 0 ; i < names.length ; i++ ) // Cut off the quotation marks
            names[i] = names[i].substring( 1, names[i].length()-1 );
        Arrays.sort(names); // Might as well sort before returning
        return names;
    }
    
    public static int tally( String a ){
        char[] b = a.toCharArray();
        int c = 0;
        int d = 0;
        
        for( int i = 0; i < b.length; i++ ){
            c = ((b[i] - '0') + 10) % 26;
            if( c == 0 )
                c = 26;
            d += c;
        }
        
        return d;
    }
    
}
