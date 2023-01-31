package com.zhouyu.gradleDemo.designModel.AbstractFactory;

public class AbstractFactory {
    public static void main(String[] args) {
        Application app = configureApplication();
        app.paint();
    }
    private static Application configureApplication(){
        Application app;
        GUIFactory factory = null;
        String osName = System.getProperty("os.name").toLowerCase();
        switch (osName){
            case "mac":
                factory = new MacFactory();
            case "windows 10":
                factory = new WinFactory();
        }
        return new Application(factory);
    }
}
class Application{
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory){
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }
    public void paint(){
        button.paint();
        checkbox.paint();
    }
}
interface GUIFactory{
    Button createButton();
    Checkbox createCheckbox();
}
class MacFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}
class WinFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new WinButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WinCheckbox();
    }
}
class MacCheckbox implements Checkbox{
    @Override
    public void paint() {
        System.out.println("I m MacCheckbox");
    }
}
class WinCheckbox implements Checkbox{
    @Override
    public void paint() {
        System.out.println("I m WinCheckBox");
    }
}
interface Checkbox{
    void paint();
}
class MacButton implements Button{
    @Override
    public void paint() {
        System.out.println("I am MacButton");
    }
}
class WinButton implements Button{
    @Override
    public void paint() {
        System.out.println("I am WinButton");
    }
}
interface Button {
    void paint();
}
