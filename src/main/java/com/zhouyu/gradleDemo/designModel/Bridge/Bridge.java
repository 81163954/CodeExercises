package com.zhouyu.gradleDemo.designModel.Bridge;

public class Bridge {
    public static void main(String[] args) {
        Tv tv = new Tv();
        Radio radio = new Radio();
        testDevice(tv);
        testDevice(radio);
    }
    static void testDevice(Device device){
        BasicRemote r = new BasicRemote(device);
        r.channelUp();
        r.volumeDown();
        device.printStatus();
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.mute();
        device.printStatus();
    }
}
class AdvancedRemote extends BasicRemote{
    public AdvancedRemote(Device device){
        super.device = device;
    }
    public void mute(){
        device.setVolume(0);
    }
}
class BasicRemote implements Remote{
    protected Device device;
    public BasicRemote(){};
    public BasicRemote(Device device){
        this.device = device;
    }

    @Override
    public void power() {
        if(device.isEnabled()){
            device.disable();
        }else{
            device.enable();
        }
    }

    @Override
    public void volumeDown() {
        device.setVolume(device.getVolume()-10);
    }

    @Override
    public void volumeUp() {
        device.setVolume(device.getVolume()+10);
    }

    @Override
    public void channelDown() {
        device.setChannel(device.getChannel()-1);
    }

    @Override
    public void channelUp() {
        device.setChannel(device.getChannel()+1);
    }
}
interface Remote {
    void power();

    void volumeDown();

    void volumeUp();

    void channelDown();

    void channelUp();
}
class Tv implements Device{
    private boolean on = false;
    private int volume = 30;
    private int channel = 1;

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
        on = true;
    }

    @Override
    public void disable() {
        on = false;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int volume) {
        if (volume > 100) {
            this.volume = 100;
        } else if (volume < 0) {
            this.volume = 0;
        } else {
            this.volume = volume;
        }
    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
    }

    @Override
    public void printStatus() {
        System.out.println("------------------------------------");
        System.out.println("| I'm TV set.");
        System.out.println("| I'm " + (on ? "enabled" : "disabled"));
        System.out.println("| Current volume is " + volume + "%");
        System.out.println("| Current channel is " + channel);
        System.out.println("------------------------------------\n");
    }
}
class Radio implements Device{
    private boolean on = false;
    private int volume = 30;
    private int channel = 1;
    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
        on = true;
    }

    @Override
    public void disable() {
        on = false;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int volume) {
        if(volume>100){
            volume = 100;
        }else if(volume<0){
            volume = 0;
        }else{
            this.volume = volume;
        }
    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
    }

    @Override
    public void printStatus() {
        System.out.println("------------------------------------");
        System.out.println("| I'm radio.");
        System.out.println("| I'm " + (on ? "enabled" : "disabled"));
        System.out.println("| Current volume is " + volume + "%");
        System.out.println("| Current channel is " + channel);
        System.out.println("------------------------------------\n");
    }
}
interface Device {
    boolean isEnabled();

    void enable();

    void disable();

    int getVolume();

    void setVolume(int percent);

    int getChannel();

    void setChannel(int channel);

    void printStatus();
}


