package DesignPatterns.Builder;

public class Computer {

    //can be called in Main Computer.Builder
    public static class Builder{
        //to access the fields in Computer.class
        private Computer instance;

        private Builder(){
            instance = new Computer();
        }

//By returning Builder we can chain the below methods
        public Builder withProcessor(String processor){
            instance.processor = processor;
            return this;
        }

        public Builder withRam(String ram){
            instance.ram = ram;
            return this;
        }

        public Builder withMotherboard(String motherboard){
            instance.motherboard = motherboard;
            return this;
        }

        public Builder withGraphicCard(String graphicCard){
            instance.graphicCard = graphicCard;
            return this;
        }

        public Builder withSsd(String ssd){
            instance.ssd = ssd;
            return this;
        }

        public Builder withMonitor(String monitor){
            instance.monitor = monitor;
            return this;
        }

        public Builder withKeyboard(String keyboard){
            instance.keyboard = keyboard;
            return this;
        }

        public Builder withMouse(String mouse){
            instance.mouse = mouse;
            return this;
        }

        //control which fields are mandatory for creating a new Computer()
        public Computer build() throws Exception {
            if(instance.processor == null
                    || instance.ram == null
                    || instance.motherboard == null
                    || instance.graphicCard == null
                    || instance.ssd == null){

                throw new Exception("You are missing one of the required components to build a computer");
            }

            return instance;
        }
    }

    private String processor;
    private String ram;
    private String motherboard;
    private String graphicCard;
    private String ssd;
    private String monitor;
    private String keyboard;
    private String mouse;

    //private constructor so we cannot create a Computer without the Builder
    private Computer() {}

    //accessing Builder.class
    public static Builder builder(){
        return new Builder();
    }
}
