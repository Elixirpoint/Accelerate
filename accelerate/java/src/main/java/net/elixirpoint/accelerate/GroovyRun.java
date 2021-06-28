package net.elixirpoint.accelerate;

import groovy.lang.GroovyShell;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class GroovyRun
{
    public static void main(final String[] args) throws IOException
    {
        GroovyShell shell = new GroovyShell();
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                    {
                        execute();
                    }
                catch (Exception e)
                    {
                        e.printStackTrace();
                    }
            }

            private void execute() throws Exception
            {
                final File file = new File("Engine.java");
                long timestamp = file.lastModified();
                GroovyShell shell = new GroovyShell();
                Object app = shell.evaluate(file);
                Engine e = getEngine(app);
                while (true)
                    {
                        if (timestamp < file.lastModified())
                            {
                                timestamp = file.lastModified();
                                app = shell.evaluate(file);
                                e = getEngine(app);
                            }

                        e.start();
                        e.stop();

                        Thread.sleep(5000);
                    }
            }
            private Engine getEngine(final Object app)
            {
                return (Engine) Proxy.newProxyInstance(app.getClass().getClassLoader(),
                                                       new Class[]{Engine.class},
                                                       new InvocationHandler()
                                                       {
                                                           @Override
                                                           public Object invoke(Object proxy, Method method, Object[] args)
                                                                   throws Throwable
                                                           {
                                                               Method m = app.getClass().getMethod(method.getName());
                                                               return m.invoke(app, args);
                                                           }
                                                       });
            }
        }).start();
    }
}