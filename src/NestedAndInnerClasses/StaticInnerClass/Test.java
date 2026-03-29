package NestedAndInnerClasses.StaticInnerClass;

public class Test {

    public static void main( String [] args ){
        Computer myComputer = new Computer("Apple","Mack Book Pro 13 Inch","Machintosh") ;
        System.out.println(myComputer.getComputerInformation());
        Computer.Usb  newUSB = new Computer.Usb("USBV3.14");
        System.out.println(newUSB.getUsbType());
    }
}
