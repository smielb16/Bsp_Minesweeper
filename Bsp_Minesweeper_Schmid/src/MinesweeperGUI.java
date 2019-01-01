
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class MinesweeperGUI extends JFrame {

    private JLabel[][] labelArr;
    private int initRowColSize;
    private int amountBombs;
    private Mode mode = Mode.BEGINNER;
    private MinesweeperBL minesweeperbl;

    public MinesweeperGUI() {
        super("VierGewinnt");
        evaluateMode(mode);
        minesweeperbl = new MinesweeperBL(initRowColSize, amountBombs);
        initComponents();
        this.setSize(1000, 1000);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MinesweeperGUI().setVisible(true);
    }

    private void initComponents() {
        labelArr = new JLabel[initRowColSize][initRowColSize];
        Container container = this.getContentPane();
        Panel panel = new Panel();
        panel.setLayout(new GridLayout(initRowColSize, initRowColSize, 3, 3));
        for (int i = 0; i < initRowColSize; i++) { //Reihen
            for (int j = 0; j < initRowColSize; j++) { //Spalten
                JLabel label = new JLabel();
                label.setName(i + "" + j);
                label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
                label.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if(SwingUtilities.isLeftMouseButton(e)){
                            makeMove(e);
                        }
                        else if(SwingUtilities.isRightMouseButton(e)){
                            setFlag(e);
                        }
                    }
                });
                label.setOpaque(true);
                label.setBackground(Color.GRAY);
                label.setForeground(Color.WHITE);
                label.setHorizontalAlignment(JLabel.CENTER);
                labelArr[i][j] = label;
                panel.add(label);
            }
        }
        container.add(panel);
    }

    private void evaluateMode(Mode mode) {
        switch (mode) {
            case BEGINNER:
                initRowColSize = 8;
                amountBombs = 10;
                break;
            case INTERMEDIATE:
                initRowColSize = 10;
                amountBombs = 30;
                break;
            case EXPERT:
                initRowColSize = 12;
                amountBombs = 50;
                break;
        }
    }
    
    private void setFlag(MouseEvent e){
        int row = Integer.parseInt(e.getComponent().getName()) / 10;
        int col = Integer.parseInt(e.getComponent().getName()) % 10;
        if(minesweeperbl.flag(row, col)){
            labelArr[row][col]
                    .setIcon(new ImageIcon(new ImageIcon("./flag.png")
                            .getImage()
                            .getScaledInstance(-1, 50, Image.SCALE_SMOOTH)));
        }
    }

    private void makeMove(MouseEvent e) {
        int row = Integer.parseInt(e.getComponent().getName()) / 10;
        int col = Integer.parseInt(e.getComponent().getName()) % 10;
        int handle = minesweeperbl.setField(row, col);
        if (handle == -1) {
            labelArr[row][col]
                    .setIcon(new ImageIcon(new ImageIcon("./bomb.png")
                            .getImage()
                            .getScaledInstance(-1, 50, Image.SCALE_SMOOTH)));
            JOptionPane.showMessageDialog(null, "You lose!");
            reset();
        }
        else {
           labelArr[row][col].setText(handle+"");
           labelArr[row][col].setBackground(Color.WHITE);
           labelArr[row][col].setForeground(determineForeground(handle));
        }
    }

    private void reset() {
        for (int i = 0; i < labelArr.length; i++) {
            for (int j = 0; j < labelArr.length; j++) {
                labelArr[i][j].setBackground(Color.GRAY);
                labelArr[i][j].setText("");
                labelArr[i][j].setIcon(null);
            }
        }
        minesweeperbl = new MinesweeperBL(initRowColSize, amountBombs);
    }
    
    private Color determineForeground(int handle){
        switch(handle){
            case 1:
                return Color.BLUE;
            case 2:
                return Color.GREEN;
            case 3:
                return Color.RED;
            case 4:
                return Color.MAGENTA;
            case 5:
                return Color.BLACK;
            case 6:
                return Color.ORANGE;
            case 7:
                return Color.GRAY;
            case 8:
                return Color.CYAN;
            default:
                return Color.YELLOW;
        }
    }

}
