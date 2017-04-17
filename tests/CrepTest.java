import static org.junit.Assert.*;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_SCREENPeer;
import org.junit.Test;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CrepTest {

    @Test
    public void word() throws IOException {
        Crep myCrep = new Crep(false, false, false);
        List<String> supplierNames = new ArrayList<String>();
        supplierNames.add("Грядущие нам открывают года.");
        assertEquals(supplierNames, myCrep.read(new File("lol.txt"), "года"));


    }

    @Test
    public void wordR() throws IOException {
        Crep myCrep = new Crep(true, false, false);
        List<String> suppplierNames = new ArrayList<String>();
        suppplierNames.add("Хранимая Богом родная земля!");
        assertEquals(suppplierNames, myCrep.read(new File("lol.txt"), "[Х]"));


    }

    @Test
    public void wordV() throws IOException {
        Crep myCrep = new Crep(false, true, false);
        List<String> suppplierNames = new ArrayList<String>();
        suppplierNames.add("Россия — любимая наша страна.");
        suppplierNames.add("Твоё достоянье на все времена!");
        suppplierNames.add("Предками данная мудрость народная!");
        suppplierNames.add("От южных морей до полярного края");
        suppplierNames.add("Раскинулись наши леса и поля.");
        suppplierNames.add("Одна ты на свете! Одна ты такая —");
        suppplierNames.add("Хранимая Богом родная земля!");
        suppplierNames.add("Предками данная мудрость народная!");
        suppplierNames.add("Широкий простор для мечты и для жизни");
        suppplierNames.add("Грядущие нам открывают года.");
        suppplierNames.add("Нам силу даёт наша верность Отчизне.");
        assertEquals(suppplierNames, myCrep.read(new File("lol.txt"), ","));
    }

    @Test
    public void wordI() throws IOException {
        Crep myCrep = new Crep(false, false, true);
        List<String> suppplierNames = new ArrayList<String>();
        suppplierNames.add("Россия — священная наша держава,");
        suppplierNames.add("Россия — любимая наша страна.");
        assertEquals(suppplierNames, myCrep.read(new File("lol.txt"), "РОССИЯ"));
    }

    @Test
    public void wordRV() throws IOException {
        Crep myCrep = new Crep(true, true, false);
        List<String> suppplierNames = new ArrayList<String>();
        suppplierNames.add("Широкий простор для мечты и для жизни");
        assertEquals(suppplierNames, myCrep.read(new File("lol.txt"), "[а]"));
    }

    @Test
    public void wordNothing() throws IOException {
        Crep myCrep = new Crep(false, false, false);
        List<String> supplierNames = new ArrayList<String>();
        assertEquals(supplierNames, myCrep.read(new File("lol.txt"), "Америка"));
    }
}