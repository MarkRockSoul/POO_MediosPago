public class Main {
    public static void main(String[] args) {
        // Crear instancias de diferentes medios de pago
        TarjetaCredito tarjeta1 = new TarjetaCredito(1500.00, "USD", "Juan Perez", "1234567812345678", 12);
        Yape yape1 = new Yape(200.00, "Maria Lopez", "912345678");
        TarjetaCredito tarjeta2 = new TarjetaCredito(500.00, "EUR", "Carlos Gomez", "8765432187654321", 6);
        Yape yape2 = new Yape(350.00, "Ana Torres", "987654321");

        // Crear el procesador de pagos y agregar los medios de pago
        ProcesadorPagos procesador = new ProcesadorPagos();
        procesador.agregarPago(tarjeta1);
        procesador.agregarPago(yape1);
        procesador.agregarPago(tarjeta2);
        procesador.agregarPago(yape2);

        // Procesar todos los pagos
        procesador.procesarPagos();
    }
}
