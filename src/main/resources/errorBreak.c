void main() {
    int x = 0;

// Caso valido 1. Break dentro de un ciclo con llaves
    while (x < 10) {
        if (x == 5) {
            break;
        }
        x++;
    }

// Caso valido 2. Break dentro de un switch
    switch(x) {
        case 10:
            break;
    }

// Caso valido 3. Break en ciclo de una sola línea (sin llaves)
    for (int i = 0; i < 5; i++)
        break;

// Error 1. Break dentro de un if que no está en un ciclo
    if (x == 10) {
        break;
    }

// Error 2. Break completamente suelto
    break;
}