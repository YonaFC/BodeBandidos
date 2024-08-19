/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views.mantenimientos;
import Controller.RandomAccesFile.ProductAccesFile;
import Views.DashboardInterface;
import java.awt.Color;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Clientes;
import model.Product;

/**
 *
 * @author Carlos Fabricio
 */
public class ProductPanel extends javax.swing.JPanel {

    private DashboardInterface dashboardInterface;
    DefaultTableModel model;
    private ArrayList<Product> array;
    private TableRowSorter<DefaultTableModel> rowSorter;
    ProductAccesFile file;
    
    /**
     * Creates new form ProductPanel
     */
    public ProductPanel(DashboardInterface dashboardInterface) {
        initComponents();
        
        this.dashboardInterface = dashboardInterface;
                
        model = new DefaultTableModel();    
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Categoria");
        model.addColumn("Marca");
        model.addColumn("Precio");
        model.addColumn("Fecha de actualización");
        model.addColumn("Fecha de creación");
        
        tblProductBox.setModel(model);
        rowSorter = new TableRowSorter<>(model);
        tblProductBox.setRowSorter(rowSorter);
        file = new ProductAccesFile();

        loadProductsInTable();
        
          tblProductBox.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = tblProductBox.getSelectedRow();
                if (selectedRow >= 0) {
                    txtName.setText(tblProductBox.getValueAt(selectedRow, 1).toString());
                    txtCategory.setText(tblProductBox.getValueAt(selectedRow, 2).toString());
                    txtBrand.setText(tblProductBox.getValueAt(selectedRow, 3).toString());
                    txtPrice.setText(tblProductBox.getValueAt(selectedRow, 4).toString());
                }
            }
        });
        
        txtProductName.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                applyFilter();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                applyFilter();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                applyFilter();
            }

            private void applyFilter() {
                String text = txtProductName.getText();
                if (text.trim().isEmpty()) {
                    rowSorter.setRowFilter(null);
                    btnClearSearch.setBackground(null);
                    btnClearSearch.setForeground(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 1));
                    btnClearSearch.setBackground(Color.RED);
                    btnClearSearch.setForeground(Color.WHITE);
                    tblProductBox.clearSelection();
                }
            }
            }); 
        
        }
    
    private void loadProductsInTable(){
        try {
            file.openFile("product.dat");
            array = file.getProductList();

            model.setRowCount(0);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

            for (Product product : array) {
                Object[] row = {
                    product.getId(),
                    product.getName(),
                    product.getCategory(),
                    product.getMark(),
                    product.getPrice(),
                    product.getUpdatedAt().format(formatter),
                    product.getCreatedAt().format(formatter),
                };
                model.addRow(row);
            }

        file.closeFile();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void cleanFields() {
        txtName.setText("");
        txtCategory.setText("");
        txtBrand.setText("");
        txtPrice.setText("");
    }  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnEliminar1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtPrice = new javax.swing.JTextField();
        BtnEditar = new javax.swing.JButton();
        BtnCrear = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        txtCategory = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtProductName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnClearSearch = new javax.swing.JButton();
        txtBrand = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductBox = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        btnReturn = new javax.swing.JButton();

        BtnEliminar1.setBackground(new java.awt.Color(255, 0, 0));
        BtnEliminar1.setText("Eliminar");
        BtnEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminar1ActionPerformed(evt);
            }
        });

        setPreferredSize(new java.awt.Dimension(680, 400));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setAutoscrolls(true);
        jPanel1.setMinimumSize(new java.awt.Dimension(700, 400));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 400));

        BtnEditar.setBackground(new java.awt.Color(255, 0, 0));
        BtnEditar.setText("Editar");
        BtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditarActionPerformed(evt);
            }
        });

        BtnCrear.setBackground(new java.awt.Color(255, 0, 0));
        BtnCrear.setText("Crear");
        BtnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCrearActionPerformed(evt);
            }
        });

        BtnEliminar.setBackground(new java.awt.Color(255, 0, 0));
        BtnEliminar.setText("Eliminar");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        txtCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCategoryActionPerformed(evt);
            }
        });

        jLabel2.setText("Categoria");

        jLabel1.setText("Nombre:");

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel5.setText("Productos");

        txtProductName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductNameActionPerformed(evt);
            }
        });

        jLabel3.setText("Marca");

        btnClearSearch.setBackground(new java.awt.Color(255, 0, 0));
        btnClearSearch.setText("Clean filters");
        btnClearSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearSearchActionPerformed(evt);
            }
        });

        tblProductBox.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Categoria", "Marca", "Precio", "Fecha de actualización", "Fecha de creación"
            }
        ));
        jScrollPane1.setViewportView(tblProductBox);

        jLabel4.setText("Precio");

        btnReturn.setBackground(new java.awt.Color(255, 0, 0));
        btnReturn.setText("Regresar");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                        .addGap(518, 518, 518))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BtnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(111, 111, 111))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(125, 125, 125))
                            .addComponent(txtBrand, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCategory, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(125, 125, 125))
                            .addComponent(txtPrice, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(245, 245, 245))
                            .addComponent(BtnCrear, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtProductName, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                        .addGap(12, 12, 12)
                                        .addComponent(btnClearSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(173, 173, 173)
                                .addComponent(BtnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(45, 45, 45))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnReturn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6)
                        .addComponent(txtName)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6)
                        .addComponent(txtCategory)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6)
                        .addComponent(txtBrand)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6)
                        .addComponent(txtPrice)
                        .addGap(28, 28, 28)
                        .addComponent(BtnCrear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnClearSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditarActionPerformed
        int fila = tblProductBox.getSelectedRow();
        
        if (fila >= 0) {
            
            String name = txtName.getText();
            String category = txtCategory.getText();
            String brand = txtBrand.getText();
            String price = txtPrice.getText();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

            try {
                int idInt = Integer.parseInt(tblProductBox.getValueAt(fila, 0).toString());
                double db_price = Double.parseDouble(price);
                
                LocalDate fechaActualizacionLocalDate = LocalDate.now();

                Product product = array.get(fila);
                product.setId(idInt);
                product.setName(name);
                product.setCategory(category);
                product.setMark(brand);
                product.setPrice(db_price);
                product.setUpdatedAt(fechaActualizacionLocalDate);
                
                file.openFile("product.dat");
                file.updateProductById(idInt,product);
                file.closeFile();  

                loadProductsInTable();
                cleanFields();

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Error: Uno o más campos no son números enteros válidos.", "Error de conversión", JOptionPane.ERROR_MESSAGE);
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(this, "Error: El formato de fecha no es válido.", "Error de formato de fecha", JOptionPane.ERROR_MESSAGE);
            }
            catch(IOException e)
            {
                JOptionPane.showMessageDialog(null,"No se pudo actualizar");
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ninguna fila para editar.", "Error de selección", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BtnEditarActionPerformed

    private void BtnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCrearActionPerformed

        String nombre = txtName.getText();
        String category = txtCategory.getText();
        String brand = txtBrand.getText();
        String price = txtPrice.getText();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-mm-yyyy");
        
        try {
            file.openFile("product.dat");
            
            int idInt = file.newId();
            double db_price = Double.parseDouble(price);
            
            LocalDate updatedAt = LocalDate.now();
            LocalDate createdAt = LocalDate.now();
            
            Product product = new Product(idInt, nombre, category, brand, db_price, updatedAt, createdAt);
            
            file.addProduct(product);
            file.closeFile();
            
            DefaultTableModel model = (DefaultTableModel) tblProductBox.getModel();
            loadProductsInTable();
            cleanFields();
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error: Uno o más campos no son números enteros válidos.", "Error de conversión", JOptionPane.ERROR_MESSAGE);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Error: El formato de fecha no es válido.", "Error de formato de fecha", JOptionPane.ERROR_MESSAGE);
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"No se pudo grabar en el archivo");
        }
        
    }//GEN-LAST:event_BtnCrearActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        int fila = tblProductBox.getSelectedRow();
        if(fila >= 0) {
            int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el producto seleccionado?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            try{
                                
                int id = Integer.parseInt(tblProductBox.getValueAt(fila, 0).toString());
                
                file.openFile("product.dat");
                file.deleteProductById(id);
                file.closeFile();  
                
                loadProductsInTable();
                cleanFields();
            }
            catch(IOException e)
            {
                JOptionPane.showMessageDialog(null,"No se pudo eliminar el producto.");
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Por favor seleccione una fila para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void txtCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCategoryActionPerformed

    private void txtProductNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductNameActionPerformed

    private void btnClearSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearSearchActionPerformed
        txtProductName.setText("");
        btnClearSearch.setBackground(null);
        btnClearSearch.setForeground(null);
        rowSorter.setRowFilter(null);

    }//GEN-LAST:event_btnClearSearchActionPerformed

    private void BtnEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminar1ActionPerformed
        
    }//GEN-LAST:event_BtnEliminar1ActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        dashboardInterface.switchPanel("Mantenimientos");
    }//GEN-LAST:event_btnReturnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCrear;
    private javax.swing.JButton BtnEditar;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnEliminar1;
    private javax.swing.JButton btnClearSearch;
    private javax.swing.JButton btnReturn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProductBox;
    private javax.swing.JTextField txtBrand;
    private javax.swing.JTextField txtCategory;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtProductName;
    // End of variables declaration//GEN-END:variables
}
