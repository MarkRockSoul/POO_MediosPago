public abstract class MedioPago {
    private double monto;
    private String moneda;
    private String titular;

    public MedioPago(double monto, String moneda, String titular) {
        setMonto(monto);
        setMoneda(moneda);
        setTitular(titular);
    }

    // Getters y setters con validaciones de ser necesario
    public double getMonto() {
        return monto;
    }
    public void setMonto(double monto) {
        if (monto<=0) {
            throw new IllegalArgumentException("El monto debe ser positivo");
        }
        this.monto = monto;
    }
    public String getMoneda() {
        return moneda;
    }
    public void setMoneda(String moneda) {
        if (moneda == null || moneda.isBlank()) {
            throw new IllegalArgumentException("La moneda no puede ser nula o vacía");
        }
        // Convertir la moneda a mayúsculas para estandarizar su formato
        this.moneda = moneda.toUpperCase();
    }
    public String getTitular() {
        return titular;
    }
    public void setTitular(String titular) {
        if (titular == null || titular.isBlank()) {
            throw new IllegalArgumentException("El titular no puede ser nulo o vacío");
        }
        this.titular = titular;
    }

    // Metodo abstracto (Contrato) para procesar el pago, que cada clase hija implementará según su lógica específica
    public abstract boolean procesarPago();

    // Metodo compartido por todas las clases hijas para mostrar la información del pago
    public String mostrarInfoPago() {
        // Utilizamos String.format para formatear la salida de manera clara y consistente
        return String.format("[%s] Pago de %.2f %s por %s", getClass().getSimpleName(), getMonto(), getMoneda(), getTitular());
    }

}
