import java.util.ArrayList;
import java.util.List;

public class ProcesadorPagos {
    private List<MedioPago> pagos = new ArrayList<>();
    private double totalProcesado = 0.0;

    public void agregarPago(MedioPago pago) {
        if (pago == null) {
            throw new IllegalArgumentException("El pago no puede ser nulo");
        }
        pagos.add(pago);
    }

    // Polimorfismo: Procesar cada pago según su tipo específico, sin necesidad de conocer los detalles de cada clase hija
    public void procesarPagos() {
        System.out.println("=============Procesando pagos=============");
        for (MedioPago pago : pagos) {
            System.out.println(pago.mostrarInfoPago()); // Metodo heredado que muestra la información del pago de manera genérica
            boolean resultado = pago.procesarPago(); // Polimorfismo: cada clase hija implementa su propia lógica de procesamiento
            if (resultado) {
                totalProcesado += pago.getMonto();
                System.out.println("Pago procesado exitosamente.");
            } else {
                System.out.println("Error al procesar el pago.");
            }
            System.out.println(); // Línea en blanco para separar los resultados
        }
        System.out.printf("Total procesado de todos los pagos: %.2f%n", totalProcesado);
        System.out.println("==========================================");
    }
}
