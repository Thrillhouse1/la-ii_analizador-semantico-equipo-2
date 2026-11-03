package mx.edu.analizador.semantico;

import mx.edu.analizador.lexico.Token;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ErrorBreak {

    public List<ErrorSemantico> analizar(List<Token> tokens) {
        List<ErrorSemantico> errores = new ArrayList<>();
        int nivelLlaves = 0;
        Stack<Integer> llavesCicloOSwitch = new Stack<>();
        boolean esperandoBloque = false;

        for (Token token : tokens) {
            String lexema = token.lexema();

            if (lexema.equals("for") || lexema.equals("while") || lexema.equals("do") || lexema.equals("switch")) {
                esperandoBloque = true;
            }

            if (lexema.equals("{")) {
                nivelLlaves++;
                if (esperandoBloque) {
                    llavesCicloOSwitch.push(nivelLlaves);
                    esperandoBloque = false;
                }
            } else if (lexema.equals("}")) {
                if (!llavesCicloOSwitch.isEmpty() && llavesCicloOSwitch.peek() == nivelLlaves) {
                    llavesCicloOSwitch.pop();
                }
                nivelLlaves--;
            }

            if (lexema.equals("break")) {
                if (llavesCicloOSwitch.isEmpty() && !esperandoBloque) {
                    errores.add(new ErrorSemantico(
                            "Uso incorrecto de break",
                            "La instrucción break tiene el propósito específico de romper la ejecución de un ciclo o switch.",
                            token.linea(),
                            token.inicio(),
                            token.fin()
                    ));
                }

                if (esperandoBloque) {
                    esperandoBloque = false;
                }
            }
        }

        return errores;
    }
}