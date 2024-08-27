import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Parqueadero {
    private ArrayList<Vehiculo> vehiculos;

    public Parqueadero() {
        vehiculos = new ArrayList<>();
    }

    public void agregar_vehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public void listar_vehiculos() {
        if (vehiculos.isEmpty()) {
            System.out.println("\nNo hay vehículos almacenados en el sistema.");
        } else {
            System.out.println("\nLista de Vehículos Almacenados:");
            for (Vehiculo vehiculo : vehiculos) {
                vehiculo.mostrar_datos();
            }
        }
    }
    public void editar_vehiculo(String placa) {
        Scanner scanner = new Scanner(System.in);
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.get_placa().equals(placa)) {
                System.out.println("Vehículo encontrado. Ingrese los nuevos datos:");

                System.out.println("Ingrese la nueva hora de ingreso (formato 24 horas, por ejemplo, 14:00): ");
                String nueva_hora_ingreso = scanner.next();

                System.out.println("Ingrese la nueva hora de salida (formato 24 horas, por ejemplo, 16:00): ");
                String nueva_hora_salida = scanner.next();

                // Verificar si el vehículo es eléctrico, híbrido o de gasolina
                System.out.println("Ingrese el nuevo tipo de combustible del vehículo (1: Eléctrico, 2: Híbrido, 3: Gasolina): ");
                int nuevo_tipo_combustible = scanner.nextInt();

                boolean aplica_descuento = (nuevo_tipo_combustible == 1 || nuevo_tipo_combustible == 2);

                // Actualizar los datos del vehículo
                vehiculo.setHora_ingreso(nueva_hora_ingreso);
                vehiculo.setHora_salida(nueva_hora_salida);
                vehiculo.setAplica_descuento(aplica_descuento);

                System.out.println("Datos del vehículo actualizados exitosamente.");
                return;
            }
        }
        System.out.println("No se encontró el vehículo con la placa especificada.");
    }

    public void sacar_vehiculo(String placa){
    }
}
