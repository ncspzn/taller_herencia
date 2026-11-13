
import co.edu.uniquindio.poo.model.*;

import javax.swing.JOptionPane;


    public static void main(String[] args) {

        Empresa empresa = new Empresa();
        int opcion = 0;

        do {

            try {

                opcion = Integer.parseInt(JOptionPane.showInputDialog(
                        "SISTEMA DE NOMINA\n\n"
                                + "1. Agregar empleado de planta\n"
                                + "2. Agregar empleado de ventas\n"
                                + "3. Agregar empleado temporal\n"
                                + "4. Mostrar empleados\n"
                                + "5. Buscar empleado\n"
                                + "6. Empleado con mayor salario\n"
                                + "7. Nomina total\n"
                                + "8. Resumenes de pago\n"
                                + "9. Salir\n\n"
                                + "Seleccione una opcion:"
                ));

                switch (opcion) {

                    case 1:

                        empresa.agregarEmpleado(new EmpleadoPlanta(
                                JOptionPane.showInputDialog("Nombre:"),
                                JOptionPane.showInputDialog("Documento:"),
                                Integer.parseInt(JOptionPane.showInputDialog("Edad:")),
                                Float.parseFloat(JOptionPane.showInputDialog("Salario base:")),
                                CategoriaEmpleado.valueOf(JOptionPane.showInputDialog(
                                        "Categoria: JUNIOR, SEMI_SENIOR o SENIOR").toUpperCase()),
                                Float.parseFloat(JOptionPane.showInputDialog("Descuento salud:")),
                                Float.parseFloat(JOptionPane.showInputDialog("Descuento pension:")),
                                JOptionPane.showInputDialog("Cargo:"),
                                Integer.parseInt(JOptionPane.showInputDialog("Horas extra:")),
                                Float.parseFloat(JOptionPane.showInputDialog("Valor hora extra:")),
                                Float.parseFloat(JOptionPane.showInputDialog("Auxilio transporte:"))
                        ));

                        JOptionPane.showMessageDialog(null, "Empleado registrado");
                        break;

                    case 2:

                        empresa.agregarEmpleado(new EmpleadoVentas(
                                JOptionPane.showInputDialog("Nombre:"),
                                JOptionPane.showInputDialog("Documento:"),
                                Integer.parseInt(JOptionPane.showInputDialog("Edad:")),
                                Float.parseFloat(JOptionPane.showInputDialog("Salario base:")),
                                CategoriaEmpleado.valueOf(JOptionPane.showInputDialog(
                                        "Categoria: JUNIOR, SEMI_SENIOR o SENIOR").toUpperCase()),
                                Float.parseFloat(JOptionPane.showInputDialog("Descuento salud:")),
                                Float.parseFloat(JOptionPane.showInputDialog("Descuento pension:")),
                                Float.parseFloat(JOptionPane.showInputDialog("Total ventas:")),
                                Float.parseFloat(JOptionPane.showInputDialog("Porcentaje comision:"))
                        ));

                        JOptionPane.showMessageDialog(null, "Empleado registrado");
                        break;

                    case 3:

                        empresa.agregarEmpleado(new EmpleadoTemporal(
                                JOptionPane.showInputDialog("Nombre:"),
                                JOptionPane.showInputDialog("Documento:"),
                                Integer.parseInt(JOptionPane.showInputDialog("Edad:")),
                                Float.parseFloat(JOptionPane.showInputDialog("Salario base:")),
                                CategoriaEmpleado.valueOf(JOptionPane.showInputDialog(
                                        "Categoria: JUNIOR, SEMI_SENIOR o SENIOR").toUpperCase()),
                                Float.parseFloat(JOptionPane.showInputDialog("Descuento salud:")),
                                Float.parseFloat(JOptionPane.showInputDialog("Descuento pension:")),
                                Integer.parseInt(JOptionPane.showInputDialog("Dias trabajados:")),
                                Float.parseFloat(JOptionPane.showInputDialog("Valor por dia:"))
                        ));

                        JOptionPane.showMessageDialog(null, "Empleado registrado");
                        break;

                    case 4:

                        empresa.mostrarEmpleados();
                        break;

                    case 5:

                        String documento = JOptionPane.showInputDialog("Ingrese el documento:");

                        Empleado empleado = empresa.buscarEmpleado(documento);

                        if (empleado != null) {
                            empleado.mostrarInformacion();
                        } else {
                            JOptionPane.showMessageDialog(null, "Empleado no encontrado");
                        }

                        break;

                    case 6:

                        Empleado mayor = empresa.empleadoMayorSalario();

                        if (mayor != null) {
                            JOptionPane.showMessageDialog(null,
                                    "Empleado: " + mayor.nombre
                                            + "\nSalario neto: " + mayor.getSalarioNeto());
                        } else {
                            JOptionPane.showMessageDialog(null, "No hay empleados registrados");
                        }

                        break;

                    case 7:

                        JOptionPane.showMessageDialog(null,
                                "Nomina total: " + empresa.calcularNominaTotal());
                        break;

                    case 8:

                        empresa.mostrarResumenesPago();
                        break;

                    case 9:

                        JOptionPane.showMessageDialog(null, "Programa finalizado");
                        break;

                    default:

                        JOptionPane.showMessageDialog(null, "Opcion incorrecta");
                }

            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(null, "Ingrese un numero valido");

            } catch (IllegalArgumentException e) {

                JOptionPane.showMessageDialog(null, e.getMessage());

            } catch (NullPointerException e) {

                JOptionPane.showMessageDialog(null, "Operacion cancelada");
            }

        } while (opcion != 9);
    }

