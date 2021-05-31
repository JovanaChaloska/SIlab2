import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SILab2Test {
    private final SILab2 l = new SILab2();
    private List<Time> List = new ArrayList<>();
    private List<Integer> rez = new ArrayList<>();

    @Test
    public void MultipleCondition() {
        List<Time> lista1 = new ArrayList<>();
        lista1.add(new Time(-1,30,30));
        List<Time> lista2 = new ArrayList<>();
        lista2.add(new Time(25,30,30));
        List<Time> lista3 = new ArrayList<>();
        lista3.add(new Time(12,30,30));
        List<Time> lista4 = new ArrayList<>();
        lista4.add(new Time(12,-1,30));
        List<Time> lista5 = new ArrayList<>();
        lista5.add(new Time(12,61,30));
        List<Time> lista6 = new ArrayList<>();
        lista6.add(new Time(12,30,-1));
        List<Time> lista7 = new ArrayList<>();
        lista7.add(new Time(12,30,61));
        List<Time> lista8 = new ArrayList<>();
        lista8.add(new Time(24,0,0));
        List<Time> lista9 = new ArrayList<>();
        lista9.add(new Time(24,0,1));
        List<Time> lista10 = new ArrayList<>();
        lista10.add(new Time(24,1,1));

        RuntimeException exception = null;

        try{
            l.function(lista1);
        }
        catch (RuntimeException ex){
            exception=ex;
        }
        assertEquals("The hours are smaller than the minimum", exception.getMessage());

        try{
            l.function(lista2);
        }
        catch (RuntimeException ex){
            exception=ex;
        }
        assertEquals("The hours are greater than the maximum", exception.getMessage());

        rez.add(14706);
        assertEquals(rez, l.function(lista3));

        try{
            l.function(lista4);
        }
        catch (RuntimeException ex){
            exception =ex;
        }
        assertEquals("The minutes are not valid", exception.getMessage());

        try{
            l.function(lista5);
        }
        catch (RuntimeException ex){
            exception =ex;
        }
        assertEquals("The minutes are not valid", exception.getMessage());

        try{
            l.function(lista6);
        }
        catch (RuntimeException ex){
            exception =ex;
        }
        assertEquals("The seconds are not valid", exception.getMessage());

        try{
            l.function(lista7);
        }catch (RuntimeException ex){
            exception =ex;
        }
        assertEquals("The seconds are not valid", exception.getMessage());

        rez.remove(0);
        rez.add(86400);
        assertEquals(rez, l.function(lista8));

        try{
            l.function(lista9);
        }catch (RuntimeException ex){
            exception =ex;
        }
        assertEquals("The time is greater than the maximum", exception.getMessage());

        try{
            l.function(lista10);
        }catch (RuntimeException ex){
            exception =ex;
        }
        assertEquals("The time is greater than the maximum", exception.getMessage());
    }

    @Test
    public void EveryBranch() {
        List<Time> lista1 = new ArrayList<>();
        List<Time> lista2 = new ArrayList<>();
        lista2.add(new Time(-1,45,45));
        List<Time> lista3 = new ArrayList<>();
        lista3.add(new Time(25,45,45));
        List<Time> lista4 = new ArrayList<>();
        lista4.add(new Time(22,-2,2));
        List<Time> lista5 = new ArrayList<>();
        lista5.add(new Time(22,2,-2));
        List<Time> lista6 = new ArrayList<>();
        lista6.add(new Time(22,2,2));
        List<Time> lista7 = new ArrayList<>();
        lista7.add(new Time(24,0,0));
        List<Time> lista8 = new ArrayList<>();
        lista8.add(new Time(24,2,2));


        rez = l.function(lista1);
        assertTrue(rez.isEmpty());

        RuntimeException exception = null;

        try{
            l.function(lista2);
        }
        catch (RuntimeException ex){
            exception =ex;
        }
        assertEquals("The hours are smaller than the minimum", exception.getMessage());

        try{
            l.function(lista3);
        }
        catch (RuntimeException ex){
            exception =ex;
        }
        assertEquals("The hours are greater than the maximum", exception.getMessage());

        try{
            l.function(lista4);
        }
        catch (RuntimeException ex){
            exception =ex;
        }
        assertEquals("The minutes are not valid", exception.getMessage());

        try{
            l.function(lista5);
        }
        catch (RuntimeException ex){
            exception =ex;
        }
        assertEquals("The seconds are not valid", exception.getMessage());

        rez.add(79322);
        assertEquals(rez, l.function(lista6));

        rez.remove(0);
        rez.add(86400);
        assertEquals(rez, l.function(lista7));

        try{
            l.function(lista8);
        }catch (RuntimeException exc){
            exception =exc;
        }
        assertEquals("The time is greater than the maximum", exception.getMessage());
    }

}