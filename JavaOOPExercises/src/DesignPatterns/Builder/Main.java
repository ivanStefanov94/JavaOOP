package DesignPatterns.Builder;

public class Main {
    public static void main(String[] args) throws Exception {

        Computer computer = Computer.builder()
                .withProcessor("Intel")
                .withGraphicCard("GTX")
                .withRam("64 GB")
                .withMotherboard("MSI")
                .withSsd("1 TB")
                .withKeyboard("Logitech")
                .build();

    }
}
