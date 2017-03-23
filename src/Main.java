import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Field field = new Field(50, 50);
        Set<Rule> rules = new HashSet<>();
        rules.add(new Rule(true, true, false, false));
        rules.add(new Rule(false, true, true, false));
        rules.add(new Rule(false, true, false, false));
        rules.add(new Rule(false, false, true, false));
        rules.add(new Rule(false, false, false, false));
        field.setValue(25,0,1);
        CellAutomata cellAutomata = new CellAutomata(field, rules);
        JFrame frame = draw(field);
        JLabel lblimage = new JLabel(new ImageIcon(createImage(field)));
        frame.getContentPane().removeAll();
        frame.getContentPane().add(lblimage, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();

        Thread.sleep(10000);
        for (int i = 1; i < 50; i++) {
            cellAutomata.performLine(i);
            lblimage = new JLabel(new ImageIcon(createImage(field)));
            frame.getContentPane().removeAll();
            frame.getContentPane().add(lblimage, BorderLayout.CENTER);
            frame.revalidate();
            frame.repaint();
            Thread.sleep(10);

        }
        while (true) {
            for (int i = 0; i < 50; i++) {
                cellAutomata.performLine(i);
                lblimage = new JLabel(new ImageIcon(createImage(field)));
                frame.getContentPane().removeAll();
                frame.getContentPane().add(lblimage, BorderLayout.CENTER);
                frame.revalidate();
                frame.repaint();
                Thread.sleep(10);

            }
        }
    }

    public static BufferedImage createImage(Field field) {
        BufferedImage image = new BufferedImage(field.getxSize() * 10, field.getySize() * 10, BufferedImage.TYPE_INT_ARGB);
        Graphics2D ig2 = image.createGraphics();
        for (int i = 0; i < field.getxSize(); i++) {
            for (int j = 0; j < field.getySize(); j++) {
                if (field.getValue(i, j) == 0)
                    ig2.setColor(Color.white);
                else
                    ig2.setPaint(new Color(0f, 0f, 0f, (field.getValue(i, j) / 10f)>=1?1:field.getValue(i, j) / 10f));
                ig2.fill(new Rectangle2D.Double(i * 10, j * 10,
                        9,
                        9));
            }
        }
        return image;
    }

    public static JFrame draw(Field field) {
        JFrame frame = new JFrame();

        frame.setSize(field.getxSize() * 10 + 20, field.getySize() * 10 + 20);
        frame.setVisible(true);
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        return frame;
    }
}
