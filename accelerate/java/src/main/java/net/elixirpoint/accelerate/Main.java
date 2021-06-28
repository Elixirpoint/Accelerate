package net.elixirpoint.accelerate;

public class Main {

    private String message;

    public Main(String s){
        message = s;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void messageValue() {
        System.out.println(message);
    }
}