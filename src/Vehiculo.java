public class Vehiculo {
    String placa;
    int tipo_vehiculo; // 1: Motocicleta, 2: Vehículo Ligero
    String hora_ingreso;
    String hora_salida;
    int plaza_asignada;
    boolean aplica_descuento;

    public String get_placa(){
        return placa;
    }

    public void setHora_ingreso(String hora_ingreso) {
        this.hora_ingreso = hora_ingreso;
    }

    public void setHora_salida(String hora_salida) {
        this.hora_salida = hora_salida;
    }

    public void setAplica_descuento(boolean aplica_descuento) {
        this.aplica_descuento = aplica_descuento;
    }

    //Constructor
    public Vehiculo(String placa, int tipo_vehiculo, String hora_ingreso, int plaza_asignada, boolean aplica_descuento) {
        this.placa = placa;
        this.tipo_vehiculo = tipo_vehiculo;
        this.hora_ingreso = hora_ingreso;
        this.plaza_asignada = plaza_asignada;
        this.aplica_descuento = aplica_descuento;
    }

    public void mostrar_datos() {
        System.out.println("\nDatos del Vehículo:");
        System.out.println("Placa: " + placa);
        System.out.println("Tipo de Vehículo: " + (tipo_vehiculo == 1 ? "Motocicleta" : "Vehículo Ligero"));
        System.out.println("Hora de Ingreso: " + hora_ingreso);
        System.out.println("Plaza Asignada: " + plaza_asignada);
        System.out.println("Aplica Descuento: " + (aplica_descuento ? "Sí" : "No"));
    }
}
