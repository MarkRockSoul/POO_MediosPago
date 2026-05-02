public class TarjetaCredito extends MedioPago {
    // Atributos propios de Tarjeta de Crédito
    private String numeroTarjeta;
    private int cuotas;

    public TarjetaCredito(double monto, String moneda, String titular, String numeroTarjeta, int cuotas) {
        super(monto, moneda, titular);
        setNumeroTarjeta(numeroTarjeta);
        setCuotas(cuotas);
    }

    public String getNumeroTarjeta() {
        // Ofuscar el número de tarjeta para mostrar solo los últimos 4 dígitos
        String ultimosCuatroDigitos = numeroTarjeta.substring(numeroTarjeta.length() - 4);
        return "**** **** **** " + ultimosCuatroDigitos;
        // Si se desea mostrar el número completo (no recomendado por seguridad), se podría retornar directamente
        // return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        // Validación básica para el número de tarjeta (puede ser más compleja según el formato esperado)
        if (!numeroTarjeta.matches("/^\\d{16}/gm")) {
            throw new IllegalArgumentException("El número de tarjeta debe tener 16 dígitos");
        }
        if (numeroTarjeta == null || numeroTarjeta.isBlank()) {
            throw new IllegalArgumentException("El número de tarjeta no puede ser nulo o vacío");
        }
        this.numeroTarjeta = numeroTarjeta;
    }

    public int getCuotas() {
        return cuotas;
    }

    public void setCuotas(int cuotas) {
        if (cuotas < 1 || cuotas > 36) {
            throw new IllegalArgumentException("El número de cuotas debe estar entre 1 y 36");
        }
        this.cuotas = cuotas;
    }

    @Override
    public boolean procesarPago() {
        // Simulamos el procesamiento del pago con tarjeta de crédito
        System.out.printf("[TarjetaCredito] procesando pago de %.2f %s por %s con tarjeta %s en %d cuotas%n", getMonto(), getMoneda(), getTitular(), getNumeroTarjeta(), getCuotas());
        // Aquí podríamos agregar lógica específica para validar el pago, conectarnos a una API, etc.
        // Para este ejemplo, simplemente retornamos true para indicar que el pago fue exitoso
        System.out.println("[TarjetaCredito] Pago procesado exitosamente via tarjeta de crédito.");
        return true;        
    }    


}
