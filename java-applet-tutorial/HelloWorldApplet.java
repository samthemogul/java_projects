import java.applet.Applet;
import java.awt.*;

class HelloWorldApplet extends Applet {
    public void paint(Graphics g) {
        g.drawString("Hello world!", 5, 25);
    }
}
