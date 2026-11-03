void main() {
    int x = 0;

    // --- CASOS VÁLIDOS (No deben marcar error) ---

    // 1. Break dentro de un ciclo con llaves
    while (x < 10) {
        if (x == 5) {
            break;
        }
        x++;
    }

    // 2. Break dentro de un switch
    switch(x) {
        case 10:
            break;
    }

    // 3. Break en ciclo de una sola línea (sin llaves)
    for (int i = 0; i < 5; i++)
        break;


    // --- CASOS INVÁLIDOS (Deben disparar tu Error Semántico 8) ---

    // Error A: Break dentro de un if que no está en un ciclo
    if (x == 10) {
        break;
    }

    // Error B: Break completamente suelto
    break;
}