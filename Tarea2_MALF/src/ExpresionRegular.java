public class ExpresionRegular {

    static public void comprobarExpresionRegular(String _er)
    {


        boolean[] caracteres_verificados = new boolean[_er.length()];

        int tipo;

        for (int i = 0; i < _er.length() ; i++)
        {
            if(!caracteres_verificados[i])
            {
                tipo = identificarCaracter(_er.charAt(i));

                switch (tipo){

                    case 0:
                        verificarConcatenacion(_er,caracteres_verificados,i);
                        break;

                    case 1:
                        verificarUnion(_er,caracteres_verificados,i);
                        break;

                    case 2:
                        verificarClausula(_er,caracteres_verificados,i);
                        break;

                    case 3:
                        verificarParentesis(_er,caracteres_verificados,i);
                        break;

                    case 4:
                        verificarVacio(_er,caracteres_verificados,i);
                        break;

                    case 5:
                        verificarConjuntoVacio(_er,caracteres_verificados,i);
                        break;

                    case 6:
                        verificarAlfabeto(_er,caracteres_verificados,i);
                        break;

                    case -1:
                        throw new RuntimeException("Error en sintaxis de parentesis");
                }

            }

        }

    }


    private static boolean verificarConcatenacion(String er, boolean[] caracteresVerificados, int i)
    {

        boolean bandera = true;

        //Revisa caracter anterior
        if(i != 0)
        {
            int tipo_b = identificarCaracter(er.charAt(i-1));

            // Caracteres:  * - ) - Alfabeto - Vacio
            if (!(tipo_b == 2 || tipo_b == -1 || tipo_b == 6 || tipo_b == 4))
            {
                bandera = false;
            }
        }
        // Concatenación no puede ir al inicio
        else
        {
            bandera = false;
        }


        // Revisa caracter posterior
        if(i != er.length()-1)
        {
            int tipo_b = identificarCaracter(er.charAt(i+1));

            // Caracteres: ( - Alfabeto
            if (!(tipo_b == 3 || tipo_b == 6 || tipo_b == 4))
            {
                bandera = false;
            }
        }
        // Concatenación no puede ir al final
        else
        {
            bandera = false;
        }

        // Hay error ?
        if(!bandera)
        {
            throw new RuntimeException("Error de Sintaxis en concatenación");
        }

        // VERIFICADO !!!
        caracteresVerificados[i] = true;

        return true;
    }

    private static boolean verificarUnion(String er, boolean[] caracteresVerificados, int i)
    {
        boolean bandera = true;

        //Revisa caracter anterior
        if(i != 0)
        {
            int tipo_b = identificarCaracter(er.charAt(i-1));

            // * - ) - Alfabeto - Vacio
            if (!(tipo_b == 2 || tipo_b == -1 || tipo_b == 6 || tipo_b == 4))
            {
                bandera = false;
            }
        }
        // Unión no puede ir al inicio
        else
        {
            bandera = false;
        }


        // Revisa caracter posterior
        if(i != er.length()-1)
        {
            int tipo_b = identificarCaracter(er.charAt(i+1));

            // ( - Alfabeto - Vacio
            if (!(tipo_b == 3 || tipo_b == 6 || tipo_b == 4 ))
            {
                bandera = false;
            }
        }
        // Unión no puede ir al final
        else
        {
            bandera = false;
        }


        // Hay error ?
        if(!bandera)
        {
            throw new RuntimeException("Error de Sintaxis en unión");
        }

        // VERIFICADO !!!
        caracteresVerificados[i] = true;

        return true;
    }

    private static boolean verificarClausula(String er,boolean[] caracteresVerificados, int i)
    {
        boolean bandera = true;

        //Revisa caracter anterior
        if(i != 0)
        {
            int tipo_b = identificarCaracter(er.charAt(i-1));

            // Caracteres:  ) - Alfabeto - Vacio
            if (!(tipo_b == -1 || tipo_b == 6 || tipo_b == 4))
            {
                bandera = false;
            }
        }
        // Clausula no puede ir al inicio
        else
        {
            bandera = false;
        }


        // Revisa caracter posterior
        if(i != er.length()-1)
        {
            int tipo_b = identificarCaracter(er.charAt(i+1));

            // Caracteres: . - | . )
            if (!(tipo_b == 0 || tipo_b == 1 || tipo_b == -1))
            {
                bandera = false;
            }
        }

        //Hay error ?
        if(!bandera)
        {

            throw new RuntimeException("Error de Sintaxis en concatenación");

        }

        // VERIFICADO !!!
        caracteresVerificados[i] = true;

        return true;
    }

    private static boolean verificarParentesis(String er,boolean[] caracteresVerificados,int i)
    {
        boolean bandera = true;

        int tipo_f;

        //Revisa caracter anterior
        if(i != 0)
        {
            int tipo_b = identificarCaracter(er.charAt(i-1));


            // Caracteres:  . - |
            if (!(tipo_b == 0 || tipo_b == 1))
            {
                bandera = false;
            }
        }




        // Revisa caracter posterior
        if(i != er.length()-1)
        {
            int tipo_b = identificarCaracter(er.charAt(i+1));

            // Caracteres: Alfabeto - (  - Vacio
            if (!(tipo_b == 6 || tipo_b == 4 || tipo_b == 3))
            {
                bandera = false;
            }
        }
        // Parentesis no puede ir al final
        else
        {
            bandera = false;
        }


        //Encontrar parentesis cerrado
        for ( int j = i ; j < er.length() ; j++)
        {

            int tipo_c = identificarCaracter(er.charAt(j));
            if( ( tipo_c == -1 ) && ( !caracteresVerificados[j] ) )
            {
                caracteresVerificados[j] = true;
                break;
            }
            // No se encotró
            else if (j == er.length()-1){
                bandera = false;
            }
        }

        if(!bandera)
        {

            throw new RuntimeException("Error de Sintaxis en Parentesis");

        }

        // VERIFICADO !!!
        caracteresVerificados[i] = true;

        return true;
    }

    private static boolean verificarVacio(String er, boolean[] caracteresVerificados, int i)
    {
        boolean bandera = true;

        int tipo_f;

        //Revisa caracter anterior
        if(i != 0)
        {
            int tipo_b = identificarCaracter(er.charAt(i-1));


            // Caracteres:  . - ( - |
            if (!(tipo_b == 0 || tipo_b == 1 || tipo_b == 3))
            {
                bandera = false;
            }
        }


        // Revisa caracter posterior
        if(i != er.length()-1)
        {
            int tipo_b = identificarCaracter(er.charAt(i+1));

            // Caracteres:  . - ) - | - *
            if (!(tipo_b == 0 || tipo_b == 1 || tipo_b == 2 || tipo_b == -1))
            {
                bandera = false;
            }
        }

        if(!bandera)
        {

            throw new RuntimeException("Error de Sintaxis en vacio");

        }

        // VERIFICADO !!!
        caracteresVerificados[i] = true;

        return true;
    }

    private static boolean verificarConjuntoVacio(String er, boolean[] caracteresVerificados, int i)
    {
        if(er.length() != 1)
        {
            throw new RuntimeException("Error de Sintaxis en conjunto Vacio");
        }

        return true;
    }

    private static boolean verificarAlfabeto(String er, boolean[] caracteresVerificados, int  i)
    {
        boolean bandera = true;

        //Revisa caracter anterior
        if(i != 0)
        {
            int tipo_b = identificarCaracter(er.charAt(i-1));

            // Caracteres:  . - | - (
            if (!(tipo_b == 0 || tipo_b == 1 || tipo_b == 3))
            {
                bandera = false;
            }
        }



        // Revisa caracter posterior
        if(i != er.length()-1)
        {
            int tipo_b = identificarCaracter(er.charAt(i+1));

            // Caracteres:  . - | - ) - *
            if (!(tipo_b == 0 || tipo_b == 1 || tipo_b == 2 || tipo_b == -1))
            {
                bandera = false;
            }
        }


        // Hay error ?
        if(!bandera)
        {

            throw new RuntimeException("Error de Sintaxis en alfabeto");

        }

        // VERIFICADO !!!
        caracteresVerificados[i] = true;

        return true;
    }

    private static int identificarCaracter(char caracter)
    {

        // Concatenación
        if((int) caracter == 46)
        {

            return 0;

        }

        // Unión
        else if ((int) caracter == 124)
        {

            return 1;

        }

        // Clausura de Kleene
        else if ((int) caracter == 42)
        {
            return 2;
        }

        // Parentesis Inicial
        else if ((int) caracter == 40)
        {

            return 3;
        }

        // Parentesis Final
        else if ((int) caracter == 41)
        {
            return -1;
        }

        // Vacío
        else if ((int) caracter == 45)
        {

            return 4;
        }

        // Conjunto Vacio
        else if ((int) caracter == 126)
        {

            return 5;
        }

        // Alfabeto
        else if (( (int) caracter >  64 && (int) caracter <  91 ) ||
                 ( (int) caracter >  96 && (int) caracter <  123) ||
                 ( (int) caracter >  47 && (int) caracter <  58 ) ||
                   (int) caracter == 36 || (int) caracter == 38 )
        {

            return 6;

        }

        // Error
        else
        {
            throw new IllegalArgumentException("Caracter Invalido");
        }

    }
}