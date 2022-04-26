package pl.lublin.wsei.java.cwiczenia.lab2c.console;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class TestNioCopy {
    public static void main(String[] args) throws IOException {
        //Long startTime = System.currentTimeMillis();
        long startTime = System.nanoTime(); //dokladniejszy pomiar
        File oryginal= new File( "sample_1920×1280.tiff");
        File kopia = new File(  "img_copy.tiff");
        Files.copy(oryginal.toPath(), kopia.toPath(), StandardCopyOption.REPLACE_EXISTING);
        //System.out.println("Czas kopiowania: + (System.currentTimeMillis() - startTime)+" ms");
                System.out.println("Czas kopiowania:" + (float) (System.nanoTime() - startTime)/1000000+ "ms");
    }
}
