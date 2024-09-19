
/*

    Kendall Andrey Calderón Burgos.

    Proyecto 2. Programación Intermedia.

    Primer Cuatrimestre 2024.

*/

//Menú Principal
package Proyecto2;

//Imports.
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;
import javax.swing.JPanel;

public class Menu extends javax.swing.JFrame {

    //Variables.
    int xMouse, yMouse;
    
    //Constructor.
    public Menu() {
        initComponents();
        crearArchvios();
        this.setLocationRelativeTo(null);
        setTitle("Sistema de Registros de Notas de Estudiantes");
        
        //Redondear bordes de la ventana.
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 15, 15));
    }
    
    /* - - - - - - - - - - - - - - - - - - - - Métodos - - - - - - - - - - - - - - - - - - - - */
    //Método para crear los archivos .txt
    private void crearArchvios() {
        File estudiantesFile = new File("Estudiantes.txt");
        File promediosFile = new File("Promedios.txt");
        
        try {
            // Verificar si los archivos existen, si no existen, crearlos
            if (estudiantesFile.createNewFile() && promediosFile.createNewFile()) {
                System.out.println("Se crearon los archivos con exito");
            }
        } catch (IOException e) {
            System.out.println("Error al crear los archivos: " + e.getMessage());
        }
    }
    
    //Método para cambiar opción.
    private void cambiarOpcion(JPanel opcion) {
        opcion.setSize(940, 580); //Establece el tamaño de la ventana.
        opcion.setLocation(0, 0); //Establece la posición de la ventana..
        panelPrincipal.removeAll(); //Elimina lo que se muestra en la ventana.
        panelPrincipal.add(opcion, BorderLayout.CENTER); //Agrega la ventana al Jframe.
        panelPrincipal.revalidate(); //Revalida el diseño despues de haber cargado cada componente.
        panelPrincipal.repaint(); //Se repinta la ventana despues de haberlo hecho.
    }
    
    //Design.
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedorPrincipal = new javax.swing.JPanel();
        barraSuperior = new javax.swing.JPanel();
        panelSalir = new javax.swing.JPanel();
        btnSalir = new javax.swing.JLabel();
        panelAtras = new javax.swing.JPanel();
        btnAtras = new javax.swing.JLabel();
        panelTitulo = new javax.swing.JPanel();
        Titulo = new javax.swing.JLabel();
        panelPrincipal = new javax.swing.JPanel();
        contenedorBTNS = new javax.swing.JPanel();
        panelDatosBTN = new javax.swing.JPanel();
        btnDatos = new javax.swing.JLabel();
        panelPromediosBTN = new javax.swing.JPanel();
        btnPromedios = new javax.swing.JLabel();
        panelEstudiantesBTN = new javax.swing.JPanel();
        btnEstudiantes = new javax.swing.JLabel();
        panelFiltrarBTN = new javax.swing.JPanel();
        btnFiltrar = new javax.swing.JLabel();
        panelIMG = new javax.swing.JPanel();
        texto1 = new javax.swing.JLabel();
        texto2 = new javax.swing.JLabel();
        imagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contenedorPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barraSuperior.setBackground(new java.awt.Color(242, 242, 242));
        barraSuperior.setAlignmentX(0.0F);
        barraSuperior.setAlignmentY(0.0F);
        barraSuperior.setDoubleBuffered(false);
        barraSuperior.setName(""); // NOI18N
        barraSuperior.setPreferredSize(new java.awt.Dimension(860, 45));
        barraSuperior.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                barraSuperiorMouseDragged(evt);
            }
        });
        barraSuperior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                barraSuperiorMousePressed(evt);
            }
        });

        panelSalir.setAlignmentX(0.0F);
        panelSalir.setAlignmentY(0.0F);
        panelSalir.setOpaque(false);
        panelSalir.setPreferredSize(new java.awt.Dimension(40, 40));

        btnSalir.setFont(new java.awt.Font("Hack Nerd Font", 0, 30)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(0, 0, 0));
        btnSalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSalir.setText("x");
        btnSalir.setAlignmentY(0.0F);
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalirMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelSalirLayout = new javax.swing.GroupLayout(panelSalir);
        panelSalir.setLayout(panelSalirLayout);
        panelSalirLayout.setHorizontalGroup(
            panelSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );
        panelSalirLayout.setVerticalGroup(
            panelSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        panelAtras.setAlignmentX(0.0F);
        panelAtras.setAlignmentY(0.0F);
        panelAtras.setOpaque(false);
        panelAtras.setPreferredSize(new java.awt.Dimension(40, 40));

        btnAtras.setFont(new java.awt.Font("High Tower Text", 1, 38)); // NOI18N
        btnAtras.setForeground(new java.awt.Color(0, 0, 0));
        btnAtras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAtras.setText("<");
        btnAtras.setAlignmentY(0.0F);
        btnAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtras.setEnabled(false);
        btnAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAtrasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAtrasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAtrasMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelAtrasLayout = new javax.swing.GroupLayout(panelAtras);
        panelAtras.setLayout(panelAtrasLayout);
        panelAtrasLayout.setHorizontalGroup(
            panelAtrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAtras, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );
        panelAtrasLayout.setVerticalGroup(
            panelAtrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAtrasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        panelTitulo.setOpaque(false);

        Titulo.setBackground(new java.awt.Color(51, 51, 51));
        Titulo.setFont(new java.awt.Font("Sitka Text", 1, 15)); // NOI18N
        Titulo.setForeground(new java.awt.Color(51, 51, 51));
        Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titulo.setText("Proyecto");

        javax.swing.GroupLayout panelTituloLayout = new javax.swing.GroupLayout(panelTitulo);
        panelTitulo.setLayout(panelTituloLayout);
        panelTituloLayout.setHorizontalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelTituloLayout.setVerticalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout barraSuperiorLayout = new javax.swing.GroupLayout(barraSuperior);
        barraSuperior.setLayout(barraSuperiorLayout);
        barraSuperiorLayout.setHorizontalGroup(
            barraSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, barraSuperiorLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(panelAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 389, Short.MAX_VALUE)
                .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 390, Short.MAX_VALUE)
                .addComponent(panelSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        barraSuperiorLayout.setVerticalGroup(
            barraSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelAtras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        contenedorPrincipal.add(barraSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 40));

        panelPrincipal.setBackground(new java.awt.Color(242, 242, 242));
        panelPrincipal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
        panelPrincipal.setForeground(new java.awt.Color(247, 247, 247));

        contenedorBTNS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        contenedorBTNS.setOpaque(false);
        contenedorBTNS.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 21));

        panelDatosBTN.setBackground(new java.awt.Color(242, 242, 242));
        panelDatosBTN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(60, 63, 65)));
        panelDatosBTN.setPreferredSize(new java.awt.Dimension(200, 40));
        panelDatosBTN.setLayout(new java.awt.BorderLayout());

        btnDatos.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnDatos.setForeground(new java.awt.Color(60, 63, 65));
        btnDatos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDatos.setText("Ingresar o Editar Datos ");
        btnDatos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDatosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDatosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDatosMouseExited(evt);
            }
        });
        panelDatosBTN.add(btnDatos, java.awt.BorderLayout.CENTER);

        contenedorBTNS.add(panelDatosBTN);

        panelPromediosBTN.setBackground(new java.awt.Color(242, 242, 242));
        panelPromediosBTN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(60, 63, 65)));
        panelPromediosBTN.setPreferredSize(new java.awt.Dimension(200, 40));
        panelPromediosBTN.setLayout(new java.awt.BorderLayout());

        btnPromedios.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnPromedios.setForeground(new java.awt.Color(60, 63, 65));
        btnPromedios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnPromedios.setText("Ingresar Promedios");
        btnPromedios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPromedios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPromediosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPromediosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPromediosMouseExited(evt);
            }
        });
        panelPromediosBTN.add(btnPromedios, java.awt.BorderLayout.CENTER);

        contenedorBTNS.add(panelPromediosBTN);

        panelEstudiantesBTN.setBackground(new java.awt.Color(242, 242, 242));
        panelEstudiantesBTN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(60, 63, 65)));
        panelEstudiantesBTN.setPreferredSize(new java.awt.Dimension(200, 40));
        panelEstudiantesBTN.setLayout(new java.awt.BorderLayout());

        btnEstudiantes.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnEstudiantes.setForeground(new java.awt.Color(60, 63, 65));
        btnEstudiantes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEstudiantes.setText("Ver Estudiantes");
        btnEstudiantes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEstudiantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEstudiantesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEstudiantesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEstudiantesMouseExited(evt);
            }
        });
        panelEstudiantesBTN.add(btnEstudiantes, java.awt.BorderLayout.CENTER);

        contenedorBTNS.add(panelEstudiantesBTN);

        panelFiltrarBTN.setBackground(new java.awt.Color(242, 242, 242));
        panelFiltrarBTN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(60, 63, 65)));
        panelFiltrarBTN.setPreferredSize(new java.awt.Dimension(200, 40));
        panelFiltrarBTN.setLayout(new java.awt.BorderLayout());

        btnFiltrar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnFiltrar.setForeground(new java.awt.Color(60, 63, 65));
        btnFiltrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnFiltrar.setText("Filtrar Promedio");
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

        contenedorBTNS.add(panelFiltrarBTN);

        panelIMG.setOpaque(false);
        panelIMG.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        texto1.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        texto1.setForeground(new java.awt.Color(242, 242, 242));
        texto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        texto1.setText("¡Bienvenido al Sistema de Registros de Notas de Estudiantes!");
        panelIMG.add(texto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 789, -1));

        texto2.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        texto2.setForeground(new java.awt.Color(242, 242, 242));
        texto2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        texto2.setText("Por favor, selecciona una  de las opciónes de arriba para continuar.");
        panelIMG.add(texto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 789, -1));

        imagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Proyecto2/img/Bg.jpg"))); // NOI18N
        imagen.setText("jLabel1");
        panelIMG.add(imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 410));

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedorBTNS, javax.swing.GroupLayout.DEFAULT_SIZE, 940, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelIMG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(contenedorBTNS, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(panelIMG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        contenedorPrincipal.add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 940, 580));

        getContentPane().add(contenedorPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Diseño y acción de la barra superior.
    private void barraSuperiorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraSuperiorMousePressed
        xMouse = evt.getX(); //Guarda la posición x.
        yMouse = evt.getY(); //Guarda la posición y.
    }//GEN-LAST:event_barraSuperiorMousePressed

    private void barraSuperiorMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraSuperiorMouseDragged
        int x = evt.getXOnScreen(); //Guarda la posición x del mouse en la pantalla.
        int y = evt.getYOnScreen(); //Guarda la posición y del mouse en la pantalla.
        this.setLocation(x - xMouse, y - yMouse); //Lo posiciona en la posición indicada.
    }//GEN-LAST:event_barraSuperiorMouseDragged

    //Diseño y acción del botón para Salir.
    private void btnSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseEntered
        panelSalir.setOpaque(true);
        panelSalir.setBackground(new Color(247, 83, 96, 255));
        btnSalir.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_btnSalirMouseEntered
    
    private void btnSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseExited
        panelSalir.setOpaque(false);
        panelSalir.setBackground(new Color(244, 49, 19, 0));
        btnSalir.setForeground(new Color(18, 18, 18));
    }//GEN-LAST:event_btnSalirMouseExited
     
    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        System.exit(0); //Sirve para salir del programa.
    }//GEN-LAST:event_btnSalirMouseClicked

    //Diseño y acción del botón para Atras.
    private void btnAtrasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseEntered
        if (btnAtras.isEnabled()) {
            panelAtras.setOpaque(true);
            panelAtras.setBackground(new Color(54, 185, 234));
            btnAtras.setForeground(new Color(255, 255, 255));
        }
    }//GEN-LAST:event_btnAtrasMouseEntered

    private void btnAtrasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseExited
        if (btnAtras.isEnabled()) {
            panelAtras.setOpaque(false);
            panelAtras.setBackground(new Color(244, 49, 19, 0));
            btnAtras.setForeground(new Color(18, 18, 18));
        }
    }//GEN-LAST:event_btnAtrasMouseExited

    private void btnAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtrasMouseClicked
        if (btnAtras.isEnabled()) {        
            //Obtiene la ubicación de la ventana.
            int currentX = this.getLocation().x;
            int currentY = this.getLocation().y;

            //Crea la nueva instancia.
            Menu menuPrincipal = new Menu();

            //Estable la posición obtenida.
            menuPrincipal.setLocation(currentX, currentY);

            //Hace visible la instancia.
            menuPrincipal.setVisible(true);

            //Cierra la ventana.
            this.dispose(); 
        }
    }//GEN-LAST:event_btnAtrasMouseClicked

    /* - - - - - - - - - - - - - - - - Diseños de las opciones - - - - - - - - - - - - - - - - */
    //Diseño del botón Ingresar Datos.
    private void btnDatosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDatosMouseEntered
        panelDatosBTN.setOpaque(true);
        panelDatosBTN.setBackground(new Color(60, 63, 65));
        btnDatos.setForeground(new Color(242, 242, 242));
    }//GEN-LAST:event_btnDatosMouseEntered

    private void btnDatosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDatosMouseExited
        panelDatosBTN.setOpaque(false);
        panelDatosBTN.setBackground(new Color(60, 63, 65));
        btnDatos.setForeground(new Color(60, 63, 65));
    }//GEN-LAST:event_btnDatosMouseExited

    //Diseño del botón Ingresar Promedios.
    private void btnPromediosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPromediosMouseEntered
        panelPromediosBTN.setOpaque(true);
        panelPromediosBTN.setBackground(new Color(60, 63, 65));
        btnPromedios.setForeground(new Color(242, 242, 242));
    }//GEN-LAST:event_btnPromediosMouseEntered

    private void btnPromediosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPromediosMouseExited
        panelPromediosBTN.setOpaque(false);
        panelPromediosBTN.setBackground(new Color(60, 63, 65));
        btnPromedios.setForeground(new Color(60, 63, 65));
    }//GEN-LAST:event_btnPromediosMouseExited

    //Diseño del botón Ver Estudiantes.
    private void btnEstudiantesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEstudiantesMouseEntered
        panelEstudiantesBTN.setOpaque(true);
        panelEstudiantesBTN.setBackground(new Color(60, 63, 65));
        btnEstudiantes.setForeground(new Color(242, 242, 242));
    }//GEN-LAST:event_btnEstudiantesMouseEntered

    private void btnEstudiantesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEstudiantesMouseExited
        panelEstudiantesBTN.setOpaque(false);
        panelEstudiantesBTN.setBackground(new Color(60, 63, 65));
        btnEstudiantes.setForeground(new Color(60, 63, 65));
    }//GEN-LAST:event_btnEstudiantesMouseExited

    //Diseño del botón Filtrar Promedios.
    private void btnFiltrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFiltrarMouseExited
        panelFiltrarBTN.setOpaque(false);
        panelFiltrarBTN.setBackground(new Color(60, 63, 65));
        btnFiltrar.setForeground(new Color(60, 63, 65));
    }//GEN-LAST:event_btnFiltrarMouseExited

    private void btnFiltrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFiltrarMouseEntered
        panelFiltrarBTN.setOpaque(true);
        panelFiltrarBTN.setBackground(new Color(60, 63, 65));
        btnFiltrar.setForeground(new Color(242, 242, 242));
    }//GEN-LAST:event_btnFiltrarMouseEntered

    /* - - - - - - - - - - - - - - - - Métodos de las opciones - - - - - - - - - - - - - - - - */
    //Método para el botón Manipulacion de Estudiantes.
    private void btnDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDatosMouseClicked
        ManipulacionEstudiantes opcion = new ManipulacionEstudiantes();
        
        //Cambia el titulo de la barra superior.
        Titulo.setText("Manipulación de Estudiantes");
            
        //Habilita el botón Atras.
        btnAtras.setEnabled(true);
        
        //Cambia la ventana a Ingresar Estudiantes.
        cambiarOpcion(opcion);
    }//GEN-LAST:event_btnDatosMouseClicked

    //Método del botón para Ingresar Promedios.
    private void btnPromediosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPromediosMouseClicked
        IngresarPromedios opcion = new IngresarPromedios();
        
        //Cambia el titulo de la barra superior.
        Titulo.setText("Ingresar o Editar Promedios");
            
        //Habilita el botón Atras.
        btnAtras.setEnabled(true);
        
        //Cambia la ventana a Ingresar Promedios.
        cambiarOpcion(opcion);
    }//GEN-LAST:event_btnPromediosMouseClicked

    //Método del botón para Ver Estudiantes.
    private void btnEstudiantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEstudiantesMouseClicked
        VerEstudiantes opcion = new VerEstudiantes();
        
        //Cambia el titulo de la barra superior.
        Titulo.setText("Lista de Estudiantes");
            
        //Habilita el botón Atras.
        btnAtras.setEnabled(true);
        
        //Cambia la ventana a Ver Estudiantes.
        cambiarOpcion(opcion);
    }//GEN-LAST:event_btnEstudiantesMouseClicked

    //Método del botón para Filtrar Promedios.
    private void btnFiltrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFiltrarMouseClicked
        FiltrarPromedios opcion = new FiltrarPromedios();
        
        //Cambia el titulo de la barra superior.
        Titulo.setText("Filtrar Promedios");
        
        //Habilita el botón Atras.
        btnAtras.setEnabled(true);
        
        //Cambia la ventana a Filtrar Promedios.
        cambiarOpcion(opcion);
    }//GEN-LAST:event_btnFiltrarMouseClicked

    //Main.
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo;
    private javax.swing.JPanel barraSuperior;
    private javax.swing.JLabel btnAtras;
    private javax.swing.JLabel btnDatos;
    private javax.swing.JLabel btnEstudiantes;
    private javax.swing.JLabel btnFiltrar;
    private javax.swing.JLabel btnPromedios;
    private javax.swing.JLabel btnSalir;
    private javax.swing.JPanel contenedorBTNS;
    private javax.swing.JPanel contenedorPrincipal;
    private javax.swing.JLabel imagen;
    private javax.swing.JPanel panelAtras;
    private javax.swing.JPanel panelDatosBTN;
    private javax.swing.JPanel panelEstudiantesBTN;
    private javax.swing.JPanel panelFiltrarBTN;
    private javax.swing.JPanel panelIMG;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelPromediosBTN;
    private javax.swing.JPanel panelSalir;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JLabel texto1;
    private javax.swing.JLabel texto2;
    // End of variables declaration//GEN-END:variables
}