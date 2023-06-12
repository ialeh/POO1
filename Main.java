import java.util.Scanner;
import paquete1.Usuario;
import paquete1.Reinas;
import paquete2.Calificacion;

public class Main {
    public static void main(String[] args) {
        Reinas[] reinas = new Reinas[5];
        reinas[0] = new Reinas("Isabel", 25, "Medicina");
        reinas[1] = new Reinas("Evelyn", 22, "Derecho");
        reinas[2] = new Reinas("Perla", 27, "Ingeniería");
        reinas[3] = new Reinas("Estefania", 24, "Arquitectura");
        reinas[4] = new Reinas("Kore", 26, "Economía");

        Usuario[] usuarios = new Usuario[5];
        usuarios[0] = new Usuario("Usuario 1", 1, "Alex", "alex");
        usuarios[1] = new Usuario("Usuario 2", 2, "Tobi", "tobi");
        usuarios[2] = new Usuario("Usuario 3", 3, "nacho", "nacho");
        usuarios[3] = new Usuario("Usuario 4", 4, "meloso", "meloso");
        usuarios[4] = new Usuario("Usuario 5", 5, "tubo", "tubo");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.println("Ingrese la contraseña: ");
        String contraseña = scanner.nextLine();

        Usuario usuarioActual = null;

        try {
            for (Usuario usuario : usuarios) {
                if (usuario.iniciarSesion(nombreUsuario, contraseña)) {
                    usuarioActual = usuario;
                    break;
                }
            }

            if (usuarioActual == null) {
                throw new Exception("Usuario o contraseña incorrectos");
            }

            System.out.println("Inicio de sesión exitoso");
            int opcion;

            do {
                System.out.println("------------------------");
                System.out.println("Menú de Opciones");
                System.out.println("------------------------");
                System.out.println("1. Calificar a las reinas");
                System.out.println("2. Mostrar información de las reinas");
                System.out.println("3. Mostrar información del usuario");
                System.out.println("4. Salir");
                System.out.println("------------------------");
                System.out.println("Ingrese una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println("Calificación de las reinas:");
                        for (Reinas reina : reinas) {
                            System.out.println("------------------------");
                            System.out.println("Nombre: " + reina.nombre);
                            System.out.println("Carrera: " + reina.carrera);
                            System.out.println("Edad: " + reina.edad);

                            int nivelConfianza, belleza, preguntasRespondidas;

                            try {
                                System.out.println("Ingrese el nivel de confianza (1-10): ");
                                nivelConfianza = scanner.nextInt();

                                if (nivelConfianza < 1 || nivelConfianza > 10) {
                                    throw new Exception("El nivel de confianza debe estar entre 1 y 10");
                                }

                                System.out.println("Ingrese la calificación de belleza (1-10): ");
                                belleza = scanner.nextInt();

                                if (belleza < 1 || belleza > 10) {
                                    throw new Exception("La calificación de belleza debe estar entre 1 y 10");
                                }

                                System.out.println("Ingrese la cantidad de preguntas respondidas: ");
                                preguntasRespondidas = scanner.nextInt();
                            } catch (Exception e) {
                                System.out.println("Error: " + e.getMessage());
                                scanner.nextLine(); // Limpiar el búfer del escáner
                                continue;
                            }

                            Calificacion calificacion = new Calificacion();
                            calificacion.calificarReina(reina, nivelConfianza, belleza, preguntasRespondidas);
                        }
                        break;
                    case 2:
                        System.out.println("Información de las reinas:");
                        for (Reinas reina : reinas) {
                            System.out.println("------------------------");
                            System.out.println("Nombre: " + reina.nombre);
                            System.out.println("Carrera: " + reina.carrera);
                            System.out.println("Edad: " + reina.edad);
                        }
                        break;
                    case 3:
                        System.out.println("Información del usuario:");
                        usuarioActual.mostrarInformacion();
                        break;
                    case 4:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción inválida");
                        break;
                }
            } while (opcion != 4);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

