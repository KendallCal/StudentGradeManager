
//Manipulación de Estudiantes.

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

public class ManipulacionEstudiantes extends javax.swing.JPanel {

    //ArrayList.
    private List<String> errores = new ArrayList<>(); //Lista para almacenar los errores.

    //Constructor.
    public ManipulacionEstudiantes() {
        initComponents();

        //Muestra la tabla desde el inicio.
        mostrarEstudiantesEnTabla(leerEstudiantesDesdeArchivo("Estudiantes.txt"));
    }
    
    /* - - - - - - - - - - - Métodos para resaltar los bordes de los JTextField - - - - - - - - - - - - */
    //Método para resaltar los bordes del JTextField.
    private void resaltarBordeError(JTextField textField) {
        textField.setBorder(BorderFactory.createLineBorder(Color.RED));
    }

    //Método para restaurar los bordes del JTextField.
    private void restaurarBordeOriginal(JTextField textField) {
        textField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    
    /* - - - - - - - - - - - - - - - - - Métodos para validar cámpos - - - - - - - - - - - - - - - - - */
    //Método para validar todos los campos.
    private void validarCampos() {
        //Limpia la lista antes de verificar.
        errores.clear();

        verificarCedula(errores); //Valida la cedula.
        verificarNombre(errores); //Valida el nombre.
        verificarApellido1(errores); //Valida el Primer Apellido.
        verificarApellido2(errores); //Valida el Segudo Apellido.
        verificarCarrera(errores); //Valida la carrera.

        //Muestra los errores.
        if (!errores.isEmpty()) {
            mostrarErrores(errores);
        }
    }

    //Método para mostrar los errores y resaltar bordes.
    private void mostrarErrores(List<String> errores) {
        StringBuilder mensajeError = new StringBuilder("Se encontraron los siguientes errores:\n");

        //Recorre el arreglo y muestra los errores.
        for (String error : errores) {
            mensajeError.append("- ").append(error).append("\n");
        }

        //Muestra el JOptionPanel de los errores.
        JOptionPane.showMessageDialog(this, mensajeError.toString(), "Errores de validación.", JOptionPane.ERROR_MESSAGE);
    }

    //Método para validar la Cédula.
    private boolean verificarCedula(List<String> errores) {
        String cedulaText = cedula.getText().trim();

        //Verifica que la cédula no este vacía.
        if (cedulaText.isEmpty()) {
            errores.add("La Cédula no debe estar vacía.");
            resaltarBordeError(cedula);
            return false;
        }

        //Verifica que la cédula solo tenga números y que sea igual a 9.
        if (!cedulaText.matches("[0-9]+") || cedulaText.length() != 9) {
            errores.add("La Cédula debe tener solo números y solo 9 dígitos.");
            resaltarBordeError(cedula);
            return false;
        }

        //Restaura el borde.
        restaurarBordeOriginal(cedula);
        return true;
    }

    //Método para validar el Nombre.
    private boolean verificarNombre(List<String> errores) {
        String nombreText = nombre.getText().trim();

        //Verifica que el nombre no este vacío.
        if (nombreText.isEmpty()) {
            errores.add("El Nombre no debe estar vacío.");
            resaltarBordeError(nombre);
            return false;
        }

        //Verifica que el nombre solo tenga letras.
        if (!nombreText.matches("[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ ]+")) {
            errores.add("El Nombre debe tener solo letras.");
            resaltarBordeError(nombre);
            return false;
        }

        //Restaura el borde.
        restaurarBordeOriginal(nombre);
        return true;
    }

    //Método para validar el Primer Apellido.
    private boolean verificarApellido1(List<String> errores) {
        String apellido1Text = apellido1.getText().trim();

        //Verifica que el primer apellido no este vacío.
        if (apellido1Text.isEmpty()) {
            errores.add("El Primer Apellido no debe estar vacío.");
            resaltarBordeError(apellido1);
            return false;
        }

        //Verifica que el primer apellido solo tenga letras.
        if (!apellido1Text.matches("[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ]+")) {
            errores.add("El Primer Apellido debe tener solo letras.");
            resaltarBordeError(apellido1);
            return false;
        }

        //Verifica que el primer apellido tenga más de 3 letras.
        if (apellido1Text.length() < 3) {
            errores.add("El Primer Apellido debe tener al menos 3 letras.");
            resaltarBordeError(apellido1);
            return false;
        }

        //Restaura los boordes.
        restaurarBordeOriginal(apellido1);
        return true;
    }
    
    //Método para validar el Apellido 2.
    private boolean verificarApellido2(List<String> errores) {
        String apellido2Text = apellido2.getText().trim();

        //Verifica que el segundo apellido no este vacío.
        if (apellido2Text.isEmpty()) {
            errores.add("El Segundo Apellido no debe estar vacío.");
            resaltarBordeError(apellido2);
            return false;
        }

        //Verifica que el segundo apellido solo tenga letras.
        if (!apellido2Text.matches("[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ]+")) {
            errores.add("El Segundo Apellido debe tener solo letras.");
            resaltarBordeError(apellido2);
            return false;
        }

        //Verifica que el sengundo apellido tenga más de 3 letras.
        if (apellido2Text.length() < 3) {
            errores.add("El Segundo Apellido debe tener al menos 3 letras.");
            resaltarBordeError(apellido2);
            return false;
        }

        //Restaura los boordes.
        restaurarBordeOriginal(apellido2);
        return true;
    }

    //Método para validar la carrera
    private boolean verificarCarrera(List<String> errores) {
        String carreraText = carrera.getText().trim();

        //Verifica que la carrera no este vacía.
        if (carreraText.isEmpty()) {
            errores.add("La Carrera no debe estar vacía.");
            resaltarBordeError(carrera);
            return false;
        }

        //Verifica que solo tenga letras.
        if (!carreraText.matches("[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ ]+")) {
            errores.add("La Carrera debe tener solo letras.");
            resaltarBordeError(carrera);
            return false;
        }

        //Restuara el borde.
        restaurarBordeOriginal(carrera);
        return true;
    }

    //Método para validar si una cédula ya existe en el archivo Estudiantes.txt
    private boolean existeCedula(String cedula) {
        List<Persona> personas = leerEstudiantesDesdeArchivo("Estudiantes.txt");
        for (Persona persona : personas) {
            if (persona.getCedula().equals(cedula)) {
                return true; //Si exites retorna true.
            }
        }
        return false; //Si no existe retorna false.
    }
    
    //Método para la validación de la tabla modificada.
    private boolean validarModificacionEstudiante(String nuevaCedula, String nombre, String apellido1, String apellido2, String carrera, String cedulaOriginal) {
        //Instancia la lsita de errores.
        List<String> errores = new ArrayList<>();

        //Verifica si la cédula existe.
        List<Persona> estudiantes = leerEstudiantesDesdeArchivo("Estudiantes.txt");
        for (Persona estudiante : estudiantes) {
            if (!estudiante.getCedula().equals(cedulaOriginal) && estudiante.getCedula().equals(nuevaCedula)) {
                errores.add("Ya existe un estudiante con la misma cédula.");
                break;
            }
        }

        //Valida la Cédula.
        if (nuevaCedula.isEmpty() || nuevaCedula.length() != 9 || !nuevaCedula.matches("[0-9]+")) {
            errores.add("La Cédula debe tener solo números y solo 9 dígitos.");
        }

        //Valida el Nombre.
        if (nombre.isEmpty() || !nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ ]+")) {
            errores.add("El Nombre no puede estar vacío y debe tener solo letras.");
        }

        //Valida el Primer Apellido.
        if (apellido1.isEmpty() || apellido1.length() < 3 || !apellido1.matches("[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ]+")) {
            errores.add("El Primer Apellido no debe estar vacío, debe tener solo letras y al menos 3 letras.");
        }
        
        //Valida el Segundo Apellido..
        if (apellido2.isEmpty() || apellido2.length() < 3 || !apellido2.matches("[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ]+")) {
            errores.add("El Segundo Apellido no debe estar vacío, debe tener solo letras y al menos 3 letras.");
        }

        //Valida la Carrera.
        if (carrera.isEmpty() || !carrera.matches("[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ ]+")) {
            errores.add("La carrera no puede estar vacía y debe tener solo letras.");
        }

        //Si hay errores muestra los errores.
        if (!errores.isEmpty()) {
            mostrarErrores(errores);
            return false;
        }

        //Si no hay errores retona true.
        return true;
    }

