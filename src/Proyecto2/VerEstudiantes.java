
//Ver Estudiantes.

package Proyecto2;

//Imports.
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class VerEstudiantes extends javax.swing.JPanel {

    //Constructor.
    public VerEstudiantes() {
        initComponents();
        diseñoTabla();
        mostrarDatosEnTabla();
    }
    
    /* - - - - - - - - - - - - - - - - - - Métodos de Diseño - - - - - - - - - - - - - - - - - - */
    //Método para diseño de la tabla.
    private void diseñoTabla() {
        
        //Establece un renderizador personalizado para la tabla.
        tablaListaEstudiantes.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            
            //Sobrescribe el método getTableCellRendererComponent para personalizar el renderizado de las celdas.
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                //Llama al método original para obtener el valor de la celda.
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                //Si el valor es un String y está en las columnas de calificaciones, se centra el texto.
                if (value instanceof String && (column >= 5 && column <= 10)) {
                    setHorizontalAlignment(JLabel.CENTER); //Centra el texto en la celda.
                } else {
                    //Si no está en las columnas de calificaciones, el texto se alinea a la izquierda.
                    setHorizontalAlignment(JLabel.LEFT);
                }

                //Si el valor es un String.
                if (value instanceof String) {
                    //Intenta convertirlo a float para verificar si es una calificación.
                    try {
                        float floatValue = Float.parseFloat((String) value);
                        
                        //Si es menor a 7.0, se muestra en rojo y en negrita.
                        if (floatValue < 7.0) {
                            c.setForeground(Color.RED); //Color rojo para calificaciones bajas.
                            c.setFont(c.getFont().deriveFont(Font.BOLD)); //Estilo en negrita.
                        } else {
                            c.setForeground(table.getForeground()); //Restablece el color predeterminado.
                        }
                    } catch (NumberFormatException e) {
                        //Si no se puede convertir a float, se mantiene el color y el estilo predeterminados.
                        c.setForeground(table.getForeground());
                        c.setFont(c.getFont().deriveFont(Font.PLAIN));
                    }
                }
                return c; //Devuelve el componente de la celda personalizado.
            }
        });
    }

    /* - - - - - - - - - - - - - - - - - - Métodos Principales - - - - - - - - - - - - - - - - - */  
    //Método para leer los estudiantes del archivo Estudiantes.txt
    private List<Persona> leerEstudiantesDesdeArchivo(String nombreArchivo) {
        //Guarda los estudiantes en una lista.
        List<Persona> estudiantes = new ArrayList<>();
        
        //Lee los estudiantes del archivo.
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length >= 5) {
                    String cedula = partes[0];
                    String nombre = partes[1];
                    String apellido1 = partes[2];
                    String apellido2 = partes[3];
                    String carrera = partes[4];
                    
                    //Agrega los los datos a la lista.
                    estudiantes.add(new Persona(cedula, nombre, apellido1, apellido2, carrera));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return estudiantes; //Devuelve la lista.
    }

    //Método para leer las calificaciones del archivo Promedios.txt
    private List<String> leerCalificacionesDesdeArchivo(String cedulaEstudiante) {
        //Guarda las calificaiones en una lista.
        List<String> calificaciones = new ArrayList<>();
        
        //Lee el archivo Promedios.txt
        try (BufferedReader reader = new BufferedReader(new FileReader("Promedios.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length > 0 && partes[0].equals(cedulaEstudiante)) {
                    for (int i = 1; i < partes.length; i++) {
                        
                        //Guarda las calificaciones.
                        calificaciones.add(partes[i]);
                    }
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return calificaciones; //Devuelve las calificaciones.
    }
    
    //Método para mostrar los datos en la tabla.
    private void mostrarDatosEnTabla() {
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaListaEstudiantes.getModel();

        //Limpia la tabla antes de agregar nuevos datos.
        modeloTabla.setRowCount(0);

        //Guarda los datos de estudiantes en una lista.
        List<Persona> estudiantes = leerEstudiantesDesdeArchivo("Estudiantes.txt");

        //Busca las calificaciones de cada estudiante en Promedios.txt
        for (Persona estudiante : estudiantes) {
            List<String> calificaciones = leerCalificacionesDesdeArchivo(estudiante.getCedula());

            //Agrega los datos del estudiante a la izquierda de las calificaciones en el centro.
            Object[] fila = {
                estudiante.getCedula(),
                estudiante.getNombre(),
                estudiante.getApellido1(),
                estudiante.getApellido2(),
                estudiante.getCarrera(),
                "-", //Proyecto 1
                "-", //Proyecto 2
                "-", //Foro Académico
                "-", //Encuesta
                "-", //Juego
                "-" //Promedio
            };

            //Si tiene calificaciones disponibles actualiza las columnas.
            if (!calificaciones.isEmpty()) {
                for (int i = 0; i < calificaciones.size(); i++) {
                    fila[i + 5] = calificaciones.get(i);
                }

                //Agregar el promedio.
                fila[10] = calificaciones.get(calificaciones.size() - 1);
            }
            //Agrega cada fila a la tabla.
            modeloTabla.addRow(fila);
        }
    }

    //Design.
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaListaEstudiantes = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(940, 580));
        setMinimumSize(new java.awt.Dimension(940, 580));
        setLayout(new java.awt.BorderLayout());

        panelPrincipal.setBackground(new java.awt.Color(242, 242, 242));
        panelPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        titulo.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        titulo.setForeground(new java.awt.Color(51, 51, 51));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Lista de Estudiantes");

        tablaListaEstudiantes.setBackground(new java.awt.Color(242, 242, 242));
        tablaListaEstudiantes.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        tablaListaEstudiantes.setForeground(new java.awt.Color(60, 63, 65));
        tablaListaEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaListaEstudiantes.setRowHeight(23);
        tablaListaEstudiantes.setShowHorizontalLines(true);
        tablaListaEstudiantes.setShowVerticalLines(true);
        jScrollPane1.setViewportView(tablaListaEstudiantes);

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(titulo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );

        add(panelPrincipal, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JTable tablaListaEstudiantes;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
