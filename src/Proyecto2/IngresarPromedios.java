
//Ingresar Promedios.

package Proyecto2;

//Imports.
import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class IngresarPromedios extends javax.swing.JPanel {

    //Arreglos.
    private List<String> errores = new ArrayList<>();
    
    //Variables.
    private String cedulaIngresada;
    
    //Constructor.
    public IngresarPromedios() {
        initComponents();
    }

    /* - - - - - - - - - - - - - Métodos para Validación - - - - - - - - - - - - - */
    //Método para validar todos los campos.
    private void validarCampos() {
        //Limpia la lista antes de verificar.
        errores.clear();

        verificaProyecto1(errores); //Valida el Proyecto 1.
        verificaProyecto2(errores); //Valida el Proyecto 2.
        verificaForoAcademico(errores); //Valida el Foro Academico
        verificarEncuesta(errores); //Valida la Encuesta.
        verificarJuego(errores); //Valida el Juego.

        //Muestra los errores.
        if (!errores.isEmpty()) {
            mostrarErrores(errores);
        }
    }

    //Método para mostrar los errores.
    private void mostrarErrores(List<String> errores) {
        StringBuilder mensajeError = new StringBuilder("Se encontraron los siguientes errores:\n");

        //Recorre el arreglo y muestra los errores.
        for (String error : errores) {
            mensajeError.append("- ").append(error).append("\n");
        }

        //Muestra el JOptionPanel de los erroe¿res.
        JOptionPane.showMessageDialog(this, mensajeError.toString(), "Errores de validación.", JOptionPane.ERROR_MESSAGE);
    }

    //Valida el Proyecto 1.
    private boolean verificaProyecto1(List<String> errores) {
        String proyecto1Text = proyecto1.getText().trim();

        //Verifica que el campo no este vacío.
        if (proyecto1Text.isEmpty()) {
            errores.add("La calificación del Proyecto 1 no debe estar vacía.");
            resaltarBordeError(proyecto1);
            return false;
        }

        //Verifica que el proyecto 1 solo tenga números.
        if (!proyecto1Text.matches("[0-9.]+")) {
            errores.add("La calificación del proyecto 1 debe tener solo números.");
            resaltarBordeError(proyecto1);
            return false;
        }

        //Verifica que el proyecto 1 sea menor a 10.
        double calificacion = Double.parseDouble(proyecto1Text);
        if (calificacion > 10) {
            errores.add("La calificación del Proyecto 1 debe ser menor o igual a 10.");
            resaltarBordeError(proyecto1);
            return false;
        }

        //Restaura el borde.
        restaurarBordeOriginal(proyecto1);
        return true;
    }

    //Valida el Proyecto 2.
    private boolean verificaProyecto2(List<String> errores) {
        String proyecto2Text = proyecto2.getText().trim();

        //Verifica que el campo no este vacío.
        if (proyecto2Text.isEmpty()) {
            errores.add("La calificación del Proyecto 2 no debe estar vacía.");
            resaltarBordeError(proyecto2);
            return false;
        }

        //Verifica que el proyecto 2 solo tenga números.
        if (!proyecto2Text.matches("[0-9.]+")) {
            errores.add("La calificación del proyecto 2 debe tener solo números.");
            resaltarBordeError(proyecto2);
            return false;
        }

        //Verifica que el proyecto 2 sea menor a 10.
        double calificacion = Double.parseDouble(proyecto2Text);
        if (calificacion > 10) {
            errores.add("La calificación del Proyecto 2 debe ser menor o igual a 10.");
            resaltarBordeError(proyecto2);
            return false;
        }

        //Restaura el borde.
        restaurarBordeOriginal(proyecto2);
        return true;
    }

    //Valida el Foro Academico.
    private boolean verificaForoAcademico(List<String> errores) {
        String foroAcademicoText = foroAcademico.getText().trim();

        //Verifica que el campo no este vacío.
        if (foroAcademicoText.isEmpty()) {
            errores.add("La calificación del Foro Academico no debe estar vacía.");
            resaltarBordeError(foroAcademico);
            return false;
        }

        //Verifica que el Foro Academico solo tenga números.
        if (!foroAcademicoText.matches("[0-9.]+")) {
            errores.add("La calificación del Foro Academico debe tener solo números.");
            resaltarBordeError(foroAcademico);
            return false;
        }

        //Verifica que el Foro Academico sea menor a 10.
        double calificacion = Double.parseDouble(foroAcademicoText);
        if (calificacion > 10) {
            errores.add("La calificación del Foro Academico debe ser menor o igual a 10.");
            resaltarBordeError(foroAcademico);
            return false;
        }

        //Restaura el borde.
        restaurarBordeOriginal(foroAcademico);
        return true;
    }

    //Valida el Encuesta.
    private boolean verificarEncuesta(List<String> errores) {
        String encuestaText = encuesta.getText().trim();

        //Verifica que el campo no este vacío.
        if (encuestaText.isEmpty()) {
            errores.add("La calificación de la Encuesta no debe estar vacía.");
            resaltarBordeError(encuesta);
            return false;
        }

        //Verifica que la Encuesta solo tenga números.
        if (!encuestaText.matches("[0-9.]+")) {
            errores.add("La calificación del Encuesta debe tener solo números.");
            resaltarBordeError(encuesta);
            return false;
        }

        //Verifica que la Encuesta sea menor a 10.
        double calificacion = Double.parseDouble(encuestaText);
        if (calificacion > 10) {
            errores.add("La calificación de la Encuesta debe ser menor o igual a 10.");
            resaltarBordeError(encuesta);
            return false;
        }

        //Restaura el borde.
        restaurarBordeOriginal(encuesta);
        return true;
    }

    //Valida el Juego.
    private boolean verificarJuego(List<String> errores) {
        String juegoText = juego.getText().trim();

        //Verifica que el campo no este vacío.
        if (juegoText.isEmpty()) {
            errores.add("La calificación del Juego no debe estar vacía.");
            resaltarBordeError(juego);
            return false;
        }

        //Verifica que el Juego solo tenga números.
        if (!juegoText.matches("[0-9.]+")) {
            errores.add("La calificación del Juego debe tener solo números.");
            resaltarBordeError(juego);
            return false;
        }

        //Verifica que el Juego sea menor a 10.
        double calificacion = Double.parseDouble(juegoText);
        if (calificacion > 10) {
            errores.add("La calificación del Juego debe ser menor o igual a 10.");
            resaltarBordeError(juego);
            return false;
        }

        //Restaura el borde.
        restaurarBordeOriginal(juego);
        return true;
    }

    //Método para resaltar los bordes del JTextField.
    private void resaltarBordeError(JTextField textField) {
        textField.setBorder(BorderFactory.createLineBorder(Color.RED));
    }

    //Método para restaurar los bordes del JTextField.
    private void restaurarBordeOriginal(JTextField textField) {
        textField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    
    //Método para validar la tabla modificada.
    private boolean validarModificacionEstudiante(String nuevoProyecto1, String nuevoProyecto2, String nuevoForoAcademico, String nuevaEncuesta, String nuevoJuego) {
        // Instancia la lista de errores.
        List<String> errores = new ArrayList<>();

        // Valida la calificación del Proyecto 1.
        if (nuevoProyecto1.isEmpty() || !nuevoProyecto1.matches("[0-9.]+") || Float.parseFloat(nuevoProyecto1) > 10) {
            errores.add("La calificación del Proyecto 1 debe ser un número válido entre 0 y 10.");
        }

        // Valida la calificación del Proyecto 2.
        if (nuevoProyecto2.isEmpty() || !nuevoProyecto2.matches("[0-9.]+") || Float.parseFloat(nuevoProyecto2) > 10) {
            errores.add("La calificación del Proyecto 2 debe ser un número válido entre 0 y 10.");
        }

        // Valida la calificación del Foro Académico.
        if (nuevoForoAcademico.isEmpty() || !nuevoForoAcademico.matches("[0-9.]+") || Float.parseFloat(nuevoForoAcademico) > 10) {
            errores.add("La calificación del Foro Académico debe ser un número válido entre 0 y 10.");
        }

        // Valida la calificación de la Encuesta.
        if (nuevaEncuesta.isEmpty() || !nuevaEncuesta.matches("[0-9.]+") || Float.parseFloat(nuevaEncuesta) > 10) {
            errores.add("La calificación de la Encuesta debe ser un número válido entre 0 y 10.");
        }

        // Valida la calificación del Juego.
        if (nuevoJuego.isEmpty() || !nuevoJuego.matches("[0-9.]+") || Float.parseFloat(nuevoJuego) > 10) {
            errores.add("La calificación del Juego debe ser un número válido entre 0 y 10.");
        }

        // Si hay errores muestra los errores.
        if (!errores.isEmpty()) {
            mostrarErrores(errores);
            return false;
        }

        // Si no hay errores retorna true.
        return true;
    }

    /* - - - - - - - - - - - - - - - Métodos Principales - - - - - - - - - - - - - - - */
    //Método para leer los estudiantes desde el archivo Estudiantes.txt
    private List<Persona> leerEstudiantesDesdeArchivo(String nombreArchivo) {
        String linea;

        //Mete los datos del archivo a una lista.
        List<Persona> estudiantes = new ArrayList<>();

        //Lee los los estudiantes desde el archivo Estudiantes.txt
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {

            //Mientras no este vacío.
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length >= 5) {
                    String cedula = partes[0];
                    String nombre = partes[1];
                    String apellido1 = partes[2];
                    String apellido2 = partes[3];
                    String carrera = partes[4];

                    //Crear un nuevo objeto Persona y lo agrega a la lista.
                    estudiantes.add(new Persona(cedula, nombre, apellido1, apellido2, carrera));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return estudiantes; //Retorna el arreglo de estudiantes.
    }

    // Método para leer las calificaciones desde el archivo Promedios.txt
    private List<String> leerCalificacionesDesdeArchivo(String cedulaEstudiante) {
        String linea;

        //Mete los datos del archivo a una lista.
        List<String> calificaciones = new ArrayList<>();

        //Lee los los estudiantes desde el archivo Promedios.txt
        try (BufferedReader reader = new BufferedReader(new FileReader("Promedios.txt"))) {

            //Mientras no este vacio.
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");

                //Si la línea corresponde a la cédula del estudiante se agregan las calificaciones a la lista.
                if (partes.length > 0 && partes[0].equals(cedulaEstudiante)) {
                    for (int i = 1; i < partes.length; i++) {
                        calificaciones.add(partes[i]);
                    }
                    break; //Sale del bucle cuando encuentre las calificaciones.
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return calificaciones; //Retornamos la lista de calificaciones del estudiante.
    }

    //Método para buscar al estudiante por su cédula en el archivo Estudiantes.txt
    private Persona buscarEstudiantePorCedula(String cedula) {
        List<Persona> estudiantes = leerEstudiantesDesdeArchivo("Estudiantes.txt");

        //Recorre la lista en busca de la cédula.
        for (Persona estudiante : estudiantes) {
            if (estudiante.getCedula().equals(cedula)) {
                return estudiante; //Retorna el estudiante si se encuentra la cédula.
            }
        }
        return null; //Retorna null si no se enuentra.
    }

    //Método para verificar si el estudiante tiene calificaciones en el archivo.
    private boolean verificarCalificacionesEstudiante(String cedula) {
        List<String> calificaciones = leerCalificacionesDesdeArchivo(cedula);
        return !calificaciones.isEmpty(); //Si no se encuentra la cédula en el archivo devuelve falso.
    }

    //Método para mostrar los datos del estudiante en la tabla.
    private void mostrarDatosEstudianteEnTabla(Persona estudiante) {
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaCalificaciones.getModel();

        //Limpia la tabla antes de ingresar los datos.
        modeloTabla.setRowCount(0);

        //Se crea un objeto con los datos que estan en Estudiantes.txt.
        Object[] fila = {
            estudiante.getCedula(),
            estudiante.getNombre(),
            estudiante.getApellido1(),
            estudiante.getApellido2(),
            estudiante.getCarrera(),
            "", //Queda vacío para ingresar el Proyecto 1.
            "", //Queda vacío para ingresar el Proyecto 2.
            "", //Queda vacío para ingresar el Foro Academico.
            "", //Queda vacío para ingresar la Encuesta.
            "", //Queda vacío para ingresar el Juego.
            "" //Queda vacío para ingresar el Promedio.
        };

        //Agrega los datos del objeto a la tabla.
        modeloTabla.addRow(fila);

        //Verifica si el estudiante ya tiene calificaciones.
        String cedulaEstudiante = estudiante.getCedula();
        boolean tieneCalificaciones = verificarCalificacionesEstudiante(cedulaEstudiante);

        //Si tiene calificaiones muestra las calificiones y habilida el boton de Editar, si no tiene desabilita el botón de editar y habilita el bloque de Guardar Calificaciones.
        if (tieneCalificaciones) {
            //Si tiene calificaciones muestra la calificiones.
            mostrarCalificacionesEstudianteEnTabla(cedulaEstudiante);
            btnGuardar.setEnabled(false);
            btnEditar.setEnabled(true);
        } else {
            btnGuardar.setEnabled(true);
            proyecto1.setEnabled(true);
            proyecto2.setEnabled(true);
            foroAcademico.setEnabled(true);
            encuesta.setEnabled(true);
            juego.setEnabled(true);
            btnEditar.setEnabled(false);
        }
    }

    //Método para mostrar las calificaciones del estudiante en la tabla.
    private void mostrarCalificacionesEstudianteEnTabla(String cedula) {
        //Busca la cédula del estudiante.
        Persona estudiante = buscarEstudiantePorCedula(cedula);

        //Guarda las calificaciones en una lista.
        List<String> calificaciones = leerCalificacionesDesdeArchivo(cedula);

        //Si se encontraron las calificones.
        if (!calificaciones.isEmpty()) {
            DefaultTableModel modeloTabla = (DefaultTableModel) tablaCalificaciones.getModel();

            //Limpiar la tabla antes de agregar nuevos datos.
            modeloTabla.setRowCount(0);

            //Agrega los datos del estudiante recuperados de Estudiantes.txt
            Object[] filaEstudiante = new Object[11];
            filaEstudiante[0] = estudiante.getCedula();
            filaEstudiante[1] = estudiante.getNombre();
            filaEstudiante[2] = estudiante.getApellido1();
            filaEstudiante[3] = estudiante.getApellido2();
            filaEstudiante[4] = estudiante.getCarrera();

            //Agrega las calificaciones recuperadas desde Promedios.txt
            for (int i = 0; i < 5; i++) {
                filaEstudiante[i + 5] = calificaciones.get(i);
            }

            //Agrega el promedio recuperado desde Promedios.txt
            filaEstudiante[10] = calificaciones.get(5);

            //Agrega la fila del estudiante a la tabla.
            modeloTabla.addRow(filaEstudiante);
        }
    }
    
    //Método para actualizar las calificaciones.
    private void actualizarCalificaciones(String cedulaEstudiante, float nuevoProyecto1, float nuevoProyecto2, float nuevoForoAcademico, float nuevaEncuesta, float nuevoJuego, float nuevoPromedio) {
        //Guarda los datos en una lista.
        List<String> lineas = new ArrayList<>();

        //Lee todas las líneas del archivo y las guarda en la lista.
        try (BufferedReader reader = new BufferedReader(new FileReader("Promedios.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        //Busca la cédula y actualiza las calificaciones.
        for (int i = 0; i < lineas.size(); i++) {
            String[] partes = lineas.get(i).split(",");
            if (partes.length > 0 && partes[0].equals(cedulaEstudiante)) {
                lineas.set(i, cedulaEstudiante + "," + nuevoProyecto1 + "," + nuevoProyecto2 + "," + nuevoForoAcademico + "," + nuevaEncuesta + "," + nuevoJuego + "," + nuevoPromedio);
                break; //Sale del bucle.
            }
        }

        //Vuelve a escribir las linea actualizadas.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Promedios.txt"))) {
            for (String linea : lineas) {
                writer.write(linea);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar las nuevas calificaciones.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    //Design.
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        panelBuscarPorCedula = new javax.swing.JPanel();
        tituloPanelBPC = new javax.swing.JLabel();
        panelCedula = new javax.swing.JPanel();
        textoBuscarCedula = new javax.swing.JLabel();
        buscarCedula = new javax.swing.JTextField();
        panelBuscarBTN = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JLabel();
        panelCalidifaciones = new javax.swing.JPanel();
        panelNotas = new javax.swing.JPanel();
        panelProyecto1 = new javax.swing.JPanel();
        tituloProyecto1 = new javax.swing.JLabel();
        valorProyecto1 = new javax.swing.JLabel();
        proyecto1 = new javax.swing.JTextField();
        panelProyecto2 = new javax.swing.JPanel();
        tituloProyecto2 = new javax.swing.JLabel();
        valorProyecto2 = new javax.swing.JLabel();
        proyecto2 = new javax.swing.JTextField();
        panelForoAcademico = new javax.swing.JPanel();
        tiruloForoAcademico = new javax.swing.JLabel();
        valorForoAcademico = new javax.swing.JLabel();
        foroAcademico = new javax.swing.JTextField();
        panelEncuesta = new javax.swing.JPanel();
        tituloEncuesta = new javax.swing.JLabel();
        valorEncuesta = new javax.swing.JLabel();
        encuesta = new javax.swing.JTextField();
        panelJuego = new javax.swing.JPanel();
        tituloJuego = new javax.swing.JLabel();
        valorJuego = new javax.swing.JLabel();
        juego = new javax.swing.JTextField();
        panelGuardarBTN = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCalificaciones = new javax.swing.JTable();
        panelEditarCalificaciones = new javax.swing.JPanel();
        tituloPanelEC = new javax.swing.JLabel();
        panelEditarBTN = new javax.swing.JPanel();
        btnEditar = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();

        setMaximumSize(new java.awt.Dimension(940, 580));
        setMinimumSize(new java.awt.Dimension(940, 580));
        setLayout(new java.awt.BorderLayout());

        panelPrincipal.setBackground(new java.awt.Color(242, 242, 242));
        panelPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        panelPrincipal.setMaximumSize(new java.awt.Dimension(940, 580));
        panelPrincipal.setMinimumSize(new java.awt.Dimension(940, 580));
        panelPrincipal.setPreferredSize(new java.awt.Dimension(940, 580));

        panelBuscarPorCedula.setBackground(new java.awt.Color(204, 204, 204));
        panelBuscarPorCedula.setMaximumSize(new java.awt.Dimension(720, 110));
        panelBuscarPorCedula.setMinimumSize(new java.awt.Dimension(720, 110));
        panelBuscarPorCedula.setOpaque(false);
        panelBuscarPorCedula.setPreferredSize(new java.awt.Dimension(720, 110));
        panelBuscarPorCedula.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 300, 0));

        tituloPanelBPC.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        tituloPanelBPC.setForeground(new java.awt.Color(51, 51, 51));
        tituloPanelBPC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloPanelBPC.setText("Ingrese la cédula del estudiante");
        tituloPanelBPC.setPreferredSize(new java.awt.Dimension(230, 30));
        panelBuscarPorCedula.add(tituloPanelBPC);

        panelCedula.setOpaque(false);
        panelCedula.setPreferredSize(new java.awt.Dimension(180, 65));

        textoBuscarCedula.setBackground(new java.awt.Color(0, 0, 0));
        textoBuscarCedula.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        textoBuscarCedula.setForeground(new java.awt.Color(51, 51, 51));
        textoBuscarCedula.setText("Cédula");
        textoBuscarCedula.setPreferredSize(new java.awt.Dimension(180, 25));
        panelCedula.add(textoBuscarCedula);

        buscarCedula.setBackground(new java.awt.Color(255, 255, 255));
        buscarCedula.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        buscarCedula.setForeground(new java.awt.Color(60, 63, 65));
        buscarCedula.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        buscarCedula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        buscarCedula.setCaretColor(new java.awt.Color(102, 102, 102));
        buscarCedula.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        buscarCedula.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        buscarCedula.setMargin(new java.awt.Insets(20, 20, 20, 20));
        buscarCedula.setPreferredSize(new java.awt.Dimension(180, 25));
        buscarCedula.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        buscarCedula.setSelectionColor(new java.awt.Color(153, 153, 255));
        buscarCedula.setSelectionStart(5);
        panelCedula.add(buscarCedula);

        panelBuscarPorCedula.add(panelCedula);

        panelBuscarBTN.setBackground(new java.awt.Color(242, 242, 242));
        panelBuscarBTN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelBuscarBTN.setPreferredSize(new java.awt.Dimension(100, 35));
        panelBuscarBTN.setLayout(new java.awt.BorderLayout());

        btnBuscar.setBackground(new java.awt.Color(242, 242, 242));
        btnBuscar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBuscar.setText("Buscar");
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBuscarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBuscarMouseExited(evt);
            }
        });
        panelBuscarBTN.add(btnBuscar, java.awt.BorderLayout.CENTER);

        panelBuscarPorCedula.add(panelBuscarBTN);

        panelCalidifaciones.setBackground(new java.awt.Color(60, 63, 66));
        panelCalidifaciones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        panelCalidifaciones.setMaximumSize(new java.awt.Dimension(900, 150));
        panelCalidifaciones.setMinimumSize(new java.awt.Dimension(900, 150));
        panelCalidifaciones.setPreferredSize(new java.awt.Dimension(900, 150));

        panelNotas.setMaximumSize(new java.awt.Dimension(940, 95));
        panelNotas.setMinimumSize(new java.awt.Dimension(940, 95));
        panelNotas.setOpaque(false);
        panelNotas.setPreferredSize(new java.awt.Dimension(940, 95));
        panelNotas.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 40, 5));

        panelProyecto1.setMaximumSize(new java.awt.Dimension(110, 70));
        panelProyecto1.setMinimumSize(new java.awt.Dimension(100, 29));
        panelProyecto1.setOpaque(false);
        panelProyecto1.setPreferredSize(new java.awt.Dimension(120, 87));

        tituloProyecto1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        tituloProyecto1.setForeground(new java.awt.Color(242, 242, 242));
        tituloProyecto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloProyecto1.setText("Proyecto 1");
        tituloProyecto1.setPreferredSize(new java.awt.Dimension(120, 25));
        panelProyecto1.add(tituloProyecto1);

        valorProyecto1.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        valorProyecto1.setForeground(new java.awt.Color(242, 242, 242));
        valorProyecto1.setText("Valor = 40");
        panelProyecto1.add(valorProyecto1);

        proyecto1.setBackground(new java.awt.Color(242, 242, 242));
        proyecto1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        proyecto1.setForeground(new java.awt.Color(51, 51, 51));
        proyecto1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        proyecto1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        proyecto1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        proyecto1.setEnabled(false);
        proyecto1.setPreferredSize(new java.awt.Dimension(120, 25));
        proyecto1.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        proyecto1.setSelectionColor(new java.awt.Color(153, 153, 255));
        panelProyecto1.add(proyecto1);

        panelNotas.add(panelProyecto1);

        panelProyecto2.setMaximumSize(new java.awt.Dimension(110, 70));
        panelProyecto2.setMinimumSize(new java.awt.Dimension(100, 29));
        panelProyecto2.setOpaque(false);
        panelProyecto2.setPreferredSize(new java.awt.Dimension(120, 87));

        tituloProyecto2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        tituloProyecto2.setForeground(new java.awt.Color(242, 242, 242));
        tituloProyecto2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloProyecto2.setText("Proyecto 2");
        tituloProyecto2.setPreferredSize(new java.awt.Dimension(120, 25));
        panelProyecto2.add(tituloProyecto2);

        valorProyecto2.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        valorProyecto2.setForeground(new java.awt.Color(242, 242, 242));
        valorProyecto2.setText("Valor = 40");
        panelProyecto2.add(valorProyecto2);

        proyecto2.setBackground(new java.awt.Color(242, 242, 242));
        proyecto2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        proyecto2.setForeground(new java.awt.Color(51, 51, 51));
        proyecto2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        proyecto2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        proyecto2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        proyecto2.setEnabled(false);
        proyecto2.setPreferredSize(new java.awt.Dimension(120, 25));
        proyecto2.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        proyecto2.setSelectionColor(new java.awt.Color(153, 153, 255));
        panelProyecto2.add(proyecto2);

        panelNotas.add(panelProyecto2);

        panelForoAcademico.setMaximumSize(new java.awt.Dimension(110, 70));
        panelForoAcademico.setMinimumSize(new java.awt.Dimension(100, 29));
        panelForoAcademico.setOpaque(false);
        panelForoAcademico.setPreferredSize(new java.awt.Dimension(120, 87));

        tiruloForoAcademico.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        tiruloForoAcademico.setForeground(new java.awt.Color(242, 242, 242));
        tiruloForoAcademico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tiruloForoAcademico.setText("Foro Academico");
        tiruloForoAcademico.setPreferredSize(new java.awt.Dimension(120, 25));
        panelForoAcademico.add(tiruloForoAcademico);

        valorForoAcademico.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        valorForoAcademico.setForeground(new java.awt.Color(242, 242, 242));
        valorForoAcademico.setText("Valor = 10");
        panelForoAcademico.add(valorForoAcademico);

        foroAcademico.setBackground(new java.awt.Color(242, 242, 242));
        foroAcademico.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        foroAcademico.setForeground(new java.awt.Color(51, 51, 51));
        foroAcademico.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        foroAcademico.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        foroAcademico.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        foroAcademico.setEnabled(false);
        foroAcademico.setPreferredSize(new java.awt.Dimension(120, 25));
        foroAcademico.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        foroAcademico.setSelectionColor(new java.awt.Color(153, 153, 255));
        panelForoAcademico.add(foroAcademico);

        panelNotas.add(panelForoAcademico);

        panelEncuesta.setMaximumSize(new java.awt.Dimension(110, 70));
        panelEncuesta.setMinimumSize(new java.awt.Dimension(100, 29));
        panelEncuesta.setOpaque(false);
        panelEncuesta.setPreferredSize(new java.awt.Dimension(120, 87));

        tituloEncuesta.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        tituloEncuesta.setForeground(new java.awt.Color(242, 242, 242));
        tituloEncuesta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloEncuesta.setText("Encuesta");
        tituloEncuesta.setPreferredSize(new java.awt.Dimension(120, 25));
        panelEncuesta.add(tituloEncuesta);

        valorEncuesta.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        valorEncuesta.setForeground(new java.awt.Color(242, 242, 242));
        valorEncuesta.setText("Valor = 5");
        panelEncuesta.add(valorEncuesta);

        encuesta.setBackground(new java.awt.Color(242, 242, 242));
        encuesta.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        encuesta.setForeground(new java.awt.Color(51, 51, 51));
        encuesta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        encuesta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        encuesta.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        encuesta.setEnabled(false);
        encuesta.setPreferredSize(new java.awt.Dimension(120, 25));
        encuesta.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        encuesta.setSelectionColor(new java.awt.Color(153, 153, 255));
        panelEncuesta.add(encuesta);

        panelNotas.add(panelEncuesta);

        panelJuego.setMaximumSize(new java.awt.Dimension(110, 70));
        panelJuego.setMinimumSize(new java.awt.Dimension(100, 29));
        panelJuego.setOpaque(false);
        panelJuego.setPreferredSize(new java.awt.Dimension(120, 87));

        tituloJuego.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        tituloJuego.setForeground(new java.awt.Color(242, 242, 242));
        tituloJuego.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloJuego.setText("Juego");
        tituloJuego.setPreferredSize(new java.awt.Dimension(120, 25));
        panelJuego.add(tituloJuego);

        valorJuego.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        valorJuego.setForeground(new java.awt.Color(242, 242, 242));
        valorJuego.setText("Valor = 5");
        panelJuego.add(valorJuego);

        juego.setBackground(new java.awt.Color(242, 242, 242));
        juego.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        juego.setForeground(new java.awt.Color(51, 51, 51));
        juego.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        juego.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        juego.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        juego.setEnabled(false);
        juego.setPreferredSize(new java.awt.Dimension(120, 25));
        juego.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        juego.setSelectionColor(new java.awt.Color(153, 153, 255));
        panelJuego.add(juego);

        panelNotas.add(panelJuego);

        panelCalidifaciones.add(panelNotas);

        panelGuardarBTN.setBackground(new java.awt.Color(242, 242, 242));
        panelGuardarBTN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelGuardarBTN.setEnabled(false);
        panelGuardarBTN.setPreferredSize(new java.awt.Dimension(100, 35));
        panelGuardarBTN.setLayout(new java.awt.BorderLayout());

        btnGuardar.setBackground(new java.awt.Color(242, 242, 242));
        btnGuardar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(0, 0, 0));
        btnGuardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnGuardar.setText("Guardar");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.setEnabled(false);
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGuardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGuardarMouseExited(evt);
            }
        });
        panelGuardarBTN.add(btnGuardar, java.awt.BorderLayout.CENTER);

        panelCalidifaciones.add(panelGuardarBTN);

        tablaCalificaciones.setBackground(new java.awt.Color(242, 242, 242));
        tablaCalificaciones.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        tablaCalificaciones.setForeground(new java.awt.Color(60, 63, 65));
        tablaCalificaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Cédula", "Nombre", "P. Apellido", "S. Apellido", "Carrera", "Proyecto 1", "Proyecto 2", "Foro Academico", "Encuesta", "Juego", "Promedio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaCalificaciones.setRowHeight(25);
        tablaCalificaciones.setShowHorizontalLines(true);
        tablaCalificaciones.setShowVerticalLines(true);
        jScrollPane1.setViewportView(tablaCalificaciones);

        panelEditarCalificaciones.setMaximumSize(new java.awt.Dimension(940, 32767));
        panelEditarCalificaciones.setOpaque(false);
        panelEditarCalificaciones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 120, 0));

        tituloPanelEC.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        tituloPanelEC.setForeground(new java.awt.Color(51, 51, 51));
        tituloPanelEC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloPanelEC.setText("Editar Calificaciones");
        tituloPanelEC.setPreferredSize(new java.awt.Dimension(180, 30));
        panelEditarCalificaciones.add(tituloPanelEC);

        panelEditarBTN.setBackground(new java.awt.Color(242, 242, 242));
        panelEditarBTN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelEditarBTN.setPreferredSize(new java.awt.Dimension(100, 35));
        panelEditarBTN.setLayout(new java.awt.BorderLayout());

        btnEditar.setBackground(new java.awt.Color(242, 242, 242));
        btnEditar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(0, 0, 0));
        btnEditar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEditar.setText("Editar");
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.setEnabled(false);
        btnEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditarMouseExited(evt);
            }
        });
        panelEditarBTN.add(btnEditar, java.awt.BorderLayout.CENTER);

        panelEditarCalificaciones.add(panelEditarBTN);

        jSeparator1.setBackground(new java.awt.Color(18, 18, 18));
        jSeparator1.setForeground(new java.awt.Color(18, 18, 18));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCalidifaciones, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
            .addComponent(panelEditarCalificaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addComponent(jSeparator3)
            .addComponent(panelBuscarPorCedula, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addComponent(jSeparator2)
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(panelBuscarPorCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(panelCalidifaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(panelEditarCalificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        add(panelPrincipal, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    /* - - - - - - - - - - - - - - - - Diseños de los botones - - - - - - - - - - - - - - - - */
    //Diseño del botón Buscar.
    private void btnBuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseEntered
        panelBuscarBTN.setBackground(new Color(60, 63, 65));
        btnBuscar.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_btnBuscarMouseEntered

    private void btnBuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseExited
        panelBuscarBTN.setBackground(new Color(255, 255, 255));
        btnBuscar.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_btnBuscarMouseExited

    //Diseño del botón Guardar.
    private void btnGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseEntered
        if (btnGuardar.isEnabled()) {
            panelGuardarBTN.setBackground(new Color(0, 153, 153));
            btnGuardar.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_btnGuardarMouseEntered

    private void btnGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseExited

            panelGuardarBTN.setBackground(new Color(242, 242, 242));
            btnGuardar.setForeground(new Color(0, 0, 0));

    }//GEN-LAST:event_btnGuardarMouseExited

    //Diseño del botón Editar.
    private void btnEditarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMouseEntered
        if (btnEditar.isEnabled()) {
            panelEditarBTN.setBackground(new Color(93, 196, 96));
            btnEditar.setForeground(new Color(255, 255, 255));
        }
    }//GEN-LAST:event_btnEditarMouseEntered

    private void btnEditarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMouseExited
        if (btnEditar.isEnabled()) {
            panelEditarBTN.setBackground(new Color(255, 255, 255));
            btnEditar.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_btnEditarMouseExited

    /* - - - - - - - - - - - - - - - - Acción de los botones - - - - - - - - - - - - - - - - */
    //Botón buscar.
    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaCalificaciones.getModel();
        
        //Limpia la tabla.
        modeloTabla.setRowCount(0);        

        //Vacia los campos.
        this.proyecto1.setText("");
        this.proyecto2.setText("");
        this.foroAcademico.setText("");
        this.encuesta.setText("");
        this.juego.setText("");

        //Deshabilita los TextField.
        this.proyecto1.setEnabled(false);
        this.proyecto2.setEnabled(false);
        this.foroAcademico.setEnabled(false);
        this.encuesta.setEnabled(false);
        this.juego.setEnabled(false);   
        btnGuardar.setEnabled(false);
        btnEditar.setEnabled(false);

        //Guarda la la cédula en un String.
        cedulaIngresada = buscarCedula.getText().trim();

        //Valida si la cédula es vacía.
        if (cedulaIngresada.isEmpty()) {
            resaltarBordeError(buscarCedula);
            JOptionPane.showMessageDialog(this, "Por favor, ingrese una cédula.", "Cédula vacía", JOptionPane.ERROR_MESSAGE);

            //Vacia el TextField.
            buscarCedula.setText("");
            restaurarBordeOriginal(buscarCedula);
            return; //Sale del método si esta vacía.
        }

        //Valida que la cédula solo tenga números y que tenga 9 dígitos.
        if (!cedulaIngresada.matches("[0-9]+") || cedulaIngresada.length() != 9) {
            resaltarBordeError(buscarCedula);
            JOptionPane.showMessageDialog(this, "Por favor, ingrese solo numeros y que sean 9 digitos.", "Error en la cédula", JOptionPane.ERROR_MESSAGE);

            //Vacia el TextField.
            buscarCedula.setText("");
            restaurarBordeOriginal(buscarCedula);
            return; //Sale del método tiene estos errores.
        }

        //Busca al estudiante por su cédula.
        Persona estudiante = buscarEstudiantePorCedula(cedulaIngresada);

        //Si hay estudiantes con la cédula ingresada.
        if (estudiante != null) {
            //Muestra los datos del estudiante en la tabla y las calificaciones en caso de que tenga.
            mostrarDatosEstudianteEnTabla(estudiante);

        } else {
            //Si no se encuetra ningun estudiante muestra que no se encontró y limpia la tabla.
            JOptionPane.showMessageDialog(this, "No se encontró un estudiante con la cédula ingresada.", "Estudiante no encontrado", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarMouseClicked

    //Botón Guardar.
    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        if (btnGuardar.isEnabled()) {
            //Guarda la cédula ingresada.
            String cedula = cedulaIngresada;

            //Valida los campos.
            validarCampos();
            
            //Si no hay errores.
            if (errores.isEmpty()) {
                //Obtiene los datos de los trabajos.
                float proyecto1 = Float.parseFloat(this.proyecto1.getText());
                float proyecto2 = Float.parseFloat(this.proyecto2.getText());
                float foroAcademico = Float.parseFloat(this.foroAcademico.getText());
                float encuesta = Float.parseFloat(this.encuesta.getText());
                float juego = Float.parseFloat(this.juego.getText());

                //Calcula el promedio.
                float promedio = GenerarPromedios.calcularPromedio(proyecto1, proyecto2, foroAcademico, encuesta, juego);

                //Guarda los datos en el archivo Promedios.txt
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("Promedios.txt", true));
                    writer.write(cedula + "," + proyecto1 + "," + proyecto2 + "," + foroAcademico + "," + encuesta + "," + juego + "," + promedio);
                    writer.newLine();
                    writer.close();

                    //Actualiza la tabla con los datos del estudiante y sus calificaciones.
                    mostrarCalificacionesEstudianteEnTabla(cedula);

                    //Habilita el botón Editar y desabilita el botón Guardar.
                    btnGuardar.setEnabled(false);
                    btnEditar.setEnabled(true);

                    //Vacia los campos.
                    this.proyecto1.setText("");
                    this.proyecto2.setText("");
                    this.foroAcademico.setText("");
                    this.encuesta.setText("");
                    this.juego.setText("");

                    //Deshabilita los TextField.
                    this.proyecto1.setEnabled(false);
                    this.proyecto2.setEnabled(false);
                    this.foroAcademico.setEnabled(false);
                    this.encuesta.setEnabled(false);
                    this.juego.setEnabled(false);
                    
                    //Muestra mensaje de éxito.
                    JOptionPane.showMessageDialog(this, "Calificaciones guardadas con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error al guardar las calificaciones.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnGuardarMouseClicked

    //Botón Editar.
    private void btnEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMouseClicked
        if (btnEditar.isEnabled()) {
            DefaultTableModel modeloTabla = (DefaultTableModel) tablaCalificaciones.getModel();

            //Obtiene la columna seleccionada y verifica si se ha seleccionado una.
            int columnaSeleccionada = tablaCalificaciones.getSelectedRow();
            if (columnaSeleccionada == -1) {
                JOptionPane.showMessageDialog(this, "Por favor, seleccione una fila para editar.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            //Obtiene la cédula del estudiante de la fila.
            String cedula = (String) modeloTabla.getValueAt(columnaSeleccionada, 0);

            //Obtiene los datos de las celdas en String.
            String nuevoProyecto1String = (String) modeloTabla.getValueAt(columnaSeleccionada, 5);
            String nuevoProyecto2String = (String) modeloTabla.getValueAt(columnaSeleccionada, 6);
            String nuevoForoAcademicoString = (String) modeloTabla.getValueAt(columnaSeleccionada, 7);
            String nuevaEncuestaString = (String) modeloTabla.getValueAt(columnaSeleccionada, 8);
            String nuevoJuegoString = (String) modeloTabla.getValueAt(columnaSeleccionada, 9);

            //Valida los campos.
            if (!validarModificacionEstudiante(nuevoProyecto1String, nuevoProyecto2String, nuevoForoAcademicoString, nuevaEncuestaString, nuevoJuegoString)) {
                return; //Si hay error sale del método.
            }

            //Convierte los datos en Float después de validar.
            float nuevoProyecto1 = Float.parseFloat(nuevoProyecto1String);
            float nuevoProyecto2 = Float.parseFloat(nuevoProyecto2String);
            float nuevoForoAcademico = Float.parseFloat(nuevoForoAcademicoString);
            float nuevaEncuesta = Float.parseFloat(nuevaEncuestaString);
            float nuevoJuego = Float.parseFloat(nuevoJuegoString);

            //Calcula el nuevo promedio.
            float promedio = GenerarPromedios.calcularPromedio(nuevoProyecto1, nuevoProyecto2, nuevoForoAcademico, nuevaEncuesta, nuevoJuego);

            //Guardar las nuevas calificaciones en el archivo Promedios.txt
            actualizarCalificaciones(cedula, nuevoProyecto1, nuevoProyecto2, nuevoForoAcademico, nuevaEncuesta, nuevoJuego, promedio);

            //Actualiza la tabla.
            mostrarCalificacionesEstudianteEnTabla(cedula);

            //Muestra mensaje de éxito.
            JOptionPane.showMessageDialog(this, "Calificaciones editadas con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBuscar;
    private javax.swing.JLabel btnEditar;
    private javax.swing.JLabel btnGuardar;
    private javax.swing.JTextField buscarCedula;
    private javax.swing.JTextField encuesta;
    private javax.swing.JTextField foroAcademico;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField juego;
    private javax.swing.JPanel panelBuscarBTN;
    private javax.swing.JPanel panelBuscarPorCedula;
    private javax.swing.JPanel panelCalidifaciones;
    private javax.swing.JPanel panelCedula;
    private javax.swing.JPanel panelEditarBTN;
    private javax.swing.JPanel panelEditarCalificaciones;
    private javax.swing.JPanel panelEncuesta;
    private javax.swing.JPanel panelForoAcademico;
    private javax.swing.JPanel panelGuardarBTN;
    private javax.swing.JPanel panelJuego;
    private javax.swing.JPanel panelNotas;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelProyecto1;
    private javax.swing.JPanel panelProyecto2;
    private javax.swing.JTextField proyecto1;
    private javax.swing.JTextField proyecto2;
    private javax.swing.JTable tablaCalificaciones;
    private javax.swing.JLabel textoBuscarCedula;
    private javax.swing.JLabel tiruloForoAcademico;
    private javax.swing.JLabel tituloEncuesta;
    private javax.swing.JLabel tituloJuego;
    private javax.swing.JLabel tituloPanelBPC;
    private javax.swing.JLabel tituloPanelEC;
    private javax.swing.JLabel tituloProyecto1;
    private javax.swing.JLabel tituloProyecto2;
    private javax.swing.JLabel valorEncuesta;
    private javax.swing.JLabel valorForoAcademico;
    private javax.swing.JLabel valorJuego;
    private javax.swing.JLabel valorProyecto1;
    private javax.swing.JLabel valorProyecto2;
    // End of variables declaration//GEN-END:variables
}
