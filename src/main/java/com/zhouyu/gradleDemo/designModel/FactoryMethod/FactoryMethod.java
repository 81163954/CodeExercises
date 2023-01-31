package com.zhouyu.gradleDemo.designModel.FactoryMethod;

import javax.swing.*;
import java.awt.*;

public class FactoryMethod {
    private static Dialog dialog;
    public static void main(String[] args) {
        configure();
        runBusinessLogic();
        System.out.println(1);
        System.out.println(System.getProperty("os.name"));
    }
    static void configure(){
        if(System.getProperty("os.name").equals("Windows 10")){
            dialog = new WindowsDialog();
        }else{
            dialog = new HtmlDialog();
        }
    }
    static void runBusinessLogic(){
        dialog.renderView();
    }
}
class WindowsDialog extends Dialog{

    @Override
    Button createButton() {
        return new WindowsButton();
    }
}
class HtmlDialog extends Dialog{

    @Override
    Button createButton() {
        return new HtmlButton();
    }
}
abstract class Dialog{
    void renderView(){
        Button button = createButton();
        button.render();
    }
    abstract Button createButton();

}
class WindowsButton implements Button{
    JPanel panel = new JPanel();
    JFrame frame = new JFrame();
    JButton button;
    @Override
    public void render() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("Hello World!");
        label.setOpaque(true);
        label.setBackground(new Color(235, 233, 126));
        label.setFont(new Font("Dialog", Font.BOLD, 44));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.getContentPane().add(panel);
        panel.add(label);
        onClick();
        panel.add(button);

        frame.setSize(320, 200);
        frame.setVisible(true);
        onClick();
    }

    @Override
    public void onClick() {
        System.out.println("windowsButton onclick!!");
    }
}
class HtmlButton implements Button{
    @Override
    public void render() {
        System.out.println("<button>btn1</button>");

    }
    @Override
    public void onClick() {
        System.out.println("htmlButton onclick!!");
    }
}
interface Button{
    void render();
    void onClick();
}



