import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class P1CalculaLluvia {

    public static void main( String[ ] args )
    {
        int minLluvia = 0;
        int totalLluvia = 0;

        try( BufferedReader br = new BufferedReader( new FileReader("lluvia.txt" ) );
             BufferedWriter bw = new BufferedWriter( new FileWriter("salida.txt" ) ) ) {

            minLluvia = Integer.parseInt(br.readLine());

            String line;

            while( ( line = br.readLine( ) ) != null && !line.equals( "-1" ) )
            {
                String[ ] parts = line.split(" " );
                String mes = parts[ 0 ];

                int sum = 0;

                for( int i = 1; i < parts.length; i++ )
                {
                    int lluvia = Integer.parseInt(parts[i]);
                    sum += lluvia;
                }

                if( sum >= minLluvia )
                {
                    bw.write(mes + " " + sum );
                    bw.newLine( );
                    totalLluvia += sum;
                }
            }

            bw.write("Total " + totalLluvia );

        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }
}