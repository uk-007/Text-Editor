import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextEditor extends JFrame implements ActionListener{

    JTextArea textArea;

    JScrollPane scene;

    JLabel fontlabel;

    JSpinner font_size_spinner;

    JComboBox fontstylebox;

    JMenuBar menubar;

    JMenu file;

    JMenuItem save;

    JMenuItem exit;

    TextEditor(){
        this.setTitle("Text Editor");
        this.setSize(500,500);
        this.setLayout(new FlowLayout());

        //working on text area
        textArea = new JTextArea();
        textArea.setFont(new Font("Arial",Font.PLAIN, 25));

        //work on scrolling pane
        scene = new JScrollPane(textArea);
        scene.setPreferredSize(new Dimension(400,400));
        scene.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        //adding font label in text bar
        fontlabel = new JLabel("Font : ");

        //add font size spinner
        font_size_spinner = new JSpinner();
        font_size_spinner.setPreferredSize(new Dimension(40,30));
        font_size_spinner.setValue(20);
        font_size_spinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                textArea.setFont(new Font(textArea.getFont().getFamily(),Font.PLAIN,(int)font_size_spinner.getValue()));
            }
        });

        //adding font family box
        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        fontstylebox = new JComboBox(fonts);
        fontstylebox.setSelectedItem("Arial");

        fontstylebox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setFont(new Font((String) fontstylebox.getSelectedItem(), Font.PLAIN, (int) font_size_spinner.getValue()));
            }
        });

        // Let's start with the menu bar
        menubar = new JMenuBar();
        file = new JMenu("File");
        save = new JMenuItem("Save");
        exit = new JMenuItem("Exit");

        save.addActionListener(this);
        exit.addActionListener(this);

        // add save and exit option into the file.
        file.add(save);
        file.add(exit);

        // add this file menu to the menubar.
        menubar.add(file);

        // adding all the components into the stage.
        this.setJMenuBar(menubar);
        this.add(fontlabel);
        this.add(font_size_spinner);
        this.add(fontstylebox);
        this.add(scene);

        // we need to set the stage to visible to actually see it.
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }
}
