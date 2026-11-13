package co.edu.uniquindio.poo.model;

public class EmpleadoVentas extends Empleado {

    private float totalVentas;
    private float porcentajeComision;

    public EmpleadoVentas(String nombre, String documento, int edad,
                          float salarioBase, CategoriaEmpleado categoria,
                          float descuentoSalud, float descuentoPension,
                          float totalVentas, float porcentajeComision) {

        super(nombre, documento, edad, salarioBase, categoria,
                descuentoSalud, descuentoPension);

        if (totalVentas < 0) {
            throw new IllegalArgumentException("Ventas inválidas");
        }

        if (porcentajeComision < 0 || porcentajeComision > 100) {
            throw new IllegalArgumentException("Comisión inválida");
        }

        this.totalVentas = totalVentas;
        this.porcentajeComision = porcentajeComision;
    }

    public float calcularComision() {
        return totalVentas * porcentajeComision / 100;
    }

    @Override
    public float calcularSalarioBruto() {

        return salarioBase
                + calcularBonificacionCategoria()
                + calcularComision();
    }

    @Override
    public void mostrarInformacion() {

        super.mostrarInformacion();
        System.out.println("Total ventas: " + totalVentas);
        System.out.println("Comisión: " + calcularComision());
    }
}
