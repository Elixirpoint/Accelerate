package net.elixirpoint.accelerate;

import javax.swing.*;

public class Main
{

    private String message;

    public Main(String s)
    {
        message = s;
    }

    public static void main(String[] args) throws InterruptedException
    {
        HelloWorld scalaClass = new HelloWorld();
        Timer timer = new Timer(1000, scalaClass);
        timer.start();
        Thread.sleep(10000);
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public void messageValue()
    {
        System.out.println(message);
    }
}