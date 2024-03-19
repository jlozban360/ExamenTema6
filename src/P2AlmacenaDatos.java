import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class P2AlmacenaDatos
{
    public static void main( String[ ] args )  throws IOException
    {
        Scanner sc = new Scanner( System.in );
        String strFinal = "";

        try( RandomAccessFile file = new RandomAccessFile("marcas.dat", "rw" ) )
        {
            while( true )
            {
                System.out.println( "Introduce el día de la semana y la marca (0=SALIR): " );
                String line = sc.nextLine( );

                String[ ] parts = line.split(" " );

                Integer auxDia = Integer.valueOf( parts[ 0 ] );

                if( auxDia >= 1 && auxDia <= 5 )
                {
                    System.out.println();
                }
                else

                if( auxDia == 0 )
                {
                    System.out.println( "Saliendo del programa..." );
                    break;
                }
                else if( auxDia < 1 || auxDia > 5  )
                {
                    strFinal = "Día no válido";
                }
                else
                    strFinal = line;

                byte[ ] textoBytes = strFinal.getBytes();
                file.write( textoBytes );

                file.close( );
                System.out.println( "Datos correctamente escritos en el archivo." );
            }
        } catch( IOException e ) {
            e.printStackTrace( );
        }
    }
}
