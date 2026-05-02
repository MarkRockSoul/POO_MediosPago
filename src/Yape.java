public class Yape extends MedioPago {
    // Atributo propio de Yape
    private String numeroCelular;

    public Yape(double monto, String titular, String numeroCelular) {
        super(monto, "PEN", titular);
        setNumeroCelular(numeroCelular);
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        // Validación básica para el número de celular (puede ser más compleja según el formato esperado)
        if (!numeroCelular.matches("/^9\\d{8}/gm")) {
            throw new IllegalArgumentException("El número de celular debe comenzar con 9 y tener 9 dígitos en total");
        }
        if (numeroCelular == null || numeroCelular.isBlank()) {
            throw new IllegalArgumentException("El número de celular no puede ser nulo o vacío");
        }
        this.numeroCelular = numeroCelular;
    }

    @Override
    public boolean procesarPago() {
        // Simulamos el procesamiento del pago con Yape
        System.out.printf("[Yape] enviando S/%.2f a %s (%s) a través del número %s%n", getMonto(), getTitular(), super.getMoneda(), getNumeroCelular());
        // Aquí podríamos agregar lógica específica para validar el pago, conectarnos a una API, etc.
        // Para este ejemplo, simplemente retornamos true para indicar que el pago fue exitoso
        System.out.println("[Yape] Pago procesado exitosamente via billetera digital.");
        return true;
    }
    
}