    /* - - - - - - - - - - - - - - - - - Metodos Principales - - - - - - - - - - - - - - - - - */
    //Método para leer los estudiantes desde el archivo.
    private List<Persona> leerEstudiantesDesdeArchivo(String nombreArchivo) {
        List<Persona> estudiantes = new ArrayList<>();

        //Lee los los estudiantes desde el archivo Estudiante.txt
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length >= 5) { //Ajustar el número según la cantidad de atributos en la clase Persona.
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

        //Retorna el arreglo estudiantes.
        return estudiantes;
    }

    //Método para mostrar los estudiantes en la tabla.
    private void mostrarEstudiantesEnTabla(List<Persona> estudiantes) {
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaEstudiantes.getModel();
        modeloTabla.setRowCount(0); //Limpiar la tabla antes de agregar nuevos datos.

        //Recorre el arreglo persona y muestra los estudiantes como un obejeto.
        for (Persona estudiante : estudiantes) {
            Object[] fila = {
                estudiante.getCedula(),
                estudiante.getNombre(),
                estudiante.getApellido1(),
                estudiante.getApellido2(),
                estudiante.getCarrera()
            };
            modeloTabla.addRow(fila);
        }
    }
    
    // Método para eliminar las calificaciones del estudiante del archivo Promedios.txt
    private void eliminarCalificaciones(String cedula) throws IOException {
        List<String> calificaciones = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("Promedios.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (!linea.startsWith(cedula)) {
                    calificaciones.add(linea);
                }
            }
        }

        //Guardar las calificaciones sin el estudiante eliminado.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Promedios.txt"))) {
            for (String calificacion : calificaciones) {
                writer.write(calificacion);
                writer.newLine();
            }
        }
    }

    //Método para guardar los cambios en el archivo.
    private void guardarCambiosEnArchivo(List<Persona> estudiantes) throws IOException {
        //Escribe los estudiantes en el archivo.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Estudiantes.txt"))) {
            for (Persona estudiante : estudiantes) {
                writer.write(estudiante.getCedula() + "," + estudiante.getNombre() + "," + estudiante.getApellido1() + "," + estudiante.getApellido2() + "," + estudiante.getCarrera());
                writer.newLine();
            }
        }
    }

    //Design.
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        panelGuardar = new javax.swing.JPanel();
        panelCedula = new javax.swing.JPanel();
        textoCedula = new javax.swing.JLabel();
        cedula = new javax.swing.JTextField();
        panelNombre = new javax.swing.JPanel();
        textoNombre = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        panelApellido1 = new javax.swing.JPanel();
        textoApellido1 = new javax.swing.JLabel();
        apellido1 = new javax.swing.JTextField();
        panelApellido2 = new javax.swing.JPanel();
        textoApellido2 = new javax.swing.JLabel();
        apellido2 = new javax.swing.JTextField();
        panelCarrera = new javax.swing.JPanel();
        textoCarrera = new javax.swing.JLabel();
        carrera = new javax.swing.JTextField();
        panelGuardarBTN = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JLabel();
        panelEdicion = new javax.swing.JPanel();
        panelBuscarPorCedula = new javax.swing.JPanel();
        tituloPanelBPC = new javax.swing.JLabel();
        panelCedula1 = new javax.swing.JPanel();
        textoBuscarCedula = new javax.swing.JLabel();
        buscarCedula = new javax.swing.JTextField();
        panelBuscarBTN = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEstudiantes = new javax.swing.JTable();
        botonesTabla = new javax.swing.JPanel();
        panelModificarBTN = new javax.swing.JPanel();
        btnModificar = new javax.swing.JLabel();
        panelEliminarBTN = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JLabel();

        setForeground(new java.awt.Color(242, 242, 242));
        setPreferredSize(new java.awt.Dimension(940, 580));

        panelPrincipal.setBackground(new java.awt.Color(242, 242, 242));
        panelPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        panelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelGuardar.setBackground(new java.awt.Color(242, 242, 242));
        panelGuardar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        panelGuardar.setForeground(new java.awt.Color(242, 242, 242));
        panelGuardar.setOpaque(false);
        panelGuardar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 28));

        panelCedula.setOpaque(false);
        panelCedula.setPreferredSize(new java.awt.Dimension(220, 65));

        textoCedula.setBackground(new java.awt.Color(0, 0, 0));
        textoCedula.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        textoCedula.setForeground(new java.awt.Color(0, 0, 0));
        textoCedula.setText("Cédula");
        textoCedula.setPreferredSize(new java.awt.Dimension(180, 25));
        panelCedula.add(textoCedula);

        cedula.setBackground(new java.awt.Color(242, 242, 242));
        cedula.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        cedula.setForeground(new java.awt.Color(60, 63, 65));
        cedula.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        cedula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cedula.setCaretColor(new java.awt.Color(102, 102, 102));
        cedula.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        cedula.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        cedula.setMargin(new java.awt.Insets(20, 20, 20, 20));
        cedula.setPreferredSize(new java.awt.Dimension(180, 25));
        cedula.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        cedula.setSelectionColor(new java.awt.Color(102, 102, 255));
        panelCedula.add(cedula);

        panelGuardar.add(panelCedula);

        panelNombre.setOpaque(false);
        panelNombre.setPreferredSize(new java.awt.Dimension(220, 65));

        textoNombre.setBackground(new java.awt.Color(0, 0, 0));
        textoNombre.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        textoNombre.setForeground(new java.awt.Color(0, 0, 0));
        textoNombre.setText("Nombre");
        textoNombre.setPreferredSize(new java.awt.Dimension(180, 25));
        panelNombre.add(textoNombre);

        nombre.setBackground(new java.awt.Color(242, 242, 242));
        nombre.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        nombre.setForeground(new java.awt.Color(60, 63, 65));
        nombre.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        nombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        nombre.setCaretColor(new java.awt.Color(102, 102, 102));
        nombre.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        nombre.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        nombre.setMargin(new java.awt.Insets(20, 20, 20, 20));
        nombre.setPreferredSize(new java.awt.Dimension(180, 25));
        nombre.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        nombre.setSelectionColor(new java.awt.Color(102, 102, 255));
        panelNombre.add(nombre);

        panelGuardar.add(panelNombre);

        panelApellido1.setOpaque(false);
        panelApellido1.setPreferredSize(new java.awt.Dimension(220, 65));

        textoApellido1.setBackground(new java.awt.Color(0, 0, 0));
        textoApellido1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        textoApellido1.setForeground(new java.awt.Color(0, 0, 0));
        textoApellido1.setText("Primer Apellido");
        textoApellido1.setPreferredSize(new java.awt.Dimension(180, 25));
        panelApellido1.add(textoApellido1);

        apellido1.setBackground(new java.awt.Color(242, 242, 242));
        apellido1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        apellido1.setForeground(new java.awt.Color(60, 63, 65));
        apellido1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        apellido1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        apellido1.setCaretColor(new java.awt.Color(102, 102, 102));
        apellido1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        apellido1.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        apellido1.setMargin(new java.awt.Insets(20, 20, 20, 20));
        apellido1.setPreferredSize(new java.awt.Dimension(180, 25));
        apellido1.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        apellido1.setSelectionColor(new java.awt.Color(102, 102, 255));
        panelApellido1.add(apellido1);

        panelGuardar.add(panelApellido1);

        panelApellido2.setOpaque(false);
        panelApellido2.setPreferredSize(new java.awt.Dimension(220, 65));

        textoApellido2.setBackground(new java.awt.Color(0, 0, 0));
        textoApellido2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        textoApellido2.setForeground(new java.awt.Color(0, 0, 0));
        textoApellido2.setText("Segundo Apellido");
        textoApellido2.setPreferredSize(new java.awt.Dimension(180, 25));
        panelApellido2.add(textoApellido2);

        apellido2.setBackground(new java.awt.Color(242, 242, 242));
        apellido2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        apellido2.setForeground(new java.awt.Color(60, 63, 65));
        apellido2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        apellido2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        apellido2.setCaretColor(new java.awt.Color(102, 102, 102));
        apellido2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        apellido2.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        apellido2.setMargin(new java.awt.Insets(20, 20, 20, 20));
        apellido2.setPreferredSize(new java.awt.Dimension(180, 25));
        apellido2.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        apellido2.setSelectionColor(new java.awt.Color(102, 102, 255));
        panelApellido2.add(apellido2);

        panelGuardar.add(panelApellido2);

        panelCarrera.setOpaque(false);
        panelCarrera.setPreferredSize(new java.awt.Dimension(220, 65));

        textoCarrera.setBackground(new java.awt.Color(0, 0, 0));
        textoCarrera.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        textoCarrera.setForeground(new java.awt.Color(0, 0, 0));
        textoCarrera.setText("Carrera");
        textoCarrera.setPreferredSize(new java.awt.Dimension(180, 25));
        panelCarrera.add(textoCarrera);

        carrera.setBackground(new java.awt.Color(242, 242, 242));
        carrera.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        carrera.setForeground(new java.awt.Color(60, 63, 65));
        carrera.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        carrera.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        carrera.setCaretColor(new java.awt.Color(102, 102, 102));
        carrera.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        carrera.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        carrera.setMargin(new java.awt.Insets(20, 20, 20, 20));
        carrera.setPreferredSize(new java.awt.Dimension(180, 25));
        carrera.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        carrera.setSelectionColor(new java.awt.Color(102, 102, 255));
        panelCarrera.add(carrera);

        panelGuardar.add(panelCarrera);

        panelGuardarBTN.setBackground(new java.awt.Color(242, 242, 242));
        panelGuardarBTN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelGuardarBTN.setPreferredSize(new java.awt.Dimension(100, 35));
        panelGuardarBTN.setLayout(new java.awt.BorderLayout());

        btnGuardar.setBackground(new java.awt.Color(242, 242, 242));
        btnGuardar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(0, 0, 0));
        btnGuardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnGuardar.setText("Guardar");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        panelGuardar.add(panelGuardarBTN);

        panelPrincipal.add(panelGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 580));

        panelEdicion.setBackground(new java.awt.Color(0, 153, 153));
        panelEdicion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        panelEdicion.setPreferredSize(new java.awt.Dimension(470, 580));

        panelBuscarPorCedula.setOpaque(false);
        panelBuscarPorCedula.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 120, 0));

        tituloPanelBPC.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        tituloPanelBPC.setForeground(new java.awt.Color(242, 242, 242));
        tituloPanelBPC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloPanelBPC.setText("Buscar Por Cédula");
        tituloPanelBPC.setPreferredSize(new java.awt.Dimension(180, 30));
        panelBuscarPorCedula.add(tituloPanelBPC);

        panelCedula1.setOpaque(false);
        panelCedula1.setPreferredSize(new java.awt.Dimension(180, 65));

        textoBuscarCedula.setBackground(new java.awt.Color(0, 0, 0));
        textoBuscarCedula.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        textoBuscarCedula.setForeground(new java.awt.Color(242, 242, 242));
        textoBuscarCedula.setText("Cédula");
        textoBuscarCedula.setPreferredSize(new java.awt.Dimension(180, 25));
        panelCedula1.add(textoBuscarCedula);

        buscarCedula.setBackground(new java.awt.Color(242, 242, 242));
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
        buscarCedula.setSelectionColor(new java.awt.Color(102, 102, 255));
        buscarCedula.setSelectionStart(5);
        panelCedula1.add(buscarCedula);

        panelBuscarPorCedula.add(panelCedula1);

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

        tablaEstudiantes.setBackground(new java.awt.Color(242, 242, 242));
        tablaEstudiantes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        tablaEstudiantes.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        tablaEstudiantes.setForeground(new java.awt.Color(0, 0, 0));
        tablaEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cédula", "Nombre", "P. Apellido", "S. Apellido", "Carrera"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaEstudiantes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaEstudiantes.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        tablaEstudiantes.setGridColor(new java.awt.Color(153, 153, 153));
        tablaEstudiantes.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tablaEstudiantes.setShowGrid(true);
        jScrollPane1.setViewportView(tablaEstudiantes);

        botonesTabla.setOpaque(false);
        botonesTabla.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 100, 5));

        panelModificarBTN.setBackground(new java.awt.Color(242, 242, 242));
        panelModificarBTN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelModificarBTN.setPreferredSize(new java.awt.Dimension(150, 40));
        panelModificarBTN.setLayout(new java.awt.BorderLayout());

        btnModificar.setBackground(new java.awt.Color(242, 242, 242));
        btnModificar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(0, 0, 0));
        btnModificar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnModificar.setText("Modificar");
        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnModificarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnModificarMouseExited(evt);
            }
        });
        panelModificarBTN.add(btnModificar, java.awt.BorderLayout.CENTER);

        botonesTabla.add(panelModificarBTN);

        panelEliminarBTN.setBackground(new java.awt.Color(242, 242, 242));
        panelEliminarBTN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelEliminarBTN.setPreferredSize(new java.awt.Dimension(150, 40));
        panelEliminarBTN.setLayout(new java.awt.BorderLayout());

        btnEliminar.setBackground(new java.awt.Color(242, 242, 242));
        btnEliminar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEliminar.setText("Eliminar");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarMouseExited(evt);
            }
        });
        panelEliminarBTN.add(btnEliminar, java.awt.BorderLayout.CENTER);

        botonesTabla.add(panelEliminarBTN);

        javax.swing.GroupLayout panelEdicionLayout = new javax.swing.GroupLayout(panelEdicion);
        panelEdicion.setLayout(panelEdicionLayout);
        panelEdicionLayout.setHorizontalGroup(
            panelEdicionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botonesTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
            .addGroup(panelEdicionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelEdicionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
                    .addComponent(panelBuscarPorCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelEdicionLayout.setVerticalGroup(
            panelEdicionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEdicionLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(panelBuscarPorCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(botonesTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        panelPrincipal.add(panelEdicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 640, 580));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    /* - - - - - - - - - - - - - - - - Diseños de los botones - - - - - - - - - - - - - - - - */
    //Diseño del botón Guardar
    private void btnGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseExited
        panelGuardarBTN.setOpaque(false);
        panelGuardarBTN.setBackground(new Color(255, 255, 255));
        btnGuardar.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_btnGuardarMouseExited

    private void btnGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseEntered
        panelGuardarBTN.setOpaque(true);
        panelGuardarBTN.setBackground(new Color(0, 153, 153));
        btnGuardar.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_btnGuardarMouseEntered

    //Diseño del botón Buscar.
    private void btnBuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseEntered
        panelBuscarBTN.setBackground(new Color(60, 63, 65));
        btnBuscar.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_btnBuscarMouseEntered

    private void btnBuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseExited
        panelBuscarBTN.setBackground(new Color(255, 255, 255));
        btnBuscar.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_btnBuscarMouseExited

    //Diseño del botón Modificar.
    private void btnModificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseEntered
        panelModificarBTN.setBackground(new Color(93, 196, 96));
        btnModificar.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_btnModificarMouseEntered

    private void btnModificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseExited
        panelModificarBTN.setBackground(new Color(255, 255, 255));
        btnModificar.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_btnModificarMouseExited

    //Diseño del botón Eliminar.
    private void btnEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseEntered
        panelEliminarBTN.setBackground(new Color(255, 64, 64));
        btnEliminar.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_btnEliminarMouseEntered

    private void btnEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseExited
        panelEliminarBTN.setBackground(new Color(255, 255, 255));
        btnEliminar.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_btnEliminarMouseExited

    /* - - - - - - - - - - - - - Acción de los botones - - - - - - - - - - - - - */
    //Botón Guardar.
    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        //Guarda los datos obtenidos.
        String cedula = this.cedula.getText();
        String nombre = this.nombre.getText();
        String apellido1 = this.apellido1.getText();
        String apellido2 = this.apellido2.getText();
        String carrera = this.carrera.getText();
        
        //Verificar si la cédula ya existe en el archivo.
        if (existeCedula(cedula)) {
            JOptionPane.showMessageDialog(this, "Ya existe un estudiante con la misma cédula.", "Error", JOptionPane.ERROR_MESSAGE);
            
            //Vaca los campos.
            this.cedula.setText("");
            this.nombre.setText("");
            this.apellido1.setText("");
            this.apellido2.setText("");
            this.carrera.setText("");
            return;
        }
        
        //Valida los campos.
        validarCampos();

        //Si no hay errores, guarda todo en el archivo y actualizar la tabla.
        if (errores.isEmpty()) {
            BufferedWriter writer = null;
            
            //Escribe los datos en el archivo Estudiantes.txt
            try {
                writer = new BufferedWriter(new FileWriter("Estudiantes.txt", true));
                writer.write(cedula + "," + nombre + "," + apellido1 + "," + apellido2 + "," + carrera);
                writer.newLine();
                JOptionPane.showMessageDialog(this, "Estudiante guardado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                //Vacia los campos.
                this.cedula.setText("");
                this.nombre.setText("");
                this.apellido1.setText("");
                this.apellido2.setText("");
                this.carrera.setText("");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                //Cierra el BufferedWriter en el bloque finally.
                if (writer != null) {
                    try {
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            //Muestra los estudiantes en la tabla.
            mostrarEstudiantesEnTabla(leerEstudiantesDesdeArchivo("Estudiantes.txt"));
        }
    }//GEN-LAST:event_btnGuardarMouseClicked

    //Botón Buscar
    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaEstudiantes.getModel();
        String cedulaBusqueda = buscarCedula.getText().trim();

        //Valida si la cédula está vacía.
        if (cedulaBusqueda.isEmpty()) {
            resaltarBordeError(buscarCedula);
            JOptionPane.showMessageDialog(this, "Por favor, ingrese una cédula.", "Cédula vacía", JOptionPane.ERROR_MESSAGE);
            
            //Vacia el TextField.
            buscarCedula.setText("");
            mostrarEstudiantesEnTabla(leerEstudiantesDesdeArchivo("Estudiantes.txt"));
            restaurarBordeOriginal(buscarCedula);
            return; //Sale del método si esta vacía.
        }

        //Validar que la cédula solo tenga números y que tenga 9 dígitos.
        if (!cedulaBusqueda.matches("[0-9]+") || cedulaBusqueda.length() != 9) {
            resaltarBordeError(buscarCedula);
            JOptionPane.showMessageDialog(this, "Por favor, ingrese solo numeros y que sean 9 digitos.", "Error en la cédula", JOptionPane.ERROR_MESSAGE);

            //Vacia el TextField.
            buscarCedula.setText("");
            modeloTabla.setRowCount(0);
            mostrarEstudiantesEnTabla(leerEstudiantesDesdeArchivo("Estudiantes.txt"));
            restaurarBordeOriginal(buscarCedula);
            return; //Sale del método tiene estos errores.
        }
   
        boolean encontrado = false;

        //Se agregan los estudiantes del archivo Estudiantes.txt al arreglo.
        List<Persona> personas = leerEstudiantesDesdeArchivo("Estudiantes.txt");

        //Recorre el arreglo en busca en de la cédula.
        for (Persona persona : personas) {
            if (persona.getCedula().equals(cedulaBusqueda)) {
                modeloTabla.setRowCount(0); //Limpia la tabla y después agrega al estudiante a la tabla.
                Object[] fila = {
                    persona.getCedula(),
                    persona.getNombre(),
                    persona.getApellido1(),
                    persona.getApellido2(),
                    persona.getCarrera()
                };
                modeloTabla.addRow(fila);
                encontrado = true; //Si encuentra la cédula devuelve true.
                break;
            }
        }

        //Si no se encuentra ninguna cédula muestra el mensaje.
        if (!encontrado) {
            JOptionPane.showMessageDialog(this, "No se encontraron estudiantes con la cédula ingresada.", "Cédula no encontrada", JOptionPane.INFORMATION_MESSAGE);
            mostrarEstudiantesEnTabla(leerEstudiantesDesdeArchivo("Estudiantes.txt"));
        }

        //Vacia el TextField.
        buscarCedula.setText("");
    }//GEN-LAST:event_btnBuscarMouseClicked

    //Botón Modificar.
    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        //Obtiene el módelo de la tabla.
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaEstudiantes.getModel();

        //Se guarda la fila seleccionada.
        int filaSeleccionada = tablaEstudiantes.getSelectedRow();

        //Si no se selecciona un estudiante muestra el error.
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un estudiante para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
            return; //Sale del método.
        }

        //Guarda los datos de la fila en variables.
        String cedulaOriginal = (String) modeloTabla.getValueAt(filaSeleccionada, 0);
        String nombre = (String) modeloTabla.getValueAt(filaSeleccionada, 1);
        String apellido1 = (String) modeloTabla.getValueAt(filaSeleccionada, 2);
        String apellido2 = (String) modeloTabla.getValueAt(filaSeleccionada, 3);
        String carrera = (String) modeloTabla.getValueAt(filaSeleccionada, 4);

        //Al identificar el estudiante por la cédula se pide aparte para poder modificarla.
        String nuevaCedula = JOptionPane.showInputDialog(this, "Valide o edite la cédula:", cedulaOriginal);

        //Valida los campos.
        if (!validarModificacionEstudiante(nuevaCedula, nombre, apellido1, apellido2, carrera, cedulaOriginal)) {
            return; //Si hay error sale del método.
        }

        modeloTabla.setValueAt(nuevaCedula, filaSeleccionada, 0);

        //Obtiene los datos de la cédula.
        try {
            List<Persona> estudiantes = leerEstudiantesDesdeArchivo("Estudiantes.txt");
            for (Persona estudiante : estudiantes) {
                if (estudiante.getCedula().equals(cedulaOriginal)) {
                    estudiante.setNombre(nombre);
                    estudiante.setApellido1(apellido1);
                    estudiante.setApellido2(apellido2);
                    estudiante.setCarrera(carrera);

                    if (!nuevaCedula.equals(cedulaOriginal)) {
                        estudiante.setCedula(nuevaCedula);
                    }
                    break;
                }
            }

            //Guarda los cambios en el archivo.
            guardarCambiosEnArchivo(estudiantes);
            JOptionPane.showMessageDialog(this, "Estudiante modificado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            //Actualiza la tabla.
            mostrarEstudiantesEnTabla(estudiantes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnModificarMouseClicked

    //Botón Eliminar.
    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        //Obtiene la fila seleccionada.
        int filaSeleccionada = tablaEstudiantes.getSelectedRow();

        //Si no se selecciono una fila muestra el error.
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un estudiante para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //Obtiene la cédula y el nombre seleccionado.
        String cedula = (String) tablaEstudiantes.getValueAt(filaSeleccionada, 0);
        String nombre = (String) tablaEstudiantes.getValueAt(filaSeleccionada, 1);

        //Muestra un mensaje de confirmación para eliminar al estudiante.
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar al estudiante " + nombre + " con cédula " + cedula + "?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);

        //Si se confirma, procede a eliminar el estudiante.
        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                //Guarda los estudiantes del archivo Estudiantes.txt en la clase Persona.
                List<Persona> estudiantes = leerEstudiantesDesdeArchivo("Estudiantes.txt");

                //Elimina el estudiante de la lista.
                estudiantes.removeIf(estudiante -> estudiante.getCedula().equals(cedula));
                
                //Elimina las calificaciones del estudainte.
                eliminarCalificaciones(cedula);

                //Guarda los cambios y muestra el mensaje de exito.
                guardarCambiosEnArchivo(estudiantes);
                JOptionPane.showMessageDialog(this, "Estudiante eliminado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                //Actualiza la tabla.
                mostrarEstudiantesEnTabla(estudiantes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnEliminarMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellido1;
    private javax.swing.JTextField apellido2;
    private javax.swing.JPanel botonesTabla;
    private javax.swing.JLabel btnBuscar;
    private javax.swing.JLabel btnEliminar;
    private javax.swing.JLabel btnGuardar;
    private javax.swing.JLabel btnModificar;
    private javax.swing.JTextField buscarCedula;
    private javax.swing.JTextField carrera;
    private javax.swing.JTextField cedula;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombre;
    private javax.swing.JPanel panelApellido1;
    private javax.swing.JPanel panelApellido2;
    private javax.swing.JPanel panelBuscarBTN;
    private javax.swing.JPanel panelBuscarPorCedula;
    private javax.swing.JPanel panelCarrera;
    private javax.swing.JPanel panelCedula;
    private javax.swing.JPanel panelCedula1;
    private javax.swing.JPanel panelEdicion;
    private javax.swing.JPanel panelEliminarBTN;
    private javax.swing.JPanel panelGuardar;
    private javax.swing.JPanel panelGuardarBTN;
    private javax.swing.JPanel panelModificarBTN;
    private javax.swing.JPanel panelNombre;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JTable tablaEstudiantes;
    private javax.swing.JLabel textoApellido1;
    private javax.swing.JLabel textoApellido2;
    private javax.swing.JLabel textoBuscarCedula;
    private javax.swing.JLabel textoCarrera;
    private javax.swing.JLabel textoCedula;
    private javax.swing.JLabel textoNombre;
    private javax.swing.JLabel tituloPanelBPC;
    // End of variables declaration//GEN-END:variables
}
