package NestedAndInnerClasses.StaticInnerClass;


public class Computer {

    private String model ;

    private String brand ;

    private OperatingSystem os ;


    public Computer( String brand , String model , String os ){
        this.brand = brand ;
        this.model = model ;

        this.os = new OperatingSystem( os ) ;

    }


    public String getComputerInformation(){
        return "Computer Model ==> " + this.model + " Of Brand ==> " + this.brand
                +" Has OS ==> " + this.os.getOsInformation() ;
    }


    /*
    * Static Inner Class Is Associated With The Outer Most Class
      And Not With The Obj Of The Class
     * */


    public static class Usb{
        private String usbType ;

        public Usb(String usbType ){
            this.usbType = usbType ;
        }

        public String getUsbType() {
            return usbType;
        }
    }



    /*
    * Member Inner Class Associated With The Obj Of The Outer Most Class
    */

    private class OperatingSystem{

        private String osName ;

        public  OperatingSystem (String osName ){
            this.osName = osName ;
        }


        public String  getOsInformation(){
            return this.osName ;
        }

    }
}
