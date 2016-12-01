package irrcyn.View;

import org.cytoscape.application.swing.CytoPanelComponent;
import org.cytoscape.application.swing.CytoPanelName;
import org.cytoscape.task.read.LoadNetworkFileTaskFactory;
import org.cytoscape.task.read.LoadTableFileTaskFactory;
import org.cytoscape.task.read.LoadVizmapFileTaskFactory;
import org.cytoscape.work.TaskManager;
import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements CytoPanelComponent {

    private JPanel mainpanel = new JPanel();

    private JPanel toptitlepanel = new JPanel();

    private JPanel toppanel = new JPanel();

    private JPanel middlepanel = new JPanel();

    private JPanel middletitlepanel = new JPanel();

    private JPanel bottompanel = new JPanel();

    private JPanel bottomtitlepanel = new JPanel();

    private JLabel numberonelabel = new JLabel();

    private JLabel numbertwolabel = new JLabel();

    private JLabel numberthreelabel = new JLabel();

    private JLabel inputfilenamelabel = new JLabel();

    private JLabel outputfilenamelabel = new JLabel();

    private JLabel expandcheckboxlabel = new JLabel();

    private JLabel affymetrixlabel = new JLabel("Affymetrix", SwingConstants.LEFT);

    private JLabel illuminalabel = new JLabel("Illumina", SwingConstants.LEFT);

    private JLabel sourcelabel = new JLabel();

    private JLabel targetlabel = new JLabel();

    private JLabel genelabel = new JLabel();

    private JLabel sigmollabel = new JLabel();

    private JLabel cytolabel = new JLabel();

    private JLabel emptylabel = new JLabel("          ");

    private JLabel includecomplexeslabel = new JLabel();

    private JTextField inputtextfield = new JTextField(20);

    private JTextField outputtextfield = new JTextField(20);

    private JTextField genesourcetextfield = new JTextField(20);

    private JTextField genetargettextfield = new JTextField(20);

    private JTextField sigmolsourcetextfield = new JTextField(20);

    private JTextField sigmoltargettextfield = new JTextField(20);
    
    private JTextField filterconvertsiftexfield = new JTextField(20);
    
    private JTextField filterconvertcsvtexfield = new JTextField(20);


    private JTextArea cytoidsourcetextarea = new JTextArea();

    private JTextArea cytoidtargettextarea = new JTextArea();

    private JScrollPane cytoidsourcescrollpane;

    private JScrollPane cytoidtargetscrollpane;

    private JButton browsebutton = new JButton("Browse");

    private JButton outputbutton = new JButton("Browse");

    private JButton convertbutton = new JButton("Convert to SIF");

    private JButton loadTableButton = new JButton("Load Table");

    private JButton loadStyleButton = new JButton("Load Style");

    private JButton choosebutton = new JButton("Choose");

    private JButton genesourcebrowsebutton = new JButton("Browse");

    private JButton genetargetbrowsebutton = new JButton("Browse");

    private JButton sigmolsourcebrowsebutton = new JButton("Browse");

    private JButton sigmoltargetbrowsebutton = new JButton("Browse");

    private JButton subgraphbutton = new JButton("Subgraph it!");

    private JButton checktoexpandhelpbutton = new JButton("?");

    private JButton step3helpbutton = new JButton("?");

    private JCheckBox expandcheckbox = new JCheckBox();

    private JCheckBox affymetrixcheckbox = new JCheckBox();

    private JCheckBox illuminacheckbox = new JCheckBox();

    private JCheckBox includecomplexescheckbox = new JCheckBox();

    private JCheckBox nodefiltertaskcheckbox = new JCheckBox();
    
    

    private JLabel message = new JLabel("");

    GridBagConstraints c = new GridBagConstraints();

    private String dir;

    public MainFrame(Controller controller, TaskManager tm, LoadNetworkFileTaskFactory ldn, LoadTableFileTaskFactory ldt, LoadVizmapFileTaskFactory lds) throws Exception {
        controller = new Controller(this, tm, ldn, ldt, lds);
        expandcheckboxlabel.setFont(new Font("Ariel", Font.ITALIC, 8));
        expandcheckboxlabel.setText("Check to expand");
        mainpanel.setLayout(new GridBagLayout());
        toptitlepanel.setLayout(new GridBagLayout());
        toppanel.setLayout(new GridBagLayout());
        middletitlepanel.setLayout(new GridBagLayout());
        middlepanel.setLayout(new GridBagLayout());
        bottomtitlepanel.setLayout(new GridBagLayout());
        bottompanel.setLayout(new GridBagLayout());
        numberonelabel.setText("Step 1: Generate Network from PID");
        numberonelabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30;
        c.ipadx = 20;
        c.weightx = 0.0;
        c.gridwidth = 4;
        c.gridx = 0;
        c.gridy = 0;
        toptitlepanel.add(numberonelabel, c);
        inputfilenamelabel.setText("Select input file (XML):");
        c.weightx = 0.5;
        c.gridwidth = 1;
        c.ipady = 5;
        c.ipadx = 5;
        c.gridx = 0;
        c.gridy = 0;
        toppanel.add(inputfilenamelabel, c);
        c.gridx = 1;
        c.gridy = 0;
        toppanel.add(inputtextfield, c);
        c.gridx = 2;
        c.gridy = 4;
        toppanel.add(convertbutton, c);
        convertbutton.setActionCommand("Convert");
        convertbutton.addActionListener(controller);
        c.gridx = 5;
        c.gridy = 0;
        toppanel.add(emptylabel, c);
        outputfilenamelabel.setText("Output path/file (optional):");
        c.gridx = 0;
        c.gridy = 1;
        c.ipady = 5;
        c.ipadx = 5;
        toppanel.add(outputfilenamelabel, c);
        c.gridx = 1;
        c.gridy = 1;
        toppanel.add(outputtextfield, c);
        c.gridx = 2;
        c.gridy = 0;
        toppanel.add(browsebutton, c);
        browsebutton.setActionCommand("Browse");
        browsebutton.addActionListener(controller);
        c.gridx = 2;
        c.gridy = 1;
        toppanel.add(outputbutton, c);
        outputbutton.setActionCommand("Output");
        outputbutton.addActionListener(controller);
        numbertwolabel.setText("Step 2: Overlap Microarray Data");
        numbertwolabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30;
        c.ipadx = 20;
        c.weightx = 0.0;
        c.gridwidth = 4;
        c.gridx = 0;
        c.gridy = 0;
        middletitlepanel.add(numbertwolabel, c);
        c.ipady = 0;
        c.ipadx = 0;
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 0;
        middlepanel.add(affymetrixcheckbox, c);
        c.gridx = 0;
        c.gridy = 1;
        middlepanel.add(illuminacheckbox, c);
        c.gridx = 1;
        c.gridy = 0;
        middlepanel.add(affymetrixlabel, c);
        c.gridx = 1;
        c.gridy = 1;
        middlepanel.add(illuminalabel, c);
        c.gridx = 1;
        c.gridy = 2;
        middlepanel.add(choosebutton, c);
        choosebutton.setActionCommand("Choose");
        choosebutton.addActionListener(controller);
        numberthreelabel.setText("Step 3: Subgraph Extraction");
        numberthreelabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30;
        c.ipadx = 20;
        c.weightx = 0.0;
        c.gridwidth = 4;
        c.gridx = 0;
        c.gridy = 0;
        bottomtitlepanel.add(numberthreelabel, c);
        c.ipadx = 0;
        c.ipady = 0;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 5;
        bottompanel.add(step3helpbutton, c);
        step3helpbutton.setActionCommand("Step3Help");
        step3helpbutton.addActionListener(controller);
        sourcelabel.setText("SOURCE");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 10;
        c.ipadx = 10;
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 0;
        bottompanel.add(sourcelabel, c);
        targetlabel.setText("TARGET");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 10;
        c.ipadx = 10;
        c.gridwidth = 2;
        c.gridx = 3;
        c.gridy = 0;
        bottompanel.add(targetlabel, c);
        genelabel.setText("Genes (UniProtID):");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 10;
        c.ipadx = 10;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        bottompanel.add(genelabel, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 10;
        c.ipadx = 10;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 1;
        c.ipadx = 10;
        c.ipady = 10;
        c.gridwidth = 1;
        c.gridx = 2;
        c.gridy = 1;
        genesourcebrowsebutton.setActionCommand("Gene Source Browse");
        genesourcebrowsebutton.addActionListener(controller);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 10;
        c.ipadx = 10;
        c.gridwidth = 1;
        c.gridx = 3;
        c.gridy = 1;
        bottompanel.add(genetargettextfield, c);
        c.ipadx = 10;
        c.ipady = 10;
        c.gridwidth = 1;
        c.gridx = 4;
        c.gridy = 1;
        bottompanel.add(genetargetbrowsebutton, c);
        genetargetbrowsebutton.setActionCommand("Gene Target Browse");
        genetargetbrowsebutton.addActionListener(controller);
        sigmollabel.setText("Signalling Molecules (UniProtID):");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 10;
        c.ipadx = 10;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 2;
        bottompanel.add(sigmollabel, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 10;
        c.ipadx = 10;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 2;
        bottompanel.add(sigmolsourcetextfield, c);
        c.ipadx = 10;
        c.ipady = 10;
        c.gridwidth = 1;
        c.gridx = 2;
        c.gridy = 2;
        bottompanel.add(sigmolsourcebrowsebutton, c);
        sigmolsourcebrowsebutton.setActionCommand("Sigmol Source Browse");
        sigmolsourcebrowsebutton.addActionListener(controller);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 10;
        c.ipadx = 10;
        c.gridwidth = 1;
        c.gridx = 3;
        c.gridy = 2;
        bottompanel.add(sigmoltargettextfield, c);
        c.ipadx = 10;
        c.ipady = 10;
        c.gridwidth = 1;
        c.gridx = 4;
        c.gridy = 2;
        bottompanel.add(sigmoltargetbrowsebutton, c);
        sigmoltargetbrowsebutton.setActionCommand("Sigmol Target Browse");
        sigmoltargetbrowsebutton.addActionListener(controller);
        includecomplexeslabel.setText("Please check here to include signalling molecules within nodes of protein complexes and protein families:");
        includecomplexeslabel.setFont(new Font("Ariel", Font.ITALIC, 9));
        c.ipady = 5;
        c.ipadx = 5;
        c.gridwidth = 3;
        c.gridx = 1;
        c.gridy = 3;
        bottompanel.add(includecomplexeslabel, c);
        c.ipady = 5;
        c.ipadx = 5;
        c.gridwidth = 2;
        c.gridx = 4;
        c.gridy = 3;
        bottompanel.add(includecomplexescheckbox, c);
        cytolabel.setText("Enter CytoIDs, one in each line:");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 10;
        c.ipadx = 10;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 4;
        bottompanel.add(cytolabel, c);
        cytoidsourcetextarea.setSize(7, 10);
        cytoidsourcescrollpane = new JScrollPane(cytoidsourcetextarea);
        c.ipady = 100;
        c.ipadx = 100;
        c.gridx = 1;
        c.gridy = 4;
        c.gridwidth = 2;
        bottompanel.add(cytoidsourcescrollpane, c);
        cytoidtargettextarea.setSize(7, 10);
        cytoidtargetscrollpane = new JScrollPane(cytoidtargettextarea);
        c.ipady = 100;
        c.ipadx = 100;
        c.gridx = 3;
        c.gridy = 4;
        c.gridwidth = 2;
        bottompanel.add(cytoidtargetscrollpane, c);
        c.gridwidth = 1;
        c.ipady = 10;
        c.ipadx = 10;
        c.gridx = 4;
        c.gridy = 5;
        bottompanel.add(subgraphbutton, c);
        subgraphbutton.setActionCommand("Subgraph");
        subgraphbutton.addActionListener(controller);
        c.ipady = 10;
        c.ipadx = 10;
        c.gridx = 0;
        c.gridy = 0;
        mainpanel.add(toptitlepanel, c);
        c.ipady = 10;
        c.ipadx = 10;
        c.gridx = 0;
        c.gridy = 1;
        mainpanel.add(toppanel, c);
        c.ipady = 10;
        c.ipadx = 10;
        c.gridx = 0;
        c.gridy = 2;
        mainpanel.add(new JSeparator(JSeparator.HORIZONTAL), c);
        c.ipady = 10;
        c.ipadx = 10;
        c.gridx = 0;
        c.gridy = 3;
        mainpanel.add(middletitlepanel, c);
        c.ipady = 10;
        c.ipadx = 10;
        c.gridx = 0;
        c.gridy = 4;
        mainpanel.add(middlepanel, c);
        c.ipady = 10;
        c.ipadx = 10;
        c.gridx = 0;
        c.gridy = 5;
        mainpanel.add(new JSeparator(JSeparator.HORIZONTAL), c);
        c.ipady = 10;
        c.ipadx = 10;
        c.gridx = 0;
        c.gridy = 6;
        mainpanel.add(bottomtitlepanel, c);
        c.ipady = 10;
        c.ipadx = 10;
        c.gridx = 0;
        c.gridy = 7;
        mainpanel.add(bottompanel, c);
        getContentPane().add(mainpanel);
        getContentPane().setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void isLoading() {
        convertbutton.setText("Conversion in progress...");
        convertbutton.setEnabled(false);
    }

    public void finishedLoading(String name) {
        convertbutton.setText("Convert");
        convertbutton.setEnabled(true);
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 2;
        if (name == "-PROBLEM-") {
            message.setText("Problem Occured");
            ;
            message.setForeground(new Color(160, 10, 30));
        } else {
            message.setText(name + ": Conversion successful to  : \n" + dir);
            message.setForeground(new Color(0, 130, 30));
        }
        toppanel.add(message, c);
    }

    public boolean isExpandChecked() {
        return expandcheckbox.isSelected();
    }

    public boolean isAffymetrixChecked() {
        return affymetrixcheckbox.isSelected();
    }

    public boolean isIlluminaChecked() {
        return illuminacheckbox.isSelected();
    }

    public boolean isIncludeComplexesChecked() {
        return includecomplexescheckbox.isSelected();
    }

    public String getInputTextfieldText() {
        return this.inputtextfield.getText();
    }

    public String getOutputTextfieldText() {
        return this.outputtextfield.getText();
    }

    public void setOutputTextfieldText(String s) {
        this.outputtextfield.setText(s);
    }

    public void setOutputFilenameLabelstring(String s) {
        outputfilenamelabel.setText(s);
    }

    public void setLabelstring(String s) {
        inputfilenamelabel.setText(s);
    }

    public String getTextFromTextArea() {
        return inputtextfield.getText();
    }

    public void setTextToOutputText(String outputText) {
        this.dir = outputText;
    }

    public JTextField getInputtext() {
        return inputtextfield;
    }

    public void setInputFileText(String inputtext) {
        this.inputtextfield.setText(inputtext);
    }

    public JTextArea getCytoidSourceTextArea() {
        return cytoidsourcetextarea;
    }

    public void setCytoidSourceTextAreaText(String cytoidsourcetextareatext) {
        this.cytoidsourcetextarea.setText(cytoidsourcetextareatext);
    }

    public JTextArea getCytoidTargetTextArea() {
        return cytoidtargettextarea;
    }

    public void setCytoidTargetTextAreaText(String arg) {
        this.cytoidtargettextarea.setText(arg);
    }

    public JTextField getGenesourcetextfield() {
        return genesourcetextfield;
    }

    public void setGenesourcetextfieldText(String arg) {
        this.genesourcetextfield.setText(arg);
    }

    public JTextField getGenetargettextfield() {
        return genetargettextfield;
    }

    public void setGenetargettextfieldText(String arg) {
        this.genetargettextfield.setText(arg);
    }

    public JTextField getSigmolsourcetextfield() {
        return sigmolsourcetextfield;
    }

    public void setSigmolsourcetextfieldText(String arg) {
        this.sigmolsourcetextfield.setText(arg);
    }

    public JTextField getSigmoltargettextfield() {
        return sigmoltargettextfield;
    }

    public void setSigmoltargettextfieldText(String arg) {
        this.sigmoltargettextfield.setText(arg);
    }

    public JButton getLoadTableButton() {
        return loadTableButton;
    }

    public JButton getLoadStyleButton() {
        return loadStyleButton;
    }

    @Override
    public Component getComponent() {
        return null;
    }

    @Override
    public CytoPanelName getCytoPanelName() {
        return CytoPanelName.EAST;
    }

    @Override
    public Icon getIcon() {
        return null;
    }

    public JCheckBox getNodefiltertaskcheckbox() {
        return nodefiltertaskcheckbox;
    }

    public void setNodefiltertaskcheckbox(JCheckBox nodefiltertaskcheckbox) {
        this.nodefiltertaskcheckbox = nodefiltertaskcheckbox;
    }
}
