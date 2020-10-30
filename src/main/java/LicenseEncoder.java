import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;


public class LicenseEncoder {
    static final String TEMPLATE_BACK = "./src/main/resources/template_licencia_back.jpg";
    static final String TEST_OUTPUT = "./src/main/resources/test.jpg";
    static final String FONT = "Arial";
    static final Integer FONT_SIZE = 25;

    public static void encode() {
        try {
            BufferedImage back = ImageIO.read(new File(TEMPLATE_BACK));
            Graphics g = back.getGraphics();
            g.setFont(new Font(FONT, Font.PLAIN, FONT_SIZE));
            g.setColor(Color.BLACK);

            // Donante
            g.drawString("Si", Position.DONANTE_X, Position.DONANTE_Y);

            // Grupo y Factor
            g.drawString("B+", Position.GRUPO_X, Position.GRUPO_Y);

            // Observaciones
            g.drawString("Debe conducir con lentes", Position.OBSERVACIONES_X, Position.OBSERVACIONES_Y);

            g.dispose();

            // Guarda la imagen en el directorio /resources
            ImageIO.write(back, "jpg", new File(TEST_OUTPUT));

            // Encoding en base64 de la licencia
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ImageIO.write(back, "jpg", outputStream);
            String b64image = Base64.getEncoder().encodeToString(outputStream.toByteArray());

            System.out.println(b64image);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
