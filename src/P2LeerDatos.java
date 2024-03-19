import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class P2LeerDatos {
    public static void main( String[ ] args )
    {
        try
        {
            DataInputStream dis = new DataInputStream( new FileInputStream("marcas.dat" ) );

            int[ ] contador = new int[ 5 ];
            double[ ] min = new double[ 5 ];
            double[ ] max = new double[ 5 ];

            while( true )
            {
                try
                {
                    int dia = dis.readInt( );
                    double marca = dis.readDouble( );

                    contador[ dia - 1 ]++;

                    if (contador[ dia - 1 ] == 1 || marca < min[ dia - 1 ] )
                        min[ dia - 1 ] = marca;

                    if (contador[ dia - 1 ] == 1 || marca > max[ dia - 1 ] )
                        max[ dia - 1 ] = marca;

                } catch (IOException e) {
                    break;
                }
            }

            String diaSemana[ ] = {
                    "Lunes", "Martes", "Miércoles", "Jueves", "Viernes"
            };

            for( int i = 0; i < 5; i++ )
            {

                if( contador[ i ] > 0 )
                    System.out.println( diaSemana[ i ] + ": " + contador[ i ] + " marcas; min=" + min[ i ] + "; máx=" + max[ i ] );
                else
                    System.out.println( diaSemana[ i ] + ": NO HAY DATOS");
            }

            dis.close( );

        } catch ( IOException e ) {
            throw new RuntimeException( e );
        }
    }
}