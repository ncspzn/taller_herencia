package co.edu.uniquindio.poo.model;

public abstract class Empleado {

    public String nombre;
    protected String documento;
    protected int edad;
    protected float salarioBase;
    protected CategoriaEmpleado categoria;
    protected float descuentoSalud;
    protected float descuentoPension;

    public Empleado(String nombre, String documento, int edad,
                    float salarioBase, CategoriaEmpleado categoria,
                    float descuentoSalud, float descuentoPension) {

        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Nombre inválido");
        }

        if (documento == null || documento.isBlank()) {
            throw new IllegalArgumentException("Documento inválido");
        }

        if (edad <= 0) {
            throw new IllegalArgumentException("Edad inválida");
        }

        if (salarioBase < 0) {
            throw new IllegalArgumentException("Salario base negativo");
        }

        if (categoria == null) {
            throw new IllegalArgumentException("Categoría inválida");
        }

        validarPorcentaje(descuentoSalud);
        validarPorcentaje(descuentoPension);

        this.nombre = nombre;
        this.documento = documento;
        this.edad = edad;
        this.salarioBase = salarioBase;
        this.categoria = categoria;
        this.descuentoSalud = descuentoSalud;
        this.descuentoPension = descuentoPension;
    }

    public abstract float calcularSalarioBruto();

    public float calcularBonificacionCategoria() {

        switch (categoria) {
            case JUNIOR:
                return salarioBase * 0.05f;

            case SEMI_SENIOR:
                return salarioBase * 0.10f;

            case SENIOR:
                return salarioBase * 0.15f;

            default:
                return 0;
        }
    }

    public float calcularDescuentos() {

        float salud = calcularSalarioBruto() * descuentoSalud / 100;
        float pension = calcularSalarioBruto() * descuentoPension / 100;

        return salud + pension;
    }

    public float calcularSalarioNeto() {
        return calcularSalarioBruto() - calcularDescuentos();
    }

    public void mostrarInformacion() {

        System.out.println("Nombre: " + nombre);
        System.out.println("Documento: " + documento);
        System.out.println("Edad: " + edad);
        System.out.println("Categoría: " + categoria);
        System.out.println("Salario bruto: " + calcularSalarioBruto());
        System.out.println("Descuentos: " + calcularDescuentos());
        System.out.println("Salario neto: " + calcularSalarioNeto());
    }

    public ResumenPago generarResumenPago() {

        return new ResumenPago(
                documento,
                nombre,
                getClass().getSimpleName(),
                calcularSalarioBruto(),
                calcularDescuentos(),
                calcularSalarioNeto()
        );
    }

    protected void validarPorcentaje(float porcentaje) {

        if (porcentaje < 0 || porcentaje > 100) {
            throw new IllegalArgumentException("Porcentaje inválido");
        }
    }

    public String getDocumento() {
        return documento;
    }

    public float getSalarioNeto() {
        return calcularSalarioNeto();
    }
}
