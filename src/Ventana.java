import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import javax.swing.text.DefaultEditorKit;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class Ventana extends JFrame implements ItemListener, ActionListener {

    JMenuBar barraMenu;
    JMenu menuArchivo, menuEdicion, menuEstiloFuente;
    JMenuItem itemNuevo, itemAbrir, itemCerrar, itemGuardar, itemGuardarComo, itemImprimir, itemCopiar, itemCortar,
            itemPegar, itemBold, itemNormal, itemCursiva, itemCopiarPop, itemCortarPop, itemPegarPop, itemNormalPop, itemBoldPop, itemCursivaPop;
    JButton btnNuevo, btnAbrir, btnGuardar, btnImprimir, btnCopiar, btnCortar, btnPegar, btnBold;
    JLabel labelTamanio, labeLetra;
    JComboBox comboTamanio, comboLetra;
    DefaultComboBoxModel modeloTamanio, modeloLetra;
    JTextArea textArea;
    JFileChooser fileChooser;
    JPopupMenu popupMenu;
    JPanel panelSuperior, panelCentro;

    public void initGUI(){
        instancias();
        configurarMenu();
        configurarPanel();
        configurararPopup();
        rellenarLetras();
        rellenarTamanio();
        acciones();
        this.setSize(new Dimension(900,900));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Microsoft Word 2020®");
        this.setVisible(true);
    }

    private void instancias() {
        barraMenu = new JMenuBar();
        menuArchivo = new JMenu("Archivo");
        menuEdicion = new JMenu("Edición");
        menuEstiloFuente = new JMenu("Estilo de la fuente");
        itemNuevo = new JMenuItem("Nuevo");
        itemNuevo.setIcon(new ImageIcon(getClass().getResource("/recursos/new.png")));
        itemAbrir = new JMenuItem("Abrir");
        itemAbrir.setIcon(new ImageIcon(getClass().getResource("/recursos/open.png")));
        itemCerrar = new JMenuItem("Cerrar");
        itemCerrar.setIcon(new ImageIcon(getClass().getResource("/recursos/close.png")));
        itemGuardar = new JMenuItem("Guardar");
        itemGuardar.setIcon(new ImageIcon(getClass().getResource("/recursos/save.png")));
        itemGuardarComo = new JMenuItem("Guardar como...");
        itemGuardarComo.setIcon(new ImageIcon(getClass().getResource("/recursos/saveAs.png")));
        itemImprimir = new JMenuItem("Imprimir");
        itemImprimir.setIcon(new ImageIcon(getClass().getResource("/recursos/print.png")));
        itemCopiar = new JMenuItem(new DefaultEditorKit.CopyAction());
        itemCopiar.setText("Copiar");
        itemCopiar.setIcon(new ImageIcon(getClass().getResource("/recursos/copy.png")));
        itemCopiarPop = new JMenuItem(new DefaultEditorKit.CopyAction());
        itemCopiarPop.setText("Copiar");
        itemCopiarPop.setIcon(new ImageIcon(getClass().getResource("/recursos/copy.png")));
        itemCortar = new JMenuItem(new DefaultEditorKit.CutAction());
        itemCortar.setText("Cortar");
        itemCortar.setIcon(new ImageIcon(getClass().getResource("/recursos/cut.png")));
        itemCortarPop = new JMenuItem(new DefaultEditorKit.CutAction());
        itemCortarPop.setText("Cortar");
        itemCortarPop.setIcon(new ImageIcon(getClass().getResource("/recursos/cut.png")));
        itemPegar = new JMenuItem(new DefaultEditorKit.PasteAction());
        itemPegar.setText("Pegar");
        itemPegar.setIcon(new ImageIcon(getClass().getResource("/recursos/paste.png")));
        itemPegarPop = new JMenuItem(new DefaultEditorKit.PasteAction());
        itemPegarPop.setText("Pegar");
        itemPegarPop.setIcon(new ImageIcon(getClass().getResource("/recursos/paste.png")));
        itemBold = new JMenuItem("Bold");
        itemBold.setIcon(new ImageIcon(getClass().getResource("/recursos/bold.png")));
        itemBoldPop = new JMenuItem("Bold");
        itemBoldPop.setIcon(new ImageIcon(getClass().getResource("/recursos/bold.png")));
        itemNormal = new JMenuItem("Normal");
        itemNormal.setIcon(new ImageIcon(getClass().getResource("/recursos/normal.png")));
        itemNormalPop = new JMenuItem("Normal");
        itemNormalPop.setIcon(new ImageIcon(getClass().getResource("/recursos/normal.png")));
        itemCursiva = new JMenuItem("Cursiva");
        itemCursiva.setIcon(new ImageIcon(getClass().getResource("/recursos/italic.png")));
        itemCursivaPop = new JMenuItem("Cursiva");
        itemCursivaPop.setIcon(new ImageIcon(getClass().getResource("/recursos/italic.png")));
        btnNuevo = new JButton();
        btnNuevo.setIcon(new ImageIcon(getClass().getResource("/recursos/new.png")));
        btnAbrir = new JButton();
        btnAbrir.setIcon(new ImageIcon(getClass().getResource("/recursos/open.png")));
        btnGuardar = new JButton();
        btnGuardar.setIcon(new ImageIcon(getClass().getResource("/recursos/save.png")));
        btnImprimir = new JButton();
        btnImprimir.setIcon(new ImageIcon(getClass().getResource("/recursos/print.png")));
        btnCopiar = new JButton(new DefaultEditorKit.CopyAction());
        btnCopiar.setText("");
        btnCopiar.setIcon(new ImageIcon(getClass().getResource("/recursos/copy.png")));
        btnCortar = new JButton(new DefaultEditorKit.CutAction());
        btnCortar.setText("");
        btnCortar.setIcon(new ImageIcon(getClass().getResource("/recursos/cut.png")));
        btnPegar = new JButton(new DefaultEditorKit.PasteAction());
        btnPegar.setText("");
        btnPegar.setIcon(new ImageIcon(getClass().getResource("/recursos/paste.png")));
        btnBold = new JButton();
        btnBold.setIcon(new ImageIcon(getClass().getResource("/recursos/bold.png")));
        labelTamanio = new JLabel("Tamaño de letra");
        labeLetra = new JLabel("Tipo de letra");
        modeloLetra = new DefaultComboBoxModel();
        modeloTamanio = new DefaultComboBoxModel();
        comboLetra = new JComboBox(modeloLetra);
        comboTamanio = new JComboBox(modeloTamanio);
        textArea = new JTextArea();
        fileChooser = new JFileChooser();
        popupMenu = new JPopupMenu();
        panelSuperior = new JPanel();
        panelCentro = new JPanel();
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    }

    private void configurarMenu() {
        barraMenu.add(menuArchivo);
        barraMenu.add(menuEdicion);
        menuArchivo.add(itemNuevo);
        menuArchivo.add(itemAbrir);
        menuArchivo.add(itemCerrar);
        menuArchivo.add(itemGuardar);
        menuArchivo.add(itemGuardarComo);
        menuArchivo.addSeparator();
        menuArchivo.add(itemImprimir);
        menuEdicion.add(itemCopiar);
        menuEdicion.add(itemCortar);
        menuEdicion.add(itemPegar);
        menuEdicion.addSeparator();
        menuEdicion.add(menuEstiloFuente);
        menuEstiloFuente.add(itemBold);
        menuEstiloFuente.add(itemNormal);
        menuEstiloFuente.add(itemCursiva);
        this.setJMenuBar(barraMenu);
    }

    private void configurarPanel() {
        this.setLayout(new BorderLayout());
        this.add(configurarSuperior(),BorderLayout.NORTH);
        this.add(textArea,BorderLayout.CENTER);
    }

    private JPanel configurarSuperior() {
        panelSuperior.setLayout(new GridBagLayout());
        configurarConstrait(0,0,1,1,0,0.2,GridBagConstraints.CENTER, GridBagConstraints.BOTH,btnNuevo);
        configurarConstrait(1,0,1,1,0,0.2,GridBagConstraints.CENTER, GridBagConstraints.BOTH,btnAbrir);
        configurarConstrait(2,0,1,1,0,0.2,GridBagConstraints.CENTER, GridBagConstraints.BOTH,btnGuardar);
        configurarConstrait(3,0,1,1,0,0.2,GridBagConstraints.CENTER, GridBagConstraints.BOTH,btnImprimir);
        configurarConstrait(4,0,1,1,0,0.2,GridBagConstraints.CENTER, GridBagConstraints.BOTH,btnCopiar);
        configurarConstrait(5,0,1,1,0,0.2,GridBagConstraints.CENTER, GridBagConstraints.BOTH,btnCortar);
        configurarConstrait(6,0,1,1,0,0.2,GridBagConstraints.CENTER, GridBagConstraints.BOTH,btnPegar);
        configurarConstrait(7,0,1,1,0,0.2,GridBagConstraints.CENTER, GridBagConstraints.BOTH,btnBold);
        configurarConstrait(8,0,1,1,0,0.2,GridBagConstraints.CENTER, GridBagConstraints.BOTH,labeLetra);
        configurarConstrait(9,0,1,1,0,0.2,GridBagConstraints.CENTER, GridBagConstraints.BOTH,comboLetra);
        configurarConstrait(10,0,1,1,0,0.2,GridBagConstraints.CENTER, GridBagConstraints.BOTH,labelTamanio);
        configurarConstrait(11,0,1,1,0,0.2,GridBagConstraints.CENTER, GridBagConstraints.BOTH,comboTamanio);
        return panelSuperior;
    }

    private void configurarConstrait(int x, int y, int tx, int ty, int px, double py, int anchor, int fill, Component c){
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = tx;
        constraints.gridheight = ty;
        constraints.weightx = px;
        constraints.weighty = py;
        constraints.anchor = anchor;
        constraints.fill = fill;
        panelSuperior.add(c,constraints);
    }

    private void configurararPopup() {
        popupMenu.add(itemCopiarPop);
        popupMenu.add(itemCortarPop);
        popupMenu.add(itemPegarPop);
        popupMenu.addSeparator();
        popupMenu.add(itemNormalPop);
        popupMenu.add(itemBoldPop);
        popupMenu.add(itemCursivaPop);
        textArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton()==MouseEvent.BUTTON3){
                    popupMenu.show(textArea,e.getX(),e.getY());
                    setVisible(true);
                }
            }
        });
    }

    private void rellenarLetras() {
        Font[] fuentes = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getAllFonts();

        for (Font item : fuentes) {

            modeloLetra.addElement(item.getName());
        }
    }

    private void cambiarLetras() {
        Font fuente = new Font((String) modeloLetra.getSelectedItem(),
                comboTamanio.getSelectedIndex(),
                (int) modeloTamanio.getSelectedItem());
            textArea.setFont(fuente);
    }

    private void rellenarTamanio() {
        for (int i = 8; i <= 50; i++) {
            modeloTamanio.addElement(i);
        }
    }

    private void acciones() {
        btnAbrir.addActionListener(this);
        btnGuardar.addActionListener(this);
        btnNuevo.addActionListener(this);
        btnBold.addActionListener(this);
        itemNuevo.addActionListener(this);
        itemAbrir.addActionListener(this);
        itemGuardar.addActionListener(this);
        itemGuardarComo.addActionListener(this);
        itemNormal.addActionListener(this);
        itemBold.addActionListener(this);
        itemCursiva.addActionListener(this);
        itemNormalPop.addActionListener(this);
        itemBoldPop.addActionListener(this);
        itemCursivaPop.addActionListener(this);
        comboLetra.addItemListener(this);
        comboTamanio.addItemListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNuevo) {
            textArea.setText("");
        } else if (e.getSource() == itemNuevo) {
            textArea.setText("");
        } else if (e.getSource() == btnAbrir) {
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION);
        } else if (e.getSource() == itemAbrir) {
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION);
        } else if (e.getSource() == itemCerrar) {
            setVisible(false);
        } else if (e.getSource() == btnGuardar) {
            int returnValue = fileChooser.showSaveDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION);
        } else if (e.getSource() == itemGuardar) {
            int returnValue = fileChooser.showSaveDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION);
        } else if (e.getSource() == itemGuardarComo) {
            int returnValue = fileChooser.showSaveDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION);
        } else if (e.getSource() == btnBold) {
            textArea.setFont(textArea.getFont().deriveFont(Font.BOLD, textArea.getFont().getSize()));
        } else if (e.getSource() == itemBold) {
            textArea.setFont(textArea.getFont().deriveFont(Font.BOLD, textArea.getFont().getSize()));
        } else if (e.getSource() == itemNormal) {
            textArea.setFont(textArea.getFont().deriveFont(Font.PLAIN, textArea.getFont().getSize()));
        } else if (e.getSource() == itemCursiva) {
            textArea.setFont(textArea.getFont().deriveFont(Font.ITALIC, textArea.getFont().getSize()));
        } else if (e.getSource() == itemBoldPop) {
            textArea.setFont(textArea.getFont().deriveFont(Font.BOLD, textArea.getFont().getSize()));
        } else if (e.getSource() == itemNormalPop) {
            textArea.setFont(textArea.getFont().deriveFont(Font.PLAIN, textArea.getFont().getSize()));
        } else if (e.getSource() == itemCursivaPop) {
            textArea.setFont(textArea.getFont().deriveFont(Font.ITALIC, textArea.getFont().getSize()));
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == comboLetra) {
            cambiarLetras();
        } else if (e.getSource() == comboTamanio) {
            cambiarLetras();
        }
    }
}
