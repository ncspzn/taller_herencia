package co.edu.uniquindio.poo.model;

import java.util.ArrayList;

public class Empresa {

    private ArrayList<Empleado> listaEmpleados;

    public Empresa() {
        listaEmpleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {

        if (empleado == null) {
            throw new IllegalArgumentException("Empleado inválido");
        }

        if (buscarEmpleado(empleado.getDocumento()) != null) {
            throw new IllegalArgumentException("El documento ya existe");
        }

        listaEmpleados.add(empleado);
    }

    public Empleado buscarEmpleado(String documento) {

        for (Empleado empleado : listaEmpleados) {

            if (empleado.getDocumento().equals(documento)) {
                return empleado;
            }
        }

        return null;
    }

    public void mostrarEmpleados() {

        if (listaEmpleados.isEmpty()) {
            System.out.println("No hay empleados registrados");
            return;
        }

        for (Empleado empleado : listaEmpleados) {

            empleado.mostrarInformacion();
            System.out.println("-------------------------");
        }
    }

    public Empleado empleadoMayorSalario() {

        if (listaEmpleados.isEmpty()) {
            return null;
        }

        Empleado mayor = listaEmpleados.get(0);

        for (Empleado empleado : listaEmpleados) {

            if (empleado.getSalarioNeto() > mayor.getSalarioNeto()) {
                mayor = empleado;
            }
        }

        return mayor;
    }

    public float calcularNominaTotal() {

        float total = 0;

        for (Empleado empleado : listaEmpleados) {
            total += empleado.calcularSalarioNeto();
        }

        return total;
    }

    public void mostrarResumenesPago() {

        if (listaEmpleados.isEmpty()) {
            System.out.println("No hay empleados registrados");
            return;
        }

        for (Empleado empleado : listaEmpleados) {

            ResumenPago resumen = empleado.generarResumenPago();

            System.out.println("DOCUMENTO: " + resumen.documento());
            System.out.println("NOMBRE: " + resumen.nombre());
            System.out.println("TIPO: " + resumen.tipoEmpleado());
            System.out.println("SALARIO BRUTO: " + resumen.salarioBruto());
            System.out.println("DESCUENTOS: " + resumen.descuentos());
            System.out.println("SALARIO NETO: " + resumen.salarioNeto());

            System.out.println("-------------------------");
        }
    }
}
