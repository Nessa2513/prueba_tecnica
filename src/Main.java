import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parqueadero parqueadero = new Parqueadero();

        //Numero de plazas disponibles
        int plazas_motos = 6;
        int plazas_vehiculos_ligeros = 5;

        while (true) {
            //Preguntar tipo de vehículo; si es diferene a moto o vehículo ligero no entra.
            System.out.println("\nBienvenido al parqueadero TSG.");
            System.out.println(" Menu");
            System.out.println("1. Ingresar un vehículo");
            System.out.println("2. Listar vehículos");
            System.out.println("3. Editar vehículos almacenados");
            System.out.println("4. Sacar vehículo");
            System.out.println("5. Cerrar parqueadero");

            int opcion_menu = scanner.nextInt();

            if (opcion_menu == 1) { //Ingresar vehículo
                System.out.println("Ingrese el tipo de vehículo (1: Motocicleta, 2: Vehículo Ligero): ");
                int tipo_vehiculo = scanner.nextInt();

                if (tipo_vehiculo == 1) {
                    if (plazas_motos > 0 && plazas_motos <= 6) {
                        System.out.println("Motocicleta aceptada.");
                        plazas_motos--;
                    } else {
                        System.out.println("Lo sentimos, no hay plazas disponibles para motocicletas.");
                        continue;
                    }

                } else if (tipo_vehiculo == 2) {
                    if (plazas_vehiculos_ligeros > 0 && plazas_vehiculos_ligeros <= 5) {
                        System.out.println("Vehículo ligero aceptado.");
                        plazas_vehiculos_ligeros--;
                    } else {
                        System.out.println("Lo sentimos, no hay plazas disponibles para vehículos ligeros.");
                        continue;
                    }

                } else {
                    System.out.println("Lo sentimos, no aceptamos este tipo de vehículo.");
                    continue;
                }

                // Solicitar  datos del vehículo
                System.out.println("Ingrese la placa del vehículo: ");
                String placa = scanner.next();

                System.out.println("Ingrese la hora de ingreso (formato 24 horas, por ejemplo, 14:00): ");
                String hora_ingreso = scanner.next();

                // Determinar la plaza asignada
                int plaza_asignada = (tipo_vehiculo == 1) ? (6 - plazas_motos) : (5 - plazas_vehiculos_ligeros);

                // Verificar si el vehículo es eléctrico, híbrido o de gasolina
                System.out.println("Ingrese el tipo de combustible del vehículo (1: Eléctrico, 2: Híbrido, 3: Gasolina): ");
                int tipo_combustible = scanner.nextInt();

                boolean aplica_descuento = (tipo_combustible == 1 || tipo_combustible == 2);

                // Crear un objeto Vehiculo y almacenarlo en el parqueadero
                Vehiculo vehiculo = new Vehiculo(placa, tipo_vehiculo, hora_ingreso, plaza_asignada, aplica_descuento);
                parqueadero.agregar_vehiculo(vehiculo);

                // Mostrar los datos del vehículo
                vehiculo.mostrar_datos();
            } else if (opcion_menu == 2) { //Listar vehículos
                parqueadero.listar_vehiculos();

            } else if (opcion_menu == 3) { //Editar vehículos
                System.out.println("Ingrese la placa del vehiculo a editar");
                String placa = scanner.next();
                parqueadero.editar_vehiculo(placa);

            } else if (opcion_menu == 4) { //Sacar vehículo
                System.out.println("Ingrese la placa del vehiculo a salir");
                String placa = scanner.next();
                parqueadero.sacar_vehiculo(placa);

            } else if (opcion_menu == 5) { //Cerrar parqueadero
                System.out.println("Saliendo del sistema. ¡Gracias!");
                break;
            } else {
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }
}