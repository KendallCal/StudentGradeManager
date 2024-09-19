
//Filtrar Promedios.

package Proyecto2;

//Imports.
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FiltrarPromedios extends javax.swing.JPanel {

    //Arreglos, HashSet, y Map.
    private Map<String, Estudiante> estudiantes; //Asocia cada cédula con un objeto Estudiante.
    private List<String> errores = new ArrayList<>(); //Almacena mensajes de error.
    private Set<String> cedulasAgregadas = new HashSet<>(); //Almacenar cédulas únicas.
    
    //Constructor.
    public FiltrarPromedios() {
        initComponents();
        cargarDatosEstudiantes();
        cargarDatosPromedios();
    }

    /* - - - - - - - - - - - - - Metodos de Validación - - - - - - - - - - - - - */
    //Método para validar todos los campos.
    private void validarCampos() {
        //Limpia la lista antes de verificar.
        errores.clear();

        verificaCarrera(errores); //Valida la Carrera.
        verificaPromedio(errores); //Valida el Promedio.

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

        //Muestra el JOptionPanel de los errores.
        JOptionPane.showMessageDialog(this, mensajeError.toString(), "Errores de validación.", JOptionPane.ERROR_MESSAGE);
    }

    //Método para validar la carrera.
    private boolean verificaCarrera(List<String> errores) {
        String carreraText = filtrarPorCarrera.getText().trim();

        //Verifica si el campo está vacío.
        if (carreraText.isEmpty()) {
            restaurarBordeOriginal(filtrarPorCarrera);
            return true;
        }

        //Verifica que la carrera solo tenga letras.
        if (!carreraText.matches("\\p{L}+")) {
            errores.add("La carrera solo debe tener letras.");
            resaltarBordeError(filtrarPorCarrera);
            return false;
        }

        //Restaura el borde.
        restaurarBordeOriginal(filtrarPorCarrera);
        return true;
    }

    //Método para validar el promedio.
    private boolean verificaPromedio(List<String> errores) {
        String promedioText = filtrarPorPromedio.getText().trim();

        //Verificar si el campo está vacío.
        if (promedioText.isEmpty()) {
            restaurarBordeOriginal(filtrarPorPromedio);
            return true; 
        }

        //Verifica que el promedio solo tenga numeros.
        if (!promedioText.matches("[0-9.]+")) {
            errores.add("El promedio solo debe tener numeros.");
            resaltarBordeError(filtrarPorPromedio);
            return false;
    }

    //Verificar que el Promedio sea menor a 10 solo si se ha ingresado un valor
    try {
        double promedio = Double.parseDouble(filtrarPorPromedio.getText());
        if (promedio > 10) {
            errores.add("La calificación del Proyecto 2 debe ser menor o igual a 10.");
            resaltarBordeError(filtrarPorPromedio);
            return false;
        }
    } catch (NumberFormatException e) {
        // Ignorar si el valor no se puede convertir a un número
    }

    //Restaura el borde.
    restaurarBordeOriginal(filtrarPorPromedio);
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

    /* - - - - - - - - - - - - - Metodos Principales - - - - - - - - - - - - - */
    //Método para cargar los datos del Estudiante.
    private void cargarDatosEstudiantes() {

        //Crea un mapa para almacenar los estudiantes, donde la clave es la cédula del estudiante.
        estudiantes = new HashMap<>();

        //Lee el archivo Estudiantes.txt
        try (BufferedReader br = new BufferedReader(new FileReader("Estudiantes.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length >= 5) {
                    String cedula = partes[0];
                    String nombre = partes[1];
                    String apellido1 = partes[2];
                    String apellido2 = partes[3];
                    String carrera = partes[4];

                    //Crea un nuevo estudiante con los datos adquiridos.
                    estudiantes.put(cedula, new Estudiante(0, 0, 0, 0, 0, 0, cedula, nombre, apellido1, apellido2, carrera));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Método para cargar los promedios del archivo Promedios.txt
    private void cargarDatosPromedios() {
        //Lee el archivo Promedio.txt
        try (BufferedReader br = new BufferedReader(new FileReader("Promedios.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length >= 7) {
                    String cedula = partes[0];
                    
                    //Extrae los datos de la línea dela archivo.
                    float proyecto1 = Float.parseFloat(partes[1]);
                    float proyecto2 = Float.parseFloat(partes[2]);
                    float foroAcademico = Float.parseFloat(partes[3]);
                    float encuesta = Float.parseFloat(partes[4]);
                    float juego = Float.parseFloat(partes[5]);
                    float promedio = Float.parseFloat(partes[6]);

                    //Obtiene el estudiante correspondiente a las calificaciones.
                    Estudiante estudiante = estudiantes.get(cedula);

                    //Actualiza las calificaciones de Estudiante.
                    if (estudiante != null) {
                        estudiante.setProyecto1(proyecto1);
                        estudiante.setProyecto2(proyecto2);
                        estudiante.setForoAcademico(foroAcademico);
                        estudiante.setEncuesta(encuesta);
                        estudiante.setJuego(juego);
                        estudiante.setPromedio(promedio);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Design.
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        panelFiltrar = new javax.swing.JPanel();
        panelFiltrarPorCarrera = new javax.swing.JPanel();
        tituloFiltrarPorCarrera = new javax.swing.JLabel();
        filtrarPorCarrera = new javax.swing.JTextField();
        panelFiltrarPorPromedio = new javax.swing.JPanel();
        tituloFiltrarPorPromedio = new javax.swing.JLabel();
        filtrarPorPromedio = new javax.swing.JTextField();
        panelFiltrarBTN = new javax.swing.JPanel();
        btnFiltrar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaFiltrar = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(940, 580));
        setMinimumSize(new java.awt.Dimension(940, 580));
        setLayout(new java.awt.BorderLayout());

        panelPrincipal.setBackground(new java.awt.Color(242, 242, 242));
        panelPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        panelFiltrar.setMaximumSize(new java.awt.Dimension(400, 32767));
        panelFiltrar.setMinimumSize(new java.awt.Dimension(400, 84));
        panelFiltrar.setOpaque(false);
        panelFiltrar.setPreferredSize(new java.awt.Dimension(400, 142));
        panelFiltrar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 50, 5));

        panelFiltrarPorCarrera.setMaximumSize(new java.awt.Dimension(145, 74));
        panelFiltrarPorCarrera.setMinimumSize(new java.awt.Dimension(145, 74));
        panelFiltrarPorCarrera.setOpaque(false);
        panelFiltrarPorCarrera.setPreferredSize(new java.awt.Dimension(145, 74));

        tituloFiltrarPorCarrera.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        tituloFiltrarPorCarrera.setForeground(new java.awt.Color(0, 0, 0));
        tituloFiltrarPorCarrera.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloFiltrarPorCarrera.setText("Filtrar por Carrera");
        tituloFiltrarPorCarrera.setMaximumSize(new java.awt.Dimension(130, 25));
        tituloFiltrarPorCarrera.setMinimumSize(new java.awt.Dimension(130, 25));
        tituloFiltrarPorCarrera.setPreferredSize(new java.awt.Dimension(130, 25));
        panelFiltrarPorCarrera.add(tituloFiltrarPorCarrera);

        filtrarPorCarrera.setBackground(new java.awt.Color(255, 255, 255));
        filtrarPorCarrera.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        filtrarPorCarrera.setForeground(new java.awt.Color(51, 51, 51));
        filtrarPorCarrera.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        filtrarPorCarrera.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        filtrarPorCarrera.setMaximumSize(new java.awt.Dimension(130, 25));
        filtrarPorCarrera.setMinimumSize(new java.awt.Dimension(130, 25));
        filtrarPorCarrera.setPreferredSize(new java.awt.Dimension(130, 25));
        filtrarPorCarrera.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        filtrarPorCarrera.setSelectionColor(new java.awt.Color(102, 102, 255));
        panelFiltrarPorCarrera.add(filtrarPorCarrera);

        panelFiltrar.add(panelFiltrarPorCarrera);

        panelFiltrarPorPromedio.setMaximumSize(new java.awt.Dimension(145, 74));
        panelFiltrarPorPromedio.setMinimumSize(new java.awt.Dimension(145, 74));
        panelFiltrarPorPromedio.setOpaque(false);
        panelFiltrarPorPromedio.setPreferredSize(new java.awt.Dimension(145, 74));

        tituloFiltrarPorPromedio.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        tituloFiltrarPorPromedio.setForeground(new java.awt.Color(0, 0, 0));
        tituloFiltrarPorPromedio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloFiltrarPorPromedio.setText("Filtrar por Promedio");
        tituloFiltrarPorPromedio.setMaximumSize(new java.awt.Dimension(130, 25));
        tituloFiltrarPorPromedio.setMinimumSize(new java.awt.Dimension(130, 25));
        tituloFiltrarPorPromedio.setPreferredSize(new java.awt.Dimension(130, 25));
        panelFiltrarPorPromedio.add(tituloFiltrarPorPromedio);

        filtrarPorPromedio.setBackground(new java.awt.Color(255, 255, 255));
        filtrarPorPromedio.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        filtrarPorPromedio.setForeground(new java.awt.Color(51, 51, 51));
        filtrarPorPromedio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        filtrarPorPromedio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        filtrarPorPromedio.setMaximumSize(new java.awt.Dimension(130, 25));
        filtrarPorPromedio.setMinimumSize(new java.awt.Dimension(130, 25));
        filtrarPorPromedio.setPreferredSize(new java.awt.Dimension(130, 25));
        filtrarPorPromedio.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        filtrarPorPromedio.setSelectionColor(new java.awt.Color(102, 102, 255));
        panelFiltrarPorPromedio.add(filtrarPorPromedio);

        panelFiltrar.add(panelFiltrarPorPromedio);

        panelFiltrarBTN.setBackground(new java.awt.Color(242, 242, 242));
        panelFiltrarBTN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelFiltrarBTN.setPreferredSize(new java.awt.Dimension(100, 35));
        panelFiltrarBTN.setLayout(new java.awt.BorderLayout());

        btnFiltrar.setBackground(new java.awt.Color(242, 242, 242));
        btnFiltrar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnFiltrar.setForeground(new java.awt.Color(0, 0, 0));
        btnFiltrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnFiltrar.setText("Filtrar");
        btnFiltrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFiltrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFiltrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFiltrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFiltrarMouseExited(evt);
            }
        });
        panelFiltrarBTN.add(btnFiltrar, java.awt.BorderLayout.CENTER);

        panelFiltrar.add(panelFiltrarBTN);

        tablaFiltrar.setBackground(new java.awt.Color(242, 242, 242));
        tablaFiltrar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        tablaFiltrar.setForeground(new java.awt.Color(60, 63, 65));
        tablaFiltrar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Cédula", "Nombre", "P. Apellido", "S. Apellido", "Carrera", "Proyecto 1", "Proyecto 2", "Foro Academico", "Encuesta", "Juego", "Promedio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaFiltrar.setRowHeight(23);
        tablaFiltrar.setShowHorizontalLines(true);
        tablaFiltrar.setShowVerticalLines(true);
        jScrollPane1.setViewportView(tablaFiltrar);

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                        .addGap(0, 263, Short.MAX_VALUE)
                        .addComponent(panelFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 263, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(panelFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        add(panelPrincipal, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    /* - - - - - - - - - - - - - - Diseños de los botones - - - - - - - - - - - - - - */
    //Diseño de botón Filtrar.
    private void btnFiltrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFiltrarMouseEntered
        panelFiltrarBTN.setOpaque(true);
        panelFiltrarBTN.setBackground(new Color(0, 153, 153));
        btnFiltrar.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_btnFiltrarMouseEntered

    private void btnFiltrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFiltrarMouseExited
        panelFiltrarBTN.setOpaque(false);
        panelFiltrarBTN.setBackground(new Color(255, 255, 255));
        btnFiltrar.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_btnFiltrarMouseExited

    /* - - - - - - - - - - - - - - Acción de los botones - - - - - - - - - - - - - - */
    //Botón Filtrar
    private void btnFiltrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFiltrarMouseClicked
        //Valida los campos.
        validarCampos();

        //Limpia la tabla.
        DefaultTableModel model = (DefaultTableModel) tablaFiltrar.getModel();
        model.setRowCount(0);

        //Guarda los datos.
        String carrera = filtrarPorCarrera.getText().trim();
        String promedioStr = filtrarPorPromedio.getText().trim();

        //Limpia lista de cedulas agregadas.
        cedulasAgregadas.clear();

        //Si los dos campos están vacíos.
        if (carrera.isEmpty() && promedioStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay estudiantes registrados, por favor ingrese estudiantes..", "Sin resultados", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        List<Estudiante> estudiantesFiltrados = new ArrayList<>();

        //Filtrar estudiantes por Carrera.
        if (!carrera.isEmpty()) {
            for (Estudiante estudiante : estudiantes.values()) {
                if (estudiante.getCarrera().equalsIgnoreCase(carrera)) {
                    estudiantesFiltrados.add(estudiante);
                }
            }
        } else {
            estudiantesFiltrados.addAll(estudiantes.values());
        }

        //Filtrar estudiantes por Promedio.
        if (!promedioStr.isEmpty()) {
            try {
                float promedio = Float.parseFloat(promedioStr);
                estudiantesFiltrados.removeIf(estudiante -> Math.abs(estudiante.getPromedio() - promedio) > 0.05);
            } catch (NumberFormatException e) {
            }
        }

        //Verificar si se encontraron estudiantes.
        if (estudiantesFiltrados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se encontraron estudiantes que cumplan con los criterios de búsqueda.", "Sin resultados", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        //Agregar estudiantes filtrados a la tabla.
        for (Estudiante estudiante : estudiantesFiltrados) {
            Object[] row = {estudiante.getCedula(), 
                            estudiante.getNombre(), 
                            estudiante.getApellido1(), 
                            estudiante.getApellido2(),
                            estudiante.getCarrera(), 
                            estudiante.getProyecto1(), 
                            estudiante.getProyecto2(),
                            estudiante.getForoAcademico(), 
                            estudiante.getEncuesta(), 
                            estudiante.getJuego(),
                            estudiante.getPromedio()};
            model.addRow(row);
        }
    }//GEN-LAST:event_btnFiltrarMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnFiltrar;
    private javax.swing.JTextField filtrarPorCarrera;
    private javax.swing.JTextField filtrarPorPromedio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelFiltrar;
    private javax.swing.JPanel panelFiltrarBTN;
    private javax.swing.JPanel panelFiltrarPorCarrera;
    private javax.swing.JPanel panelFiltrarPorPromedio;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JTable tablaFiltrar;
    private javax.swing.JLabel tituloFiltrarPorCarrera;
    private javax.swing.JLabel tituloFiltrarPorPromedio;
    // End of variables declaration//GEN-END:variables
}
