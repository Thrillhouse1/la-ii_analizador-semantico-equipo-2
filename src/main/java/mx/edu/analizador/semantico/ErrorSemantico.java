package mx.edu.analizador.semantico;

<<<<<<< HEAD
import mx.edu.analizador.lexico.Token;

import java.util.ArrayList;
import java.util.List;

/**
 * Un error semántico encontrado en el código: es una fila de la tabla de errores de la interfaz.
 * linea, inicio y fin señalan el token que causó el error (columnas desde 1, fin inclusivo).
 */
public record ErrorSemantico(String nombre, String descripcion, int linea, int inicio, int fin) {

    /**
     * Busca todos los errores semánticos en los tokens. Cada error del catálogo tiene su
     * propia clase; al implementar uno nuevo, agrégalo aquí.
     */
    public static List<ErrorSemantico> buscarErrores(List<Token> tokens) {
        List<ErrorSemantico> errores = new ArrayList<>();
        // errores.addAll(new ErrorContinue().analizar(tokens)); // 9 - Uso incorrecto de continue
        errores.addAll(new FuncionNoDeclarada().analizar(tokens));// 6- funcion no declarada
        errores.addAll(new ErrorBreak().analizar(tokens)); // 9 - Uso incorrecto del break
        return errores;
    }



}
=======
public class ErrorSemantico {
    private final String nombre;
    private final String descripcion;
    private final int linea;
    private final int inicio;
    private final int fin;

    public ErrorSemantico(String nombre, String descripcion, int linea, int inicio, int fin) {
      this.nombre = nombre;
      this.descripcion = descripcion;
      this.linea = linea;
      this.inicio = inicio;
      this.fin = fin;
    }

    public String getNombre() {

        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getLinea() {
        return linea;
    }

    public int getInicio() {
        return inicio;
    }

    public int getFin() {
        return fin;
    }

    /*@Override
    public String toString() {
        return nombre + " en línea " + linea + ", columna " + inicio;
    }*/
}
>>>>>>> 73b4b9a75fbfa5c330a3a56e46dbbd79ea21b08b
