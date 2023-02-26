import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FunctionGUI extends JFrame {
    private JLabel FunctionLabel = new JLabel("Функція: Y = A*sqr(X)*Sin(A*X)");
    private JLabel ParamALabel = new JLabel("Параметр А");
    private JLabel StepH = new JLabel("Крок(h)");
    private JLabel NumOfPoints = new JLabel("Кількість точок");
    private JTextField AField = new JTextField();
    private JTextField HField = new JTextField();
    private JTextField PField = new JTextField();
    private JPanel mainPanel = new JPanel();
    private JPanel inputPanel = new JPanel();
    private JTextArea result = new JTextArea(15,2);
    private JButton btn = new JButton("Обчислити");

    public FunctionGUI()
    {
        setSize(400,500); setResizable(true); setLocationRelativeTo(null); setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        FunctionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(FunctionLabel, BorderLayout.NORTH);

        mainPanel.setBorder(BorderFactory.createTitledBorder("Вхідні данні"));
        inputPanel.setLayout(new GridLayout(4,0,5,5));
        inputPanel.add(ParamALabel); inputPanel.add(AField); inputPanel.add(StepH);
        inputPanel.add(HField); inputPanel.add(NumOfPoints); inputPanel.add(PField);
        inputPanel.add(btn);
        result.setEditable(false);
        JScrollPane scroll = new JScrollPane(result); scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        mainPanel.add(inputPanel);
        add(mainPanel, BorderLayout.CENTER); add(scroll, BorderLayout.SOUTH);
        btn.addActionListener(new BtnActionListener());
        setVisible(true);
    }
    class BtnActionListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(AField.getText().equals("") && HField.getText().equals("") && PField.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Всі поля пусті", "Помилка", JOptionPane.ERROR_MESSAGE);
            }
            else if(AField.getText().equals("") || PField.getText().equals("") || HField.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Один з полів пустий!", "Помилка", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                double A = Float.parseFloat(AField.getText());
                double h = Float.parseFloat(HField.getText());
                int p = Integer.parseInt(PField.getText());
                result.setText("");
                for(double i = A; i <= p; i += h)
                {
                    double Y = A * Math.sqrt(i) * Math.sin(A * i);
                    result.append(i + "\t" + Y + "\n");
                }
                result.setFont(new Font("Arial", Font.BOLD, 20));
            }
        }
    }
}
