import java.util.Scanner;

public class Main {
    static int posicion = 0;
/*
    static String example = "(a<b)";
    static String[] cadena = example.split("");
*/static String[] cadena;

    static int current = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Introduce tu cadena ");
        String input = in.nextLine();
        cadena = input.split("");
        int r = EXP();
        System.out.println("Tu cadena es: ");
        checkString(r, posicion);
    }

    static void checkString(int r, int pos) {
        if (r == 1 && pos == 1) {
            System.out.println("correct");
        } else {
            System.out.println("incorrect");
        }
    }

    static int EXP() {
        int p = posicion;
        String c;
        if (TERM() == 1) {
            c = cadena[posicion++];
            if (c.equals("&")) {
                c = cadena[posicion++];
                if (c.equals("&")) {
                    if (EXP() == 1) {
                        return 1;
                    }
                }
            }
        }
        posicion = p;
        if (TERM() == 1) {
            c = cadena[posicion++];
            if (c.equals("|")) {
                c = cadena[posicion++];
                if (c.equals("|")) {
                    if (EXP() == 1) {
                        return 1;
                    }
                }
            }
        }
        posicion = p;
        if (TERM() == 1) {
            return 1;
        }
        posicion = p;
        return 0;
    }

    static int TERM() {
        int p = posicion;
        String c;
        if (FACT() == 1) {
            c = cadena[posicion++];
            if (c.equals("<")) {
                if (TERM() == 1) {
                    return 1;
                }
            }
        }
        posicion = p;
        if (FACT() == 1) {
            c = cadena[posicion++];
            if (c.equals("<")) {
                c = cadena[posicion++];
                if (c.equals("=")) {
                    if (TERM() == 1) {
                        return 1;
                    }
                }
            }
        }
        posicion = p;
        if (FACT() == 1) {
            c = cadena[posicion++];
            if (c.equals(">")) {
                if (TERM() == 1) {
                    return 1;
                }
            }
        }
        posicion = p;
        if (FACT() == 1) {
            c = cadena[posicion++];
            if (c.equals(">")) {
                c = cadena[posicion++];
                if (c.equals("=")) {
                    if (TERM() == 1) {
                        return 1;
                    }
                }
            }
        }
        posicion = p;
        if (FACT() == 1) {
            c = cadena[posicion++];
            if (c.equals("=")) {
                c = cadena[posicion++];
                if (c.equals("=")) {
                    if (TERM()==1) {
                        return 1;
                    }
                }
            }
        }
        posicion = p;
        if (FACT() == 1) {
            c = cadena[posicion++];
            if (c.equals("!")) {
                c = cadena[posicion++];
                if (c.equals("=")) {
                    if (TERM() == 1) {
                        return 1;
                    }
                }
            }
        }
        posicion = p;
        if (FACT() == 1) {
            return 1;
        }
        posicion = p;
        return 0;
    }

    static int FACT() {
        int p = posicion;
        String c;
        if (NUM() == 1) {
            return 1;
        }
        posicion = p;
        if (LIT() == 1) {
            return 1;
        }
        posicion = p;
        c = cadena[posicion++];
        if (c.equals("(")) {
            if (EXP() ==1) {
                c = cadena[posicion++];
                if (c.equals(")")) {
                    return 1;
                }
            }
        }
        posicion = p;
        c = cadena[posicion++];
        if (c.equals("!")) {
            if (FACT() ==1) {
                return 1;
            }
        }
        posicion = p;
        return 0;
    }

    static  int NUM() {
        int p = posicion;

        String c;
        c = cadena[posicion++];
        if (c.equals("0") || c.equals("1") || c.equals("2") || c.equals("3") || c.equals("4") || c.equals("5") || c.equals("6") || c.equals("7") || c.equals("8") || c.equals("9")) {
            return 1;
        }
        posicion = p;
        return 0;

    }

    static int LIT() {
        int p = posicion;

        String c;
        c = cadena[posicion++];
        if (c.equals("a") || c.equals("b") || c.equals("c") || c.equals("x") || c.equals("y") || c.equals("z")) {
            return 1;
        }
        posicion = p;
        return 0;
    }
}
