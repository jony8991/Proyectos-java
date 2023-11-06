/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberito.vistas;

import bomberito.accesoADatos.BrigadaData;
import bomberito.accesoADatos.CuartelData;
import bomberito.accesoADatos.SiniestroData;
import bomberito.entidades.Brigada;
import bomberito.entidades.Cuartel;
import bomberito.entidades.Siniestro;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Melina
 */
public class AsignarBrigadaASiniestro extends javax.swing.JInternalFrame {
    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
    
    SiniestroData controlSin=null;
    CuartelData controlCuar=null;
    BrigadaData controlBri=null;
    
    /**
     * Creates new form AsignarBrigadaASiniestro
     */
    public AsignarBrigadaASiniestro() {
        initComponents();
        controlSin=new SiniestroData();
        controlCuar=new CuartelData();
        controlBri=new BrigadaData();
        modelo=new DefaultTableModel();
        
        armarCabeceraTabla();
        cargarTabla();
        cargarComboCuartel();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JCBXCuartel = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        JCBXBrig = new javax.swing.JComboBox<>();
        JBoton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTabla = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        BotonCalcularDis = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jLabel6.setText("jLabel6");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 51));
        jLabel1.setText("Asignar brigada al Siniestro");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Siniestros");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Cuartel:");

        JCBXCuartel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBXCuartelActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Brigada:");

        JBoton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        JBoton.setForeground(new java.awt.Color(0, 204, 204));
        JBoton.setText("MANDAR BRIGADA");
        JBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBotonActionPerformed(evt);
            }
        });

        JTabla = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        JTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        JTabla.getTableHeader().setResizingAllowed(false);
        JTabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(JTabla);

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        BotonCalcularDis.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        BotonCalcularDis.setText("Distancia:");
        BotonCalcularDis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCalcularDisActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(255, 51, 51));
        jLabel7.setText("Cuartel más cercana.");
        jLabel7.setToolTipText("");

        jLabel8.setText("Distancia de Cuartel seleccionada");

        jLabel5.setText("Brigada del Cuartel mas cercano");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(212, 212, 212)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(304, 304, 304)
                                .addComponent(jLabel2)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(74, 74, 74)
                                        .addComponent(JCBXCuartel, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JCBXBrig, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JBoton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BotonCalcularDis)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                                        .addGap(126, 126, 126)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 164, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(69, 69, 69)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(JCBXBrig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(JCBXCuartel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBoton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotonCalcularDis)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5))))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBotonActionPerformed
        try{

        Brigada codBrigada = (Brigada) JCBXBrig.getSelectedItem();
        int sinSelec =JTabla.getSelectedRow();
        int idSiniestro= (Integer)JTabla.getValueAt(sinSelec, 0);
        Siniestro nuevo= new Siniestro(codBrigada,idSiniestro);
        controlSin.AsignarBrigada(nuevo);

        boolean libre=false;
        int idBrigada = codBrigada.getIdBrigada();

        controlSin.actualizarBrigada(idBrigada,libre);  
       
        actualizarTabla();
              
        }catch(NullPointerException npe){
            JOptionPane.showMessageDialog(null, "Selecciona ambos Cuartel y Brigada.", "Error", JOptionPane.ERROR_MESSAGE);
        }catch(ArrayIndexOutOfBoundsException a){
            JOptionPane.showMessageDialog(null, "Seleccione un siniestro a asignar","Error",JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_JBotonActionPerformed

    private void JCBXCuartelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBXCuartelActionPerformed
        Cuartel cuartelselec = (Cuartel) JCBXCuartel.getSelectedItem();
        int idCuartel = cuartelselec.getIdCuartel();
        int sinSelec = JTabla.getSelectedRow();
        if (sinSelec >= 0) {
            String sintipo = (String) JTabla.getValueAt(sinSelec, 2);
            JCBXBrig.removeAllItems();
            for (Brigada brgda : controlBri.traerBrigadas()) {
                if (brgda.getNroCuartel().getIdCuartel() == idCuartel && brgda.getEspecialidad().contains(sintipo) && brgda.isLibre()) {
                    JCBXBrig.addItem(brgda);
                }
            }
        }      
    }//GEN-LAST:event_JCBXCuartelActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BotonCalcularDisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCalcularDisActionPerformed
        jLabel7.setText("");
        try {

            int filaSelec = JTabla.getSelectedRow();
            Cuartel cuartelSelec = (Cuartel) JCBXCuartel.getSelectedItem();
            double distanciaMinima = Double.MAX_VALUE;
            double distancia = 0;
            Cuartel cuartelMasCercano = null;
            int sinX = (Integer) JTabla.getValueAt(filaSelec, 3);
            int sinY = (Integer) JTabla.getValueAt(filaSelec, 4);
            int cuarX = cuartelSelec.getCoordX();
            int cuarY = cuartelSelec.getCoordY();
            double distanciaCuartelSelec = calcularDistancia(sinX, sinY, cuarX, cuarY);

            for (Cuartel cuartel : controlCuar.traerCuarteles()) {
                int cuarX2 = cuartel.getCoordX();
                int cuarY2 = cuartel.getCoordY();
                
                distancia = calcularDistancia(sinX, sinY, cuarX2, cuarY2);
                
                if (distancia < distanciaMinima) {
                    distanciaMinima = distancia;
                    cuartelMasCercano = cuartel;
                    
                    
                    }
                int idCuartelMasCercano = cuartelMasCercano.getIdCuartel();
                String sinTipo = JTabla.getValueAt(filaSelec,2).toString();
                

                for (Brigada bri : controlBri.traerBrigadas()){
                    if(bri.getNroCuartel().getIdCuartel() == idCuartelMasCercano && bri.isLibre() && bri.getEspecialidad().contains(sinTipo)){
                        jLabel5.setText("Brigada recomendad: "+bri.getNombreBrigada());
                    }
                }
            }

            if (cuartelMasCercano != null ) {
                DecimalFormat df = new DecimalFormat("0.00");
                String disEn2Decimales = df.format(distanciaMinima);

                jLabel7.setText("Cuartel mas cercano " + cuartelMasCercano.getNombreCuartel() + ": " + disEn2Decimales);
            } else {
                jLabel7.setText("No hay cuarteles disponibles para calcular la distancia.");
            }
                DecimalFormat df = new DecimalFormat("0.00");
                String disEn2Decimales = df.format(distanciaCuartelSelec);
            jLabel8.setText("Distancia con el cuartel seleccionado: " + cuartelSelec + ": " + disEn2Decimales);

        } catch (ArrayIndexOutOfBoundsException e) {
            jLabel7.setText("Error: Selecciona una fila válida en la tabla.");
        }

    }//GEN-LAST:event_BotonCalcularDisActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonCalcularDis;
    private javax.swing.JButton JBoton;
    private javax.swing.JComboBox<Brigada> JCBXBrig;
    private javax.swing.JComboBox<Cuartel> JCBXCuartel;
    private javax.swing.JTable JTabla;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    private void armarCabeceraTabla(){
      modelo.addColumn("ID");
      modelo.addColumn("Fecha");
      modelo.addColumn("Tipo");
      modelo.addColumn("X");
      modelo.addColumn("Y");
      modelo.addColumn("Detalles");
      JTabla.setModel(modelo);
      
      JTabla.setAutoResizeMode(JTabla.AUTO_RESIZE_OFF);
      JTabla.getColumnModel().getColumn(0).setPreferredWidth(17);
      JTabla.getColumnModel().getColumn(1).setPreferredWidth(67);
      JTabla.getColumnModel().getColumn(2).setPreferredWidth(330);
      JTabla.getColumnModel().getColumn(3).setPreferredWidth(25);
      JTabla.getColumnModel().getColumn(4).setPreferredWidth(25);
      JTabla.getColumnModel().getColumn(5).setPreferredWidth(330);

      
    }

    private void cargarTabla(){
        for(Siniestro cosa: controlSin.traerSiniestrosParaAsignar()){
            modelo.addRow(new Object[]{
                cosa.getIdSiniestro(),
                cosa.getFechaSiniestro(),
                cosa.getTipo(),
                cosa.getCoordX(),
                cosa.getCoordY(),
                cosa.getDetalles()
            });
        }
    }
 
    private void cargarComboCuartel(){
        for(Cuartel ctl: controlCuar.traerCuarteles()){
            JCBXCuartel.addItem(ctl);
        }
    }
    
    private void actualizarTabla() {
        modelo.setRowCount(0);
        cargarTabla();
    }
    
    public double calcularDistancia(int x1, int y1,int x2,int y2){
        double distancia= Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return distancia;
        
    }
    
    
}